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

    //Getting the head element
    public E getHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    //Getting the last (tail) element
    public E getLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    //Getting the size of the list
    public int size() {
        return size;
    }

    //Removing and returning the head element
    public E remove() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node<E> removedNode = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;  //List is set now empty
        }

        indices.remove(0);
        size--;
        return removedNode.data;
    }

    //Removing and returning the last (tail) element
    public E removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }

        Node<E> removedNode = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        indices.remove(size - 1);
        size--;
        return removedNode.data;
    }

    //Removing and returning the element at a specific index
    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> removedNode = indices.get(index);
        if (removedNode.prev != null) {
            removedNode.prev.next = removedNode.next;
        } else {
            head = removedNode.next;
        }

        if (removedNode.next != null) {
            removedNode.next.prev = removedNode.prev;
        } else {
            tail = removedNode.prev;
        }

        indices.remove(index);
        size--;
        return removedNode.data;
    }

    //Removing the first occurrence of a specific element
    public boolean remove(E elem) {
        for (int i = 0; i < size; i++) {
            if (indices.get(i).data.equals(elem)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    //Providing a string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}


// Update: hw3: submit
