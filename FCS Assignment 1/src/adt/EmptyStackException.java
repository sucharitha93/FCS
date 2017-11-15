/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author USER
 */
public class EmptyStackException extends RuntimeException
{

    /**
     *
     * @param err
     */
    public EmptyStackException(String err) 
    {
        super(err);
    }
}
