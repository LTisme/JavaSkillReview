package org.example.commonUseAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2023/2/12
 * @Author: LTisme
 * @ClassName: useAPI_SimpleDateFormat
 * @Description: ---> 因为Calendar的默认日期是美国格式，而每次想要变成自己习惯的日期格式，都需要修改字符串形式
 *                    所以可以通过SimpleDateFormat来帮助我们快速形成想要的日期格式
 */

public class useAPI_SimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");

        String format = simpleDateFormat.format(date);
        System.out.println(format);
        System.out.println(format);

        Date parse = simpleDateFormat.parse("2023-02-12 15:02:14");
        System.out.println(parse);
    }
}
