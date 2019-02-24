package com.codify.datastructure;

public class Queue<E> {

	int front, rear, DEFAULT_SIZE;

	E[] queue;

	public Queue() {

		front = rear = -1;
		DEFAULT_SIZE = 10;

		queue = (E[]) new Object[DEFAULT_SIZE];

	}

	public void enqueue(E e) {

		if (isFull()) {

			resize(2 * queue.length);
		}

		else if (isEmpty()) {

			++front;
			++rear;

		} else {

			rear = (rear + 1) % queue.length;
		}

		queue[rear] = e;
	}

	public E dequeue() {

		E e = null;

		if (isEmpty()) {

			System.out.println("Queue is empty: ");
			return null;

		} else if (front == rear) {

			front--;
			rear--;

		} else {

			e = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
		}

		return e;

	}

	private boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	private void resize(int newSize) {

		E[] temp = (E[]) new Object[newSize];

		for (int i = 0; i < queue.length; i++) {
			temp[i] = queue[i];
		}

		queue = temp;

		temp = null;

	}

	private boolean isFull() {
		return rear == queue.length - 1;
	}

	private int size() {
		return rear + 1;
	}

	private void printQ() {
		for (E e : queue) {
			if (e != null) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {

		Queue<Integer> q = new Queue<>();

		q.enqueue(10);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(20);

		System.out.println("Queue size: " + q.size());

		System.out.println("\nElements in queue: \n");
		q.printQ();

		System.out.println("\nElements after dequeue: " + q.dequeue());
		q.printQ();

		System.out.println("\nElements after dequeue: " + q.dequeue());
		q.printQ();

	}

}
