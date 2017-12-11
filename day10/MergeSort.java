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
		for (int i=s; i<=mid; i++) {
			if (i<=mid && i<=e) {
				if (ls[i].compareTo(ls[mid+i-s]) > 0) {
					T swap = ls[mid+i-s];
					ls[i] = ls[mid+i-s];
					ls[mid+i-s] = ls[i];
				}
			}
		}
	}

	public String sortName() {
		return "Merge Sort";
	}


	/*
	public static void main(String[] args) {
		Integer[] ls = new Integer[10];
		ls[0] = 3;
		ls[1] = -11;
		ls[2] = 9;
		ls[3] = 90;
		ls[4] = 17;
		ls[5] = 16;
		ls[6] = 15;
		ls[7] = 40;
		ls[8] = 52;
		ls[9] = -10;
		SelectSort<Integer> sortob = new SelectSort<Integer>();
		sortob.sort(ls);

		for (int i = 0; i<10; i++) {
			System.out.println(ls[i]);
		}
	}
	*/
}