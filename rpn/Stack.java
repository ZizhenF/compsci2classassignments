public class Stack<T> implements IStack<T> {
	T[] ls;
	int top;
	int size;

	public Stack(int _size) {
		size = _size;
		ls = (T[]) new Object[size];
		top = -1;
	}

	public void push(T v) throws OverFlowException {
		if (top>=size-1) {throw new OverFlowException();}
		ls[top+1] = v;
		top++;
	}

	public T pop() throws UnderFlowException {
		if (top<0) {throw new UnderFlowException();}
		T topval = ls[top];
		ls[top] = null;
		top--;
		return topval;
	}
}