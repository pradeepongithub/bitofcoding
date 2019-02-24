package com.codify.datastructure;

public class Stack<E> {

	int SIZE = 10;
	int top = -1;
	E[] stack;

	public Stack(int size) {
		this.SIZE = size;
		stack = (E[]) new Object[SIZE];
	}

	public Stack() {

	}

	private void resize(int newSize) {
		E[] items = (E[]) new Object[newSize];
		for (int i = 0; i <= top; i++) {
			items[i] = stack[i];
		}
		stack = items;

	}

	public void push(E e) {
		if (top == stack.length - 1) {
			resize(2 * stack.length);
		}
		stack[++top] = e;
	}

	public int size() {
		return top + 1;
	}

	public E pop() {
		if (top == -1) {
			System.out.println("Underflow: ");
			return null;
		}

		E e = stack[top];

		stack[top--] = null;

		if (top > 0 && top == stack.length / 4) {
			resize(stack.length / 2);

		}
		return e;
	}

	public E top() {
		if (top == -1) {
			System.out.println("Underflow: ");
			return null;
		}
		return stack[top];

	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(5);

		System.out.println("PUSH: ");
		stack.push(10);
		stack.push(20);
		stack.push(50);
		stack.push(4);
		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(9);

		System.out.println("POP : ");

		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.pop());
		}

	}

}
