public class SingleLinkList<T> implements IList<T> {

	SLink<T> curr;
	SLink<T> tail;
	SLink<T> head;
	int size;


	//constructor, only creates an empty pointer
	public SingleLinkList() {
		curr = tail = head = new SLink<T>(null, null); //got this idea from the textbook
		size = 0;
	}

	public void append(T v) {
		//create a new link
		SLink<T> appL = new SLink<T>(v, null);
		//add the pointer to the current tail
		tail.setNext(appL);
		//move tail and curr, add to size
		tail = appL;
		curr = appL;
		size += 1;
	}

	public void remove() {
		//a loop to find the item before curr
		boolean indicator = true;
		SLink<T> prevloc;
		SLink<T> currloc = head;
		while indicator {
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
		SLink<T> currloc = head;
		//a loop to find the item before idx
		for (i=0; i<idx-1; i++) {
			currloc = currloc.getNext();
		}  //the resulted currloc is actually the previous loc before idx
		if (currloc.getNext() == curr) {curr = currloc;}
		else if (currloc.getNext() == tail) {tail = currloc;}
		currloc.setNext((currloc.getNext()).getNext());
		size--;
	}
}