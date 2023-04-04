package DSImplementations;


import java.util.function.BiFunction;

public class DoublyLinkedList {
  protected int size = 0;

  private DoublyLinkedListNode head;
  private DoublyLinkedListNode tail;

  public DoublyLinkedList() {}

  private void linkHead(int newData) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(null, newData, head);

    if (head == null) {
      tail = newNode;
    } else {
      head.setPrevious(newNode);
    }
    head = newNode;
    size++;
  }

  private void linkTail(int newData) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(tail, newData, null);

    if (tail == null)
      head = newNode;
    else
      tail.setNext(newNode);

    tail = newNode;
    size++;
  }

  private void linkTail(DoublyLinkedListNode newNode) {
    if (tail == null)
      head = newNode;
    else
      tail.setNext(newNode);

    tail = newNode;
    size++;
  }

  private void linkBefore(int newData, DoublyLinkedListNode targetNode) {
    DoublyLinkedListNode previousNode = targetNode.getPrevious();
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(previousNode, newData, targetNode);

    targetNode.setPrevious(newNode);

    if (previousNode == null) {
      head = newNode;
    } else {
      previousNode.setNext(newNode);
    }
    size++;
  }

  private void linkAfter(int newData, DoublyLinkedListNode targetNode) {
    DoublyLinkedListNode nextNode = targetNode.getNext();
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(targetNode, newData, nextNode);

    targetNode.setNext(newNode);

    if (nextNode == null) {
      tail = newNode;
    } else {
      nextNode.setPrevious(newNode);
    }
    size++;
  }

  private void linkAfter(DoublyLinkedListNode newNode, DoublyLinkedListNode targetNode) {
    DoublyLinkedListNode nextNode = targetNode.getNext();

    targetNode.setNext(newNode);

    if (nextNode == null) {
      tail = newNode;
    } else {
      nextNode.setPrevious(newNode);
    }
    size++;
  }

  public void addHead(int newData) {
    linkHead(newData);
  }

  public void addTail(int newData) {
    linkTail(newData);
  }

  public void addTail(DoublyLinkedListNode newNode) {
    linkTail(newNode);
  }

  public void addBefore(int newData, DoublyLinkedListNode targetNode) {
    linkBefore(newData, targetNode);
  }

  public void addAfter(int newData, DoublyLinkedListNode targetNode) {
    linkAfter(newData, targetNode);
  }

  public void addAfter(DoublyLinkedListNode newNode, DoublyLinkedListNode targetNode) {
    linkAfter(newNode, targetNode);
  }

  public void insert(int newData) {
    addTail(newData);
  }

  public void insert(DoublyLinkedListNode newNode) {
    addTail(newNode);
  }

  private boolean unlink(DoublyLinkedListNode targetNode) {

    DoublyLinkedListNode previousNode = targetNode.getPrevious();
    DoublyLinkedListNode nextNode = targetNode.getNext();

    if (!contains(targetNode)) {
      return false;
    }

    if (previousNode == null) {
      head = nextNode;
    } else {
      previousNode.setNext(nextNode);
      targetNode.setPrevious(null);
    }

    if (nextNode == null) {
      tail = previousNode;
    } else {
      nextNode.setPrevious(previousNode);
      targetNode.setNext(null);
    }
    targetNode.setData(0);
    size--;
    return true;
  }

  public void remove(DoublyLinkedListNode targetNode) {
    boolean isRemoved = unlink(targetNode);
    if (!isRemoved) {
      System.out.println("Node not found");
    }
  }

  public DoublyLinkedListNode search(int data) { // returns first node with data
    return traverseNodes(data, (node, d) -> node.getData() == d);
  }

  public boolean contains(int data) {
    return traverseNodes(data, (node, d) -> node.getData() == d) != null;
  }

  public boolean contains(DoublyLinkedListNode targetNode) {
    return traverseNodes(0, (node, d) -> node == targetNode) != null;
  }

  public void print() {
    DoublyLinkedListNode current = head;
    while (current != null) {
      System.out.printf("(%d,%d), ", current.getData(), current.getColumnIndex());
      current = current.getNext();

    }
    System.out.print("null\n");
  }

  public DoublyLinkedListNode getHead() {
    return head;
  }

  public DoublyLinkedListNode getTail() {
    return tail;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void printNode(DoublyLinkedListNode targetNode) {
    System.out.println(targetNode);
  }

  private DoublyLinkedListNode traverseNodes(int data,
      BiFunction<DoublyLinkedListNode, Integer, Boolean> condition) {
    DoublyLinkedListNode tempHead = head;
    while (tempHead != null) {
      if (condition.apply(tempHead, data)) {
        return tempHead;
      }
      tempHead = tempHead.getNext();
    }
    return null;
  }

}
