public class DoubleLinkList<T> implements IList<T> {
	IDLink<T> head;
	IDLink<T> tail;
	IDLink<T> curr;
	int size;

	public DoubleLinkList() {
		head = new DLink(null, null, null);
		tail = head;
		curr = head;
		size = 0;
	}

	public void insert(int idx, T v) {
		//to avoid error in method move() when didx=size b/c it temporarily removes an item
		if (idx == size) {
			this.append(v);
			return;
		}

		IDLink<T>  newlink = new DLink(v, null, null);
		IDLink<T> aftern = head;
		for (int i = 0; i <= idx; i++) {
			aftern = aftern.getNext();
		}
		IDLink prevn = aftern.getPrev();
		prevn.setNext(newlink);
		newlink.setPrev(prevn);
		newlink.setNext(aftern);
		aftern.setPrev(newlink);
		size++;
	}

	public void append(T v) {
		IDLink<T> newlink= new DLink(v, (DLink<T>) tail, null);
		tail.setNext(newlink);
		tail = newlink;
		curr = tail;
		size++;
	}

	public void remove() {
		// avoid going into the real null head!!!!!!
		boolean iffirst = false;
		if (curr == head.getNext()) {
			iffirst = true;
		}
		if (curr == tail) {
			IDLink<T> prevcurr = curr.getPrev();
			prevcurr.setNext(null);
			curr.setValue(null);
			curr.setNext(null);
			curr.setPrev(null);
			curr = prevcurr;
			tail = prevcurr;
			size--;
			if (iffirst) {
				curr = curr.getNext();
			}
		}
		else {
			IDLink<T> prevcurr = curr.getPrev();
			IDLink<T> aftcurr = curr.getNext();
			prevcurr.setNext(aftcurr);
			aftcurr.setPrev(prevcurr);
			curr.setValue(null);
			curr.setPrev(null);
			curr.setNext(null);
			curr = prevcurr;
			size--;
			if (iffirst) {
				curr = curr.getNext();
			}
		}
	}

	public void remove(int idx) {
		IDLink<T> idxedlink = head;
		for (int i = 0; i <= idx; i++) {
			idxedlink = idxedlink.getNext();
		}
		IDLink<T> previdx = idxedlink.getPrev();
		if (idxedlink == curr) {
			curr = previdx;
		}
		if (idx == size-1) {
			previdx.setNext(null);
			idxedlink.setValue(null);
			idxedlink.setPrev(null);
			idxedlink.setNext(null);
			tail = previdx;
			size--;
		}
		else {
			IDLink<T> aftidx = idxedlink.getNext();
			previdx.setNext(aftidx);
			aftidx.setPrev(previdx);
			idxedlink.setValue(null);
			idxedlink.setPrev(null);
			idxedlink.setNext(null);
			size--;
		}
	}

	public void move(int sidx, int didx) {
		IDLink<T> sitem = head;
		for (int i=0; i<=sidx; i++) {
			sitem = sitem.getNext();
		}
		T sval = sitem.getValue();
		this.remove(sidx);
		this.insert(didx, sval);
	}

	public T fetch() {
		T val = curr.getValue();
		return val;
	}

	public T fetch(int idx) {
		IDLink<T> idxedlink = head;
		for (int i = 0; i <= idx; i++) {
			idxedlink = idxedlink.getNext();
		}
		return idxedlink.getValue();
	}

	public void next() {
		curr = curr.getNext();
	}

	public void prev() {
		curr = curr.getPrev();
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