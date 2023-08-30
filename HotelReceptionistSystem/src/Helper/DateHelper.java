package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String formatDate(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}
}
