package com.arbonkeep;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author arbonkeep
 * @date 2020/1/17 - 10:42
 * 本方法用于测试
 */
public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> dy = new DynamicArray<>();
        dy.add(11);
        dy.add(22);
        dy.add(33);
        dy.add(44);
        dy.add(55);

//        dy.add(dy.size() - 1, 66);//调用指定index插入元素的方法，size() -1，是在倒数第二个位置插入元素
//        System.out.println(dy);

//        dy.set(3,88);
//        Assert.test(dy.get(3) == 88);//检验是否正确

//        System.out.println(dy);

        for (int i = 0; i < 20; i++) {
            dy.add(11);
        }
        System.out.println(dy);
    }
}
