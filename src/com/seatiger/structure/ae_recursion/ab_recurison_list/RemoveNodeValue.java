package com.seatiger.structure.ae_recursion.ab_recurison_list;

/**
 * the question in leetcode 203 question
 * Remove all elements from a linked list of integers that have value val.
 *  * Example:
 *  * Input:  1->2->6->3->4->5->6, val = 6
 *  * Output: 1->2->3->4->5
 *
 *  the ways can reference \image\structure\ae_recursion\ab_thinking_to_remove.png
 *
 *  the test you can see com.seatiger.leetcode.LC0203_RemoveLinkedListElements
 *
 *  the process can reference image/structure/ae_recursion/ac_process_remvenode.jpg
 */
public class RemoveNodeValue {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * find the smallest question is head == null
     * you can think that remove each ,can have one node ,this element is e
     * and other nodes, the one node point to the other nodes
     * if the element e that you should remove value
     * so we return other nodes ,else we return one node that points other node
     *
     * the first node and the other node is all node
     * the one node is first head node
     * the other nodes is head.next
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }


//        ListNode resNode = removeElements(head.next, val);
//        if(head.val == val){
//            return resNode;
//        }else{
//            head.next = resNode;
//            return head;
//        }



        head.next = removeElements(head.next,val);

        if(head.val == val){
            return head.next;
        }
        return head;
    }
}


