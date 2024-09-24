package DataStructure.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {

    public static void main( String[] args ) throws IOException {
        MyBinarySearchTree mbst = new MyBinarySearchTree();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        boolean flag = true;

        while( flag ) {
            System.out.println( "1. Add Data / 2. Show Data / 3. Close" );
            switch ( Integer.parseInt( br.readLine() ) ){
                case 1:
                    System.out.print( "Input Number: " );
                    mbst.addData( Integer.parseInt( br.readLine() ) );
                    break;
                case 2:
                    mbst.show();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
        br.close();
    }

    static class Node {
        private Node left, right;
        private int data, depth;

        public Node(){
            this.left = null;
            this.right = null;
            this.data = 0;
            this.depth = 0;
        }
        // About Data
        public void setData( int data ) {
            this.data = data;
        }
        public int getData(){
            return this.data;
        }
        // About Depth
        public void setDepth() {
            this.depth++;
        }
        public int getDepth(){
            return this.depth;
        }

        // About Child Node
        public void setLeft( Node node ){
            this.left = node;
        }
        public void setRight( Node node ){
            this.right = node;
        }
        public Node getLeft(){
            return this.left;
        }
        public Node getRight(){
            return this.right;
        }

        // Show Data
        public void show(){
            System.out.println( "Depth: " + this.depth + " | Data: " + this.data );
            if( this.left != null ){
                this.left.show();
            }
            if( this.right != null ){
                this.right.show();
            }
        }
    }

    static class MyBinarySearchTree {
        private Node root;

        public MyBinarySearchTree() {
            this.root = null;
        }

        // Add Data( Node )
        public void addData( Node target, Node node ){
            node.setDepth();
            if( target.getData() < node.getData() ){
                if( target.getRight() == null ){
                    target.setRight( node );
                }
                else {
                    addData( target.getRight(), node );
                }
            }
            else if( target.getData() > node.getData() ){
                if( target.getLeft() == null ){
                    target.setLeft( node );
                }
                else {
                    addData( target.getLeft(), node );
                }
            }
            else {
                System.out.println( "The data is Already Existed" );
            }
        }
        public void addData( int data ){
            if( this.root == null ){
                this.root = new Node();
                this.root.setData( data );
            }
            else {
                Node node = new Node();
                node.setData( data );
                addData( this.root, node );
            }
        }

        // Show Data
        public void show(){
            this.root.show();
        }

    }

}
