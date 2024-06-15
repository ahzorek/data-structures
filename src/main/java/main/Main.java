package main;

import dataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello!!!!");

        //testes com a linked list
        usingLists();
    }

    public static void usingLists(){
        LinkedList list = new LinkedList("1");

        //list.print();

        list.append("2");
        list.append("3");
        list.append("4");
        list.append("5");
        list.append("6");
        list.removeLast();
        list.prepend("0");

        System.out.println("_____________________________________");
        list.insert(0, "-1");
        list.updateIndex(4, "3.5");
        list.print();

        System.out.println("_____________________________________");
        list.remove(3);
        list.print();

        list.getTail();
        list.getHead();
        list.getLength();
    }
}
