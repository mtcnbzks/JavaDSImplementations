package DSImplementations;

public class SinglyLinkedListImplementation {
   public int size;
   public Node head = null;

   static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
         this.next = null;
      }
   }

   public Node getHead() {
      return head;
   }

   public Node getLast() {
      Node last = head;
      while (last.next != null) {
         last = last.next;
      }
      return last;
   }

   public void addFirst(Node newNode) {
      if (head != null) {
         newNode.next = head;
      }
      head = newNode;
      size++;
   }

   public void addLast(Node newNode) {
      if (newNode != null) {
         Node last = head;
         while (last.next != null) {
            last = last.next;
         }
         last.next = newNode;
         size++;
      }
   }

   public Node search(Node node) {
      Node last = head;
      while (last != null) {
         if (last.data == node.data) {
            return last;
         }
         last = last.next;
      }
      return null;
   }

   public void insert(int data) {
      Node newNode = new Node(data);

      if (head == null) {
         head = newNode;
      } else {
         Node last = head;
         while (last.next != null) {
            last = last.next;
         }
         last.next = newNode;
      }
      size++;
   }

   public void print() {
      Node current = head;
      while (current != null) {
         System.out.print(current.data + " > ");
         current = current.next;
      }
      System.out.print("null\n");
   }

   int getSize() {
      return size;
   }

   boolean isEmpty() {
      return size == 0;
   }

   public static void main(String[] args) {
      SinglyLinkedListImplementation list = new SinglyLinkedListImplementation();
      list.insert(1);
      list.insert(2);
      list.insert(3);
      list.insert(4);
      list.insert(5);
      list.print();
      System.out.println("Size of the list is: " + list.getSize());
   }



}
