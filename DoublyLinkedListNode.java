package DSImplementations;


public class DoublyLinkedListNode {
  private DoublyLinkedListNode previous;
  private int data;
  private DoublyLinkedListNode next;


  public DoublyLinkedListNode(DoublyLinkedListNode previous, int data, DoublyLinkedListNode next) {
    this.previous = previous;
    this.data = data;
    this.next = next;
  }

  public DoublyLinkedListNode getPrevious() {
    return previous;
  }

  public void setPrevious(DoublyLinkedListNode previous) {
    this.previous = previous;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public DoublyLinkedListNode getNext() {
    return next;
  }

  public void setNext(DoublyLinkedListNode next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return (this.previous == null ? "null" : this.previous.data) + " <> " + this.data + " <> "
        + (this.next == null ? "null" : this.next.data);
  }
}
