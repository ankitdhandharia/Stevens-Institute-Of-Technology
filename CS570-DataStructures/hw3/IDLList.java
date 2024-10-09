/*
Assignment : Homework 3 - List
Name : Ankit Dhandharia
*/

package assignment3;

import java.util.ArrayList;

public class IDLList<E> {

    //Class representing a node in the doubly linked list
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        //Constructor for node
        Node(E elem) {
            this.data = elem;
            this.next = null;
            this.prev = null;
        }

        //Constructor for a node with previous and next nodes
        Node(E elem, Node<E> prev, Node<E> next) {
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;  //Head of the list
    private Node<E> tail;  //Tail of the list
    private int size;  //Number of elements in the list
    private ArrayList<Node<E>> indices;  //ArrayList

    //Constructor for creating an empty IDLList
    public IDLList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.indices = new ArrayList<>();
    }

    //Adding an element to the head of the list
    public boolean add(E elem) {
        Node<E> newNode = new Node<>(elem, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;

        if (size == 0) {
            //If list was empty, both head and tail are the same
            tail = head;  
        }

        indices.add(0, newNode);
        size++;
        return true;
    }

    //Adding an element at a specific index
    public boolean add(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return add(elem);
        } else if (index == size) {
            return append(elem);
        } else {
            Node<E> prevNode = indices.get(index - 1);
            Node<E> nextNode = prevNode.next;
            Node<E> newNode = new Node<>(elem, prevNode, nextNode);
            prevNode.next = newNode;
            if (nextNode != null) {
                nextNode.prev = newNode;
            }

            indices.add(index, newNode); 
            size++;
            return true;
        }
    }

    //Appending an element to the tail of the list
    public boolean append(E elem) {
        Node<E> newNode = new Node<>(elem, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        if (size == 0) {
            head = tail;
        }

        indices.add(newNode); 
        size++;
        return true;
    }

    //Getting the element at a specific index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return indices.get(index).data;
    }

}

// Update: hw3: add(index) + get(index)
