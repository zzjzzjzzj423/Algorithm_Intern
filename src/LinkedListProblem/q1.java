package LinkedListProblem;

import java.util.HashMap;

public class q1 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead=new ListNode(-1, head);
        ListNode prev=dummyHead;
        ListNode cur=dummyHead.next;
        while(cur!=null){
            ListNode temp=cur;
            if(cur.val==val){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
            temp=null;
        }
        return dummyHead.next;


    }
}
