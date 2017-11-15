/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Sucharitha
 * @param <E>
 */
public interface Stack<E> {
    int size();

  boolean isEmpty();

  void push(E e);

  E top();

  E pop();
}
