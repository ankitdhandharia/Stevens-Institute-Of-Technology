/*
Assignment : Homework 3 - List
Name : Ankit Dhandharia
*/

 package assignment3;

 public class IDLListTest {
 
     public static void main(String[] args) {
         //Creating a new IDLList of Integer type
         IDLList<Integer> myList = new IDLList<>();
 
         //Adding elements to the list at the head
         myList.add(50);
         myList.add(40);
         myList.add(30);
         myList.add(20);
         myList.add(10);
         
         //Removing the head element (0)
         System.out.println("Removed head: " + myList.remove());
         //Appending an element to the list
         myList.append(60);
         //Adding element 70 at index 4
         myList.add(4, 70); 
         //Removing the element at index 3
         System.out.println("Removed at index 3: " + myList.removeAt(3)); 
         //Removing element 1 from the list
         System.out.println("Removed element 20: " + myList.remove(20));
         //Removing the last element and print it
         System.out.println("Removed last: " + myList.removeLast());
         //Printing List
         System.out.println("List: " + myList);
         //Printing the element at index 1
         System.out.println("Element at index 1: " + myList.get(1));
         //Printing the head element
         System.out.println("Head element: " + myList.getHead());
         //Printing the last element
         System.out.println("Last element: " + myList.getLast());
     }

}

// Update: hw3: addFront + addBack
