/**
 * 
 */
package binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SucharithaReddy
 *
 */
public abstract class AbstractQuadTree<E> extends AbstractTree<E> implements QuadTree<E> {

	@Override
	public int numChildren(Position<E> p) {
	    int count=0;
	    if (ne(p) != null)
	      count++;
	    if (nw(p) != null)
	      count++;
	    if (se(p) != null)
		      count++;
	    if (sw(p) != null)
		      count++;
	    return count;
	  }
	
	@Override
	  public Iterable<Position<E>> children(Position<E> p) {
	    List<Position<E>> snapshot = new ArrayList<>(4);    // max capacity of 2
	    if (ne(p) != null)
	    	snapshot.add(ne(p));
	    if (se(p) != null)
	    	snapshot.add(se(p));
	    if (nw(p) != null)
	    	snapshot.add(nw(p));
	    if (sw(p) != null)
	    	snapshot.add(sw(p));
	    return snapshot;
	  }
	

	  private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
		  snapshot.add(p);
		  if (ne(p) != null)
			  preOrderSubtree(ne(p), snapshot);
		  if (nw(p) != null)
			  preOrderSubtree(nw(p), snapshot);
		  if (se(p) != null)
			  preOrderSubtree(se(p), snapshot);
		  if (sw(p) != null)
			  preOrderSubtree(sw(p), snapshot);
	  }


	  public Iterable<Position<E>> preorder() {
	    List<Position<E>> snapshot = new ArrayList<>();
	    if (!isEmpty())
	    	preOrderSubtree(root(), snapshot);   
	    return snapshot;
	  }

	  @Override
	  public Iterable<Position<E>> positions() {
	    return preorder();
	  }
}
