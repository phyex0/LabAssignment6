//Halit Burak Yeşildal 18050111043
package com.company;

public class BinarySearchTree {
    public static class Node{
        Patient data;
        Node left;
        Node right;

        public Node(Patient data){
            //Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Represent the root of binary tree
    public Node root;

    public BinarySearchTree(){
        root = null;
    }

    //insert() will add new node to the binary search tree
    public void insert(Patient data) {
        //Create a new node
        Node newNode = new Node(data);

        //Check whether tree is empty
        if(root == null){
            root = newNode;
            return;
        }
        else {
            //current node point to root of the tree
            Node current = root, parent = null;

            while(true) {
                //parent keep track of the parent node of current node.
                parent = current;

                //If data is less than current's data, node will be inserted to the left of tree
                if(data.getName().compareTo(current.data.getName())<0) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                //If data is greater than current's data, node will be inserted to the right of tree
                else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //Search for given name. If it's existing in the tree returns as node.
    public Node search(Node node,String name) {
        Node iter = node;
        //Check whether tree is empty
        if (root == null)
            return null;

        else {
            while(iter!=null){
                if(iter.data.getName().equalsIgnoreCase(name))
                    return iter;
                if(iter!=null && iter.data.getName().compareTo(name)<0 )
                    iter=iter.right;
                if(iter!=null && iter.data.getName().compareTo(name)>0 )
                    iter=iter.left;
            }
        }

        return null;
    }

    //Displays all records of given user if exists
    public void list(Node node, String name){
        Node temp = search(node,name);
        if(temp!=null)
            System.out.println("List of records :\n"+temp.data.toString());
        else
            System.out.println("Given patient not found...");
    }

    //check nodes if this user already exists add into it's record. Otherwise create new node.
    public void add(Node root,Patient p){
        if(search(root,p.getName())==null)
            insert(p);
        else {
            Node temp = search(root, p.getName());
            Hospital hTemp;
            while((hTemp=p.getData())!=null)
                temp.data.addData(hTemp);
        }
    }

    //minNode() will find out the minimum node
    public Node minNode(Node root) {
        if (root.left != null)
            return minNode(root.left);
        else
            return root;
    }

    //finds max node.
    public Node maxNode(Node root) {
        if (root.right != null)
            return maxNode(root.right);
        else
            return root;
    }

    //deleteNode() will delete the given node from the binary search tree
    public Node deleteNode(Node node, String value) {
        if(node == null){
            return null;
        }
        else {
            //value is less than node's data then, search the value in left subtree
            if(value.compareTo(node.data.getName()) < 0)
                node.left = deleteNode(node.left, value);

                //value is greater than node's data then, search the value in right subtree
            else if(value.compareTo(node.data.getName()) >0)
                node.right = deleteNode(node.right, value);

                //If value is equal to node's data that is, we have found the node to be deleted
            else {
                //If node to be deleted has no child then, set the node to null
                if(node.left == null && node.right == null)
                    node = null;

                    //If node to be deleted has only one right child
                else if(node.left == null) {
                    node = node.right;
                }

                //If node to be deleted has only one left child
                else if(node.right == null) {
                    node = node.left;
                }

                //If node to be deleted has two children node
                else {
                    //then find the minimum node from right subtree
                    Node temp = minNode(node.right);
                    //Exchange the data between node and temp
                    node.data = temp.data;
                    //Delete the node duplicate node from right subtree
                    node.right = deleteNode(node.right, temp.data.getName());
                }
            }
            return node;
        }
    }


    //Search record and delete given record if it's exists.
    public void removeGiven(String[] input){
        Node temp = search(root,input[0]);
        if(temp!=null)
            temp.data.deleteGivenNode(new Hospital(input[1],input[2],input[3],input[4]));
        else
            System.out.println("Given record doesn't exist");

    }


    //inorder() will perform inorder traversal on binary search tree
    public void inorderTraversal(Node node) {

        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        else {

            if(node.left!= null)
                inorderTraversal(node.left);
            System.out.println(node.data.toString());
            if(node.right!= null)
                inorderTraversal(node.right);

        }
    }


    //Go every single node and get data as string
    public String toString(Node root) {
        String result = "";
        if (root == null)
            return "";
        result += toString(root.left);
        result += toString(root.right);
        result += root.data.toString();
        return result;
    }
}
