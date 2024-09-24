package DataStructure.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularLinkedList {

    public static void main( String[] args ) throws IOException {
        MyCircularLinkedList list = new MyCircularLinkedList();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        boolean flag = true;

        while( flag ) {
            System.out.println( "1. Add Data / 2. Find Data / 3. Delete Data / 4. Show Data / 5. Close" );
            switch( Integer.parseInt( br.readLine() ) ){
                case 1:
                    System.out.print( "Input Number: " );
                    list.add( Integer.parseInt( br.readLine() ) );
                    break;
                case 2:
                    System.out.print( "Input Number: " );
                    list.find( Integer.parseInt( br.readLine() ) );
                    break;
                case 3:
                    System.out.print( "Input Number: " );
                    list.delete( Integer.parseInt( br.readLine() ) );
                    break;
                case 4:
                    list.show();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
        br.close();
    }

    static class Node {
        private int data;
        private Node next;

        public Node( int data ){
            setData( data );
        }

        public void setData( int data ){
            this.data = data;
        }
        public int getData(){
            return this.data;
        }
        public void setNext( Node next ){
            this.next = next;
        }
        public Node getNext(){
            return this.next;
        }
    }

    static class MyCircularLinkedList {
        private Node head;

        public MyCircularLinkedList(){
            this.head = null;
        }

        // Add
        public void add( int data ){
            if( this.head == null ){
                this.head = new Node( data );
            }
            else {
                add( this.head, data );
            }
        }
        public void add( Node node, int data ){
            if( node.getNext() == null || node.getNext() == this.head ){
                Node newNode = new Node( data );
                newNode.setNext( this.head );
                node.setNext( newNode );
            }
            else {
                add( node.getNext(), data );
            }
        }

        // Find
        public void find( int data ){
            find( this.head, data );
        }
        public void find( Node node, int data ){
            if( node.getData() == data ){
                System.out.println( node.getData() + "is Existed!" );
            }
            else if( node.getNext() == this.head ){
                System.out.println( node.getData() + "is Not Existed!" );
            }
            else {
                find( node.getNext(), data );
            }
        }

        // Show
        public void show(){
            show( this.head );
        }
        public void show( Node node ){
            System.out.println( node.getData() );
            if( node.getNext() != this.head ){
                show( node.getNext() );
            }
        }

        // Delete
        public void delete( int data ){
            delete( this.head, data );
        }
        public void delete( Node node, int data ){
            if( node == this.head && node.getData() == data ){
                this.head = this.head.getNext();
            }
            else {
                if( node.getNext() == this.head ){
                    System.out.println( node.getData() + "is Not Existed!" );
                }
                else if( node.getNext().getData() == data ){
                    node.setNext( node.getNext().getNext() );
                }
                else {
                    delete( node.getNext(), data );
                }
            }
        }

    }
}
