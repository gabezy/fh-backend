package dev.moreira.Fithub.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {

    public static boolean emailValidator(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        var pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
