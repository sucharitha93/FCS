package adt;



public class LinkedIntList {
	
	public static SinglyLinkedList<Integer> stutterTwo(SinglyLinkedList<Integer> i)
	{
		SinglyLinkedList<Integer> n = new SinglyLinkedList<>();
		if(i.Size()>1)
		{
			Node<Integer> t = new Node();	
			t = i.Head();
			int c=0,v1=0,v2=0;			
	        while (t.getNext() != null)
	        {
	        	if(c==0)
	        	{
	        		v1=t.getValue();
	        		c=c+1;	        		
	        	}	        	
	        	else if(c==1)
	        	{
	        		v2=t.getValue();	        		
	        		n.AddLast(v2);	
	        		n.AddLast(v1);
	        		c=0;
	        	}	        	
	        	n.AddLast(t.getValue());
	        	t=t.getNext();	           
	        }
	        if(c==1)
	        {
	        	v2=t.getValue();       		
        		n.AddLast(v2);	
        		n.AddLast(v1);
	        }
	        n.AddLast(t.getValue());        
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.AddFirst(10);
		test.AddFirst(20);
		test.AddFirst(30);
		test.AddFirst(40);
		System.out.println(test.printlist());
		
		System.out.println(stutterTwo(test).printlist());

	}

}
