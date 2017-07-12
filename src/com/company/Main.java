package com.company;

public class Main {

    Node root;

    public void addNode(int key, String name){

        Node newNode =  new Node(key, name);

        if(root == null){
            root =  newNode;
        }else{
            Node focusNode = root;
            Node parent;

            while (true){
                parent =  focusNode;
                if(key < focusNode.Key){
                    focusNode =  focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild =  newNode;
                        return;
                    }
                }else{
                    focusNode =  focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild =  newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean remove(int key){

        Node focusNode = root;
        Node parent  =  root;

        boolean isItALeftChild = true;
        while (focusNode.Key != key){
            parent = focusNode;
            if(key< focusNode.Key){
                isItALeftChild = true;
                focusNode =  focusNode.leftChild;
            }else {
                isItALeftChild = false;
                focusNode =  focusNode.rightChild;
            }

            if(focusNode == null)
                return  false;

        }

        if(focusNode.leftChild == null && focusNode.rightChild ==null){
            if(focusNode == root){
                root = null;
            }else if (isItALeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        }else if(focusNode.rightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.leftChild;
            }else{
                parent.rightChild = focusNode.leftChild;
            }
        }else if(focusNode.leftChild == null){
            if(focusNode == root){
                root = focusNode.rightChild;
            }else if(isItALeftChild){
                parent.leftChild = focusNode.rightChild;
            }else{
                parent.rightChild = focusNode.leftChild;

            }
        }else{
            Node replace = getReplacementNode(focusNode);
            if(focusNode == root){
                root = replace;
            }else if(isItALeftChild){
                parent.leftChild = replace;
            }else{
                parent.rightChild =  replace;
            }
            replace.leftChild =  focusNode.leftChild;

        }

        return true;

    }

    private Node getReplacementNode(Node replaceNode){
        Node replaceParent = replaceNode;
        Node replacement = replaceNode;
        Node focusNode = replaceNode.rightChild;

        while (focusNode != null){
            replaceParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        if(replacement != replaceNode.rightChild){
            replaceParent.rightChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }
        return  replacement;
    }

    public void inOrderTraverseTree(Node focusNode){

        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
          //  System.out.println(focusNode);
        }
    }

    public Node findNode(int key){

        Node focusNode =  root;

        if(focusNode == null)
        {
            return null;
        }

        while (focusNode.Key != key){
            if(key < focusNode.Key){
                focusNode =  focusNode.leftChild;
            }else {
                focusNode =  focusNode.rightChild;
            }
        }
        return focusNode;
    }


    public static void main(String[] args) {

        Main  tree = new Main();
        tree.addNode(50, "A");
        tree.addNode(25, "b");
        tree.addNode(15, "c");
        tree.addNode(30, "d");
        tree.addNode(65, "s");
        tree.addNode(75, "r");
        tree.addNode(80, "s");

        System.out.println("Remove key 25");
        tree.remove(25);

        tree.inOrderTraverseTree(tree.root);
        
        System.out.println("Find 30");
        System.out.println(tree.findNode(30));



    }
}
