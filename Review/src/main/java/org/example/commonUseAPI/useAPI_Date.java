package org.example.commonUseAPI;

import java.util.Date;

/**
 * @Date: 2023/2/3
 * @Author: LTisme
 * @ClassName: useAPI_Date
 * @Description: --->
 */

public class useAPI_Date {
    public static void main(String[] args) {
        Date date = new Date();
        // 获得7天后的时间戳
        long time = date.getTime() + 7 * 24 * 60 * 60 * 1000;
        // 用7天后的时间戳打印
        Date date1 = new Date(time);
        System.out.println(date1.toString());
    }
}
