public class Queue<T> implements IQueue<T> {
	T[] ls;
	int tail;
	int size;

	public Queue(int _size) {
		size = _size;
		tail = -1;
		ls = (T[]) new Object[size];
	}

	public T dequeue() throws UnderFlowException {
		if (tail < 0) {throw new UnderFlowException();}
		T headvalue = ls[0];
		T[] temp = (T[]) new Object[size];
		for (int i=0; i<tail; i++) {
			temp[i] = ls[i+1];
		}
		ls = temp;
		tail--;
		return headvalue;
	}

	public void enqueue(T v) throws OverFlowException {
		if (tail >= size-1) {throw new OverFlowException();}
		ls[tail+1] = v;
		tail++;
	}
}