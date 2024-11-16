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

    // Constructor to initialize the Treap with a seeded random priority generator
    public Treap(long seed) {
        this.priorityGenerator = new Random(seed);
        this.root = null;
    }

    // Adds a key to the Treap with a randomly generated priority
    public boolean add(E key) {
        return add(key, priorityGenerator.nextInt());
    }

    // Adds a key with a specific priority to the Treap
    public boolean add(E key, int priority) {
        if (root == null) {
            root = new Node<>(key, priority);
            return true;
        }

        Node<E> newNode = new Node<>(key, priority);
        Node<E> current = root;
        Stack<Node<E>> stack = new Stack<>();

        while (current != null) {
            if (current.data.compareTo(key) == 0) {
                return false; // Duplicate key, do nothing
            }

            stack.push(current);
            if (key.compareTo(current.data) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    reheap(newNode, stack);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    reheap(newNode, stack);
                    return true;
                }
                current = current.right;
            }
        }
        return false;
    }

    // Restores the heap property after inserting a node
    private void reheap(Node<E> node, Stack<Node<E>> stack) {
        while (!stack.isEmpty()) {
            Node<E> parent = stack.pop();
            if (parent.priority < node.priority) {
                if (parent.data.compareTo(node.data) > 0) {
                    node = parent.rotateRight();
                } else {
                    node = parent.rotateLeft();
                }

                if (!stack.isEmpty()) {
                    Node<E> grandparent = stack.peek();
                    if (grandparent.left == parent) {
                        grandparent.left = node;
                    } else {
                        grandparent.right = node;
                    }
                } else {
                    root = node;
                }
            } else {
                break;
            }
        }
    }

    // Deletes a key from the Treap, returns true if successful, false otherwise
    public boolean delete(E key) {
        if (key == null || !find(key)) {
            return false;
        }
        root = delete(root, key);
        return true;
    }

    // Helper function to recursively delete a node
    private Node<E> delete(Node<E> current, E key) {
        if (current == null) {
            return null;
        }

        if (key.compareTo(current.data) < 0) {
            current.left = delete(current.left, key);
        } else if (key.compareTo(current.data) > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                if (current.left.priority > current.right.priority) {
                    current = current.rotateRight();
                    current.right = delete(current.right, key);
                } else {
                    current = current.rotateLeft();
                    current.left = delete(current.left, key);
                }
            }
        }
        return current;
    }

    // Finds if a key exists in the Treap
    public boolean find(E key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        return find(root, key);
    }

    // Helper function for recursive search
    private boolean find(Node<E> current, E key) {
        if (current == null) {
            return false;
        }

        if (key.compareTo(current.data) == 0) {
            return true;
        }

        return key.compareTo(current.data) < 0
                ? find(current.left, key)
                : find(current.right, key);
    }

    // Prints the Treap as a string with preorder traversal
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    // Helper function for preorder traversal
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString()).append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

}

// Update: hw5: balance checks + cleanup
