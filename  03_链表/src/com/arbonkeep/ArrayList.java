package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/18 - 13:50
 * 动态数组
 */
public class ArrayList<E> extends AbstractList<E>  {
    private E[] elements;

    //常量
    private static final int DEFAULT_CAPACITY = 10;//默认数组容量为10


    //构造方法
    public ArrayList(int capacity) {
        //判断：如果传入容量小于初始容量，就将capacity设置为初始容量
        capacity = capacity <= DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;

        //初始化数组
        elements = (E[])new Object[capacity];
    }

    //空参构造
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        //清除：将所有元素进行遍历，并将每个元素赋值为null，这是因为我们需要
        //     保留堆空间所分配的空间，而不需要对应的对象
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }



    /**
     * 将index位置的元素设置为新元素，并将原来的同元素返回
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //检查是否需要扩容，如果需要就直接完成扩容。如果不需要就结束方法
        ensureCapaciry(size + 1);//如果需要继续添加元素，那么就是size + 1

        for (int i = size; i > index; i--) {//由后向前遍历，并依次后移
            elements[i] = elements[i - 1];//将前面元素的值赋值给后面
        }

        //完成移动之后，插入该元素
        elements[index] = element;
        //最后维护size
        size++;
    }

    /**
     * 删除index处的元素，并将删除的元素返回
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        //记录老的元素，用于返回
        E old = elements[index];
        //遍历，将index后面的元素向前移动
        for (int i = index + 1; i < size; i++) {
            elements[i-1] = elements[i];//将后面元素前移
        }
        //维护size
        size--;
        elements[index] = null;//并将删除位置的元素赋值为null
        return old;
    }

    /**
     * 删除指定的元素
     * @param element
     */
    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {//遍历
                if (elements[i] == null) return i;//如果元素为null，那么就返回null对应的索引
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;//如果都不满足就说明没找到返回-1
    }



    /**
     * 保证需要有capacity的容量(扩容)
     * @param capacity
     */
    private void ensureCapaciry(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        //需要扩容
        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1 + 1/2
        //创建一个新的数组
        E[] newElements = (E[]) new Object[newCapacity];

        //将旧数组的元素拷贝到新数组
        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = elements[i];
        }
        //将引用指向新的数组，覆盖旧数组
        elements = newElements;
        //打印扩容信息，此步骤可以不需要
        System.out.println(oldCapacity + "扩容为" + "_" + newCapacity);

    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {//只要i！=0说明后面还有元素，所以需要,[
                sb.append(", [");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
