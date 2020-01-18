package com.arbonkeep;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void test() {
        DynamicArray<Integer> dy = new DynamicArray<>();
        dy.add(11);
        dy.add(22);
        dy.add(33);
        dy.add(44);
        dy.add(55);
        dy.add(null);

        System.out.println(dy.indexOf(null));//可以存储空元素，这是由我们自己定义的

    }

    //ArrayList原码
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        //注意：ArrayList集合是基于动态数组实现的，并且源码与我们实现的动态数组基本相似，只不过源码比较
        //完善

    }
}
