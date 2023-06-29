在 Java 中，File 类是 java.io 包中唯一代表磁盘文件本身的对象。
File 类定义了一些与平台无关的方法来操作文件，
File 类主要用来获取或处理与磁盘文件相关的信息，像文件名、 文件路径、访问权限和修改日期等，还可以浏览子目录层次结构。
File 类表示处理文件和文件系统的相关信息。
也就是说，File 类不具有从文件读取信息和向文件写入信息的功能，它仅描述文件本身的属性。

           构造器	                             描述
1、File(String pathname)	            通过将给定路径名字符串来创建一个新 File 实例
2、File(String parent,String child)	    根据指定的父路径和文件路径创建一个新File对象实例
3、File(File parent,String child)	    根据指定的父路径对象和文件路径创建一个新的File对象实例
上面的意思其实很简单的：就是下面的拼接用法：
1、File file = new File("D:\\code\\a.txt");
2、File file = new File("D:\\code\\","a.txt");
3、File file = new File("D:\\code");
   File child = new File(file,"a.txt");

