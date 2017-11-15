/**
 * 
 */
package adt;

/**
 * @author SucharithaReddy
 *
 */
public class CircularArrayQueue<E> implements Queue<E>
{
	private final int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private E[] queue; 
	
	public CircularArrayQueue()
	{
		front = rear = count = 0;
		queue = (E[]) (new Object[DEFAULT_CAPACITY]);
	}
	
	public CircularArrayQueue (int initialCapacity)
	{
		front = rear = count = 0;
		queue = ( (E[])(new Object[initialCapacity]) );
	}
	
	public void enqueue (E element)
	{
		if (size() == queue.length) 
			expandCapacity();
		queue[rear] = element;
		rear = (rear+1) % queue.length;
		count++;
	}
	
	public E dequeue()
	{
		if (isEmpty())
			System.out.println("Empty !");
		E result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		count--;
		return result;
	}
	
	public E first()
	{
		if (isEmpty())
			System.out.println("Empty !");
		return queue[front];
	}
	
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	public int size()
	{
		return count;
	}
	
	public String toString()
	{
		String result = "{";
		int scan = 0;
		while(scan < count)
		{
			if(queue[scan]!=null)
			{
				result += queue[scan].toString()+",";
			}
			scan++;
		}
		result+="}";
		return result;
	}
	
	public void expandCapacity()
	{
		E[] larger = (E[])(new Object[queue.length *2]);   
		for(int scan=0; scan < count; scan++)
		{
			larger[scan] = queue[front];
			front=(front+1) % queue.length;
		}			
		front = 0;
		rear = count;
		queue = larger;
	}

	public E front()
	{
		return queue[front];
	}
	
}