/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
  ListNode head;

  //constructors go here
  public LinkedList(){
    head = null;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    if (head == null) {
      head = new ListNode(line, head);
      return head;
    }

    if (line.compareTo(head.getValue()) < 0) {
      head = new ListNode(line, head);
      return head;
    }

    ListNode temp = head;
    while (temp.getNext() != null && line.compareTo(temp.getNext().getValue()) >= 0) {
      temp = temp.getNext();
    }

    ListNode node = new ListNode(line, temp.getNext());
    temp.setNext(node);
    return node;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    if (head == null) {
      return null;
    }
    if (head.getValue().equals(line)) {
      ListNode delete = head;
      head = head.getNext();
      return delete;
    }

    ListNode temp = head;
    while (temp.getNext() != null && !temp.getNext().getValue().equals(line)) {
      temp = temp.getNext();
    }
    if (temp.getNext() == null || !temp.getNext().getValue().equals(line)) {
      return null;
    }
    ListNode nodeToDelete = temp.getNext();
    temp.setNext(temp.getNext().getNext());
    return nodeToDelete;

  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String str = "";
    if (head == null) {
      str = "";
    }
    else {
      ListNode temp = head;
      str += temp.getValue();
      while (temp.getNext() != null) {
        temp = temp.getNext();
        str += " " + temp.getValue();
      }
    }

    return str; 
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
  }

  public ListNode reverse()
  {
    if (head == null) {
      return null;
    }
    if (head.getNext() == null) {
      return head;
    }

    if (head.getNext().getNext() == null) {
      ListNode temp = head.getNext();
      temp.setNext(head);
      head = temp;
      return head;
    }

    return null;

  }


}
