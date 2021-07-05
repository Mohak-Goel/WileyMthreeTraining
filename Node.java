package companyname.projectname.modulename;

public class Node {
	private int data;
	private Node next;
	private Node prev;
	
	Node(){
		data = 0;
		next = null;
		prev = null;
	}
	
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
