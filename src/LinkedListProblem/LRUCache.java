package LinkedListProblem;

import java.util.HashMap;

class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }

    };

    HashMap<Integer,Node> hashMap=new HashMap<>();
    int capacity;
    Node dummyHead = new Node(-1, -1);
    int realSize=0;
    Node dummyTail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            Node node=hashMap.get(key);
            this.removeNode(node);
            this.updateHead(node);
            return node.val;
        }

        return -1;

    }

    public void put(int key, int value) {

        if(hashMap.containsKey(key)){
            Node node=hashMap.get(key);
            this.removeNode(node);
            this.updateHead(node);
            node.val=value;
        }else{
            Node newNode=new Node(key, value);
            if(realSize==capacity){
                hashMap.remove(dummyTail.prev.key,dummyTail.prev);
                this.removeNode(dummyTail.prev);

                realSize--;
                this.updateHead(newNode);
                hashMap.put(key, newNode);
            }else{
                this.updateHead(newNode);
                hashMap.put(key, newNode);
            }
            realSize++;
        }


    }

    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void updateHead(Node node){
        Node nextNode=dummyHead.next;
        nextNode.prev=node;
        node.next=nextNode;
        node.prev=dummyHead;
        dummyHead.next=node;

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */