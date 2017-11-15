/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueueimpl;

import java.util.*;

/**
 *
 * @author USER
 */
public class PriorityQueueImpl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue<Integer,Integer> myQHeap = new HeapPriorityQueue<>();
       
        
        PriorityQueue<Integer,Integer> myQUnsorted = new UnsortedPriorityQueue<>();
        System.out.println("UNSORTED PRIORITY QUEUE");
        long start = System.currentTimeMillis();
        insertIntoQ(myQUnsorted);
        System.out.println("MIn Key:  " + myQUnsorted.min().getKey() + ", " + myQUnsorted.min().getValue());
        listEntries(myQUnsorted);
        long end = System.currentTimeMillis();
        System.out.println("Time taken:  " + (end-start));
        
        start = System.currentTimeMillis();
        System.out.println("\n \nHEAP PRIORITY QUEUE");
        insertIntoQ(myQHeap);
        System.out.println("MIn Key:  " + myQHeap.min().getKey() + ", " + myQHeap.min().getValue());
        listEntries(myQHeap);
        end = System.currentTimeMillis();
        System.out.println("Time taken:  " + (end-start));
        
    }
    
     public static void insertIntoQ(PriorityQueue<Integer,Integer> pQ){
        
        for (int i = 0; i< 10; i++){
            Random rand = new Random();
            Integer key = rand.nextInt(100);
            pQ.insert(key, i);
            System.out.println("Inserting: "+ key + ", "+ i);
        }
    }
    
    public static List listEntries(PriorityQueue<Integer,Integer> pQ){
        List<Entry> list = new ArrayList<>();
        while(pQ.isEmpty()){
            list.add(pQ.removeMin());
        }       
        return list;
    }
}
