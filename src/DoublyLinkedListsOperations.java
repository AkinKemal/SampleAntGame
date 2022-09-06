public class DoublyLinkedListsOperations {
    private Node head, tail;

    public DoublyLinkedListsOperations() {
        head = null;
        tail = null;
    }

    public int getSize() {
        int cnt = 0;
        Node walk = head;

        while (walk != null) {
            cnt++;
            walk = walk.getNext();
        }
        return cnt;
    }


    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setPrev(null);
            newNode.setNext(null);
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }


    public String print(int height, int weight) {
        String text = "";
        int cnt = 0;

        Node walk = head;

        while (walk != null) {
            if (cnt % weight == 0) {
                text += "\n";
            }
            text += walk.getData();
            cnt++;
            walk = walk.getNext();
        }
        return text;
    }
}