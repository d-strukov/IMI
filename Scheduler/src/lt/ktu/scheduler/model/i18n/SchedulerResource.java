package lt.ktu.scheduler.model.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class SchedulerResource {

	private static Locale locale = new Locale("en");
	private static ResourceBundle mainBundle = ResourceBundle.getBundle(
			"ResourceBundle", locale);

	public static String getTextFor(String key) {
		try {
			return mainBundle.getString(key);
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			return key;
		}
	}

}
