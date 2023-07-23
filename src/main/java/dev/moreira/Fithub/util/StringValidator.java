package dev.moreira.Fithub.util;

public class StringValidator {

    public static boolean stringIsEmptyOrNull(String str) {
        return str == null || str.trim().isEmpty();
    }
}
