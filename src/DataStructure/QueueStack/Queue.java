package DataStructure.QueueStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Queue {

    public static void main ( String[] args ) throws IOException {
        MyQueue myQueue = new MyQueue();
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        boolean flag = true;

        while( flag ){
            System.out.println( "1. Add Number / 2. Get Number / 3. Information of Queue / 4. Close" );
            switch( Integer.parseInt( br.readLine() ) ){
                case 1:
                    myQueue.enQueue( Integer.parseInt( br.readLine() ) );
                    break;
                case 2:
                    System.out.println( myQueue.deQueue() );
                    break;
                case 3:
                    System.out.print( "Rear: ");
                    myQueue.showRear();
                    System.out.print( "Front: " );
                    myQueue.showFront();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
        br.close();
    }

    static class MyQueue {
        private Vector<Integer> queue;
        private int pos;

        public MyQueue() {
            this.queue = new Vector<Integer>();
            this.pos = 0;
        }

        public void enQueue( int n ){
            queue.add( n );
        }
        public int deQueue(){
            int target = queue.get( this.pos );
            queue.remove( this.pos );
            this.pos++;
            return target;
        }
        public void showRear(){
            System.out.println( queue.get( queue.size() - 1 ) );
        }
        public void showFront(){
            System.out.println( queue.get( this.pos ) );
        }
    }
}
