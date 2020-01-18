package com.arbonkeep;

/**
 * @author arbonkeep
 * @date 2020/1/18 - 11:24
 * 链表的实现
 *      实现思想：链表需要有节点Node和元素个数Size，节点里面存储了具体元素以及指向下一个节点的值(将Node设置为内部类)
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;//链表的第一个节点

    //常量
    private static final int ELEMET_NOT_FOUND = -1;

    //内部类，Node
    public static class Node<E> {
        E element;//元素
        Node<E> next;//指向下一个节点

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 将所有元素清空
     */
    @Override
    public void clear() {
        size = 0;
        first = null;//将第一个指针断开即可
    }

    /**
     * 获取size
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断是否为null
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
        return indexOf(element) != ELEMET_NOT_FOUND;//索引不为-1，存在
    }

    /**
     * 获取index索引的元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;//调用寻找节点的方法，找到对应节点后获取element
    }

    /**
     * 将index位置的元素设置为element
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;//保存节点中旧的元素
        node.element = element;//将传入的元素赋值给节点
        return old;
    }

    /**
     * 在index位置添加一个元素
     * @param index
     * @param element
     * 思想：找到index的前一个节点prev，让prev.next指向新创建的节点(new Node<>(element, prev.next))
     *      注意：在新创建的节点中，next指向的是原来的prev.next
     */
    @Override
    public void add(int index, E element) {//index可能为0
        if (index == 0) {//在最前面添加元素
            first = new Node<>(element, first);//将first.next指向first
        } else {
            //找到前面一个节点
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);

        }
        //维护size
        size++;
    }

    /**
     * 删除index处的元素
     * @param index
     * @return
     * 思想：将index前一个节点的next指向index后一个节点
     */
    @Override
    public E remove(int index) {
        //记录需要删除的节点
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            //找到需要删除节点的前一个节点
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;//prev.next = prev.next.next
        }
        size--;
        return node.element;
    }

    /**
     * 查看元素对应的索引
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {//判断元素是否为null
            Node<E> node = first;//记录第一个节点
            for (int i = 0; i < size; i ++) {//遍历
                if (node.element == null) return i;//如果节点中的元素为null就将i返回
                node = node.next;//每次循环，都需要获取到下一个节点
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i ++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMET_NOT_FOUND;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     * 思想：记录第一个节点，当我们需要找到index对应的节点总共需要向后寻找index次
     */
    private Node<E> node(int index) {
        rangeCheck(index);//判断索引是否合法

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;//向下寻找index次找到该节点，并赋值给node
        }
        return node;
    }

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size=").append(size).append(", [");
        //遍历方法一
        Node<E> node = first;//找到第一个节点
        for (int i = 0; i < size; i++) {//遍历
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(node.element);
            node = node.next;//每次循环需要获取到下一个节点
        }
        //遍历方法二
//        Node<E> node1 = first;
//        while (node1 != null) {//最后一个节点null
//
//
//
//            node1 = node1.next;
//        }

        sb.append("]");
        return sb.toString();
    }
}
