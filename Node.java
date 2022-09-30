package sol;

/**
 * A class that implements doubly linked list nodes.
 */

// Task 5-C

/*

 */
public class Node<S> {
    private S item;
    private Node<S> next;

    //Task 6-A
    private Node<S> prev;

    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     */
    public Node(S item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    /**
     * A constructor for Node.
     *
     * @param item - the item stored at this node
     * @param next - the node which comes directly after this node in the list
     */
    public Node(S item, Node<S> next) {
        this.item = item;
        this.next = next;
    }

    /**
     * Returns a boolean indicating whether the Node has a given item.
     *
     * @param checkItem - the item to check if the Node has
     * @return true if this Node has checkItem, false otherwise
     */
    public boolean hasItem(S checkItem) {
        return this.item.equals(checkItem);
    }

    /**
     * Returns the Node's item.
     *
     * @return the Node's item
     */
    public S getItem() {
        return this.item;
    }

    /**
     * Returns a boolean indicating if the Node has a Node as its next field.
     *
     * @return true if the Node has a next Node, false otherwise
     */
    private boolean hasNext() {
        return (this.next != null);
    }

    /**
     * Returns the size of the list starting at this Node until the end of the list.
     *
     * @return the size of the list starting at this Node until the end of the list.
     */
    public int size() {
        if (this.hasNext())
            return 1 + this.next.size();
        else
            return 1;
    }

    /**
     * Returns the Node's representation as a String.
     *
     * @return the Node's representation as a String
     */

    public String toString() {
        if (this.hasNext())
            return this.item.toString() + ", " + this.next.toString();
        else
            return this.item.toString();
    }

    /**
     * A method for get that takes in an integer i and recurses through a tree
     * to find the number item that matches the index input. This method
     * builds a count based on how many times recursion has occurred and if
     * the count is the same as the item, it returns that item. Otherwise,
     * if the next item is null or index is less than 0, a runtime exception
     * is thrown. If count != the index, it moves on to recursing through
     * next.
     *
     * @param i
     * @return
     */

    public S indexed(Integer i) {
        if (this.item == null || i < 0) {
            throw new RuntimeException("Index out of bounds");
        } else if (i == 0) {
            return this.item;
        } else {
            return this.next.indexed(i - 1);
        }
    }

    // Runtime = O(n)

    /**
     * Last recurses through a node, assessing if the next field is null, in
     * which case next is set to equal a new node made with the input
     * value. If not, last is run on this.next to find the true end node.
     *
     * @param t
     */

    public void last(S t) {
        if (this.next == null) {
            Node last = new Node(t);
            this.next = last;
            last.prev = this;
        } else {
            this.next.last(t);
        }
    }

    /**
     * Take is part of the remove method. If the node's item matches the input
     * value, it resets the item value to equal the next value.
     *
     * @param t
     */

    public void take(Object t) {
        if (this.item == t) {
            this.item = next.item;
        } else if (this.next == null) {


        }
    }

    // Task 6-B

    /**
     *
     * If a node is in between other nodes, links external nodes and drops
     * central node. If prev node does not exist, next.prev is null. If next
     * node DNE, next.prev is null.
     *
     */

    public void bypass() {

        //at end of list

        if (this.prev != null && this.next == null) {
            this.prev.next = null; }

        //beginning of list

        else if (this.next != null && this.prev == null) {
            this.next.prev = null; }

        //bypasses this node

        else {
            this.prev = this.next;
            this.next = this.prev;
            }
        }

    public boolean fullBypass(S findItem) {

        //Item found and is bypassed

        if (this.item.equals(findItem)) {
            this.bypass();
            return true;

            //Item is not found and there is no list left

        } else if (!this.item.equals(findItem) && this.next == null) {
            return false;

            //recursion continues

        } else {
            return this.next.fullBypass(findItem);
        }
    }

    public Node<S> getPrev() {
        return this.prev;
    }

    public Node<S> getNext() {
        return this.next;
    }

    public void setPrev(Node<S> n) {
        this.prev = n;
    }

    public void setNext(Node<S> n) {
        this.next = n;
    }

    public Node<S> findNode(S argument) {
        if (this.item.equals(argument)) {
                return this;
        }

        else if (this.next == null) {
            return null;

        } else {
            return this.next.findNode(argument);
        }
    }

    public S nodeEquals(S argument) {
        if (this.item == argument) {
            return this.item;
        } else {
            return null;
        }
    }

}
