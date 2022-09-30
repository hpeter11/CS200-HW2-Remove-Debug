package sol;

import src.IList;

import src.IListWithNode;

// TODO 3-C worst case runtime size
// TODO Part 4 pdf response and SRC
// TODO 5-B environment heap diagram
// TODO line 61
// TODO 6-E bypass running time
// TODO 6-G comment why tests fail
// TODO work on remove tests
// TODO Uncomment interface
// TODO Questions

// What's with the list in before suite
// How to do big O runtime
// Task 7-B constant runtime
// bypass?
// Types of remove/argument inputs


/**
 * A class that implements singly-linked mutable lists.
 *
 * @param <T> - the type of items in the list
 */
public class MutableList<T> implements IList<T>, IListWithNode<T> {
  private Node<T> start;

  private Node<T> last;
  private int length;

  /**
   * A constructor for Mutable List.
   */
  public MutableList() {
    this.start = null;
    this.last = null;
    this.length = 0;
  }

  /**
   * Returns whether the list is empty.
   *
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return (this.start == null);
  }

  /**
   * Returns the first item in the list.
   *
   * @throws RuntimeException "List is empty" when the list is empty
   * @return the first item in the list
   */

  @Override
  public T getFirst() {
    if (this.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    return this.start.getItem();
  }

  /**
   * Adds an item to the start of the list.
   *
   * @param item - the item to be added
   */

  @Override
  public void addFirst(T item) {
    this.length = this.length + 1;

    Node<T> newNode = new Node<T>(item, this.start);
    if (this.start == null) {
        if (this.last == null) {
            this.last = newNode;
        }
      this.start = newNode;
    }
    this.start.setPrev(newNode);
    newNode.setNext(this.start);
    this.start = newNode;
  }

   /**
   * Returns the number of elements in the list.
   *
   * @return the number of elements in the list
   */

 public int sizeA() {
    if (this.isEmpty())
      return 0;
    else
      return this.start.size();
  }

  // Task 3-B

    /**
     *
     * returns the length of a list built using addFirst and addLast.
     *
     * @return
     */

    @Override
  public int size() {
    return this.length;
  }

  /**
   * Returns the item at the specified index.
   *
   * @param index - an item index
   * @throws RuntimeException "Index out of bounds" if index is too small or big
   * @return the item at the specified index
   */

  // Task 1-B

  @Override
  public T get(int index) {
    return (T) this.start.indexed(index);
  }

  // Task 1-E

  /*
  Worst case runtime of indexed is O(n) because runtime of indexed is O(n)
   */

  /**
   * Removes an item from the list. If the item is not in the list, the list is
   * unchanged. If the item occurs more than once in the list, removes only the
   * first instance.
   *
   * @param item - the item to remove
   *
   * @return whether or not the item was successfully removed from the list
   */

  // Part 5-C

  /**
   *
   * Uses fullBypass to recurse through a list and if a given node is found,
   * bypass that node by linking nodes or null on either side
   *
   * @param item - the item to remove
   *
   * @return
   */

  // Task 6-C
  @Override
  public boolean remove(T item) {
      this.length = this.length - 1;
    return this.start.fullBypass(item);
  }

  /**
   * Adds an item to the end of the list.
   *
   * @param item - the item to be added
   */

  // Task 2-C

  /**
   * I believe this method has a lower O runtime because it automatically
   * initializes as null. While another program would have to both create a new
   * object and check for it every time, this program (using last) doesn't have
   * to create that object - just check for null.
   *
   * @param item - the item to be added
   */

  // Task 2-B

    /**
     *
     * Increases the length of the list by 1 and uses last to make a new node
     * at the start of the list, linking the old start in the next field.
     *
     * @param item - the item to be added
     */

    @Override
    public void addLast(T item) {
        this.length = this.length + 1;

        Node<T> last = new Node<T>(item, null);

        if (this.length == 0) {
            this.start = last;

        } else {
            last.setPrev(this.last);

            this.last.setNext(last);

            this.last = last;
        }
    }

  /**
   * Returns the first item in the list as a String.
   *
   * @return the first item in the list as a String
   */
  public String toString() {
    if (this.start == null)
      return "[]";
    else
      return "[" + this.start.toString() + "]";
  }

  // Task 7-A

    /**
     *
     * enters a list and uses findNode to search for a node with matching item,
     * subsequently returning the appropriate node.
     *
     * @param item -- an item in the list
     * @return
     */

  public Node<T> getNode(T item) {
    return this.start.findNode(item);
        }

        // Task 7-B

    /**
     *
     * removes an input node from the list
     *
     * @param node - the node to remove
     */

  public void removeNode(Node<T> node) {
    node.bypass();
    }

    // Task 7-C

    /**
     *
     * Removes a node from a list based on an input parameter item. If a
     * matching node exists, the node is removed and true is returned.
     * Otherwise, returns false.
     *
     * @param item -- an item in the list to be removed
     * @return
     */

  public boolean removeWithNodes(T item) {

    Node<T> ourNode;
    try {
      ourNode = this.getNode(item);
    } catch(RuntimeException e) { //Has to be illegal argument
      return false;
    }

    this.removeNode(ourNode);
    return true;
  }

}
