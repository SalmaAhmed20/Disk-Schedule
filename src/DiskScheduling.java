import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiskScheduling {
    final int start=0;
    final  int end=199;
    //this algorithm default as left direction
    void Scan ( ArrayList <Integer> Req, int pos)
    {
        System.out.println ("----------------Scan ( Elevator ) Algorithm --------------------" );
        ArrayList <Integer> Requests = new ArrayList <> ( Req );
        Requests.add ( pos );
        Requests.add ( start );
        Collections.sort ( Requests );
        System.out.println ("Sequence of head movement :- ");
        ArrayList<Integer> difference = new ArrayList <> ();
        int idx = Requests.indexOf ( pos );
        int count =idx;
        while (  count !=0)
        {
            if (count == idx)
            {
                difference.add ( Math.abs(Requests.get ( count )-Requests.get ( count-1 )) );
            }
            else {
                difference.add ( Math.abs ( Requests.get ( count ) - Requests.get ( count - 1 ) ) );
                System.out.print ( Requests.get ( count ) + " " );
            }
            count--;

        }
        count=0;
        int i =1;
        while ( count !=Requests.size ()-1 )
        {
            difference.add ( Math.abs ( Requests.get ( count )-Requests.get ( idx+i ) ) );
            System.out.print (Requests.get ( count ) +" " );
            count=idx+i;
            i++;
        }
        System.out.print (Requests.get ( Requests.size ()-1 ) +" " );
        System.out.println ("\n"+difference );
        int total=0;
        for ( int j = 0 ; j < difference.size () ; j++ ) {
            total= total+difference.get ( j );
        }
        System.out.println ("Total movement = " + total +" Cylinder");
    }
    //this algorithm default as right direction
    void C_Scan ( ArrayList <Integer> Req, int pos)
    {
        System.out.println ("---------------- C Scan ( Elevator ) Algorithm --------------------" );
        ArrayList <Integer> Requests = new ArrayList <> ( Req );
        Requests.add ( pos );
        Requests.add ( start );
        Requests.add ( end );
        Collections.sort ( Requests );
        ArrayList<Integer>greater =new ArrayList <> (  );
        int idx=Requests.indexOf ( pos );
        greater .addAll ( Requests.subList ( idx ,Requests.size ()) );
        ArrayList<Integer>lessthan =new ArrayList <> (  );
        lessthan .addAll ( Requests.subList ( 0 ,idx) );
        ArrayList<Integer> difference = new ArrayList <> ();
        Requests.clear ();
        Requests.addAll ( greater );
        Requests.addAll ( lessthan );
        //System.out.println (Requests );
        System.out.println ("Sequence of head movement :- ");
        for ( int i = 0 ; i < Requests.size ()-1 ; i++ ) {
            if (i==0)
            {
                difference.add ( Math.abs ( Requests.get ( i ) -Requests.get ( i+1 ) ) );
            }
            else
            {
                difference.add ( Math.abs ( Requests.get ( i ) -Requests.get ( i+1 ) ) );
                System.out.print(Requests.get ( i ) +" ");
            }
        }
        System.out.print (Requests.get ( Requests.size ()-1 ) );
        int total=0;
        for ( int i = 0 ; i < difference.size () ; i++ ) {
            total+=difference.get ( i );

        }
        System.out.println ("\nTotal movement = " + total +" Cylinder");



    }
}
