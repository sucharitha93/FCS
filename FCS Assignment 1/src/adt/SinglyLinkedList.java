/**
 * 
 */
package adt;

/**
 * @author SucharithaReddy
 *
 */
public class SinglyLinkedList<E> {
	
		

	private Node<E> head;
	private Node<E> tail;
	private int size;
	public Node<E> Head()
	{
		return head;
	}
	
	public Node<E> Tail()
	{
		return tail;
	}
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public void AddFirst(E e)
	{
		Node<E> temp = new Node(e);
		if(Size()==0)
		{
			head = new Node<E>(e);
			tail = new Node<E>(e);
			size=size+1;
		}
		else
		{
			temp.setNext(head);
			head=temp;
			size=size+1;
		}
		
	}
	public void AddLast(E e)
	{
		Node<E> temp = new Node(e);
		tail = Head();
		if(Size()==0)
		{
			head = new Node<E>(e);
			tail = head;
			size=size+1;
		}
		else
		{
			while(tail.getNext()!=null)
			{
				tail=tail.getNext();
			}
			tail.setNext(temp);
		}		
	}
	public E RemoveFirst()
	{
		if(head == null)
		{
			System.out.println("List is empty !");
			return null;
		}
		else
		{
			E e = head.getValue();
			head.nodeAssign(head.getNext());
			return e;
		}		
	}
	public int Size()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		if(this.Size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	void Delete(int position)
    {
        // If linked list is empty
        if (head == null)
            System.out.println("List is empty");
 
        // Store head node
        Node<E> temp = new Node();
        temp = head;
 
        // If head needs to be removed
        if (position == 0)
        {
        	head=head.getNext();
            size=size-1;
        }
        else if(position > Size())
        {
        	System.out.println("Position specified exceeds the size !");
        }
        else
        {
        	for(int i=0;i<position-2;i++)
        	{
        		temp=temp.getNext();
        	}
        	Node<E> t = new Node();
        	t=temp.getNext().getNext();
        	temp.setNext(t);
        	size=size-1;        	        	
        } 
    }
	
	public String printlist()
	{
		String s="";
		Node<E> tnode = new Node();
		tnode.nodeAssign(head);
		s=s+"{";
        while (tnode.getNext() != null)
        {
            s=s+tnode.getValue()+",";
            tnode.nodeAssign(tnode.getNext());
        }
        s=s+tnode.getValue()+"}";
        return s;
	}
	
	public boolean contains(E e) 
	{
		Node<E> cur = new Node<>();
		if(head !=null)
		{
			cur.nodeAssign(head);
			for(int i =0;i<Size();i++)
			{
				if(e==cur.getValue())
				{
					return true;
				}
				cur.nodeAssign(cur.getNext());				
			}
		}	
		return false;	
	}
}
