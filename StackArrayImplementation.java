package DSImplementations;

public class StackArrayImplementation {

   private int[] stackArray;

   private int top; // index of the top element
   private int size;

   public StackArrayImplementation(int size) {
      this.size = size;
      stackArray = new int[size];
      top = -1;
   }

   public boolean isFull() {
      return (top == size - 1);
   }

   public boolean isEmpty() {
      return (top == -1);
   }

   public void push(int element) {
      if (isFull()) {
         System.out.println("Stack is full");
      } else {
         top++;
         stackArray[top] = element;
      }
   }

   public int pop() {
      int element = 0;
      if (isEmpty()) {
         System.out.println("Stack is empty");
      } else {
         element = stackArray[top];
         top--;
      }
      return element;
   }

   public int peek() {

      if (isEmpty()) {
         System.out.println("Stack is empty");
         return -1;
      }

      return stackArray[top];
   }

}

