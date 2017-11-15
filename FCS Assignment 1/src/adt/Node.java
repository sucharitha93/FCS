package adt;


public class Node<E>{
	private E value;
	private Node<E> next;
	
	public Node()
	{
		this.value = null;
		this.next = null;
	}
	
	public Node(E value) {
		this.value = value;
		this.next = null;
	}
	public void nodeAssign(Node<E> e)
	{
		if(e!=null)
		{
			this.setValue(e.getValue());
			this.setNext(e.getNext());
		}
			
		
					
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}		
}
