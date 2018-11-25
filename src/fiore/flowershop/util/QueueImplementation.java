/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiore.flowershop.util;

import java.lang.reflect.Array;

/**
 *
 * @author Jasmine
 */
public class QueueImplementation<E> implements  Queue<E>{

    private int front, rear;
    private int maxSize, size;
    private E elements[];

    
    public QueueImplementation(Class<E> element) {
        maxSize = 10000;
        front = 0;
        rear = -1;
        size = 0;
        elements = (E[]) Array.newInstance(element, maxSize);
    }

    public QueueImplementation(Class<E> element, int max) {
        maxSize = max;
        front = 0;
        rear = -1;
        size = 0;
        elements = (E[]) Array.newInstance(element, max);
    }

    public void enqueue(E e) {

        if (rear == maxSize - 1) {
            int j = 0;
            for (int i = front; i <= rear; i++) {
                elements[j++] = elements[i];
            }
        }
        elements[++rear] = e;
        size++;
    }

    public E dequeue() {
        E saved = elements[front];
        elements[front] = null;
        front++;
        size--;
        return saved;
    }
    
    public E[] getQueue(Class<E> element){

        E e[] = (E[]) Array.newInstance(element, rear+1);
  
        for(int i  = 0 ; i <= rear ; i++){
            e[i] = elements[i];
        }
        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }

    @Override
    public E peek() {
         E saved = elements[front];
        return saved;

    }

}
