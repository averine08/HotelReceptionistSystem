package Helper;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberHelper {
	public static String formatMoneyRupiah(int number) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		formatter.setMaximumFractionDigits(0);
		
		return formatter.format(number).replace("$", "Rp");
	}
	
	public static String formatPadLeftWithPrefix(String prefix, int number, int digitCount) {
		String numberString = String.valueOf(number);
		String zeroString = "";
		for (int i = numberString.length(); i < digitCount; i++) {
			zeroString += "0";
		}
		
		return prefix + zeroString + numberString;
	}
}
