public class HashNode<K,V> {
    K key;

    V value;
    HashNode<K,V> next;

    public HashNode(K key,V value){
        this.key = key;
        this.value = value;
    }

    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append("Node: " + " K= ").append(key).append(", V= ").append(value).append("\n");
        if (next != null)
            nodeString.append(" , ").append(next);
        return nodeString.toString();
    }
}
