package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement != null) && (currentElement != last)) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {

        if(first.next == null && last.prev == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.prev = null;
            newNode.next = null;
            first.next = newNode;
            last.prev = newNode;
            return;
        }

        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = last.prev;
        newNode.next = null;
        last.prev.next = newNode;
        last.prev = newNode;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
