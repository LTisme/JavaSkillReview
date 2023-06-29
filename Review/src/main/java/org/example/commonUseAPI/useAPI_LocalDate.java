package org.example.commonUseAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_LocalDate
 * @Description: --->
 */

public class useAPI_LocalDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate localDate = now.withYear(1991);
        System.out.println(localDate);

        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
    }
}
