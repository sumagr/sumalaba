package com.solvd.delivery.collection;

public class LinkedList {

        private Node head;

        private class Node {
            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public LinkedList() {
            this.head = null;
        }

        public void insert(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public boolean search(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public void delete(int data) {
            if (head == null) {
                return;
            }

            if (head.data == data) {
                head = head.next;
                return;
            }

            Node current = head;
            Node prev = null;
            while (current != null && current.data != data) {
                prev = current;
                current = current.next;
            }

            if (current == null) {
                return;
            }

            prev.next = current.next;
        }
    }


