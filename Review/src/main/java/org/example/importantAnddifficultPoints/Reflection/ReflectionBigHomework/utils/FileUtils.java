package org.example.importantAnddifficultPoints.Reflection.ReflectionBigHomework.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date: 2023/5/31
 * @Author: LTisme
 * @ClassName: FileUtils
 * @Description: ---> 文件工具类：传入一个路径，然后返回这个路径下所有的类的全限定名称
 */

public class FileUtils {

    public static List<String> getAllFilesName(String classpath) {
        // 拿到了 .class 文件的绝对路径名后就可以将其变为 全限定名，有了全限定名才可以使用反射的 class.forName() 方法
        // 比如 D:\Java_Practice_Files\All_Projects\JavaSkill\Review\target\classes\org\example\algorithm\BinarySearch.class 变成
        // org.example.algorithm.BinarySearch
        // 因为已经拿到了url也就是父文件夹的路径名，所以只用做一个字符串的分割和再拼接操作即可
        List<String> classNames = new ArrayList<>();

        findTargetFiles(classpath, ".class", classNames);

        List<String> collect = classNames.stream().map(path -> {
            String absolutePath = new File(classpath).getAbsolutePath();
            String tempString = path.replace(absolutePath + "\\", "");
            // 然后把反斜杠替换成 . 再把最后的 .class 给删除
            String[] split = tempString.replace("\\", ".").split(".class");
            return split[0];
        }).collect(Collectors.toList());

        return collect;
    }

    // 这里写个方法来递归获取当前文件夹下所有的类名
    public static void findTargetFiles(String initPath, String targetSuffix, List<String> paths) {
        // 尝试获取初始路径下的文件
        File file = new File(initPath);

        File[] list = file.listFiles(file1 -> {
            // 如果是文件夹，就继续递归，直到递归到非文件夹
            if (file1.isDirectory()) {
                // 如满足new File(initPath).isDirectory()
                findTargetFiles(file1.getPath(), targetSuffix, paths);
            }
            else {
                // 如满足new File(initPath).isFile()
                if (file1.getName().endsWith(targetSuffix)) {
                    // 如满足new File(initPath).isFile()
                    // 然后将路径全填进数组
                    paths.add(file1.getAbsolutePath());
                    return true;
                }
                return false;
            }
            return false;
        });
    }
}
