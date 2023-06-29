package org.example.designPattern.StrategyMethod.good;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: CompareHeightStrategy
 * @Description: --->
 */

public class CompareHeightStrategy implements Comparable{
    @Override
    public boolean compare(User user1, User user2) {
        return user1.getHeight() - user2.getHeight() >0;
    }
}
