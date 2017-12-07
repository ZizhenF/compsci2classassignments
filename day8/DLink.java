public class DLink<T> implements IDLink<T> {
	T val;
	DLink<T> prev;
	DLink<T> next;

	public DLink(T _val, DLink<T> _prev, DLink<T> _next) {
		val = _val;
		prev = _prev;
		next = _next;
	}

	public T getValue() {
		return val;
	}

	public void setValue(T v) {
		val = v;
	}

	public IDLink<T> getNext() {
		return (IDLink<T>) next;
	}

	public IDLink<T> getPrev() {
		return (IDLink<T>) prev;
	}

	public void setNext(IDLink<T> c) {
		next = (DLink<T>) c;
	}

	public void setPrev(IDLink<T> c) {
		prev = (DLink<T>) c;
	}
}