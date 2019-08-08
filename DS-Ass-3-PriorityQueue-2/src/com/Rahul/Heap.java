package com.Rahul;

// TODO: Auto-generated Javadoc
/**
 * author : Rahul Vijay
 * created : 08/08/2019
 * The Class Heap.
 * Define Heap members and implement priority queue for bowlers using heap 
 */
public class Heap implements PriorityQueue{
	
	/** The arr. */
	Bowler[] arr;
	
	/** The size. */
	int size;
	
	/** The capacity. */
	int capacity;
	
	/**
	 * Instantiates a new heap.
	 *
	 * @param capacity the capacity
	 */
	public Heap(int capacity) {
		super();
		this.arr = new Bowler[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	/* (non-Javadoc)
	 * insert bowler into heap
	 */
	@Override
	public void enqueue(Bowler bowler) {
		int i;
		if(size ==  capacity){
			throw new RuntimeException("Queue is full");
		}
		else{
			arr[size] = bowler;
			i = size;
			size++;
			while(i != 0 && arr[i].ballsLeft > arr[parent(i)].ballsLeft){
				swap(i, parent(i));
				i = parent(i);
			}
		}
	}

	/**
	 * Swap.
	 *
	 * @param i the i
	 * @param parent the parent
	 */
	private void swap(int i, int parent) {
		Bowler temp = arr[i];
		arr[i] = arr[parent];
		arr[parent] = temp;
	}

	/**
	 * Parent.
	 *
	 * @param i the i
	 * @return the int
	 */
	private int parent(int i) {
		return i/2;
	}

	/* (non-Javadoc)
	 * remove bowler from heap and heapify again
	 */
	@Override
	public Bowler dequeue() {
		if(size == 0){
			throw new RuntimeException("Queue is empty");
		}
		Bowler max = arr[0];
		arr[0] = arr[size - 1];
		size--;
		
		maxHeapify(0);
		return max;
	}

	/**
	 * Max heapify.
	 * This method regains the property of max Heap
	 *
	 * @param i the i
	 */
	private void maxHeapify(int i) {
		while(right(i) < size){
			int left = left(i);
			int right = right(i);
			boolean flag = false;
			if(arr[i].ballsLeft < arr[left].ballsLeft){
				swap(i, left);
				flag = true;
			}
			if(arr[i].ballsLeft < arr[right].ballsLeft){
				swap(i, right);
				flag = true;
			}
			if(flag == false){
				return;
			}
			i++;
		}
	}

	/**
	 * return right child
	 *
	 * @param i the i
	 * @return the int
	 */
	private int right(int i) {
		return 2*i + 2;
	}

	/**
	 * return left child
	 *
	 * @param i the i
	 * @return the int
	 */
	private int left(int i) {
		return 2*i + 1;
	}

	/* (non-Javadoc)
	 * @see com.Rahul.PriorityQueue#top()
	 */
	@Override
	public Bowler top() {
		if(size == 0){
			throw new RuntimeException("Queue is empty");
		}
		return arr[0];
	}

	/* (non-Javadoc)
	 * @see com.Rahul.PriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 */
	@Override
	public boolean isFull() {
		if(size == capacity){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * decrease value of balls of bowler after every ball 
	 */
	@Override
	public void decreaseKey() {
		if(size == 0){
			throw new RuntimeException("No bowlers left");
		}
		System.out.println(arr[0].bowlerName + "  ");
		arr[0].ballsLeft--;
		
		maxHeapify(0);
	}

}
