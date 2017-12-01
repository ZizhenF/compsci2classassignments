public class SLink<T> implements ISLink<T> {
	T val;
	SLink<T> next;  //points to the next cell

	public SLink(T _val, SLink<T> _next) {
		this.val = _val;
		this.next = _next;
	}

	public T getValue() {
		return val;
	}

	public void setValue(T v) {
		val = v;
	}

	public ISLink<T> getNext() {
		return ((ISLink<T>) next);
	}

	public void setNext(ISLink<T> c) {
		next = (SLink<T>) c;
	}
}