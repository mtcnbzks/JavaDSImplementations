package DSImplementations;

public class QueueLLImplementation<T> {
   static class Node<T> {
      T data;
      Node<T> next;

      public Node(T data) {
         this.data = data;
         this.next = null;
      }
   }

   int size = 0;
   Node<T> head, tail;

   public QueueLLImplementation() {
      this.head = null;
      this.tail = null;
   }

   void enqueue(T data) {
      Node<T> newNode = new Node<>(data);

      if (this.tail == null) {
         this.tail = this.head = newNode;
      } else {
         this.tail.next = newNode;
         this.tail = newNode;
      }
      size++;
   }

   T dequeue() {
      if (this.head == null) {
         return null;
      }

      T temp = this.head.data;
      this.head = this.head.next;

      if (this.head == null) {
         this.tail = null;
      }
      size--;

      return temp;
   }

   public T peek() {
      if (this.head == null) {
         return null;
      }
      return this.head.data;
   }


   void print() {
      Node<T> temp = this.head;

      while (temp != null) {
         System.out.printf("%d > ", temp.data);
         temp = temp.next;
      }
      System.out.printf("null\n");
   }
}
