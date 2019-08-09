package com.Rahul;

// TODO: Auto-generated Javadoc
/**
 * The Interface PriorityQueue.
 */
public interface PriorityQueue {
	
	/**
	 * Enqueue.
	 *
	 * @param bowler the bowler
	 */
	public void enqueue(Bowler bowler);
	
	/**
	 * Dequeue.
	 *
	 * @return the bowler
	 */
	public Bowler dequeue();
	
	/**
	 * Top.
	 *
	 * @return the bowler
	 */
	public Bowler top();
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Checks if is full.
	 *
	 * @return true, if is full
	 */
	public boolean isFull();

	/**
	 * Decrease key.
	 */
	public void decreaseKey();
}
