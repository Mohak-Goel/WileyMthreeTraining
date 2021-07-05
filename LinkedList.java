package companyname.projectname.modulename;

import companyname.projectname.modulename.Node;

public class LinkedList {
	
	Node head;
	Node tail;
	int size;
	
	LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	void add(int data) {
		Node newNode = new Node(10);
		if(head == null && tail == null)
		{
			head = tail = newNode;
		}
		else{
			tail.setNext(newNode);
			newNode.setPrev(tail);
		}
		size++;
	}
	
	void remove(int position) {
		if(head == null && tail == null)
		{
			return;
		}
		if(position>size)
			return;
		if(size == 1)
		{
			head=tail=null;
			size--;
		}
		if(position == 1) //1 is starting of LinkedList not 0 
		{
			Node temp = head.getNext();
			head = null;
			head = temp;
			head.setPrev(null);
			size--;
		}
		if(position == size) {
			Node temp = tail.getPrev();
			tail = null;
			tail = temp;
			tail.setNext(null);
			size--;
		}
		else {
			Node temp = head;
			for(int i = 1; i<position; i++) {
				temp = temp.getNext();
			}
			Node temp2 = temp.getNext();
			temp2.setPrev(temp.getPrev());
			temp.getPrev().setNext(temp2);
			temp=null;
			size--;
		}
	}
	
	public Node getNode(int position) {
		if(head == null && tail == null)
		{
			return null;
		}
		if(position>size)
			return null;
		else 
		{
			Node temp = head;
			for(int i = 1; i<position; i++) {
				temp = temp.getNext();
			}
			return temp;
		}
	}
}
