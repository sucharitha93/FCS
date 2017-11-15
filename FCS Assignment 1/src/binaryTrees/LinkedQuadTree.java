/**
 * 
 */
package binaryTrees;

import binaryTrees.LinkedBinaryTree.Node;

/**
 * @author SucharithaReddy
 *
 */
public class LinkedQuadTree<E> extends AbstractQuadTree<E>{
	protected static class Node<E> implements Position<E> {
	    private E element;         
	    private Node<E> parent;     
	    private Node<E> ne;      
	    private Node<E> nw;     
	    private Node<E> se;       
	    private Node<E> sw;      

	    public Node(E e, Node<E> above, Node<E> neChild, Node<E> nwChild, Node<E> seChild, Node<E> swChild) {
	      element = e;
	      parent = above;
	      ne = neChild;
	      se = seChild;
	      nw = nwChild;
	      sw = swChild;
	    }

	    // accessor methods
	    @Override
	    public E getElement() { return element; }
	    public Node<E> getParent() { return parent; }
	    public Node<E> getNE() { return ne; }
	    public Node<E> getNW() { return nw; }
	    public Node<E> getSE() { return se; }
	    public Node<E> getSW() { return sw; }

	    // update methods
	    public void setElement(E e) { element = e; }
	    public void setParent(Node<E> parentNode) { parent = parentNode; }
	    public void setNE(Node<E> Child) { ne = Child; }
	    public void setNW(Node<E> Child) { nw = Child; }
	    public void setSE(Node<E> Child) { se = Child; }
	    public void setSW(Node<E> Child) { sw = Child; }
	  } 
	
	
	  protected Node<E> createNode(E e, Node<E> parent, Node<E> neChild, Node<E> nwChild, Node<E> seChild, Node<E> swChild) {
	    return new Node<>(e, parent, neChild,nwChild,seChild,swChild);
	  }

	  // LinkedQuadTree instance variables
	  /** The root of the quad tree */
	  protected Node<E> root = null;     // root of the tree

	  /** The number of nodes in the quad tree */
	  private int size = 0;              // number of nodes in the tree

	  // constructor
	  /** Constructs an empty quad tree. */
	  public LinkedQuadTree() { }      // constructs an empty binary tree


	  protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
	    if (!(p instanceof Node))
	      throw new IllegalArgumentException("Not valid position type");
	    Node<E> node = (Node<E>) p;       // safe cast
	    if (node.getParent() == node)     // our convention for defunct node
	      throw new IllegalArgumentException("p is no longer in the tree");
	    return node;
	  }
	  
	  @Override
	  public int size() {
	    return size;
	  }
	  
	  @Override
	  public Position<E> root() {
	    return root;
	  }
	  
	  @Override
	  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
	    Node<E> node = validate(p);
	    return node.getParent();
	  }

	@Override
	public Position<E> ne(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
	    return node.getNE();
	}

	@Override
	public Position<E> nw(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
	    return node.getNW();
	}

	@Override
	public Position<E> se(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
	    return node.getSE();
	}

	@Override
	public Position<E> sw(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
	    return node.getSW();
	}
	
	public Position<E> addRoot(E e) throws IllegalStateException {
	    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
	    root = createNode(e, null, null, null, null, null);
	    size = 1;
	    return root;
	  }



	
	public Position<E> addNE(Position<E> p, E e) throws IllegalArgumentException {				
		Node<E> parent = validate(p);
		if (parent.getNE() != null)
			throw new IllegalArgumentException("p already has a NE child");
		Node<E> child = createNode(e, parent, null, null, null, null);
		parent.setNE(child);
		size++;
		return child;
	}
	public Position<E> addSE(Position<E> p, E e) throws IllegalArgumentException {				
		Node<E> parent = validate(p);
		if (parent.getSE() != null)
			throw new IllegalArgumentException("p already has a SE child");
		Node<E> child = createNode(e, parent, null, null, null, null);
		parent.setSE(child);
		size++;
		return child;
	}
	public Position<E> addSW(Position<E> p, E e) throws IllegalArgumentException {				
		Node<E> parent = validate(p);
		if (parent.getSW() != null)
			throw new IllegalArgumentException("p already has a SW child");
		Node<E> child = createNode(e, parent, null, null, null, null);
		parent.setSW(child);
		size++;
		return child;
	}
	public Position<E> addNW(Position<E> p, E e) throws IllegalArgumentException {				
		Node<E> parent = validate(p);
		if (parent.getNW() != null)
			throw new IllegalArgumentException("p already has a NW child");
		Node<E> child = createNode(e, parent, null, null, null, null);
		parent.setNW(child);
		size++;
		return child;
	}
	
	public E set(Position<E> p, E e) throws IllegalArgumentException {
	    Node<E> node = validate(p);
	    E temp = node.getElement();
	    node.setElement(e);
	    return temp;
	}
	
//	public E remove(Position<E> p) throws IllegalArgumentException {
//	    Node<E> node = validate(p);
//	    if (numChildren(p) == 4)
//	      throw new IllegalArgumentException("p has 4 children");
//	    Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
//	    if (child != null)
//	      child.setParent(node.getParent());  // child's grandparent becomes its parent
//	    if (node == root)
//	      root = child;                       // child becomes root
//	    else {
//	      Node<E> parent = node.getParent();
//	      if (node == parent.getLeft())
//	        parent.setLeft(child);
//	      else
//	        parent.setRight(child);
//	    }
//	    size--;
//	    E temp = node.getElement();
//	    node.setElement(null);                // help garbage collection
//	    node.setLeft(null);
//	    node.setRight(null);
//	    node.setParent(node);                 // our convention for defunct node
//	    return temp;
//	  }
//	  public E[] arrayRep(){
//	      int n = this.size();
//	      int N = (int)Math.pow(2, height(root)+1)-1;
//	      E[] treeArr = (E[])new Object[N];
//	      for (Position p:positions()){
//	          Node node = validate(p);
//	          treeArr[arrayIndex(node)] = (E)p.getElement();
//	      }
//	      return treeArr;
//	  }
	  
//	  public int arrayIndex(Node<E> node){
//	      if (node == root()){
//	          return 0;
//	      }           
//	      if (node == node.parent.left){
//	          return 2*arrayIndex(node.parent) + 1;
//	      }
//	      return 2*arrayIndex(node.parent) + 2;
//	  }

	  //basically preorder
	  
	  public static <E> void parenthesize(Tree<E> T, Position<E> p){
	      System.out.print(p.getElement());
	      if (T.isInternal(p)){
	          boolean firstTime = true;
	          for (Position<E> c:T.children(p)){
	              System.out.print((firstTime ? " (" : ", "));
	              firstTime = false;
	              parenthesize(T,c);
	          }
	          System.out.print(")");
	      }
	  }

}
