package edu.monmouth.hw2;

import edu.monmouth.book.*;

public class Node {
	
	private Book info;
	private Node next;
  
	public Node(Book info) {
		this.info = info;
		next = null;
	}
	public void setInfo(Book info) {
		this.info = info;
	}
	public Book getInfo() {
		return info;
	}
	public void setNext(Node link) {
		this.next = link;
	}
	public Node getNext() {
		return next;
	}
  
	@Override 
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(info);
		return build.toString();
	}
}
