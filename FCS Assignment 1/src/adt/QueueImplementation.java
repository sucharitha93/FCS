package adt;

public class QueueImplementation<E> implements Queue<E>{
	private static final int CAPACITY = 1000;
    private E[] data;
    int size = -1;
    int front = -1;
    int rear = -1;
    
    public QueueImplementation() 
    { 
        this(CAPACITY); 
    }
    
    public QueueImplementation(int capacity) 
    {        // constructs stack with given capacity
        data = (E[]) new Object[capacity];     // safe cast; compiler may give warning
    }
    @Override
    public int size() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return size;
    }

    @Override
    public boolean isEmpty() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return front == -1;
    }

    @Override
    public E front(){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty())
        	return null;
           
        return data[front];
    }

    @Override
    public void enqueue(E o){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            data[rear] = o;
        }
        else if (rear + 1 >= data.length)
        {
        	
        }
        else if ( rear + 1 < data.length)
            data[++rear] = o;    
        size++ ;
    }

    @Override
    public E dequeue()  {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty())
        {
        	return null;
        }
        else 
        {
            size-- ;
            E ele = data[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                front++;                
            return ele;
        }        
        
    }
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("(");
        for (int j = size; j >= 0; j--) 
        {
          sb.append(data[j]);
          if (j > 0) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
    
}
