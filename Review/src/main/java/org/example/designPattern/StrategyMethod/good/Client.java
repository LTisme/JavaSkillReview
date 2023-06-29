package org.example.designPattern.StrategyMethod.good;

import java.util.Arrays;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: Client
 * @Description: --->
 */

public class Client {
    public static void main(String[] args) {
        User user1 = new User("小王",12,153.4);
        User user2 = new User("小李",14,163.4);
        User user3 = new User("小张",13,123.4);
        User user4 = new User("小杨",4,46.4);

        User[] users = {user1,user2,user3,user4};
        // 这样的话，将来哪一天需要根据身高而非年龄排序的话，就会需要改UserSorter的代码，所以需要再抽象出一层
        // 我以前说过那句话的，如果一件事情在这个维度不好解决，就再抽象去包装一层
        UserSorter.sort(users, new CompareHeightStrategy());
        System.out.println(Arrays.toString(users));
        // 用lambda表达式就可以不需要再去新建一个策略实现类了
        UserSorter.sort(users, (i, j) -> (i.getAge() - j.getAge()) > 0);
    }
}
