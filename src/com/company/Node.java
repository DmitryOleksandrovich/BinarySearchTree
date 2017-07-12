package com.company;

/**
 * Created by Dima on 05.02.2017.
 */
public class Node {

    int Key;
    String name;

    Node leftChild;
    Node rightChild;

    public Node(int key, String name) {
        Key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "Key=" + Key +
                ", name='" + name + '\'' +
                '}';
    }
}
