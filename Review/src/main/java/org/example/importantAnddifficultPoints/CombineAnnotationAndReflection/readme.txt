这里将注解和反射结合起来做一个案例，为的是更好的明白注解和反射到底有什么用

项目内容是：
写一个@SingleTon注解，只要程序一启动，被加了这个注解的类，都会创建一个单例对象然后放进容器当中，这样以后取单例只用去容器当中去取
steps：
1、首先遍历一遍该类所在文件下的所有类（通过全限定名称来获取Class.forName(...)）
    全限定名的获取方法是：Thread.currentThread().getContextClassLoader().getResource("")

2、然后