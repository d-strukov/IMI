package lt.ktu.scheduler.model.utils;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {

	enum ErrorLevel {
		Undefined, Warning, Fatal
	}

	class Error {
		private ErrorLevel level = ErrorLevel.Undefined;
		private String message = "";
		private Object source = null;

		public Error(ErrorLevel err, String msg, Object src) {
			level = err;
			message = msg;
			source = src;
		}

		public Object getSource() {
			return source;
		}

		public ErrorLevel getLevel() {
			return level;
		}

		public String getMessage() {
			return message;
		}
	}

	private static List<Error> errors = new ArrayList<Error>();
	private static ValidationUtil util = new ValidationUtil();

	private ValidationUtil() {

	}

	public static void addError(Object src, String message) {
		errors.add(util.new Error(ErrorLevel.Fatal, message, src));
	}

	public static void addWarning(Object src, String message) {
		errors.add(util.new Error(ErrorLevel.Warning, message, src));
	}
}
