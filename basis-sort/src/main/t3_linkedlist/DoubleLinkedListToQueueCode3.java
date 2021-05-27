package t3_linkedlist;

/**
 * DoubleLinkedListToQueueCode3
 *
 * @author cmz
 * @date 2021-05-27 23:35
 */
public class DoubleLinkedListToQueueCode3 {

    public static class Node<V> {

        public Node<V> next;
        public Node<V> last;
        public V value;

        public Node(V v) {
            this.value = v;
            this.next = null;
            this.last = null;
        }


        public static class DoubleLinkedListQueue<V> {

            private Node<V> head;
            private Node<V> tail;

            private int size;

            public DoubleLinkedListQueue() {
                this.head = null;
                this.tail = null;
                this.size = 0;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public int size() {
                return this.size;
            }

            public void pushHead(V value) {
                if (value == null) {
                    return;
                }
                Node<V> node = new Node<>(value);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    head.last = node;
                    node.next = head;
                    head = node;
                }
                size++;
            }

            public void pushTail(V value) {
                if (value == null) {
                    return;
                }
                Node<V> node = new Node<>(value);
                if (tail == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.last = tail;
                    tail = node;
                }
                size++;
            }


            public V pollHead() {
                V v = null;
                if (head == null) {
                    return v;
                }
                size--;
                v = head.value;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.last = null;
                }
                return v;
            }

            public V pollTail() {
                V v = null;
                if (head == null) {
                    return v;
                }
                size--;
                v = tail.value;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.last;
                    tail.next = null;
                }
                return v;
            }

            public V peekHead() {
                V v = null;
                if (head != null) {
                    v = head.value;
                }
                return v;
            }

            public V peekTail() {
                V v = null;
                if (tail != null) {
                    v = tail.value;
                }
                return v;
            }
        }

    }


}
