package co.edu.uco.ucobet.generales.crosscutting.helpers;

import org.apache.commons.text.StringEscapeUtils;

public final class SanitizerHelper {

    private SanitizerHelper() {
    }

    public static String sanitizeInput(String input) {
        if (input == null) return null;
        return input.replaceAll("[<>\"']", "");
    }

    public static String escapeForXSS(String input) {
        if (input == null) return null;
        return StringEscapeUtils.escapeHtml4(input);
    }

    public static String escapeForJavaScript(String input) {
        if (input == null) return null;
        return StringEscapeUtils.escapeEcmaScript(input);
    }

    public static String escapeForSQL(String input) {
        if (input == null) return null;
        return input.replaceAll("(['\";]+)", "\\\\$1");
    }
}
