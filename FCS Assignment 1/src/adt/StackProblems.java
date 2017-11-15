package adt;

import java.util.Scanner;

public class StackProblems {
	public static Stack<Integer> reverseStacks(Stack<Integer> A) {
		Stack<Integer> S = new StackImplementation<>();
		while(!A.isEmpty())
		{
			S.push(A.pop());
		}
		return S;	
	}
	public static Stack<Integer> mergeSortedStacks(Stack<Integer> A, Stack<Integer> B) {
	Stack<Integer> revStack = new StackImplementation<>();
		int a,b;
		a=A.pop();
		b=B.pop();
		do 
		{
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

	public static boolean isPalindrome(String theString)
	{
		Stack<Character> stack = new StackImplementation<Character>();

        for (int i = 0; i < theString.length(); i++) {
            stack.push(theString.charAt(i));
        }

        String reverseInput = "";

        while (!stack.isEmpty()) {
            reverseInput += stack.pop();
        }

        if (theString.equals(reverseInput))
        	return true;
        else
        	return false;
		
	}
	
	public static double returnMax(Stack<Double> S)
	{
		double max=0;
		for(int i=0;i<S.size();i++)
		{
			if(S.top()>max)
			{
				max=S.pop();
			}
			else
			{
				S.pop();
			}			
		}
		return max;
	}
	
	public static Stack<Double> invertStack(Stack<Double> S,int p)
	{
		Queue<Double> temp = new QueueImplementation<>();
		Double t,max=0.0;
		while(S.size()!=p)
		{
			t=S.pop();
			if(t>max)
			{
				max = t;
				System.out.println("Max:"+max);
			}
			temp.enqueue(t);	
		}
		
		if(max != 0.0)
		{
			S.push(max);
		}
		System.out.println("P= "+p+" Queue: "+temp.toString());
		while(!temp.isEmpty())
		{
			t = temp.dequeue();
			System.out.println(t+" is dequeued");
			
			if(t != max)
			{
				S.push(t);
				System.out.println(t+" being pushed into stack");
			}
		}
	
		System.out.println("P= "+p+" Queue: "+temp.toString());
		
		System.out.println("P= "+p+" inverted Stack is:"+S.toString());
		
		return S;
	}
	
	public static void s2q(StackImplementation<Integer> s, QueueImplementation<Integer> q) 
	{ 
		while (!s.isEmpty())
		{ 
			q.enqueue(s.pop()); 
		} 
	 } 

	public static void q2s(StackImplementation<Integer> s, QueueImplementation<Integer> q) 
	{ 
		while (!q.isEmpty())
		{ 
			s.push(q.dequeue());
		}  		
	} 

	public static void Qn5()
	{
		StackImplementation<Integer> st = new StackImplementation<>();
		QueueImplementation<Integer> qu = new QueueImplementation<>();
		st.push(10);
		st.push(15);
		st.push(20);
		st.push(25);
		s2q(st, qu);
		q2s(st,qu);
		s2q(st, qu);
		int t=0;
		for(int i=0;i<=qu.size;i++)
		{
			t = qu.dequeue();
			st.push(t);
			qu.enqueue(t);
		}
		s2q(st, qu);
		q2s(st,qu);		
		s2q(st, qu);
		q2s(st,qu);	
		System.out.println(qu.toString());
		System.out.println(st.toString());
	}
	
	public static void Qn6()
	{
		if(isPalindrome("malayalam"))
		{
			System.out.println("It is a palindrome");
		}
		else
		{
			System.out.println("It is not a palindrome");
		}
	}
	
	public static void Qn7()
	{
		Stack<Integer> A = new StackImplementation<>();
		Stack<Integer> B = new StackImplementation<>();		
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
	}

	public static void Qn8()
	{
		
	}
	
	public static void Qn9()
	{
//		Scanner in = new Scanner(System.in);
//		String test = in.next();
		String test = "([)";		
		Character ch;
		boolean res = false;
		StackImplementation<Character> pb = new StackImplementation<>();
		for(int i=0;i<test.length();i++)
		{
			ch = test.charAt(i);
			if(ch == '{' || ch == '[' || ch == '(' || ch == '<')
			{
				pb.push(ch);
			}
			else if(ch == '}' || ch == ']' || ch == ')' || ch == '>')
			{
				if(ch == pb.pop())
				{
					res = false;
					continue;
				}
				else
				{					
					res=true;
					break;
				}				
			}
		}
		if(res && pb.isEmpty())
		{
			System.out.println("Paranthesis is balanced");
		}
		else
		{
			System.out.println("Paranthesis is not balanced");
		}
	}
	
	public static void Qn10()
	{
		Stack<Double> F = new StackImplementation<>();
		F.push(10.5);
		F.push(11.5);
		F.push(15.5);
		F.push(1.5);
		System.out.println("Maximum element is:"+returnMax(F));		
	}
	
	public static void Qn11()
	{
		Stack<Double> F = new StackImplementation<>();
		F.push(3.5);
		F.push(2.5);
		F.push(5.0);
		F.push(1.0);
		int i = 0;
		System.out.println("initial Stack is:"+F.toString());	
		while(i<F.size())
		{
			System.out.println(i+"th iteration Stack is:"+F.toString());	
			F = invertStack(F,i);
			i=i+1;
		}
		System.out.println("Final Stack is:"+F.toString());	
	}
	
	public static void Qn12()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string");
		String theString=s.nextLine();
		Stack<Character> stack1 = new StackImplementation<Character>();
		Stack<Character> stack2 = new StackImplementation<Character>();

        for (int i = 0; i < theString.length(); i++) {
            stack1.push(theString.charAt(i));
        }
        //System.out.println("Stack1 :"+stack1.toString());
        for (int i = 0; i < theString.length()/2; i++) {
            stack2.push(stack1.pop());
        }
        //System.out.println("Stack1 :"+stack1.toString());
        //System.out.println("Stack2 :"+stack2.toString());
        
        if(theString.length()%2 != 0)
        {
        	stack1.pop();
        }
        for (int i = 0; i < theString.length()/2; i++) {
            if(stack1.pop() != stack2.pop())
            {
            	break;
            }
        }   
        //System.out.println("Stack1 :"+stack1.toString());
        //System.out.println("Stack2 :"+stack2.toString());

        if (stack1.isEmpty())
        	System.out.println("Yes it is a palindrome");
        else
        	System.out.println("No it is not a palindrome");
	}
	
	public static void Qn13()
	{
        StackImplementation[] st = new StackImplementation[6];
        int var=0;
        boolean[] car = new boolean[18];char exit='n';
        for(int i=0;i<18;i++)
        car[i] = false;
    
        for(int i=0;i<6;i++)
            st[i] = new StackImplementation<Integer>();
        do{
            int ch,carno;
            Scanner sc = new Scanner(System.in);
            int totCars = 0;
            
            System.out.println("Enter your choice:+\n1.Park the car\n2.remove the car from the parking lot\n3.Print the cars that are parked\n4.Exit");
            ch = sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter the car number to be parked(car number here 1 to 18)");
                        carno = sc.nextInt();
                        if(totCars<=16){
                            for(int i=0;i<6;i++){
                                if(st[i].size() < 3){ if(!car[carno-1]){st[i].push(carno);totCars++;car[carno-1]=true;break;}
                                else {System.out.println("Car already parked");break;}
                        }
                     }}
                        else System.out.println("Parking lot is full");
                        break;
                case 2:System.out.println("Enter the car number to be removed");
                        carno = sc.nextInt();
                        int i=0,j;
                        if(car[carno-1]) {
                            while(i<6){
                                if((int)st[i].top() == carno) {st[i].pop();totCars--; car[carno-1]=false;break;}
                                else if(st[i].size()==1) ++i;
                                else{
                                    j=(i+1)%6;
                                    while(j!=i){
                                        if(st[j].size()<3) {st[j].push(st[i].pop());break;}
                                        else j=(j+1)%6;
                                    }
                                  }
                                  
                            }
                            totCars--;
                        }
                        else System.out.println("car not parked");
                         break;
                case 3: String str;
                    for(int k=0;k<6;k++){
                    if(!st[k].isEmpty()) {str=st[k].toString();System.out.println("Stack "+k+" "+str); }
                }
                    break;
                    
                case 4:exit ='y';
                        break;
                default:System.out.println("Enter correct choice");}
            
            }while(exit != 'y');
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Qn5();
//		Qn6();
//		Qn7();	
//		Qn8();
//		Qn9();
//		Qn10();
//		Qn11();
//		Qn12();
//		Qn13();
		
	}

}
