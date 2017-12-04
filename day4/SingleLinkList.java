public class SingleLinkList<T> implements IList<T> {
	ISLink<T> head;
	ISLink<T> tail;
	ISLink<T> curr;
	int size;

	public SingleLinkList() {
		head = new SLink(null, null);
		tail = head;
		curr = head;
		size = 0;
	}

	public void insert(int idx, T v) {
		//find the item right before the indexed
		ISLink<T> currloc = head;
		for (int i = 0; i < idx; i++) {
			currloc = currloc.getNext();
		}
		//set nexts;
		ISLink<T> curr_indexed = currloc.getNext();
		ISLink<T> newitem = new SLink(v, (SLink<T>) curr_indexed);
		currloc.setNext(newitem);
		size++;
	}

	public void append(T v) {
		ISLink<T> newitem = new SLink(v, null);
		tail.setNext(newitem);
		tail = newitem;
		curr = tail;
		size++;
	}

	public void remove() {
		boolean iftail = false;
		boolean iffirst = false;
		if (curr == tail) {
			iftail = true;
		}
		if (curr == head.getNext()) {
			iffirst = true;
		}
		//find the item before curr
		ISLink<T> prevloc = head;
		ISLink<T> currloc = head;
		boolean notfound = true;
		while (notfound) {
			prevloc = currloc;
			currloc = currloc.getNext();
			if (currloc == curr) {
				notfound = false;
			}
		}
		//remove
		if (iftail) {
			prevloc.setNext(null);
			tail = prevloc;
		}
		else {
			prevloc.setNext(curr.getNext());
		}
		curr.setValue(null);
		curr.setNext(null);
		// avoid going into the real null head!!!!!!
		if (iffirst) {
			curr = prevloc.getNext();
		}
		else {
			curr = prevloc;
		}
		size--;
	}

	public void remove(int idx) {
		boolean iftail = false;
		if (idx == size-1) {
			iftail = true;
		}
		//find the item before idx
		ISLink<T> currloc = head;
		for (int i = 0; i < idx; i++) {
			currloc = currloc.getNext();
		}
		ISLink<T> idxloc = currloc.getNext();
		//remove
		if (curr == idxloc) {
			curr = currloc;
		}
		if (iftail) {
			currloc.setNext(null);
			tail = currloc;
		}
		else {
			currloc.setNext(idxloc.getNext());
		}
		idxloc.setValue(null);
		idxloc.setNext(null);
		size--;
	}

	public void move(int sidx, int didx) {
		ISLink<T> si = head;
		for (int i = 0; i <= sidx; i++) {
			si = si.getNext();
		}
		T sv = si.getValue();
		this.remove(sidx);
		this.insert(didx, sv);
	}

	public T fetch() {
		return curr.getValue();
	}

	public T fetch(int idx) {
		ISLink<T> currloc = head;
		for (int i = 0; i <= idx; i++) {
			currloc = currloc.getNext();
		}
		return currloc.getValue();
	}

	public void next() {
		if (curr != tail) {
			curr = curr.getNext();
		}
	}

	public void prev() {
		if ((curr != head)&(curr != head.getNext())) {
			boolean notfound = true;
			ISLink<T> prevloc = head;
			ISLink<T> currloc = head;
			while (notfound) {
				prevloc = currloc;
				currloc = currloc.getNext();
				if (currloc == curr) {
					notfound = false;
				}
 			}
 			curr = prevloc;
		}
	}

	public void jumpToTail() {
		curr = tail;
	}

	public void jumpToHead() {
		curr = head.getNext();
	}

	public int size() {
		return size;
	}
}