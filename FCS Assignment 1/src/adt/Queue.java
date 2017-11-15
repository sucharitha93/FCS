package adt;

public interface Queue<E> {
	 public int size();
	    public boolean isEmpty();
	    public E front();
	    public void enqueue(E o);
	    public E dequeue();
}
