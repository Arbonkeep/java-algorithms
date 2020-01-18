package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/18 - 13:48
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(0,44);
        list.add(2,55);
        list.remove(1);
        System.out.println(list);


    }

}
