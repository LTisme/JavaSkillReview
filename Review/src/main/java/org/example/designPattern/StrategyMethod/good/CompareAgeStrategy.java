package org.example.designPattern.StrategyMethod.good;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: CompareAgeStrategy
 * @Description: --->
 */

public class CompareAgeStrategy implements Comparable{
    @Override
    public boolean compare(User user1, User user2) {
        return user1.getAge() - user2.getAge() > 0;
    }
}
