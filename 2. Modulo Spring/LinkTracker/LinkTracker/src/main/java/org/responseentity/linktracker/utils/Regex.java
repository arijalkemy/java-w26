package org.responseentity.linktracker.utils;

import java.util.regex.Pattern;

public class Regex {
    public static final String uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static boolean isValidUUID(String id){
        return Pattern.compile(uuidRegex).matcher(id).matches();
    }
}
