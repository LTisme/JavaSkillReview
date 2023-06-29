package org.example.commonUseAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_DateTimeFormatter
 * @Description: --->
 */

public class useAPI_DateTimeFormatter {
    public static void main(String[] args) {

        // 限定日期格式的写法
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

        // 从字符串解析成日期对象
        LocalDate parse = LocalDate.parse("2077年09月19日", dateTimeFormatter);
        System.out.println(parse);
    }
}
