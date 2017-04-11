package com.yyz.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.yyz.constant.Constant;

/**
 * 系统内金额工具类， 主要涉及到与外部渠道的金额转换
 */
public final class AmountUtil {

	/** 系统内部金额正则定义 */
	private static final String	MONEY_REG				= "^(-?\\d+)(\\.\\d{0,4})?";
	// 4位小数
	public static final String	FOUR_DECIMALS			= "#0.0000";
	// 平均价格式
	public static final String	UNIT_PRICE				= "#0.000";
	// 人民币格式
	public static final String	YUAN_FORMAT				= "#0.00";

	public static final String	RATE_OF_CHANGE_FORMAT	= "#0.00";
	// 1万
	public static final long	TEN_THOUSAND			= 10000L;
	public static final long	HUNDRED					= 100L;

	private AmountUtil() {
	}

	public static long getSettlementNumber(Number number) {
		if (number == null) {
			return 0L;
		}
		if (number.longValue() <= 100) {
			return 100L;
		}
		return number.longValue();
	}

	/**
	 * 系统内数值金额转换为元为单位的字符串， 精确到分。小于分的部分不做四舍五入<br>
	 * 例子：<br>
	 * 16元1分8厘，160180 -> 16.01 <br>
	 * 6角，6000 -> 0.60<br>
	 * 负8角9分，-8900 -> -0.89
	 * 
	 * @param amount
	 * @return
	 */
	public static String numericValueToYuan(Number amount) {
		if (amount == null) {
			return "0.00";
		}
		long value = amount.longValue();
		boolean isNegative = false;
		if (amount.longValue() < 0) {
			value = Math.abs(amount.longValue());
			isNegative = true;
		}
		StringBuffer channelAmount = new StringBuffer();
		long yuan = value / Constant.PRICE_UNIT;
		long cent = (value % Constant.PRICE_UNIT) / (Constant.PRICE_UNIT / 100);

		channelAmount.append(yuan).append(".");
		if (cent < 10L) {
			channelAmount.append("0");
		}
		channelAmount.append(cent);
		if (isNegative && value / 100 != 0) {
			channelAmount.insert(0, '-');
		}
		return channelAmount.toString();
	}

	/**
	 * 系统内数值金额转换为元为单位的字符串， 精确到厘。小于厘的部分不做四舍五入<br>
	 * 例子：<br>
	 * 16元1分8厘3毫，160183 -> 16.018 <br>
	 * 
	 * @param amount
	 * @return
	 */
	public static String numericValueToYuanExactToLi(Number amount) {
		if (amount == null) {
			return "0.000";
		}
		long value = amount.longValue();
		boolean isNegative = false;
		if (amount.longValue() < 0) {
			value = Math.abs(amount.longValue());
			isNegative = true;
		}
		StringBuffer channelAmount = new StringBuffer();
		long yuan = value / Constant.PRICE_UNIT;
		long cent = (value % Constant.PRICE_UNIT) / (Constant.PRICE_UNIT / 1000);

		channelAmount.append(yuan).append(".");
		if (cent < 10L) {
			channelAmount.append("00");
		} else if (cent < 100L && cent >= 10L) {
			channelAmount.append("0");
		}
		channelAmount.append(cent);
		if (isNegative && value / 10 != 0) {
			channelAmount.insert(0, '-');
		}
		return channelAmount.toString();
	}

	/**
	 * 将系统系统内数值金额转换为分为单位的字符串。小于分的部分不做四舍五入<br>
	 * 
	 * 一百元，1000000 -> 10000
	 * 
	 * @param amount
	 * @return
	 */
	public static String numericValueToFen(long amount) {
		return "" + amount / (Constant.PRICE_UNIT / 100);
	}

	/**
	 * 针对特殊情况， 可能会出现于渠道对接需要精确到毫
	 * 
	 * <pre>
	 * 1. 元.角分厘毫
	 * 2. 1.3456
	 * </pre>
	 * 
	 * @param amount
	 * @return
	 */
	public static String amountToChannelExactToMilli(final long amount, int n) {
		StringBuffer channelAmount = new StringBuffer();
		if (amount <= 0L) {
			channelAmount.append("-");
		}
		long amountTemp = Math.abs(amount);
		if (n <= 0) {
			n = 4;
		}
		long yuan = amountTemp / 10000L;
		channelAmount.append(yuan).append(".");
		// 余数
		long remainder = amountTemp % 10000L;
		for (int i = n; i > 0; i--) {
			long base = (long) Math.pow(10, i);
			long temp = remainder / base;
			channelAmount.append(temp);
			// 重新设置余数
			remainder = remainder % base;
		}
		return channelAmount.toString();
	}

	/**
	 * 将元为单位的字符串金额转化为系统内部的数值金额<br>
	 * 例：<br>
	 * 1元3角4分5厘6毫转化为数值<br>
	 * <strong>1.3456 -> 13456</strong><br>
	 * <br>
	 * 3角4分转化为数值<br>
	 * <strong>0.34 -> 3400</strong><br>
	 * 
	 * @param amount
	 * @return
	 */
	public static long yuanToNumericValue(String amountStr) {
		if (StringUtils.isBlank(amountStr)) {
			return 0L;
		}
		StringBuffer amount = new StringBuffer();
		if (amountStr.startsWith(".")) {
			amount.append("0");
		}
		amount.append(amountStr);

		if (!amount.toString().matches(MONEY_REG)) {
			throw new RuntimeException("金额格式不正确:" + amountStr);
		}
		BigDecimal result = new BigDecimal(amount.toString()).multiply(new BigDecimal(10000L));
		if (isOverRangeOfLongValue(result)) {
			throw new RuntimeException("金额数额范围过大:" + amountStr);
		}
		return result.setScale(0, BigDecimal.ROUND_DOWN).longValueExact();
	}

	/**
	 * 判断数字是否超过Long值的范围
	 * 
	 * @param result
	 * @return
	 */
	private static boolean isOverRangeOfLongValue(BigDecimal result) {
		BigDecimal longMaxValue = new BigDecimal(Long.MAX_VALUE);
		BigDecimal longMinValue = new BigDecimal(Long.MIN_VALUE);
		if (result.compareTo(longMaxValue) > 0 || result.compareTo(longMinValue) < 0) {
			return true;
		}
		return false;
	}

	public static long yuanToNumericValueInPointMore(String amountStr) {
		if (StringUtils.isBlank(amountStr)) {
			return 0L;
		}
		StringBuffer amount = new StringBuffer();
		if (amountStr.startsWith(".")) {
			amount.append("0");
		}
		amount.append(amountStr);
		// if (!amount.toString().matches(MONEY_REG)) {
		// throw new ZqException("传入金额格式不正确， amountStr=" + amount);
		// }
		String[] amounts = StringUtils.split(amount.toString(), ".", 2);
		long result = NumberUtils.toLong(amounts[0]) * 10000L;
		boolean isNegative = result < 0L;
		if (amounts.length > 1) {
			int length = amounts[1].length();
			int temp = (int) (NumberUtils.toDouble(amounts[1]) * Math.pow(10, 4 - length));
			if (isNegative) {
				result = result - temp;
			} else {
				result = result + temp;
			}
		}
		return result;
	}

	/**
	 * 股票份额转换
	 * 
	 * @param amountStr
	 * @return
	 */
	public static long convertStockAmount(String amountStr) {
		if (StringUtils.isBlank(amountStr)) {
			return 0L;
		}
		if (!amountStr.matches("^(-?\\d+)?")) {
			throw new RuntimeException("渠道传入股票份额格式不正确， amountStr=" + amountStr);
		}
		BigDecimal bigDecimal = new BigDecimal(amountStr);
		return bigDecimal.longValueExact();
	}

	/**
	 * 计算涨跌幅，精确到百分比两位小数. <br>
	 * 如涨幅为9.85%，返回字符串"9.85"<br>
	 * 如涨幅为-9.85%，返回字符串"-9.85"<br>
	 * 
	 * @param preClosePrice
	 *            上一个交易日收盘价
	 * @param currentPrice
	 *            当前价格
	 * @return
	 */
	public static String getRateOfChange(long preClosePrice, long currentPrice) {
		if (preClosePrice == 0L) {
			return "0.000";
		}
		BigDecimal bigDecimal = new BigDecimal((currentPrice - preClosePrice) * 100).divide(new BigDecimal(
				preClosePrice), 3, BigDecimal.ROUND_HALF_UP);

		return AmountUtil.formatAmountNumber(bigDecimal, UNIT_PRICE);
	}

	/**
	 * 统一改成3位后 此方法删除 @xuzhu
	 * 
	 * @param preClosePrice
	 * @param currentPrice
	 * @return
	 */
	public static String getRateOfChange2(long preClosePrice, long currentPrice) {
		BigDecimal bigDecimal = new BigDecimal((currentPrice - preClosePrice) * 100).divide(new BigDecimal(
				preClosePrice), 2, BigDecimal.ROUND_HALF_UP);

		return AmountUtil.formatAmountNumber(bigDecimal, YUAN_FORMAT);
	}

	/**
	 * 
	 * @param amount
	 * @return
	 */
	public static String formatAmountNumber(Number amount, String numberFormat) {
		if (numberFormat == null) {
			numberFormat = UNIT_PRICE;
		}
		if (amount == null) {
			return "0.000";
		}
		DecimalFormat df = new DecimalFormat(numberFormat);
		return df.format(amount);
	}

	/**
	 * 隔日涨跌停价，精确到分，厘位四舍五入
	 * 
	 * @param amount
	 * @return
	 */
	public static Long amountRoundingByFen(long amount) {
		if (amount % 100L < 50L) {
			amount = amount / 100L * 100L;
		} else {
			amount = (amount / 100L + 1L) * 100L;
		}
		return amount;
	}

	/**
	 * 省略个位
	 * 
	 * 例子：入参 12333 返回值 12330
	 * 
	 * @param amount
	 * @return
	 */
	public static Long omitTheUnit(Long amount) {
		if (amount == null) {
			return 0L;
		}

		return (amount / 10) * 10;
	}

	public static String formatThreeDigitsDecimalPoint(Long amount) {
		if (amount == null) {
			return "0.000";
		}
		BigDecimal bigDecimal = new BigDecimal(amount).divide(new BigDecimal(Constant.PRICE_UNIT), 3,
				BigDecimal.ROUND_HALF_UP);
		return AmountUtil.formatAmountNumber(bigDecimal, UNIT_PRICE);
	}

	public static String formatFourDigitsDecimalPoint(Number amount) {
		if (amount == null) {
			return "0.0000";
		}
		BigDecimal bigDecimal = new BigDecimal(amount.toString()).divide(new BigDecimal(Constant.PRICE_UNIT), 4,
				BigDecimal.ROUND_HALF_UP);
		return AmountUtil.formatAmountNumber(bigDecimal, FOUR_DECIMALS);
	}

	public static String getCostPrice(long totalCostPrice, String totalCount) {
		if (AmountUtil.expandingTenThousands(totalCount) == 0L) {
			return "--";
		}
		BigDecimal bigDecimal = new BigDecimal(totalCostPrice).divide(
				new BigDecimal(totalCount).multiply(new BigDecimal(Constant.PRICE_UNIT)), 4, BigDecimal.ROUND_HALF_UP);
		return AmountUtil.formatAmountNumber(bigDecimal, FOUR_DECIMALS);
	}

	public static String getProfitLossRatio(long floatProfitLoss, long totalCostPrice) {
		if (totalCostPrice == 0) {
			return "100%";
		}
		BigDecimal bigDecimal = new BigDecimal(floatProfitLoss).multiply(new BigDecimal("100"))
				.divide(new BigDecimal(totalCostPrice), 3, BigDecimal.ROUND_HALF_UP).abs();
		if (floatProfitLoss > 0) {
			return AmountUtil.formatAmountNumber(bigDecimal, UNIT_PRICE) + "%";
		}
		return "-" + AmountUtil.formatAmountNumber(bigDecimal, UNIT_PRICE) + "%";
	}

	/**
	 * 扩大万倍
	 *
	 * @param data
	 * @return
	 */
	public static long expandingTenThousands(String data) {
		if (StringUtils.isBlank(data) || !NumberUtils.isNumber(data)) {
			return 0L;
		}
		BigDecimal result = new BigDecimal(data).multiply(new BigDecimal(TEN_THOUSAND));
		if (isOverRangeOfLongValue(result)) {
			throw new RuntimeException("数额范围过大:" + data);
		}
		return result.longValue();
	}

	/**
	 * 缩小万倍，保留4位小数，从第5位小数位开始舍去
	 *
	 * @param data
	 * @return
	 */
	public static String narrowTenThousands(Number data) {
		BigDecimal bigDecimal = shrinkTenThousands(data);
		return bigDecimal.stripTrailingZeros().toPlainString();
	}

	public static BigDecimal shrinkTenThousands(Number data) {
		if (data == null || data.longValue() == 0L) {
			return new BigDecimal(0);
		}
		return new BigDecimal(data.toString()).divide(new BigDecimal(TEN_THOUSAND), 4, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 参数为null，则返回0L；否则返回原来数值
	 *
	 * @param data
	 * @return
	 */
	public static long nullToZero(Number data) {
		if (data == null) {
			return 0L;
		}
		return data.longValue();
	}
}
