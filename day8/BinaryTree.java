public class BinaryTree<K extends Comparable<K>,V> {
	Node<K, V> curr;
	Node<K, V> root;
	int size;

	public BinaryTree() {
		root = null;
		curr = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void insert(K k, V v) {
		if (root == null) {
			root = new Node(k, v);
		}
		curr = root;
		helper(k, v);
		size++;
	}

	public void helper(K k, V v) {
		if ((k.compareTo(curr.getKey())<0) && curr.getLeft() == null) {
			curr.setLeft(new Node(k, v));
			return;
		}
		else if ((k.compareTo(curr.getKey())>=0) && curr.getRight() == null) {
			curr.setRight(new Node(k, v));
			return;
		}
		if (k.compareTo(curr.getKey())<0) {
			curr = curr.getLeft();
			helper(k, v);
		}
		else if (k.compareTo(curr.getKey())>=0) {
			curr = curr.getRight();
			helper(k, v);
		}
	}

	public V fetch(K k) {
		curr = root;
		boolean notfound = true;
		while (notfound) {
			if(((curr.getKey()).compareTo(k)) == 0) {
				return curr.getValue();
			}
			else {
				if (k.compareTo(curr.getKey())<0) {
					curr = curr.getLeft();
				}
				else {
					curr = curr.getRight();
				}
			}
		}
		return null;
	}

	//what if the curr is the root?
	public void remove(K k) {
		// find the node to remove
		// use the code of fetch but also keep track of parent
		Node<K, V> parent = root;
		curr = root;
		boolean notfound = true;
		while (notfound) {
			if((curr.getKey()).compareTo(k)==0) {
				notfound = false;
			}
			else {
				if (k.compareTo(curr.getKey())<0) {
					parent = curr;
					curr = curr.getLeft();
				}
				else {
					parent = curr;
					curr = curr.getRight();
				}
			}
		}
		// case1: no children, kill the node
		if (curr.getLeft() == null && curr.getRight() == null) {
			if (parent.getLeft() == curr) {
				parent.setLeft(null);
			}
			else if (parent.getRight() == curr) {
				parent.setRight(null);
			}
			curr = null;
			size--;
			return;
		}

		// case2: one child, replace it with the child
		if (curr.getRight() == null) {
			if (parent.getLeft() == curr) {
				parent.setLeft(curr.getLeft());
			}
			else if (parent.getRight() == curr) {
				parent.setRight(curr.getLeft());
			}
			curr = null;
			size--;
			return;
		}

		else if (curr.getLeft() == null) {
			if (parent.getLeft() == curr) {
				parent.setLeft(curr.getRight());
			}
			else if (parent.getRight() == curr) {
				parent.setRight(curr.getRight());
			}
			curr = null;
			size--;
			return;
		}

		// case3: two children;
		// find the right most leaf of the left subtree (or vise versa), then replace
		Node<K, V> swapnode = curr.getLeft();  //先往左
		Node<K, V> swapparent = curr;
		while (swapnode.getRight() != null) {
			swapparent = swapnode;
			swapnode = swapnode.getRight();
		}

		
		swapnode.setRight(curr.getRight());
		swapnode.setLeft(curr.getLeft());
		if (parent.getLeft() == curr) {
			parent.setLeft(swapnode);
		}
		else if (parent.getRight() == curr) {
			parent.setRight(swapnode);
		}
		swapparent.setRight(null);
		size--;
	}
}