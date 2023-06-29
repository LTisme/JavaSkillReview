package org.example.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Date: 2023/1/6
 * @Author: LTisme
 * @ClassName: hashAlgorithm
 * @Description: ---> 哈希算法——哈希算法是一种思想，具体的实现有 MD5(Message Digest Algorithm 信息消化算法) 和 SHA-1(Secure Hash Algorithm 安全哈希算法)
 */

public class hashAlgorithm {
    // MD5 和 SHA1 都是返回的单例类，无所谓再创建单例类了

    public static byte[] md5Digest(String targetString) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // MD5返回128位（16字节）的散列值
        return md5.digest(targetString.getBytes());
    }

    public static byte[] sha1Digest(String targetString) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("SHA1");
        // SHA1返回160位（20字节）的散列值
        return md5.digest(targetString.getBytes());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Arrays.toString(hashAlgorithm.md5Digest("123")));
        System.out.println(Arrays.toString(hashAlgorithm.sha1Digest("123")));
    }
}
