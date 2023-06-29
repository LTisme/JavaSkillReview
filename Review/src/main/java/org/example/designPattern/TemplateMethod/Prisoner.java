package org.example.designPattern.TemplateMethod;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: Prisoner
 * @Description: ---> 模板设计模式
 */

public abstract class Prisoner {

    protected String name;

    /**
     * 劳动的方法
     */
    abstract void work();

    /**
     * 吃的方法
     */
    abstract void eat();

    /**
     * 看新闻
     */
    abstract void readNews();

    /**
     * 一天的生活，那这里就是模板
     */
    public void life(){
        eat();
        work();
        eat();
        work();
        eat();
        readNews();
    }
}
