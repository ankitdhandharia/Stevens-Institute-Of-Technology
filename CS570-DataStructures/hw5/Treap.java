//Howework: Homework Assignment 5
//Name : Ankit BhagwatiPrasad Dhandharia
//CWID : 20033031

package Assignment5;
import java.util.Random;
import java.util.Stack;

// This class represents a Treap, a hybrid data structure that combines a binary search tree (BST) with a heap.
public class Treap<E extends Comparable<E>> {

    // Node class represents individual elements in the Treap
    private static class Node<E> {
        public E data;         // The value stored in the node
        public int priority;   // The heap priority of the node
        public Node<E> left;   // Left child
        public Node<E> right;  // Right child

        // Constructor to initialize a node with data and priority
        public Node(E data, int priority) {
            if (data == null) {
                throw new IllegalArgumentException("Data cannot be null.");
            }
            this.data = data;
            this.priority = priority;
            this.left = null;
            this.right = null;
        }

        // Rotates the node to the right and returns the new root
        public Node<E> rotateRight() {
            Node<E> temp = this.left;
            this.left = temp.right;
            temp.right = this;
            return temp;
        }

        // Rotates the node to the left and returns the new root
        public Node<E> rotateLeft() {
            Node<E> temp = this.right;
            this.right = temp.left;
            temp.left = this;
            return temp;
        }

        // Returns a string representation of the node including its data and priority
        public String toString() {
            return data.toString() + " (" + priority + ")";
        }
    }

    private Random priorityGenerator; // Generates random priorities for nodes
    private Node<E> root;             // Root node of the Treap

    // Default constructor, initializes an empty Treap with a random priority generator
    public Treap() {
        this.priorityGenerator = new Random();
        this.root = null;
    }

}

// Update: hw5: Treap Node + rotations
