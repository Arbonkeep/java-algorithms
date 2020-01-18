package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/18 - 12:10
 */
public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;//可以提供给外界使用

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 在末尾添加一个元素
     * @param element
     */
    void add(E element);

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    int indexOf(E element);
}
