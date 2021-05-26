package t3_linkedlist;

/**
 * LinkedListToQueueAndStackCode02
 *
 * @author cmz
 * @date 2021-05-26 22:55
 */
public class LinkedListToQueueAndStackCode02 {

    public static class Node<V> {

        public Node<V> next;
        public V value;

        public Node(V v) {
            this.value = v;
        }
    }


    public static class LinkedListQueue<V> {

        public Node<V> head;

        public Node<V> tail;

        public int size;

        public LinkedListQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void offer(V v) {
            if (v == null) {
                return;
            }
            Node<V> node = new Node<>(v);
            if (head == null) {
                head = node;
            } else {
                head.next = node;
            }
            tail = node;
            size++;

        }

        public V poll() {
            V v = null;
            if (head != null) {
                v = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return v;
        }


        public V peek() {
            V v = null;
            if (head != null) {
                v = head.value;
            }
            return v;
        }
    }


    public static class LinkedListStack<V> {
        public Node<V> head;
        public int size;

        public LinkedListStack() {
            head = null;
            this.size = 0;
        }


        public void push(V v) {
            if (v == null) {
                return;
            }
            Node<V> node = new Node<>(v);
            if (head != null) {
                node.next = head;
            }
            head = node;
            size++;
        }

        public V pop() {
            V v = null;
            if (head != null) {
                v = head.value;
                head = head.next;
                size--;
            }
            return v;
        }


        public V peek() {
            V v = null;
            if (head != null) {
                v = head.value;
            }
            return v;
        }

    }


}

