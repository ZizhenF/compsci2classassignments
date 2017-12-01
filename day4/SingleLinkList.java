public class SingleLinkList<T> implements IList<T> {

	ISLink<T> curr;
	ISLink<T> tail;
	ISLink<T> head;
	int size;


	//constructor, only creates an empty pointer
	public SingleLinkList() {
		curr = tail = head = new SLink<T>(null, null); //got this idea from the textbook
		size = 0;
	}

	public void append(T v) {
		//create a new link
		ISLink<T> appL = new SLink<T>(v, null);
		//add the pointer to the current tail
		tail.setNext(appL);
		//move tail and curr, add to size
		tail = appL;
		curr = appL;
		size += 1;
		if (size == 1) {
			head = appL;
		}
	}

	public void remove() {
		//a loop to find the item before curr
		boolean indicator = true;
		ISLink<T> prevloc = new SLink(null, null);
		ISLink<T> currloc = head;
		while (indicator) {
			prevloc = currloc;
			currloc = currloc.getNext();
			if (currloc == curr) {
				indicator = false;
			}  //note here the prevloc is just an aliase of the actual link storage 
		}
		//reset the pointer
		prevloc.setNext(curr.getNext());
		if (curr == tail) {tail = prevloc;}
		curr = prevloc;
		size--;
	}

	public void remove(int idx) {
		//a loop to find the item before idx
		ISLink<T> currloc = head;
		for (int i=0; i<idx-1; i++) {
			currloc = currloc.getNext();
		}  //the resulted currloc is actually the previous loc before idx
		if (currloc.getNext() == curr) {curr = currloc;}
		else if (currloc.getNext() == tail) {tail = currloc;}
		currloc.setNext((currloc.getNext()).getNext());
		size--;
	}

	public void insert(int idx, T v) {
		//find the previous
		ISLink<T> currloc = head;
		for (int i=0; i<idx; i++) {
			currloc = currloc.getNext();
		}
		//create new link
		ISLink<T> ins = (ISLink<T>) new SLink<T>(v, (SLink<T>) currloc.getNext());
		//change the tail/head if needed, reset the pointer of the prev
		if (currloc == tail) {tail = ins;}
		if (idx == 0) {head = ins;}
		currloc.setNext(ins);
		size++;
	}

	public T fetch() {
		return curr.getValue();
	}

	public T fetch(int idx) {
		ISLink<T> currloc = head;
		for (int i=0; i<idx; i++) {
			currloc = currloc.getNext();
		}
		return currloc.getValue();
	}

	public void move(int sidx, int didx) {
		T tarVal = this.fetch(sidx);
		this.remove(sidx);
		this.insert(didx, tarVal);
	}

	public void next() {
		curr = curr.getNext();
	}

	public void prev() {
		boolean indicator = true;
		ISLink<T> prevloc = tail;
		ISLink<T> currloc = head;
		while (indicator) {
			prevloc = currloc;
			currloc = currloc.getNext();
			if (currloc == curr) {
				indicator = false;
			}
		}
		curr = prevloc;
	}

	public void jumpToTail() {
		curr = tail;
	}

	public void jumpToHead() {
		curr = head;
	}

	public int size() {
		return size;
	}
}