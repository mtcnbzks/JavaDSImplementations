package DSImplementations;

public class StackLLImplementation<T> {
   static class Node<E> {
      public E data;
      public Node<E> next;

      public Node(E data) {
         this.data = data;
         this.next = null;
      }
   }

   int size = -1;
   Node<T> head;

   public StackLLImplementation() {
      head = null;
   }

   public void push(T data) {
      Node<T> newNode = new Node<>(data);
      newNode.next = head;
      head = newNode;
      size++;
   }

   public T pop() {
      if (head == null) {
         System.out.println("Stack is empty");
         return null;
      }
      T data = head.data;
      head = head.next;
      size--;
      return data;
   }

   public T peek() {
      if (head == null) {
         System.out.println("Stack is empty");
         return null;
      }
      return head.data;
   }

   public void print() {
      Node<T> current = head;
      while (current != null) {
         System.out.print(current.data + " > ");
         current = current.next;
      }
      System.out.print("null\n");
   }
}
