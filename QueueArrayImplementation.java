package DSImplementations;

public class QueueArrayImplementation {

   private int[] queueArray;

   private int head;
   private int tail;

   private int size;

   public QueueArrayImplementation(int size) {
      this.size = size;
      queueArray = new int[size];
      head = -1;
      tail = -1;
   }

   public boolean isFull() {
      return (tail == size - 1);
   }

   public boolean isEmpty() {
      return (head == -1 || head > tail);
   }

   public void enqueue(int element) {
      if (isFull()) {
         System.out.println("Queue is full");
      } else {
         if (head == -1) {
            head = 0;
         }
         tail++;
         queueArray[tail] = element;
      }
   }

   public int dequeue() {
      int element = 0;
      if (isEmpty()) {
         System.out.println("Queue is empty");
      } else {
         element = queueArray[head];
         head++;
      }
      return element;
   }
}

