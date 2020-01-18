package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/18 - 15:08
 * 本类用于抽取动态数组和链表的公共部分
 */
public abstract class AbstractList<E> implements List<E>{
    protected int size;//元素个数

    /**
     * 返回元素个数
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断是否包含
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;//指教查找元素德索引不等于-1索命存在
    }

    /**
     * 在末尾添加一个元素
     * @param element
     */
    @Override
    public void add(E element) {
        //直接调用add方法完成尾部添加
        add(size, element);//在size处(最后)添加
    }

    //封装异常

    /**
     * 索引越界
     * @param index
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }

    /**
     * 范围检查
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }


    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
