/*
 * Developed by Atri Tripathi on 20/7/19 12:09 AM
 * Last modified 20/7/19 12:09 AM
 * Copyright (c) 2019. All rights reserved
 */

class Node{
    int key;
    String value;

    Node leftChild;
    Node rightChild;

    Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return value + " has a key " + key;
    }
}

public class BinaryTree {
    private Node root;

    private void addNode(int key, String value) {
        Node newNode = new Node(key,value);

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    private void inOrderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            inOrderTraverseTree(currentNode.leftChild);

            System.out.println(currentNode);

            inOrderTraverseTree(currentNode.rightChild);
        }
    }

    private void preOrderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode);

            preOrderTraverseTree(currentNode.leftChild);

            preOrderTraverseTree(currentNode.rightChild);
        }
    }

    private void postOrderTraverseTree(Node currentNode) {
        if (currentNode != null) {
            postOrderTraverseTree(currentNode.leftChild);

            postOrderTraverseTree(currentNode.rightChild);

            System.out.println(currentNode);
        }
    }

    private Node findNode(int key) {
        Node currentNode = root;

        while (currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addNode(50,"Boss");
        binaryTree.addNode(25,"Vice President");
        binaryTree.addNode(15,"Office Manager");
        binaryTree.addNode(30,"Secretary");
        binaryTree.addNode(75,"Sales Manager");
        binaryTree.addNode(85,"Salesman");

        System.out.println("\nIn order Traversal:");
        binaryTree.inOrderTraverseTree(binaryTree.root);        // Output will be in increasing order, because in-order

        System.out.println("\nPre Order Traversal:");
        binaryTree.preOrderTraverseTree(binaryTree.root);

        System.out.println("\nPost Order Traversal:");
        binaryTree.postOrderTraverseTree(binaryTree.root);

        System.out.println("\nSearch for 30");
        System.out.println(binaryTree.findNode(30));
    }
}