package com.Rahul;

import java.util.Arrays;

public class CircularQueue<E> {
	private int currentSize; //Current Circular Queue Size
    private E[] circularQueueElements;
    private int maxSize; //Circular Queue maximum size

    private int rear;//(new element enqueued at rear).
    private int front; //(element will be dequeued from front).
    
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (E[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }
    
    public void enqueue(E item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;
            
            if (front == -1) {
				front = rear;
			}
        }
    }
    
    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }
    
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }
    
    public boolean isEmpty() {
        return (currentSize == 0);
    }
    
    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }
    
}
