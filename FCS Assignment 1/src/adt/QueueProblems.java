/**
 * 
 */
package adt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author SucharithaReddy
 *
 */
public class QueueProblems {

	/**
	 * @param args
	 */
	public static void Qn14()
	{
		CircularArrayQueue<Integer> caq = new CircularArrayQueue<>();
		caq.enqueue(10);
		caq.enqueue(15);
		caq.enqueue(20);
		caq.enqueue(25);
		caq.enqueue(30);
		System.out.println(caq.toString());
		caq.dequeue();
		System.out.println(caq.size());
		System.out.println(caq.toString());
	}
	
	public static void Qn15()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Binary String:");
		String binaryString = in.next();
		Queue<Character> cq = new QueueImplementation<>();
		for (int i = 0; i < binaryString.length(); i++) {
            cq.enqueue(binaryString.charAt(i));
        }
		Character c=null;
		int cnt = 0;
		while(cq.size() > 3)
		{
			c = cq.dequeue();
			if(c.equals('0'))
			{
				cq.dequeue();
				cq.dequeue();
				cq.dequeue();
				cq.enqueue('0');
				cq.enqueue('0');
				
			}
			else if(c.equals('1'))
			{
				cq.dequeue();
				cq.dequeue();
				cq.dequeue();
				cq.enqueue('1');
				cq.enqueue('1');
				cq.enqueue('0');
				cq.enqueue('1');
				
			}
			else
			{
				
			}
			System.out.println(cnt+" iteration Queue: "+ cq.toString());
			cnt = cnt+1;			
		}
	}
	
	public static void Qn16()
	{
		
	}
	
	public static void Qn17()
	{
		
	}
	
	public static void Qn18()
	{
		int len,randomnum,correct=0,incorrect=0;
        Queue<Integer> obj1 = new QueueImplementation<>();
        Queue<Integer> obj2 = new QueueImplementation<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the sequence to be generated:");
        len=sc.nextInt();
        for(int i=0;i<len;i++){
            randomnum=ThreadLocalRandom.current().nextInt(0, 10);
            obj1.enqueue(randomnum);
        }
        String s = obj1.toString();
        System.out.println("Sequence generated:"+s);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(int i=0;i<50;i++)
            System.out.println();
        System.out.println("Enter random numbers");
        for(int i=0;i<len;i++){
            randomnum=sc.nextInt();
             obj2.enqueue(randomnum);
        }    
        System.out.println("Queue 1:"+ obj1.toString());
        System.out.println("Queue 2:"+ obj2.toString());
        for(int i=0;i<len;i++)
        {
            if(obj1.dequeue() == obj2.dequeue()) 
            {
            	correct++;
            }            	
            else 
            {
            	incorrect++;
            }
            	
        }        
        System.out.println("Correct:"+correct+"\nincorrect"+incorrect);
	}
	
	public static int Qn19(int m,int n)
	{
		
	        QueueImplementation<Integer> obj = new QueueImplementation<>();
	        int l = 0;
	        for(int i=0;i<m;i++){
	            obj.enqueue(i+1);
	        }
	        while(m>0){
	        for(int j=0;j<n && n<m;j++){
	            obj.enqueue(obj.dequeue());
	        }
	        l=obj.dequeue();
	        --m;
	        if(n>=m) break;
	        }
	        
	        if(m>0){
	            for(int i=0;i<m;i++){
	                l=obj.dequeue();
	            }
	        }
	        return l;	    
	}
	
	public static void Qn20()
	{
		QueueImplementation<Long> new_calls = new QueueImplementation<>(10);
        QueueImplementation<Long> old_calls = new QueueImplementation<>(5);
        Stack<Long> new_call_review = new StackImplementation<Long>();
        char exit1 = 'n';
        char exit2 = 'n';
        String FileName = "E:\\EclipseTestProjects\\FCS Assignment 1\\src\\adt\\Qn20";
        FileReader fr;
        String curr;
        Long l;
        BufferedReader br;
		try {
			fr = new FileReader(FileName);
			br = new BufferedReader(fr);	        
	        curr = br.readLine();
	        while(curr!=null){
	            //System.out.print("reading file");
	            l = Long.parseLong(curr);
	            if(new_calls.size()==10) new_calls.dequeue();
	            new_calls.enqueue(l);
	            curr=br.readLine();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
        
        for(int i=0;i<10;i++){
            new_call_review.push(new_calls.dequeue());
        }
        
        do{
            int ch1,ch2,i=1;
            Scanner sc = new Scanner(System.in);
            String s;
            System.out.println("Enter your choice:\n1.review new calls\n2.Review old calls\n3.exit");
            ch1=sc.nextInt();
            switch(ch1){
                case 1:
                    s=new_call_review.toString();
                    System.out.println(s);
                        do{
                            System.out.println("Enter your choice for "+i+"th call:\n1.callback\n2.ignore\n3.callback later\n4.exit");
                            ch2 = sc.nextInt();
                            switch(ch2){
                                case 1:
                                case 2:new_call_review.pop();++i;
                                break;
                                case 3:if(old_calls.size()==5) old_calls.dequeue();
                                        old_calls.enqueue(new_call_review.pop());++i;
                                break;
                                case 4:exit2 = 'y';break;
                                default:System.out.println("Enter correct choice");
                            }
                            if(i>10)break;
                        }while(exit2 != 'y');
                    break;
                case 2:
                    s=old_calls.toString();
                    System.out.println(s);
                    do{
                            System.out.println("Enter your choice for "+i+"th call:\n1.callback\n2.ignore\n3.callback later\n4.exit");
                            ch2 = sc.nextInt();
                            switch(ch2){
                                case 1:
                                case 2:new_call_review.pop();++i;
                                break;
                                case 3:if(old_calls.size()==5) old_calls.dequeue();
                                old_calls.enqueue(new_call_review.pop());++i;
                                break;
                                case 4:exit2 = 'y';break;
                                default:System.out.println("Enter correct choice");
                            }
                            if(i>5)break;
                        }while(exit2 != 'y');
                    break;
                case 3:
                    exit1 = 'y';
                    break;
                default:System.out.println("Enter correct choice");
            }
        }while(exit1!='y');
	}
	
	public static void main(String[] args) {
//		Qn14();
//		Qn15();
//		Qn16();
//		Qn17();	
		Qn18();
//		Qn19(1,6);
//		Qn20();
	}

}
