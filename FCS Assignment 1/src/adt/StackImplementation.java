/**
 * 
 */
package adt;

/**
 * @author SucharithaReddy
 *
 */
public class StackImplementation<E> implements Stack<E>{

	/**
	 * @param args
	 */
	public static final int CAPACITY=1000;
	private int t = -1;
	private E[] data;
    
   public StackImplementation() {
		// TODO Auto-generated constructor stub
	      this(CAPACITY); 
    }
    
    public StackImplementation(int capacity) 
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
		Stack<Character> A = new StackImplementation<>();

	}

	
}
