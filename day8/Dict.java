public class Dict<K extends Comparable<K>,V> implements IDict<K, V> {
	IList<DictItem> dict;

	public Dict() {
		dict = (IList<DictItem>) new DoubleLinkList<DictItem>();

	}

	public V add(K k, V v) {
		V currval = this.fetch(k);
		DictItem<K, V> n = new DictItem(k, v);
		dict.append(n);
		return currval;
	}

	public V remove(K k) {
		DictItem<K, V> curr;
		V currval = null;
		for (int i=0; i<dict.size(); i++) {
			curr = dict.fetch(i);
			if (curr.getKey()==k) {
				currval = curr.getValue();
				dict.remove(i);
				return currval;
			}
		}
		return null;
	}

	public int size() {
		return dict.size();
	}

	public V fetch(K k) {
		DictItem<K, V> curr;
		for (int i=0; i<dict.size(); i++) {
			curr = dict.fetch(i);
			if (curr.getKey()==k) {
				return curr.getValue();
			}
		}
		return null;
	}

	public K[] keys() {
		DictItem<K, V> curr;
		K[] keyls = (K[]) new Object[dict.size()];
		for (int i=0; i<dict.size(); i++) {
			curr = dict.fetch(i);
			keyls[i] = curr.getKey();
		}
		return keyls;
	}

}