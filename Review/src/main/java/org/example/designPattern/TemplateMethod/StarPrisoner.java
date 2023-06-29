package org.example.designPattern.TemplateMethod;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: StarPrisoner
 * @Description: --->
 */

public class StarPrisoner extends Prisoner {

    public StarPrisoner(String name) {
        this.name = name;
    }

    @Override
    void work() {
        System.out.println(this.name + "一直很烦恼的干活！");
    }

    @Override
    void eat() {
        System.out.println(this.name + "吃不下牢里的饭");
    }

    @Override
    void readNews() {
        System.out.println(this.name + "一边看新闻，一边想选妃的辉煌时刻。");
    }
}
