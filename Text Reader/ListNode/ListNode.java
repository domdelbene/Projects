package edu.monmouth.hw2;

import edu.monmouth.book.*;

public class ListNode {

	private Node head; 

	public ListNode() {
		head = null;
	}
	public Node removeFirst() {
		if(head == null) {
			return null;
		}
		else {
			Node first = head;
			head = first.getNext();
			return first;
		}
	}
	public Node first() {
		return head;
	}
	public Node last() {
		Node last = head;
		if(last != null) {
			while(last.getNext() != null) {
				last = last.getNext();
			}
		}
		return last;
	}
	public void insert(Book element) {
		Node newNode = new Node(element);
		newNode.setNext(head);
		head = newNode;
	}
	public void insertEnd(Book element) {
		Node end = head;
		while(end.getNext() != null) {
			end = end.getNext();
		}
		Node newNode = new Node(element);
		end.setNext(newNode);
	}
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	public int size() {
		Node node = head;
		int count = 0;
		
		while(node != null) {
			node = node.getNext();
			count++;
		}
		return count;
	}
	public void clear() {
		head = null;
	}

	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		Node node = head;
		int count = 1;
		
		while(node != null) {
			build.append(count + ". " + node.getInfo() + "\n");
			node = node.getNext();
			count++;
		}
		return build.toString();
	}
}
