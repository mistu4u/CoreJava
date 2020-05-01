package datastructure;

public class LinkedList {
    Node head;

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node getHead() {
        return this.head;
    }

    public void append(LinkedList list, int value) {
        //if list is null, create it
        if (list.head == null) {
            list.head = new Node(value);
        } else {
            Node last = list.head;
            //traverse the list until the last element is reached and then add the value to it
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(value);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(list, 1);
        list.append(list, 2);
        list.appendAtHead(list, 4);
        printList(list);
        list.deleteElement(list,2);
        list.deleteElement(list,6);
        printList(list);
    }

    public void appendAtHead(LinkedList list, int value) {
        Node newNode = new Node(value);
        newNode.next = list.getHead();
        list.head = newNode;
    }

    public void deleteElement(LinkedList list, int value) {
        Node currentHead = list.getHead(), prev = null;
        //If currentHead holds the value
        if (currentHead.value == value) {
            currentHead = currentHead.next;
        }
        //if the value is in between or at the end
        while (currentHead != null && currentHead.value != value) {
            prev = currentHead;
            currentHead = currentHead.next;
        }
        if (currentHead != null && prev!=null) {
            prev.next = currentHead.next;
            System.out.println("\n" + value + " was deleted from the list");
        }
        if (currentHead == null) {
            System.out.println(value + " was not found in the list");
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
