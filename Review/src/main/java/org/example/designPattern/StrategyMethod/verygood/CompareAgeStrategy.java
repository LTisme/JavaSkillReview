package org.example.designPattern.StrategyMethod.verygood;

import org.example.designPattern.StrategyMethod.good.User;

/**
 * @Date: 2023/2/14
 * @Author: LTisme
 * @ClassName: CompareAgeStrategy
 * @Description: --->
 */

public class CompareAgeStrategy implements Comparable<User>{
    @Override
    public boolean compare(User o1, User o2) {
        return o1.getAge() - o2.getAge() > 0;
    }
}
