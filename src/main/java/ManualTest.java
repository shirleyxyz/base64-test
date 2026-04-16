package org.apache.commons.codec.binary;

public class ManualTest {
    public static void main(String[] args) {
        System.out.println("========== 手动测试开始 ==========\n");

        // 测试1：编码 "Hello"
        String test1 = "Hello";
        byte[] encoded1 = Base64.encodeBase64(test1.getBytes());
        String encodedStr1 = new String(encoded1);
        System.out.println("测试1 - 原始数据: " + test1);
        System.out.println("测试1 - 编码结果: " + encodedStr1);

        byte[] decoded1 = Base64.decodeBase64(encoded1);
        String decodedStr1 = new String(decoded1);
        System.out.println("测试1 - 解码结果: " + decodedStr1);

        if (test1.equals(decodedStr1)) {
            System.out.println("测试1 - 结果: ✅ 通过\n");
        } else {
            System.out.println("测试1 - 结果: ❌ 失败");
            System.out.println("   期望: " + test1);
            System.out.println("   实际: " + decodedStr1 + "\n");
        }

        // 测试2：编码 "Java Base64"
        String test2 = "Java Base64";
        byte[] encoded2 = Base64.encodeBase64(test2.getBytes());
        String encodedStr2 = new String(encoded2);
        System.out.println("测试2 - 原始数据: " + test2);
        System.out.println("测试2 - 编码结果: " + encodedStr2);

        byte[] decoded2 = Base64.decodeBase64(encoded2);
        String decodedStr2 = new String(decoded2);
        System.out.println("测试2 - 解码结果: " + decodedStr2);

        if (test2.equals(decodedStr2)) {
            System.out.println("测试2 - 结果: ✅ 通过\n");
        } else {
            System.out.println("测试2 - 结果: ❌ 失败");
            System.out.println("   期望: " + test2);
            System.out.println("   实际: " + decodedStr2 + "\n");
        }

        System.out.println("========== 手动测试结束 ==========");
    }
}