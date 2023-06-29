package org.example.designPattern.TemplateMethod;

/**
 * @Date: 2023/1/17
 * @Author: LTisme
 * @ClassName: Visitor
 * @Description: --->
 */

public class  Visitor {

    public void visit(Prisoner prisoner){
        System.out.println("我开始参观体会囚犯的一天");
        prisoner.life();
        System.out.println("一天的参观结束");
    }

    public static void main(String[] args) {
        Prisoner wyf = new StarPrisoner("吴亦凡");
        Visitor jerry = new Visitor();
        jerry.visit(wyf);
    }
}
