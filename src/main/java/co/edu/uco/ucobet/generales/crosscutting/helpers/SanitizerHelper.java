package co.edu.uco.ucobet.generales.crosscutting.helpers;

import org.apache.commons.text.StringEscapeUtils;

public final class SanitizerHelper {

    //Texto limpio
    public static String sanitizeInput(String input) {
        if (input == null) return null;
        return input.replaceAll("[<>\"']", "");
    }

    //HTML caracteres
    public static String escapeForXSS(String input) {
        if (input == null) return null;
        return StringEscapeUtils.escapeHtml4(input);
    }

    //JavaScript caracteres
    public static String escapeForJavaScript(String input) {
        if (input == null) return null;
        return StringEscapeUtils.escapeEcmaScript(input);
    }

    //SQL caracteres
    public static String escapeForSQL(String input) {
        if (input == null) return null;
        return input.replaceAll("(['\";])+?", "\\\\$1");
    }
}