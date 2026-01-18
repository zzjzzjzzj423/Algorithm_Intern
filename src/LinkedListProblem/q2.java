package LinkedListProblem;

public class q2 {
    class MyLinkedList {

        public class ListNode{
            ListNode next;
            ListNode prev;
            int val;

            public ListNode(){

            }

            public ListNode(int val){
                this.val=val;
            }
        }

        ListNode dummyHead;
        ListNode dummyTail;
        int size=0;


        public MyLinkedList() {
            dummyHead=new ListNode();
            dummyTail=new ListNode();
            dummyHead.next=dummyTail;
            dummyTail.prev=dummyHead;

        }

        public int get(int index) {
            if (size==0 || index>=size || index<0){
                return -1;
            }
            int curIndex=0;
            int ans=0;
            ListNode cur=dummyHead.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }


            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode newNode=new ListNode(val);
            newNode.next=dummyHead.next;
            newNode.prev=dummyHead;
            dummyHead.next=newNode;
            newNode.next.prev=newNode;
            size++;
        }

        public void addAtTail(int val) {
            ListNode newNode=new ListNode(val);
            newNode.next=dummyTail;
            newNode.prev=dummyTail.prev;
            dummyTail.prev=newNode;
            newNode.prev.next=newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index>size || index<0){
                return;
            }
            ListNode cur=dummyHead.next;
            for(int i=0;i<index;i++){
                cur=cur.next;
            }

            ListNode newNode=new ListNode(val);
            newNode.next=cur;
            newNode.prev=cur.prev;
            cur.prev=newNode;
            newNode.prev.next=newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if(size==0 || index>=size || index<0){
                return;
            }
            ListNode cur=dummyHead.next;
            for (int i=0; i<index; i++){

                cur=cur.next;
            }
            System.out.println(index);

            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
            cur=null;
            size--;
        }


    }


}
