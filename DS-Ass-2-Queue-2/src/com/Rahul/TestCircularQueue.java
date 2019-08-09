package com.Rahul;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCircularQueue {
	@Test
	public void circularQueueImplementation() {
		
        CircularQueue<Integer> circularQueue = new CircularQueue(8);
        
        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("Dequeued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("After enqueueing circular queue with element having value 23");
        System.out.println(circularQueue.toString());
        assertEquals("CircularQueue [[" + "23, 16, 17, 18, 19, 20, 21, 22" + "]]", circularQueue.toString());
    }
}
