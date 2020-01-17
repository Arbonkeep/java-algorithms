package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2019/12/26 - 21:33
 */
public class Test {
    /*
        序号:      0 1 2 3 4 5 6 7
        斐波那契数：0 1 1 2 3 5 8 13  (两个数相加等于后一个数)
     */

    public static void main(String[] args) {

//        System.out.println(fib1(8));
//        System.out.println(fib2(8));

        //测试效率
        TimeTools.test("fib1", new TimeTools.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(20));
            }
        });

        TimeTools.test("fib2", new TimeTools.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(20));
            }
        });



    }

    /**
     * 求前n个斐波那契数（递归）
     * @param n
     * @return
     */
    public static int fib1(int  n) {
        if (n <= 1) {
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 求前n个斐波那契数
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        //需要重新计入
        int first = 0;
        int second = 1;

        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;//斐波那契数一定是前后两个数相加等于后一个数
            first = second;
            second = sum;
        }
        return second;
    }

    // 时间复杂度分析
    public static void test1(int n) {
        // 1
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) { // 2
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }

        // 1 + 4 + 4 + 4
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }

        // 140000
        // O(1)
        // O(1)
    }

    public static void test2(int n) {
        // O(n)
        // 1 + 3n
        for (int i = 0; i < n; i++) {
            System.out.println("test");
        }
    }

    public static void test3(int n) {
        // 1 + 2n + n * (1 + 3n)
        // 1 + 2n + n + 3n^2
        // 3n^2 + 3n + 1
        // O(n^2)

        // O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test4(int n) {
        // 1 + 2n + n * (1 + 45)
        // 1 + 2n + 46n
        // 48n + 1
        // O(n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test5(int n) {
        // 8 = 2^3
        // 16 = 2^4

        // 3 = log2(8)
        // 4 = log2(16)

        // 执行次数 = log2(n)
        // O(logn)
        while ((n = n / 2) > 0) {
            System.out.println("test");
        }
    }

    public static void test6(int n) {
        // log5(n)
        // O(logn)
        while ((n = n / 5) > 0) {
            System.out.println("test");
        }
    }

    public static void test7(int n) {
        // 1 + 2*log2(n) + log2(n) * (1 + 3n)

        // 1 + 3*log2(n) + 2 * nlog2(n)
        // O(nlogn)
        for (int i = 1; i < n; i = i * 2) {
            // 1 + 3n
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test10(int n) {
        // O(n)
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + c);
        }
    }

}
