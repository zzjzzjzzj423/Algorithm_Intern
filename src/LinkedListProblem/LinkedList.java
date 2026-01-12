package LinkedListProblem;

import java.util.HashMap;

public class LinkedList {

    class ListNode{

        int val;
        ListNode next;

        public ListNode(int val){
            this.val=val;
        }

    }

    public ListNode arr2list(int[] nums){

        ListNode head=new ListNode(nums[0]);
        ListNode cur=head;
        for (int i=1;i<nums.length;i++){
            cur.next=new ListNode(nums[i]);
            cur=cur.next;
        }
        return head;
    }
    public void makeListString(ListNode head){
        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print("null");
    }
    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode ans=null;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=ans;
            ans=cur;
            cur=next;
        }
        return ans;
    }

    public ListNode findMidNode(ListNode head){

        if(head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;


        while (fast.next!=null && fast.next.next!=null){

            slow=slow.next;
            fast=fast.next.next;

        }

        return slow;
    }

    public ListNode MergeList(ListNode head1, ListNode head2){

        ListNode dummyNode=new ListNode(0);

        ListNode cur=dummyNode;

        ListNode upNode=head1;
        ListNode bottomNode=head2;

        while(upNode!=null&&bottomNode!=null){
            if(upNode.val>bottomNode.val){
                cur.next=bottomNode;
                bottomNode=bottomNode.next;
            }else{
                cur.next=upNode;
                upNode=upNode.next;
            }
            cur=cur.next;
        }

        if (upNode!=null){
            cur.next=upNode;
        } else if (bottomNode!=null) {
            cur.next=bottomNode;
        }
        return dummyNode.next;
    }

    public boolean checkRing(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }


    public ListNode findRingEntrance(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode cur=head;
                while (cur!=slow){
                    cur=cur.next;
                    slow=slow.next;
                }
                return cur;
            }
        }
        return null;
    }




    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,10,11};
//        ListNode head=new LinkedList().arr2list(arr);
//        new LinkedList().makeListString(head);
//        ListNode reversedList=new LinkedList().reverseList(head);
//        System.out.println();
//        new LinkedList().makeListString(reversedList);
//        System.out.println();
//        ListNode mid=new LinkedList().findMidNode(reversedList);
//        new LinkedList().makeListString(mid);
        int[] arr1={1,2,3,8,9,12};
        ListNode head1=new LinkedList().arr2list(arr);
        ListNode head2=new LinkedList().arr2list(arr1);
        ListNode newHead=new LinkedList().MergeList(head2,head1);

        new LinkedList().makeListString(newHead);

        HashMap<Integer, Integer> hashMap=new HashMap<>();
        System.out.println();
    }
}
