package com.Rahul;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author : Rahul Vijay
 * created : 08/08/2019
 * The Class MainHeap.
 * Initialize heap object and call heap methods such as insert, extractMax, decreaseKey
 */
public class MainHeap {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		PriorityQueue priorityQueue = new Heap(10);
		System.out.println("Heap");
		Scanner sc = new Scanner(System.in);
		int numberOfBowlers = sc.nextInt();
		int totalBallsPlayed = sc.nextInt();
		/*Bowler b1 = new Bowler("bumrah", 5);
		priorityQueue.enqueue(b1);
		Bowler b2 = new Bowler("bhuvneshwar", 5);
		priorityQueue.enqueue(b2);
		Bowler b3 = new Bowler("pandya", 5);
		priorityQueue.enqueue(b3);
		Bowler b4 = new Bowler("chahal", 5);
		priorityQueue.enqueue(b4);
		Bowler b5 = new Bowler("kuldeep", 5);
		priorityQueue.enqueue(b5);*/
		int i = 0;
		while(i < numberOfBowlers){
			String bowlerName = sc.next();
			try {
	            System.out.print("Enter an integer: ");
				int ballsLeft = sc.nextInt();
	            System.out.println("You entered " + ballsLeft);
	            Bowler b = new Bowler(bowlerName, ballsLeft);
				priorityQueue.enqueue(b);
				i++;
	        } catch (InputMismatchException e) {
	        	throw new InputMismatchException("invalid input");
	            //System.out.println("You have entered invalid data");
	        }
		}
		while(totalBallsPlayed != 0){
			priorityQueue.decreaseKey();
			totalBallsPlayed--;
		}
	}
}
