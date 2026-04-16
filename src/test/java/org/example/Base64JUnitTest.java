package org.example;

import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Base64 单元测试")
public class Base64JUnitTest {

    @Test
    @DisplayName("测试1：编码解码一致性")
    void testEncodeAndDecode() {
        String original = "Hello JUnit";
        byte[] originalBytes = original.getBytes(StandardCharsets.UTF_8);

        byte[] encoded = Base64.encodeBase64(originalBytes);
        byte[] decoded = Base64.decodeBase64(encoded);

        assertArrayEquals(originalBytes, decoded);
    }

    @Test
    @DisplayName("测试2：编码字符串")
    void testEncodeBase64String() {
        byte[] input = "Hi".getBytes(StandardCharsets.UTF_8);
        String result = Base64.encodeBase64String(input);

        assertEquals("SGk=", result);
    }

    @Test
    @DisplayName("测试3：解码字符串")
    void testDecodeBase64String() {
        String base64 = "SGk=";
        byte[] decoded = Base64.decodeBase64(base64);
        String result = new String(decoded, StandardCharsets.UTF_8);

        assertEquals("Hi", result);
    }

    @Test
    @DisplayName("测试4：空数组编码解码")
    void testEmptyArray() {
        byte[] empty = new byte[0];
        byte[] encoded = Base64.encodeBase64(empty);
        byte[] decoded = Base64.decodeBase64(encoded);

        assertArrayEquals(empty, decoded, "空数组应该编码解码后仍为空");
    }

    @Test
    @DisplayName("测试5：URL安全模式编码")
    void testUrlSafeEncode() {
        byte[] input = "Hello+World/".getBytes(StandardCharsets.UTF_8);
        byte[] encoded = Base64.encodeBase64URLSafe(input);
        String encodedStr = new String(encoded, StandardCharsets.UTF_8);

        // URL安全编码不应包含 + 和 /
        assertFalse(encodedStr.contains("+"), "URL安全编码不应包含 +");
        assertFalse(encodedStr.contains("/"), "URL安全编码不应包含 /");

        // URL安全编码应该能正常解码
        byte[] decoded = Base64.decodeBase64(encoded);
        assertArrayEquals(input, decoded, "URL安全编码后应该能正确解码");
    }

    @Test
    @DisplayName("测试6：isBase64 字符判断")
    void testIsBase64() {
        // 有效字符
        assertTrue(Base64.isBase64((byte) 'A'), "字母A应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) 'Z'), "字母Z应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) 'a'), "字母a应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) 'z'), "字母z应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) '0'), "数字0应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) '9'), "数字9应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) '+'), "字符+应该在Base64字符集中");
        assertTrue(Base64.isBase64((byte) '/'), "字符/应该在Base64字符集中");

        // 无效字符
        assertFalse(Base64.isBase64((byte) '!'), "字符!不应该在Base64字符集中");
        assertFalse(Base64.isBase64((byte) '@'), "字符@不应该在Base64字符集中");
        assertFalse(Base64.isBase64((byte) ' '), "空格不应该在Base64字符集中");
        assertFalse(Base64.isBase64((byte) '\n'), "换行符不应该在Base64字符集中");
    }
}