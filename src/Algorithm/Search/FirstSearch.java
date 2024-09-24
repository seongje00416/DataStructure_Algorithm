package Algorithm.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class FirstSearch {

    public static void main( String[] args ) throws IOException {
        MyBST mbst = new MyBST();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        boolean flag = true;

        while( flag ){
            System.out.println( "1. Add Data / 2. Show Tree / 3. Depth First Search / 4. Breadth First Search / 0. Close " );
            switch( Integer.parseInt( br.readLine() ) ){
                case 1:
                    System.out.print( "Input Data: " );
                    mbst.add( Integer.parseInt( br.readLine() ) );
                    break;
                case 2:
                    mbst.show();
                    break;
                case 3:
                    mbst.dfs();
                    break;
                case 4:
                    mbst.bfs();
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
        br.close();
    }
    static class Node {
        private int data, depth;
        private Node left, right;

        public Node(int data) {
            setData(data);
            this.depth = 0;
        }

        public void setData(int data) {
            this.data = data;
        }
        public int getData() {
            return this.data;
        }
        public void setDepth(int depth) {
            this.depth = depth;
        }
        public int getDepth() {
            return this.depth;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public Node getLeft() {
            return this.left;
        }
        public Node getRight() {
            return this.right;
        }
    }

    static class MyBST{
        private Node root;

        public MyBST(){
            this.root = null;
        }

        // Add
        public void add( int data ){
            if( this.root == null ){
                this.root = new Node(data);
                this.root.setDepth(1);
            }
            else {
                add( this.root, data );
            }
        }
        public void add( Node target, int data ){
            if( target.getData() == data ){
                System.out.println( "This data is Already In" );
            }
            else if ( target.getData() > data ){
                if( target.getLeft() == null ){
                    Node newNode = new Node( data );
                    newNode.setDepth( target.getDepth() + 1 );
                    target.setLeft( newNode );
                }
                else {
                    add( target.getLeft(), data );
                }
            }
            else {
                if( target.getRight() == null ){
                    Node newNode = new Node( data );
                    newNode.setDepth( target.getDepth() + 1 );
                    target.setRight( newNode );
                }
                else {
                    add( target.getRight(), data );
                }
            }
        }

        // Search -> Depth First Search
        public void dfs(){
            dfs( this.root );
        }
        public void dfs( Node node ){
            System.out.println( "Depth: " + node.getDepth() + " | Data: " + node.getData() );
            if( node.getLeft() != null ){
                dfs( node.getLeft() );
            }
            if( node.getRight() != null ){
                dfs( node.getRight() );
            }
        }

        // Search -> Breadth First Search
        public void bfs(){
            MyQueue queue = new MyQueue();
            boolean flag = true;

            queue.enqueue( this.root );
            while( flag ){
                Node out = queue.dequeue();
                System.out.println( "Depth: " + out.getDepth() + " | Data: " + out.getData() );
                if( out.getLeft() != null ){
                    queue.enqueue( out.getLeft() );
                }
                if( out.getRight() != null ){
                    queue.enqueue( out.getRight() );
                }
                if( queue.isEmpty() ){ flag = false; }
            }
        }

        // Delete

        // Show
        public void show(){
            show( this.root );
        }
        public void show( Node node ){
            System.out.println( "Depth: " + node.getDepth() + " | Data: " + node.getData() );
            if( node.getLeft() != null ){
                show( node.getLeft() );
            }
            if( node.getRight() != null ){
                show( node.getRight() );
            }
        }
    }

    static class MyQueue {
        private Vector<Node> queue;
        private int pos;

        public MyQueue(){
            this.queue = new Vector<Node>();
            this.pos = 0;
        }

        public void enqueue( Node node ){
            this.queue.add( node );
        }
        public Node dequeue(){
            if( this.pos == this.queue.size() ){
                return null;
            }
            Node data = queue.get( this.pos );
            this.queue.set( this.pos, null );
            this.pos++;
            return data;
        }
        public boolean isEmpty(){
            return this.pos == this.queue.size();
        }
    }

}
