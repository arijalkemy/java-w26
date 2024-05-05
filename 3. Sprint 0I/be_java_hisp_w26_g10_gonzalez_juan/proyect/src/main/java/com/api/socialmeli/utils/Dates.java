package com.api.socialmeli.utils;

public class Dates {
    /**
     * Reserved the format from DD-MM-AAAA to AAAA-MM-DD
     * @param stringDate
     * @return
     */
    public static String reverseDate(String stringDate){
        String[] datesParts = stringDate.split("-");
        String dateReversed = datesParts[2] + "-" + datesParts[1] + "-" + datesParts[0];
        return dateReversed;
    }
}
