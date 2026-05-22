class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class MergeLinkedList {
    public static void main(String[] args) {

        Node l1 = new Node(10);
        l1.next = new Node(30);
        l1.next.next = new Node(50);

        Node l2 = new Node(20);
        l2.next = new Node(40);
        l2.next.next = new Node(60);

        Node dummy = new Node(0);
        Node temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } 
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        Node result = dummy.next;
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}