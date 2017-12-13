public class MergeSort<T extends Comparable> implements ISort<T> {

	public MergeSort() {}

	public void sort(T[] in) {
		this.split(in, 0, in.length-1);
	}

	/**
	* @param ls the complete list need to be sorted
	* @param s the starting index of this segment
	* @param e the end index of this segment
	*/
	public void split(T[] ls, int s, int e) {
		if (s == e) {return;}
		int mid = (s+e)/2;
		this.split(ls, s, mid);
		this.split(ls, mid+1, e);
		this.merge(ls, s, mid, e);
	}

	public void merge(T[] ls, int s, int mid, int e) {
		T[] temp = (T[]) new Comparable[e-s+1];
		int tempidx = 0;
		int leftptr = s;
		int rightptr = mid+1;
		while (leftptr<=mid && rightptr<=e) {
			if (ls[leftptr].compareTo(ls[rightptr])<=0) {
				temp[tempidx] = ls[leftptr];
				tempidx++;
				leftptr++;
			}
			else if (ls[leftptr].compareTo(ls[rightptr])>0) {
				temp[tempidx] = ls[rightptr];
				tempidx++;
				rightptr++;
			}
		}
		while (leftptr<=mid && rightptr>e) {
			temp[tempidx] = ls[leftptr];
			tempidx++;
			leftptr++;
		}
		while (rightptr<=e && leftptr>mid) {
			temp[tempidx] = ls[rightptr];
			tempidx++;
			rightptr++;
		}
		for (int i = 0; i < temp.length; i++) {
			ls[s+i] = temp[i];
		}
	}

	public String sortName() {
		return "Merge Sort";
	}


	/*
	public static void main(String[] args) {
		Integer[] ls = new Integer[9];
		ls[0] = 3;
		ls[1] = -11;
		ls[2] = 9;
		ls[3] = 90;
		ls[4] = 17;
		ls[5] = 16;
		ls[6] = 15;
		ls[7] = 40;
		ls[8] = 40;
		MergeSort<Integer> sortob = new MergeSort<Integer>();
		sortob.sort(ls);

		for (int i = 0; i<9; i++) {
			System.out.println(ls[i]);
		}
	}
	*/
	
}