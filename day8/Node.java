public class Node<K extends Comparable<K>,V> {
	Node<K,V> left;
	Node<K,V> right;
	K key;
	V value;

	public Node (K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Node<K,V> getLeft() {
		return left;
	}

	public Node<K,V> getRight() {
		return right;
	}

	public void setLeft(Node<K,V> n) {
		left = n;
	}

	public void setRight(Node<K,V> n) {
		right = n;
	}
}