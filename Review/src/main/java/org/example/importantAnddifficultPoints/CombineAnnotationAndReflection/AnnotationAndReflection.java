package org.example.importantAnddifficultPoints.CombineAnnotationAndReflection;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2023/4/20
 * @Author: LTisme
 * @ClassName: AnnotationAndReflection
 * @Description: ---> 遍历目标文件夹下所有目标后缀的文件，即使文件夹中套着文件夹也要进行遍历。
 */

public class AnnotationAndReflection {

    public static final List<String> PATHS = new ArrayList<>();

    // 这里用File包装路径再获取路径的原因是将斜杠统一变为反斜杠，方便后续的处理
    public static final String DIRNAME = new File(Thread.currentThread().getContextClassLoader().getResource("").getFile()).getAbsolutePath();

    public static String getInit_Path(){
        URL path = Thread.currentThread().getContextClassLoader().getResource("");
        assert path != null : "path is null";
        return path.getPath();
    }

    /**
     * @param initPath      初始文件路径
     * @param targetSuffix  搜索符合的条件字符串，比如可以填入".class"
     */
    public static File[] findTargetFiles(String initPath, String targetSuffix) {
        // 尝试获取初始路径下的文件
        File file = new File(initPath);

        File[] list = file.listFiles(file1 -> {
            // 如果是文件夹，就继续递归，直到递归到非文件夹
            if (file1.isDirectory()) {
                // 如满足new File(initPath).isDirectory()
                findTargetFiles(file1.getPath(), targetSuffix);
            }
            else {
                // 如满足new File(initPath).isFile()
                if (file1.getName().endsWith(targetSuffix)) {
                    // 如满足new File(initPath).isFile()
                    System.out.println(file1.getPath());
                    return true;
                }
                return false;
            }
            return false;
        });

        return list;
    }

    public static void main(String[] args) {
        if (getInit_Path() !=  null) {
            File[] targetFiles = findTargetFiles(getInit_Path(), ".class");
            for (File targetFile : targetFiles) {
                PATHS.add(targetFile.getAbsolutePath());
            }
        }


        PATHS.forEach(System.out::println);

        // 既然已经用集合存储路径名了，就可以用stream来进行一个统一的匹配操作
//        PATHS.stream().map(path -> {
//            // 拿到这样的绝对路径名，就可以进一步加工成全限定名称
//            // 比如：D:\Java_Practice_Files\All_Projects\JavaSkill\Review\target\classes\org\example\importantAnddifficultPoints\CombineAnnotationAndReflection\AnnotationAndReflection.class
//            // 改成：org.example.importantAnddifficultPoints.CombineAnnotationAndReflection.AnnotationAndReflection
//        }).collect(Collectors.toList());
        System.out.println(DIRNAME);
    }
}
