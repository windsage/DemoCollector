package com.chao.democollector.bean;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Jeffery on 17/11/22.
 */

public class Algorithm {

    static class Node {
        int data;
        Node next;

        HashMap<String,Node> map;
        Hashtable<String,Node> table;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    static Node delete(Node head, Node node) {
        //如果node是尾节点，从头节点开始遍历每一次，倒数第二个的next置空
        if (node.next == null) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        }
        //如果node恰巧为head，第一节点直接置空
        else if (head == node) {
            head = null;
        }
        //其余情况
        else {
            while (head.next != node) {
                head = head.next;
            }
            head.next = node.next;
            head.data = node.data;
        }
        return head;
    }
}
