public class DictItem<K, V> {
	K key;
	V value;

	public DictItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}