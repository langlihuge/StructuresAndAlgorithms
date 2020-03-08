package com.seatiger.structure.ae_recursion.ac_debug_recursive_solution;

/**
 * once remove ,could see the depth
 */
public class DebugRemoveNodeValue {


    public ListNode removeElements(ListNode head, int val,int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call : remove " + val + " " + head);


        if(head == null){
            return  null;
        }
        head.next = removeElements(head.next,val,++depth);

        System.out.print(depthString);
        System.out.println("After : remove " + val + " " + head.next);

        ListNode res = head.val == val ? head.next : head;

        System.out.print(depthString);
        System.out.println("Return : "+ " " + head);

        return res;
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < depth;i++){
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,6,4,5,5,6,7};
        ListNode node = new ListNode(arr);
        ListNode listNode = new DebugRemoveNodeValue().removeElements(node, 6,0);
        System.out.println(listNode);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    /**
     * can use this take for head node
     * @param arr
     */
    public ListNode(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1;i < arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            builder.append(cur.val + "-->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();

    }
}
