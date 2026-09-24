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
    ListNode temp  = head;
    while (temp.getNext() != null && line.compareTo(temp.getNext().getValue()) > 0) {
      temp = temp.getNext();
      ListNode node = new ListNode(line, temp);
      temp.setNext(node);
    }
    head = temp;
    return head;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String str = "";
    if (head != null) {
      str += head.getValue();
    }
    ListNode temp = head;
    while (temp.getNext() != null) {
      temp = temp.getNext();
      str += " " + temp.getValue();
    }
    return str; 
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {

  }
}
