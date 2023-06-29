package org.example.commonUseAPI;

import java.time.Instant;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_Instant
 * @Description: ---> 阿里巴巴规约说的jdk8，可以用Instant代替Date，LocalDate代替Calendar，LocalDateFormatter代替SimpleDateFormat
 */

public class useAPI_Instant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
    }
}
