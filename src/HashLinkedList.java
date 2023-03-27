public class HashLinkedList<K,V> {

    HashNode<K, V> head;
    HashNode<K, V> tail;

    public void push(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void add(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void show() {
        HashNode<K, V> temp = head;
        while (temp != null) {
            System.out.print(temp.key + " = " + temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }


    public HashNode<K, V> pop() {
        if (head == null)
            return null;
        HashNode<K, V> popData = head;
        head = head.next;
        return popData;
    }

    public HashNode<K, V> popLast() {
        if (head == null)
            return null;
        HashNode<K, V> popData = tail;
        if (head == tail) {
            head = null;
            return popData;
        }
        HashNode<K, V> temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return popData;
    }

    public HashNode<K, V> search(K searchData) {
        HashNode<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(searchData))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public boolean insertAfter(K searchData, K insertKey,V insertValue) {
        HashNode<K, V> newNode = new HashNode<>(insertKey,insertValue);
        HashNode<K, V> searchedNode = search(searchData);
        if (searchedNode != null) {
            newNode.next = searchedNode.next;
            searchedNode.next = newNode;
            return true;
        }
        return false;
    }

    public boolean delete(K key) {
        HashNode<K, V> temp = head;
        HashNode<K, V> temp2 = head;
        HashNode<K, V> temp3 = head;
        int count = 0;
        while (temp != null & temp2 != null & temp3 != null) {
            count++;
            if (count > 2) {
                temp3 = temp3.next;
            }
            if (temp.key == key) {
                temp2 = temp2.next;
                temp3.next = temp2;
                return true;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return " \n{" + head + "}";
    }
}
