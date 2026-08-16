class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        // Dummy node simplifies head insertion and removal operations
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode curr = this.head.next;
        int i = 0;
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }
        return curr != null ? curr.val : -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode;

        // If the list was empty, the new node becomes the tail as well
        if (this.tail == this.head) {
            this.tail = newNode;
        }
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public boolean remove(int index) {
        // Start at the dummy node so we can stop *before* the target index
        ListNode curr = this.head;
        int i = 0;
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }

        // Check if the node to remove exists (curr.next)
        if (curr != null && curr.next != null) {
            // If we are removing the tail node, update the tail pointer
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public List<Integer> getValues() {
        List<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}