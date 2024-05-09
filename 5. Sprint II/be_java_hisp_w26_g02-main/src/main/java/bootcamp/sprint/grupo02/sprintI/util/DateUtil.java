package bootcamp.sprint.grupo02.sprintI.util;

import java.time.LocalDate;

public class DateUtil {
    
    protected DateUtil() {

    }

    public static boolean isBetween(LocalDate toEvaluate, LocalDate startDate, LocalDate endDate) {
        return !toEvaluate.isBefore(startDate) && !toEvaluate.isAfter(endDate);
    }

    public static boolean isInLastDays(LocalDate toEvaluate, long days) {
        LocalDate today = LocalDate.now();
        LocalDate weeksAgo = today.minusDays(days);
        return isBetween(toEvaluate, weeksAgo, today);
    }
}
