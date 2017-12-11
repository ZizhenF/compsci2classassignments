public class SelectSort<T extends Comparable> implements ISort<T> {

	public SelectSort() {}

	public void sort(T[] in) {
		int sorted = 0;
		for (int i=0; i<in.length; i++) {
			int minidx = i;
			for (int j=sorted+1; j<in.length; j++) {
				if (in[j].compareTo(in[minidx])<0) {
					minidx = j;
				}
			}
			T swap = in[minidx];
			in[minidx] = in[i];
			in[i] = swap;
			sorted++;
		}
	}

	public String sortName() {
		return "Select Sort";
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