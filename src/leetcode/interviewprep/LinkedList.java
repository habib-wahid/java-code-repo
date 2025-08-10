package leetcode.interviewprep;

import java.util.HashMap;

/// Linked List Key Notes
/// 3 types of Linked List : Single, Double, Circular
/// Single means each node contains it's value and next node pointer, Double means each node contains it's value and reference of the
/// previous and next node, Circular linked list is a single linked list with last node pointing the reference of first node
///


public class LinkedList {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

  //  public static ListNode abc(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        if (lists.length == 1) {
//            return lists[0];
//        }
//
//
//        ListNode firstListHead = lists[0];
//
//        for (int i = 1; i < lists.length; i++) {
//
//            ListNode secondListHead = lists[i];
//            ListNode head = null;
//            ListNode tempHead = null;
//
//            while (firstListHead != null && secondListHead != null) {
//               if (firstListHead.val <= secondListHead.val) {
//                   ListNode node = new ListNode(firstListHead.val);
//                   if (head == null) {
//                       head = node;
//                       tempHead = node;
//                   } else {
//                       tempHead.next = node;
//                       tempHead = node;
//                   }
//                   firstListHead = firstListHead.next;
//               } else {
//                   ListNode node = new ListNode(secondListHead.val);
//                   if (head == null) {
//                       head = node;
//                       tempHead = node;
//                   } else {
//                       tempHead.next = node;
//                       tempHead = node;
//                   }
//
//                   secondListHead = secondListHead.next;
//               }
//            }
//
//            if (firstListHead != null) {
//                tempHead.next = firstListHead;
//            }
//
//            if (secondListHead != null) {
//                tempHead.next = secondListHead;
//            }
//
//            firstListHead = head;
//
//        }
//
//        return firstListHead;
//
//        return null;
//    }

    public static Node solution1(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node currentHead = head;
        Node newHead = null;
        Node tempHead = null;

        while (currentHead != null) {
            Node newNode = new Node(currentHead.val);
            if (newHead == null) {
                newHead = newNode;
                tempHead = newNode;
            } else {
                tempHead.next = newNode;
                tempHead = tempHead.next;
            }

            map.put(currentHead, tempHead);
            currentHead = currentHead.next;
        }

        Node temp = newHead;
        while (head != null) {
            if (head.random != null) {
                temp.random = map.get(head.random);
            }

            head = head.next;
            temp = temp.next;
        }

        return newHead;
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next == null) {
            return;
        }

        ListNode temp = slow.next;
        ListNode newHead = new ListNode(temp.val);
        temp = temp.next;

        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            node.next = newHead;
            newHead = node;
            temp = temp.next;
        }

        slow.next = null;



       ListNode tempHead = head;

        while (tempHead != null && newHead != null) {
            ListNode node = tempHead.next;
              ListNode tempSecondNode = new ListNode(newHead.val);
              tempSecondNode.next = node;
              tempHead.next = tempSecondNode;
              tempHead = tempHead.next.next;
              newHead = newHead.next;
        }

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public boolean findLinkedListCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;
        if (list1.val <= list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next =new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }

        return head;
    }
//    Time Complexity : O(n)
//    Space Complexity: O(1)
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(head.val);
        head = head.next;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = newHead;
            newHead = temp;
            head = head.next;
        }

        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
       // solution(head)
    }
}
