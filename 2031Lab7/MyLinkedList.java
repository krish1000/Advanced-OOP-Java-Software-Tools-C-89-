public class MyLinkedList {
    private Node head;  // instance variable.

    // Default constructor
    public MyLinkedList() {
        this.head=null;
    }

    public int len() {
        Node curr = this.head;
        int len = 0;
        while (curr != null)
        {
            curr = curr.getNext();  // or just curr =curr.next;
            len++;
        }
        return len;
    }

   /* assume list is not empty, and index is valid [0, len()-1] */ 
    public int get(int index)
    {
        Node curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.data;
    }

    // appends the specified element to the begining of this list.
    // the list may or may not be empty (but the code is same)
    public void insertBegining(int data) {
        Node newNode = new Node(data);

        // insert at the begining. Order matters.
        // also works if the list is empty.
        newNode.next = head;    // newNode.setNext(this.head);   will be null if list is empty
        head = newNode;
    }

    // inserts the specified element after the specified position in this list
    // assume list is not empty.  index is valid [0 - len()-1]
    public void insertAfter(int index, int data) {
        Node curr = this.head;

        // crawl to the requested index 
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        // insert after curr, and before curr.next;  order matters!!!
        Node newNode = new Node(data);

        // set the new node's next-node reference to curr node's next-node reference
        newNode.next = curr.next;

        // now set curr node's next-node reference to the new node
        curr.next = newNode;
    }

    // removes the element with data dat in this list.
    // assume the list is not empty
    // assume the node to be deleted exists in the list, and no duplicated keys.
    public void remove(int dat) {
        if (head.data == dat)
        {
            head = head.next;
        }
        else{
            Node curr = head;
            while (curr.next.data != dat)
            {
                curr = curr.next;
            }
            // curr is the one preceding the one to be deleted
            // remove curr.next
            curr.next = curr.next.next; // by-pass curr.next; gabage collector will recycle the deleted node.
        }
    }

    public String toString() {
        String output = "";
        if (head != null) {
            Node curr = head;
            while (curr != null) {
               output += "" + curr.getData() + "   ";
               curr = curr.getNext();
            }
        }
        return output;
    }

    private class Node {
        // two attributes (instance variables)

        // data carried by this node. 
        int data;
        // reference to the next node in the chain, or null if there isn't one.
        Node next;

        // Node constructor
        public Node(int dataValue) {
            this.data = dataValue;
            this.next = null;
        }

        // these methods should be self-explanatory
        public int getData() {
            return this.data;
        }

        public void setData(int dataValue) {
            this.data = dataValue;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node nextNode) {
            this.next = nextNode;
        }

    }

    public static void main(String[] args) {

        MyLinkedList ll = new MyLinkedList();

        ll.insertBegining(1); System.out.printf("insert 1: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(0); System.out.printf("insert 0: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(2); System.out.printf("insert 2: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(9); System.out.printf("insert 9: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(8); System.out.printf("insert 8: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(6); System.out.printf("insert 6: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(5); System.out.printf("insert 5: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(3); System.out.printf("insert 3: (%d)\t%s\n", ll.len(), ll.toString());
        ll.insertBegining(7); System.out.printf("insert 7: (%d)\t%s\n", ll.len(), ll.toString());

        int[] removeList ={0,1,2,3,5,6,7,8,9};
        for (int i=0;i<removeList.length ; i++)
        {
            int ele = removeList[i];
            ll.remove(ele);
            System.out.printf("remove %d: (%d)\t%s\n", ele, ll.len(), ll);
        }
        // insert again
        int[] insertList ={1,0,2,9,8,6,5,3,7};
        for (int i=0;i<insertList.length ; i++)
        {
            int ele = insertList[i];
            ll.insertBegining(ele); 
            System.out.printf("insert %d: (%d)\t%s\n", ele, ll.len(), ll);
        }
        ll.insertAfter(2,-4); System.out.printf("\ninsert -4 after index 2: (%d)\t%s\n", ll.len(), ll);
        ll.insertAfter(0,-6); System.out.printf("insert -6 after index 0: (%d)\t%s\n", ll.len(), ll);
        ll.insertAfter(6,-8); System.out.printf("insert -8 after index 6: (%d)\t%s\n", ll.len(), ll);

        int v = ll.get(0);  System.out.println("\nget(0): " + v);
        v = ll.get(3);  System.out.println("get(3): " + v);
        v = ll.get(6);  System.out.println("get(6): " + v);

    }

}