package com.coding.solutions.basic;

public class SinglyLinkedList<T> {

    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;

    public void add(T element){

        SinglyLinkedListNode<T> nd = new SinglyLinkedListNode<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNext(nd);
            //set tail as newly created node
            tail = nd;
        }
    }

    public void addAfter(T element, T after){

        SinglyLinkedListNode<T> tmp = head;
        SinglyLinkedListNode<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        if(refNode != null){
            //add element after the target node
            SinglyLinkedListNode<T> nd = new SinglyLinkedListNode<T>();
            nd.setValue(element);
            nd.setNext(tmp.getNext());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNext(nd);

        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void deleteFront(){

        if(head == null){
            System.out.println("Underflow...");
        }
        SinglyLinkedListNode<T> tmp = head;
        head = tmp.getNext();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }

    public void deleteAfter(T after){

        SinglyLinkedListNode<T> tmp = head;
        SinglyLinkedListNode<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNext();
        }
        if(refNode != null){
            tmp = refNode.getNext();
            refNode.setNext(tmp.getNext());
            if(refNode.getNext() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void traverse(){

        SinglyLinkedListNode<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }

    public void reverse() {
        if (this == null || this.head == null) {
            return;
        }

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = ( current != null) ? current.getNext() : null;
        SinglyLinkedListNode nextToNext = (next != null) ? next.getNext() : null;

        while ( current != null ) {
//            System.out.println(print(prev) + " -> " + print(current) + " -> " + print(next) + " -> " + print(nextToNext));
            current.setNext(prev);
            prev = current;
            current = next;
            next = nextToNext;
            if (nextToNext != null) nextToNext = nextToNext.getNext();
        }
        head = prev;
    }

    String print(SinglyLinkedListNode node) {
        if (node != null) return "" + node.getValue();
        return "NULL";
    }

    public static void main(String a[]){
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.traverse();

        sl.reverse();

        System.out.println("LinkList reversed ");
        sl.traverse();
    }
}