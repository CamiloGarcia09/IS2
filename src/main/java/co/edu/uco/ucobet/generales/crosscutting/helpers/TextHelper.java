package co.edu.uco.ucobet.generales.crosscutting.helpers;

public final class TextHelper {

	public static final String EMPTY = "";
	private static final String LETTERS_ONLY_REGEX;

    static {
        LETTERS_ONLY_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)*$";
    }

    private TextHelper() {}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}

	public static String toUpperCase(final String string) {
		return getDefault(string).toUpperCase();
	}

	public static String toLowerCase(final String string) {
		return getDefault(string).toLowerCase();
	}

	public static boolean containsOnlyLetters(final String string) {
		return string != null && string.matches(LETTERS_ONLY_REGEX);
	}
}
