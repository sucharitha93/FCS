package binaryTrees;

import java.util.Arrays;

public class QuadTreeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * LinkedBinaryTree<Integer> myTree = new LinkedBinaryTree<>();
        myTree.addRoot(23);
        myTree.addLeft(myTree.root,15);
        Position p = myTree.addRight(myTree.root, 18);
        p = myTree.addRight(p, 27);
        p = myTree.addRight(p, 57);
        System.out.println(Arrays.toString(myTree.arrayRep()));
        
        for (Position<Integer> pos : myTree.preorder()){
            System.out.print(pos.getElement() + " ");
        }
        
        System.out.println();
        LinkedBinaryTree.parenthesize(myTree,myTree.root);
		 * **/

		LinkedQuadTree<Integer> myTree = new LinkedQuadTree();
        myTree.addRoot(23);
        Position<Integer> p = myTree.addNE(myTree.root,15);
        myTree.addNW(myTree.root,16);
        myTree.addSE(myTree.root,17);
        myTree.addSW(myTree.root,18);
        myTree.addNW(p,19);
        myTree.addNE(p,20);
        
        //System.out.println(Arrays.toString(myTree.arrayRep()));
        
        for (Position<Integer> pos : myTree.preorder()){
            System.out.print(pos.getElement() + " ");
        }
        
        System.out.println();
        LinkedQuadTree.parenthesize(myTree,myTree.root);
	}

}
