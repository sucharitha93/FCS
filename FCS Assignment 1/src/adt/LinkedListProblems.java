package adt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LinkedListProblems {
	public static SinglyLinkedList<String>[] createArrayOfLL(String inputfile) {
		
		//SinglyLinkedList<String>[] alphabet = (SinglyLinkedList<String>[]) new Object[26];
		SinglyLinkedList<String>[] alphabet = new SinglyLinkedList[26];
		int i=0;
		while(i<26)
		{
			alphabet[i]=new SinglyLinkedList();
			i=i+1;
		}
		
		try {

            File f = new File(inputfile);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            int ascii;
            System.out.println("Reading file using Buffered Reader");
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
        		ascii = (int) readLine.charAt(0);
        		if(ascii>=65 && ascii<=90)
        		{
        			alphabet[ascii-65].AddFirst(readLine);
        		}
        		else if(ascii>=97 && ascii<=122)
        		{
        			alphabet[ascii-97].AddFirst(readLine);
        		}
        		else
        		{
        			
        		}
        		System.out.println(printSLLString(alphabet));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return alphabet;
	}
	public static String printSLLString(SinglyLinkedList<String>[] s)
	{
		StringBuffer b = new StringBuffer();
	
		for(int i=0;i<s.length;i++)
		{
			b.append(s[i].printlist());
			//System.out.println(s[i]);
			
		}
		return b.toString();
	}
	public static void Qn1()
	{
		String file = "E:\\EclipseTestProjects\\FCS Assignment 1\\src\\adt\\Qn1";
		System.out.print(printSLLString(createArrayOfLL(file)));
	}
	public static void Qn2()
	{
		SinglyLinkedList<String> test = new SinglyLinkedList<>();
		test.AddFirst("Apple");
		test.AddFirst("Apricot");
		test.AddFirst("Zebra");
		if(test.contains("Zebr.a"))
		{
			System.out.println("Yes the string is contained !");
		}
		else
		{
			System.out.println("No the string is not contained !");
		}
	}

	public static void Qn4()
	{
		SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
		test.AddFirst(10);
		test.AddFirst(20);
		test.AddFirst(30);
		test.AddFirst(110);
		test.AddFirst(210);
		test.AddFirst(310);
		System.out.println(test.printlist()+" "+test.Size());
		test.Delete(4);
		System.out.println(test.printlist()+" "+test.Size());
		test.Delete(0);
		System.out.println(test.printlist()+" "+test.Size());
		test.Delete(3);
		System.out.println(test.printlist()+" "+test.Size());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qn1();
		Qn2();
		Qn4();
		

	}

}
