public class BinaryTree<K extends Comparable<K>,V> {
	Node<K, V> curr;
	Node<K, V> root;
	int size;
	ArrayList<K> kls;

	public BinaryTree() {
		root = null;
		curr = null;
		size = 0;
		kls = new ArrayList<K>();
	}

	public int size() {
		return size;
	}

	public void insert(K k, V v) {
		if (root == null) {
			root = new Node(k, v);
			return;
		}
		curr = root;
		helper(k, v);
		kls.append(k);
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
		// special case: if curr is the root
		if ((root.getKey()).compareTo(k)==0) {
			Node<K, V> swapnode = root.getLeft();
			Node<K, V> swapparent = root;
			while (swapnode.getRight() != null) {
				swapparent = swapnode;
				swapnode = swapnode.getRight();
			}	
			swapnode.setRight(root.getRight());
			swapnode.setLeft(root.getLeft());
			swapparent.setRight(null);
			root = swapnode;
			size--;
			kls.remove(k);
			return;
		}

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
		kls.remove(k);
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

	public ArrayList<K> getKeys() {
		return kls;
	}


	/*
	public static void main(String[] args) {
		BinaryTree<Integer,Integer> t = new BinaryTree<Integer,Integer>();
		t.insert(17,17);
		t.insert(20,20);
		t.insert(25,25);
		t.insert(18,18);
		t.insert(1,1);
		t.insert(21,21);
		t.insert(22,22);
		t.insert(13,13);
		t.insert(14,14);
		t.insert(27,27);
		t.insert(5,5);
		t.remove(20);
		t.remove(17);
		t.remove(27);
		System.out.println(t.fetch(18));
	}
	*/
}