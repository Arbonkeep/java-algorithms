package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2019/12/26 - 23:31
 */
public class DynamicArray<E> {
    //元素数量
    private int size;
    //所有元素 ：数组
    private E[] elements;

    //常量
    private static final int DEFAULT_CAPACITY = 10;//默认容量为10
    private static final int ELEMENT_NOT_FOUND = -1;//元素找不到返回-1

    //构造方法初始化数组
    public DynamicArray(int capacity) {
        //进行判断,如果传入容量小于初始容量，就赋值为初始容量
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        //初始化数组
        elements = (E[]) new Object[capacity];//这里不能够new E[]
    }
    //空参构造
    public DynamicArray() {
        this(DEFAULT_CAPACITY);//调用有参构造
    }

    //清除所有元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
            //将数组每个元素都赋值为null，这是因为我们需要保留堆空间所分配的空间，而不需要对应的对象
        }
        size = 0;
    }

    //返回元素个数
    public int size() {
        return size;
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //是否包含元素
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;//只要索引不为-1说明元素就存在
    }

    //获取index索引位置获取元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    //将index位置的元素设置为新元素，并返回原来的元素
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    //在index位置插入一个元素
    public void add(int index, E element) {
        rangeCheckAdd(index);

        //检查是否需要扩容，如果需要直接在该方法中完成扩容
        ensureCapacity(size + 1);

        //思考：为什么是size - 1，和index
        //因为在index位置插入一个元素，那么从index开始到最后一个元素都是需要向后移动的，
        //并且需要遵循后面的元素先移动的规律
//        for (int i = size -1; i >= index; i--) {//遵循后面的元素先移动，直到index元素
//            elements[i + 1] = elements[i];//后移，将i移动到i+1
//        }

        //优化
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];//将i-1移动到i
        }
        elements[index] = element;
        size++;
    }

    //在数组的尾部添加一个元素
    public void add(E element) {
//        elements[size] = element;
//        size++;
        //调用含有index的add方法
        add(size, element);//在size处(最后)添加
    }

    //删除index位置的元素,并将删除的元素返回
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        //思考：为什么是时index + 1和index -1（最后一个元素） 呢？
        // 这是因为删除元素后，需要向前移动的元素的范围是index + 1 到index -1
        for (int i = index + 1; i < size; i ++) {//遍历需要向前移动的元素,i<size等价于i <= size - 1
            elements[i - 1] = elements[i];//将后面一个元素前移
        }
        size--;
        elements[size] = null;
        return old;
    }

    //删除指定的元素
    public void remove(E element) {
        remove(indexOf(element));//调用方法执行删除
    }

    //查看元素的索引
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;//如果元素为null，那么就返回null对应的索引
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return  i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    //保证需要有capacity的容量，即扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;//不需要扩容，直接返回

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1+1/2
        E[] newElements = (E[])new Object[newCapacity];//创建一个新的数组

        //遍历，将旧数组的元素添加到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        //将新数组的引用指向旧数组，覆盖旧数组
        elements = newElements;

        //打印扩容信息
        System.out.println(oldCapacity + "扩容为" + "_" + newCapacity);
    }

    //封装异常
    private void outOfBounds(int index) {//索引越界
        throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
    }
    //范围检查
    private void rangeCheck(int index) {
        if (index < 0 || index >= size ) {
            outOfBounds(index);
        }
    }

    //范围检查允许添加
    private void rangeCheckAdd(int index) {
        if (index < 0 || index > size ) {//注意：这里是允许=size的，这是因为插入元素可以在size插入
            outOfBounds(index);
        }
    }

    //toString方法，要求size = ?,[11, 22, 33]
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(", [");
         for (int i = 0; i < size; i++) {
             if (i != 0) {
                 sb.append(", ");
             }
             sb.append(elements[i]);
//             if (i != size -1) {
//                 sb.append(", ");
//             }
         }

        sb.append("]");
        return sb.toString();
    }
}
