public class BinarySearchTree {

    Node root;

    public void addNode(Pet key) {

        // Create a new Node and initialize it

        Node newNode = new Node(key);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            Node focusNode = root;

            // Future parent for our new Node

            Node parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (key.compareTo(focusNode.key) < 0) { //TODO figure out value

                    // Switch focus to the left child

                    focusNode = focusNode.leftChild;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.leftChild = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.rightChild;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.rightChild = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node

            System.out.println(focusNode);

            // Traverse the right node

            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public int getHeight(Node focusNode){
        if (focusNode != null){
            int count1 = getHeight(focusNode.leftChild) + 1;
            int count2 = getHeight(focusNode.rightChild)+ 1;

            if (count1 > count2){

                return count1;
            }else{
                return count2;
            }

        }else{
            return 0;
        }

    }

    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }

    }
    
    //TODO sort

    public Node findNode(String key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key.type.compareTo(key) != 0) {

            // If we should search to the left

            if (focusNode.key.type.compareTo(key) < 0) {

                // Shift the focus Node to the left child

                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.rightChild;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }

}

class Node {

    Pet key;

    Node leftChild;
    Node rightChild;

    Node(Pet key) {

        this.key = key;

    }

    public String toString() {

        return key.toString();

    }

}
