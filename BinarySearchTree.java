package DSImplementations;

import java.util.NoSuchElementException;

public class BinarySearchTree {
   // TODO: write delete method

   static class Node {
      int data;
      Node left, right;

      public Node(int data) {
         this.data = data;
         this.left = this.right = null;
      }
   }

   Node root;

   void insert(int data) {
      Node newNode = new Node(data);

      if (root == null) {
         root = newNode;
         return;
      }

      Node current = root;
      while (true) {
         if (data < current.data) {
            if (current.left == null) {
               current.left = newNode;
               return;
            }
            current = current.left;
         } else {
            if (current.right == null) {
               current.right = newNode;
               return;
            }
            current = current.right;
         }
      }
   }

   boolean delete(int target) {
      Node current = root;
      Node parent = null;

      // find target's Node
      while (current != null && current.data != target) {
         parent = current;
         if (current.data < target) {
            current = current.right;
         } else {
            current = current.left;
         }
      }

      // if target not found return false.
      if (current == null) {
         return false;
      }

      // Case 1: If node has no child, just delete it
      if (current.left == null && current.right == null) {
         if (current == root) {
            root = null;
         } else if (current == parent.left) {
            parent.left = null;
         } else {
            parent.right = null;
         }
      }

      // Case 2: If node has one child, replace the node with its child
      else if (current.left == null || current.right == null) {
         Node child = current.left == null ? current.right : current.left;
         if (current == root) {
            root = child;
         } else if (parent == current.left) {
            parent.left = child;
         } else {
            parent.right = child;
         }
      }

      // Case 3: If node has two children, replace the node's value with the successor's value
      else {
         Node successor = findSuccessor(current);
         current.data = successor.data;
         delete(successor.data);
      }
      return true;

   }

   private Node findSuccessor(Node node) {
      Node current = node.right;

      while (current.left != null) {
         current = current.left;
      }

      return current;
   }

   Node search(int target) {
      Node current = root;

      while (current != null) {
         if (current.data == target) {
            return current;
         } else if (current.data < target) {
            current = current.right;
         } else {
            current = current.left;
         }
      }
      return null;
   }


   int findMax() {
      if (root == null) {
         throw new NoSuchElementException("Binary Search Tree is empty");
      }

      Node current = root;

      while (current.right != null) {
         current = current.right;
      }

      return current.data;
   }

   int findMin() {
      if (root == null) {
         throw new NoSuchElementException("Binary Search Tree is empty");
      }

      Node current = root;

      while (current.left != null) {
         current = current.left;
      }

      return current.data;
   }

   void inOrderTraversal() {
      inOrderTraversal(root);
   }

   private void inOrderTraversal(Node node) {
      if (node != null) {
         inOrderTraversal(node.left);
         System.out.print(node.data + " ");
         inOrderTraversal(node.right);
      }
   }


}
