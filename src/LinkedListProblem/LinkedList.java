package LinkedListProblem;

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
        ListNode slow=head;
        ListNode fast=head;


        while (fast.next!=null && fast.next.next!=null){

            slow=slow.next;
            fast=fast.next.next;

        }

        return slow;
    }


    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,10,11};
        ListNode head=new LinkedList().arr2list(arr);
        new LinkedList().makeListString(head);
        ListNode reversedList=new LinkedList().reverseList(head);
        System.out.println();
        new LinkedList().makeListString(reversedList);
        System.out.println();
        ListNode mid=new LinkedList().findMidNode(reversedList);
        new LinkedList().makeListString(mid);
    }
}
