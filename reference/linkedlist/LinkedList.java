package reference.linkedlist;

public class LinkedList <E>{
    class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public int countElement() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void insertAtBeginning(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insertAtPosition(E data, int position) {
        Node newNode = new Node(data);
        if (position >= 0 && position <= countElement()) {
            if (position == 0) {
                insertAtBeginning(data);
            } else {
                if (position == countElement()) {
                    insertAtEnd(data);
                } else {
                    Node previousNewNode = head;
                    int count = 0;
                    while (previousNewNode != null && count < position - 1) {
                        count++;
                        previousNewNode = previousNewNode.next;
                    }
                    newNode.next = previousNewNode.next;
                    previousNewNode.next = newNode;
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ !!!");
        }
    }

    public void deleteAtFirst() {
        if (head == null) {
            System.out.println("LinkedList is null");
            return;
        }
        head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("LinkedList is null");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node previous = null;
        Node currentNode = head;
        while (currentNode.next != null) {
            previous = currentNode;
            currentNode = currentNode.next;
        }
        previous.next = null;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public void deleteAtPosition(int position) {
        if (position >= 0 && position <= countElement()) {
            if (position == 0) {
                deleteAtFirst();
            } else {
                if (position == countElement()) {
                    deleteAtEnd();
                } else {
                    Node currentNode = head;
                    Node previousNode = null;
                    int count = 0;
                    while (currentNode != null && count < position) {
                        previousNode = currentNode;
                        count++;
                        currentNode = currentNode.next;
                    }
                    previousNode.next = currentNode.next;
                    currentNode = null;

                }
            }
        } else {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ !!!");
        }
    }
}
