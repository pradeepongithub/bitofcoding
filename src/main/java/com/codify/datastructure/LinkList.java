package com.codify.datastructure;

public class LinkList<E> {

	LinkList() {
		head = new Node<>();
	}

	private static class Node<E> {

		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
		}

		public Node() {

		}
	}

	Node<E> head;

	public void addFirst(Node<E> node) {

		Node<E> current = head;
		head = node;
		head.next = current;

	}

	public void addLast(Node<E> node) {
		
		Node<E> current = head;
		Node<E> last = null;

		while (current != null && current.data != null) {
			last = current;
			current = current.next;
		}
		last.next = node;
	}

	public E getFist() {

		return head.data;
	}

	public E getLast() {

		Node<E> current = head;
		Node<E> last = null;

		while (current != null) {
			last = current;
			current = current.next;
		}

		return last.data;
	}

	public void removeFirst() {
		head = head.next;
	}

	public void removeLast() {
		
		Node<E> current = head;
		Node<E> last = null;

		while (current.next != null) {
			last = current;
			current = current.next;
		}
		
		last.next = null;
	}

	public static void main(String[] args) {

		Node<Integer> a = new Node<>(10);
		Node<Integer> b = new Node<>(5);
		Node<Integer> c = new Node<>(20);

		LinkList<Integer> list = new LinkList<>();

		list.addFirst(a);
		list.addFirst(b);
		list.addFirst(c);

		System.out.println("Add at first -- ");

		print(list);

		System.out.println("\n");
		System.out.println("Add at last -- ");

		Node<Integer> n1 = new Node<>(9);
		Node<Integer> n2 = new Node<>(12);
		Node<Integer> n3 = new Node<>(7);

		list.addLast(n1);
		list.addLast(n2);
		list.addLast(n3);
		print(list);

		System.out.println("\n");

		System.out.println("Get First: " + list.getFist());
		System.out.println("\nGet Last : " + list.getLast());
		list.removeFirst();
		System.out.println("\nRemove First : ");
		print(list);
		list.removeLast();
		System.out.println("\nRemove Last : ");
		print(list);

	}

	private static void print(LinkList<Integer> list) {

		Node<Integer> temp = list.head;

		while (temp != null) {

			System.out.print(" -> " + temp.data);

			temp = temp.next;

		}

	}

}
