/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author USER
 * @param <E>
 */
public class MyStack<E> implements Stack<E>
{
    public static final int CAPACITY=1000;   // default array capacity

    /** Generic array used for storage of stack elements. */
    private E[] data;
    
    /** Index of the top element of the stack in the array. */
    private int t = -1;
    
    public MyStack() 
    { 
        this(CAPACITY); 
    }
    
    public MyStack(int capacity) 
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
        // TODO code application logic here
    Stack<Integer> S = new MyStack<>();  // contents: ()
    S.push(5);                              // contents: (5)
    System.out.println("After pushing 5 stack is:" + S.toString());
    S.push(3);                              // contents: (5, 3)
    System.out.println("After pushing 3 stack is:" + S.toString());
    System.out.println("Stack size is:" + S.size());           // contents: (5, 3)     outputs 2
    System.out.println(S.pop());            // contents: (5)        outputs 3
    System.out.println("After a pop stack is:" + S.toString());
    System.out.println("Is stack empty ?" + S.isEmpty());        // contents: (5)        outputs false
    System.out.println(S.pop());            // contents: ()         outputs 5
    System.out.println("After a pop stack is:" + S.toString());
    System.out.println("Is stack empty ?" + S.isEmpty());        // contents: ()         outputs true
    System.out.println(S.pop());            // contents: ()         outputs null
    System.out.println("After a pop stack is:" + S.toString());
    S.push(7);                              // contents: (7)
    System.out.println("After pushing 7 stack is:" + S.toString());
    S.push(9);                              // contents: (7, 9)
    System.out.println("After pushing 9 stack is:" + S.toString());
    System.out.println("Top of stck is" + S.top());            // contents: (7, 9)     outputs 9
    S.push(4);                              // contents: (7, 9, 4)
    System.out.println("After pushing 4 stack is:" + S.toString());
    System.out.println("Stack Size is: " + S.size());           // contents: (7, 9, 4)  outputs 3
    System.out.println(S.pop());            // contents: (7, 9)     outputs 4
    System.out.println("After a pop stack is:" + S.toString());
    S.push(6);                              // contents: (7, 9, 6)
    System.out.println("After pushing 6 stack is:" + S.toString());
    S.push(8);                              // contents: (7, 9, 6, 8)
    System.out.println("After pushing 8 stack is:" + S.toString());
    System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
    System.out.println("After a pop stack is:" + S.toString());
    }
}
