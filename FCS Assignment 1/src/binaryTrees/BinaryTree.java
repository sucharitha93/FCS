/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTrees;

import java.util.Arrays;

/**
 *
 * @author USER
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
	
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedBinaryTree<Integer> myTree = new LinkedBinaryTree<>();
        myTree.addRoot(23);
        myTree.addLeft(myTree.root,15);
        Position<Integer> p = myTree.addRight(myTree.root, 18);
        System.out.println(p.getElement());
        p = myTree.addRight(p, 27);
        p = myTree.addLeft(p, 57);
        System.out.println(Arrays.toString(myTree.arrayRep()));
        
        for (Position<Integer> pos : myTree.inorder()){
            System.out.print(pos.getElement() + " ");
        }
        
        LinkedBinaryTree.parenthesize(myTree,myTree.root);
    }
  
}
