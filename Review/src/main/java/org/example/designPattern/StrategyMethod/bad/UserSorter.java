package org.example.designPattern.StrategyMethod.bad;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: UserSorter
 * @Description: --->
 */

public class UserSorter {

    public static void sort(User[] users){
        for (int i = 0; i < users.length-1; i++) {
            for (int j = 0; j < users.length - i - 1; j++) {
                if(users[j].getAge() > users[j + 1].getAge()){
                    User temp = users[j];
                    users[j] = users[j+1];
                    users[j+1] = temp;
                }
            }
        }
    }
}
