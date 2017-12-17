public class Node<N> implements INode<N> {
	N val;
	public Node(N _val) {
		val = _val;
	}
	public void setValue(N v) {
		val = v;
	}
	public N getValue() {
		return val;
	}
}