/**
 * 
 */
package binaryTrees;

/**
 * @author SucharithaReddy
 *
 */
public interface QuadTree<E> extends Tree<E> {
	Position<E> ne(Position<E> p) throws IllegalArgumentException;
	Position<E> nw(Position<E> p) throws IllegalArgumentException;
	Position<E> se(Position<E> p) throws IllegalArgumentException;
	Position<E> sw(Position<E> p) throws IllegalArgumentException;
}
