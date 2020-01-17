package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/17 - 16:44
 * 断言，用于测试
 */
public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("测试未通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
