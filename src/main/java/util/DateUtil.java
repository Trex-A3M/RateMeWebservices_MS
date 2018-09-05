package util;

import java.sql.Date;

public class DateUtil {
    static long current = System.currentTimeMillis();

    public static Date getCurrentDateTime() {
        return new Date(current);
    }
}
