
package adt;

/**
 * @author SucharithaReddy
 *
 *7.	Suppose you were asked to write a method that will take two sorted stacks A and B (min on top) and create one stack that is sorted (min on top). You are allowed to use only the stack operations such as pop, push, size and top. No other data structure such as arrays are not allowed. You are allowed to use stacks. Note that elements on the stack can be compared using compareTo.
        public Stack mergeSortedStacks(Stack A, Stack B) {

 */
public class Qn7<E> implements Stack<E>{

	/**
	 * @param args
	 */
	public static final int CAPACITY=1000;
	private int t = -1;
	private E[] data;
    
   public Qn7() {
		// TODO Auto-generated constructor stub
	      this(CAPACITY); 
    }
    
    public Qn7(int capacity) 
    {        // constructs stack with given capacity
        data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
    }
  
    @Override
    public int size() 
    {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException//throws FullStackException 
    {
        if (size() == data.length) throw new IllegalStateException("Stack Full");//throw new FullStackException("Stack is full");
        data[++t] = e;                           // increment t before storing new item
    }

    @Override
    public E top() //throws EmptyStackException
    {
        if (isEmpty()) return null;//throw new EmptyStackException("Stack is empty.");
        return data[t];
    }

    @Override
    public E pop() //throws EmptyStackException
    {
        if (isEmpty()) return null; //throw new EmptyStackException("Stack is empty.");
        E answer = data[t];
        data[t] = null;                        // dereference to help garbage collection
        t--;
        return answer;
    } 
    
    @Override
    public String toString() 
    {
        StringBuffer sb = new StringBuffer("(");
        for (int j = t; j >= 0; j--) 
        {
          sb.append(data[j]);
          if (j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> A = new Qn7<>();
		Stack<Integer> B = new Qn7<>();		
		A.push(11);
		A.push(9);
		A.push(7);
		A.push(4);
		A.push(1);
		B.push(8);
		B.push(6);
		B.push(5);
		B.push(4);
		B.push(2);
		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(mergeSortedStacks(A,B).toString());
		//mergeSortedStacks(A,B).toString();
		

	}
	public static Stack<Integer> reverseStacks(Stack<Integer> A) {
		Stack<Integer> S = new Qn7<>();
		while(!A.isEmpty())
		{
			S.push(A.pop());
		}
		return S;	
	}
	public static Stack<Integer> mergeSortedStacks(Stack<Integer> A, Stack<Integer> B) {
	Stack<Integer> revStack = new Qn7<>();
		int a,b;
		a=A.pop();
		b=B.pop();
		System.out.println(a+" "+b);
		System.out.println(A.toString());
		System.out.println(B.toString());
		do 
		{
			System.out.println(a+" "+b);
			if(a<b)
			{
				revStack.push(a);
				if(!(A.isEmpty()))
				{
					a=A.pop();					
				}
				
			}
			else
			{
				revStack.push(b);
				if(a == b && A.size()>0)
				{
					a = A.pop();
				}
				if(!(B.isEmpty()))
				{
					b=B.pop();					
				}
				
			}
			
			System.out.println(revStack.toString());
					
		}while(A.size()>0 && B.size()>0);
		revStack.push(a);
		revStack.push(b);
		
		if(A.size()>0)
		{			
			while(A.size()>0)
			{
				revStack.push(A.pop());
			}
		}
		
		if(B.size()>0)
		{
			while(B.size()>0)
			{
				revStack.push(B.pop());
			}
		}		
		
		return reverseStacks(revStack);
	}

	

}
