package org.example.commonUseAPI;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_Calendar
 * @Description: --->
 */

public class useAPI_Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));

        // Calendar的月份是从0开始的
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        System.out.println("现在是 " + year + "年 " + (month + 1) + "月 " + day + "日" + hour + "时 " + minute + "分");
    }
}
