package org.example.importantAnddifficultPoints.IO;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Objects;

/**
 * @Date: 2023/3/17
 * @Author: LTisme
 * @ClassName: TestFile
 * @Description: --->
 */

public class TestFile {
    // 文件夹名字
    private static final String TestTempDir = "Files_for_Testing";

    private final String temp = Objects.requireNonNull(getClass().getResource("")).getPath();

    @Test
    public void Test_filePath(){
        // 获取类文件所在的文件夹路径
        System.out.println();
    }

    @Test
    public void Test_createFile() throws IOException {
        // 以下这些并不代表已经创建出来真的文件了，这只是描述对象
        // 想在当前类所在的文件夹中创建
        final String currentPath = Objects.requireNonNull(getClass().getResource("")).getPath();
        final String targetPath = currentPath + "/" + TestTempDir;
        File dir = new File(targetPath);

        File file1 = new File(targetPath + "/file1.txt");
        File file2 = new File(targetPath, "file2.txt");
        File file3_parent = new File(targetPath);
        File file3 = new File(file3_parent, "file3.txt");

        // 开始创建文件或文件夹
        if (!dir.exists()){
            dir.mkdir();
            System.out.println("初始化文件夹创建成功，路径为：" + dir.getAbsolutePath());
        } else {
            System.out.println("初始化文件夹已存在，路径为：" + dir.getAbsolutePath());
        }

        if (!file1.exists()){
            file1.createNewFile();
        }
        if (!file2.exists()){
            file2.createNewFile();
        }
        if (!file3.exists()){
            file3.createNewFile();
        }

        System.out.println("file1.getName() = " + file1.getName());
        System.out.println("file1.getPath() = " + file1.getPath());
        System.out.println("file1.getParentFile() = " + file1.getParentFile());
        System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());
        System.out.println("file1.getAbsoluteFile() = " + file1.getAbsoluteFile());
        System.out.println("file1.canRead() = " + file1.canRead());
        System.out.println("file1.lastModified() = " + file1.lastModified());
        System.out.println("file1.getTotalSpace() = " + file1.getTotalSpace());
    }

    /**
     * 测试字节流
     * @throws IOException
     */
    @Test
    public void Test_readFile1() throws IOException {
        File from = new File("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\src\\main\\java\\org\\example\\importantAnddifficultPoints\\IO\\IO流.png");
        File to = new File("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\target\\classes\\org\\example\\importantAnddifficultPoints\\IO\\Files_for_Testing\\IO流.png");
        if (!to.exists()){
            to.createNewFile();
        }

        InputStream inputStream = new FileInputStream(from);
        OutputStream outputStream = new FileOutputStream(to);
        byte[] readArr = new byte[1024 * 1024];
        try {
            while (inputStream.read(readArr) > 0){
                outputStream.write(readArr);
            }
        } finally {
            // 调用close会默认调用flush，也就是将流里面的内容刷到硬盘上去
            inputStream.close();
            outputStream.close();
        }
    }

    /**
     * 测试字符流，只在操作字符文件的时候才好用些，不常用，几乎都是用字节流的
     */
    @Test
    public void Test_reader() throws IOException {
        File from = new File("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\src\\main\\java\\org\\example\\importantAnddifficultPoints\\IO\\readme.txt");
        File to = new File("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\target\\classes\\org\\example\\importantAnddifficultPoints\\IO\\Files_for_Testing\\readme_copied.txt");
        if (!to.exists()){
            to.createNewFile();
        }

        try(FileReader reader = new FileReader(from);
        FileWriter writer = new FileWriter(to)){
            // 这是一个字符一个字符读取的，太少了，完全可以用字符数组来读取
            int b;
            while ((b = reader.read()) != -1){
                writer.write(b);
            }
        }
    }

    /**
     * 这里测试处理流的好用方法，比如一行一行读取的readLine()方法
     */
    @Test
    public void Test_readLine() throws IOException {
        File from = new File("D:\\Java_Practice_Files\\All_Projects\\JavaSkill\\Review\\src\\main\\java\\org\\example\\importantAnddifficultPoints\\IO\\readme.txt");

        try(
                // 先是节点流，因为是直接接触文件，所以节点流的称呼是带File的
                FileReader reader = new FileReader(from);
            // 再是处理流，处理流包装的节点流
        BufferedReader bufferedReader = new BufferedReader(reader)) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                System.out.println(temp);
            }
        }
    }
}
