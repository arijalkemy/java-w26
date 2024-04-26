package bootcamp.sprint.grupo02.sprintI.enums;

import java.util.Arrays;

public enum DateOrder {
    DATE_ASC,
    DATE_DESC;

    public static boolean validateOrder(String order){
        return Arrays.stream(DateOrder.values()).anyMatch(v -> v.toString().equalsIgnoreCase(order));
    }
}
