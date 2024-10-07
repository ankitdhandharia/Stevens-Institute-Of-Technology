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

}

// Update: hw3: IDLList Node class + head/tail/size
