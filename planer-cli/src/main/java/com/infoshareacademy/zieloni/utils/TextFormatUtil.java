package com.infoshareacademy.zieloni.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatUtil {
    public static boolean containOnlyAlphabetic(String txt) {
        return txt.chars().allMatch(Character::isAlphabetic);
    }

    public static boolean containIllegalSign(String txt) {
        if (txt == null) {
            return false;
        }
        String illegalRegex = "[ąćęłńóśźżĄĘŁŃÓŚŹŻ]";
        Pattern p = Pattern.compile(illegalRegex);
        Matcher checkText = p.matcher(txt);
        return checkText.find();
    }
}
