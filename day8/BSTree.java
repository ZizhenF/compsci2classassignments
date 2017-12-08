public class BSTree<K extends Comparable<K>,V> implements IDict<K, V> {
	BinaryTree<K, V> dict;

	public BSTree() {
		dict = new BinaryTree();
	}

	public V add(K k, V v) {
		V currval = null;
		currval = dict.fetch(k);
		DictItem<K, V> n = new DictItem(k, v);
		dict.insert(k, v);
		return currval;
	}

	public V remove(K k) {
		V currval = dict.fetch(k);
		dict.remove(k);
		return currval;
	}

	public int size() {
		return dict.size();
	}

	public V fetch(K k) {
		return dict.fetch(k);
	}

	public K[] keys() {
		K[] kls = null;
		return kls;
	}
}