/*
 * James E
 */
public class MinHeap <T extends Comparable<T>> {
	private T[] heap;
	public static final int DEF_SIZE = 128;
	private int size;
	public MinHeap() {
		init(DEF_SIZE);
	}
	public MinHeap(int aS) {
		init(aS);
	}
	
	private void init(int aS) {
		if(aS >= 2) 
			heap = (T[])(new Comparable[aS]);
		else
			heap = (T[])(new Comparable[DEF_SIZE]);
		size = 0;
	}
	
	public void add(T aData) {
		if(size >= heap.length)
			return;
		heap[size] = aData;
		this.bubbleUp();
		size++;
	}
	private void bubbleUp() {
		int index = size;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index]) > 0) {
			//SWAP
			T temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	
	public T remove() {
		if(size <= 0)
			return null;
		T ret = heap[0];
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		this.bubbleDown();
		return ret;
	}
	private void bubbleDown() {
		int index = 0;
		while(index*2+1 < size) {
			//assume left is smaller
			int sNdex = index*2+1;
			//Confirm
			if(index*2-2 < size &&
					heap[index*2+1].compareTo(heap[index*2+2]) > 0)
				sNdex = index*2+2;
			if(heap[index].compareTo(heap[sNdex]) > 0) {
				T temp = heap[index];
				heap[index] = heap[sNdex];
				heap[sNdex] = temp;
			} else {
				break;
			}
			index = sNdex;
		}
	}
	
	public T peek() {
		return heap[0];
	}
	public void print() {
		for(int i = 0; i < size;i++) {
			System.out.println(heap[i]);
		}
	}
	public void heapSort(T[] array) {
		if(array == null)
			return;
		MinHeap<T> mHea = new MinHeap<T>(array.length);
		for(int i = 0; i < size;i++)
			mHea.add(array[i]);
		for(int i = 0; i < size;i++)
			mHea.remove();
	}
}

