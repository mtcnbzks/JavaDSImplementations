package DSImplementations;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
   private int capacity;
   private int size;

   T[] heap;

   @SuppressWarnings("unchecked")
   public MinHeap() {
      this.size = 0;
      this.capacity = 10;
      this.heap = (T[]) new Comparable<?>[capacity];
   }

   public T peek() {
      if (size == 0) {
         throw new IllegalStateException("Heap is empty");
      }
      return heap[0];
   }

   public T poll() {
      if (size == 0) {
         throw new IllegalStateException("Heap is empty");
      }
      T item = heap[0];
      heap[0] = heap[size - 1];
      size--;
      heapifyDown();
      return item;
   }

   public void insert(T data) {
      ensureCapacity();
      heap[size] = data;
      size++;
      heapifyUp();
   }

   public void heapifyUp() {
      int index = size - 1;
      while (hasParent(index) && getParent(index).compareTo(heap[index]) > 0) {
         swap(getParentIndex(index), index);
         index = getParentIndex(index);
      }
   }

   public void heapifyDown() {
      int index = 0;
      while (hasLeftChild(index)) {
         int smallerChildIndex = getLeftChildIndex(index);
         if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) < 0) {
            smallerChildIndex = getRightChildIndex(index);
         }
         if (heap[index].compareTo(heap[smallerChildIndex]) < 0) {
            break;
         } else {
            swap(index, smallerChildIndex);
         }
         index = smallerChildIndex;
      }
   }

   public void print() {
      for (int i = 0; i < size; i++) {
         System.out.print(heap[i] + " ");
      }
      System.out.println();
   }

   private void swap(int firstIndex, int secondIndex) {
      T temp = heap[firstIndex];
      heap[firstIndex] = heap[secondIndex];
      heap[secondIndex] = temp;
   }

   private void ensureCapacity() {
      if (size == capacity) {
         heap = Arrays.copyOf(heap, capacity * 2);
         capacity *= 2;
      }
   }

   private int getParentIndex(int childIndex) {
      return (childIndex - 1) / 2;
   }

   private int getLeftChildIndex(int parentIndex) {
      return 2 * parentIndex + 1;
   }

   private int getRightChildIndex(int parentIndex) {
      return 2 * parentIndex + 2;
   }

   private boolean hasParent(int index) {
      return getParentIndex(index) >= 0;
   }

   private boolean hasLeftChild(int index) {
      return getLeftChildIndex(index) < size;
   }

   private boolean hasRightChild(int index) {
      return getRightChildIndex(index) < size;
   }

   private T getParent(int index) {
      return heap[getParentIndex(index)];
   }

   private T getLeftChild(int index) {
      return heap[getLeftChildIndex(index)];
   }

   private T getRightChild(int index) {
      return heap[getRightChildIndex(index)];
   }
}
