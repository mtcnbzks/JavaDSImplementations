package DSImplementations;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {
   private int capacity;
   private int size;

   private T[] heap;

   @SuppressWarnings("unchecked")
   public MaxHeap() {
      this.size = 0;
      this.capacity = 10;
      this.heap = (T[]) new Comparable<?>[capacity];
   }

   public void insert(T data) {
      ensureCapacity();
      heap[size] = data;

      // heapifyUp();
      int current = size;
      while (heap[current].compareTo(heap[getParentIndex(current)]) > 0) {
         swap(current, getParentIndex(current));
         current = getParentIndex(current);
      }
      size++;
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
      T popped = heap[0];
      heap[0] = heap[size - 1];
      size--;
      maxHeapify(0);
      return popped;
   }

   public T search(T target) {
      for (int i = 0; i < size; i++) {
         if (heap[i].equals(target)) {
            return heap[i];
         }
      }
      return null;
   }

   private void maxHeapify(int index) {
      if (isLeaf(index)) {
         return;
      }

      int left = getLeftChildIndex(index);
      int right = getRightChildIndex(index);

      int largest = index;

      if (left < size && heap[left].compareTo(heap[largest]) > 0) {
         largest = left;
      }

      if (right < size && heap[right].compareTo(heap[largest]) > 0) {
         largest = right;
      }

      if (largest != index) {
         swap(index, largest);
         maxHeapify(largest);
      }

   }

   public void print() {
      for (int i = 0; i < size; i++) {
         System.out.print(heap[i] + ", ");
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

   private boolean isLeaf(int index) {
      return index >= (size / 2) && index <= size;
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

   public T[] getHeap() {
      return heap;
   }

   public void setHeap(T[] heap) {
      this.heap = heap;
   }

   public int getSize() {
      return size;
   }

   public void setSize(int size) {
      this.size = size;
   }
}
