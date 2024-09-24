package DataStructure.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {

    public static void main(String[] args) throws IOException {
        MySinglyLinkedList list = new MySinglyLinkedList();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        boolean flag = true;

        while( flag ){
            System.out.println( "1. Add Data / 2. Show Data / 3. Delete Data / 4. Close" );
            switch( Integer.parseInt( br.readLine() ) ){
                case 1:
                    System.out.print( "Input Number: " );
                    list.add( Integer.parseInt( br.readLine() ) );
                    break;
                case 2:
                    list.show();
                    break;
                case 3:
                    System.out.print( "Input Number: " );
                    list.delete( Integer.parseInt( br.readLine() ) );
                    break;
                case 4:
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

    static class MySinglyLinkedList {
        private Node head;

        public MySinglyLinkedList() {
            head = null;
        }

        // Add
        public void add( int data ){
            if( head == null ){
                head = new Node( data );
            }
            else {
                Node newNode = new Node( data );
                add( this.head, newNode );
            }
        }
        public void add( Node target, Node node ){
            if( target.getNext() == null ){
                target.setNext( node );
            }
            else {
                add( target.getNext(), node );
            }
        }

        // Find
        public void find( int data ){
            find( this.head, data );
        }
        public void find( Node target, int data ){
            if( target.getData() == data ){
                System.out.println( target.getData() + "is Existed." );
            }
            else if( target.getNext() == null ){
                System.out.println( target.getData() + "is Not Existed." );
            }
            else {
                find( target.getNext(), data );
            }
        }

        // Delete
        public void delete( int data ){
            delete( this.head, data );
        }
        public void delete( Node node, int data ){
            if( node == this.head ){
                if( node.getData() == data ){
                    this.head = this.head.getNext();
                }
                else {
                    if( node.getNext() == null ){
                        System.out.println( "This Data is not Existed." );
                    }
                    else if( node.getNext().getData() == data ){
                        node.setNext( node.getNext().getNext() );
                    }
                    else {
                        delete( node.getNext(), data );
                    }
                }
            }
            else {
                if ( node.getNext() == null ) {
                    System.out.println( "This Data is not Existed." );
                }
                else if( node.getNext().getData() == data ){
                    node.setNext( node.getNext().getNext() );
                }
                else {
                    delete( node.getNext(), data );
                }
            }
        }

        // Show
        public void show(){
            show( this.head );
        }
        public void show( Node node ){
            System.out.println( node.getData() );
            if( node.getNext() != null ){
                show( node.getNext() );
            }
        }
    }
}

