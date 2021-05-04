import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiskScheduling {
    final int start = 0;
    final int end = 199;

    public void FCFS (ArrayList <Integer> Req,int HeadPos) {
        System.out.println ("----------------FCFS Algorithm --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        int Total = 0, sub1, sub2;
        sub1 = (HeadPos - Requests.get (0));
        if ( sub1 < 0 )
            sub1 = sub1 * - 1;
        System.out.println ("Sequence of head movement :- ");
        for (int i = 0 ; i < Requests.size () - 1 ; i++) {
            if ( Requests.get (i) < start || Requests.get (i) > end )
                System.out.println ("Error: " + Requests.get (i) + " Out of bounds...");
            else {
                sub2 = Requests.get (i + 1) - Requests.get (i);
                if ( sub2 < 0 )
                    sub2 = (sub2 * - 1);
                Total = Total + sub2;
            }
        }
        for (int i = 0 ; i < Requests.size () ; i++) {
            System.out.print (Requests.get (i) + "  ");
        }
        System.out.println ("\nTotal Head Movement = " + (Total + sub1));
    }

    public void SSTF (ArrayList <Integer> Req,int HeadPos) {
        System.out.println ("----------------SSTF Algorithm --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        ArrayList <Integer> Movement = new ArrayList <> ();
        int temp, min, result, Total_Movement = 0;
        System.out.println ("Sequence of head movement :- ");
        while (Requests.size () != 0) {
            for (int i = 0 ; i < Requests.size () ; i++) {
                temp = HeadPos - Requests.get (i);
                if ( temp < 0 )
                    temp = (temp * - 1);
                Movement.add (temp);
            }
            min = Movement.get (0);
            for (int i = 1 ; i < Movement.size () ; i++) {
                if ( Movement.get (i) < min )
                    min = Movement.get (i);
            }
            System.out.print (Requests.get (Movement.indexOf (min)) + "  ");

            result = HeadPos - Requests.get (Movement.indexOf (min));
            if ( result < 0 )
                result = result * - 1;
            Total_Movement += result;
            HeadPos = Requests.get (Movement.indexOf (min));
            Requests.remove (Movement.indexOf (min));
            Movement.clear ();
        }
        System.out.println ("\nTotal Head Movement = " + Total_Movement);
    }
    //this algorithm default as left direction
    void Scan (ArrayList <Integer> Req,int pos) {
        System.out.println ("----------------Scan ( Elevator ) Algorithm --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        Requests.add (pos);
        Requests.add (start);
        Collections.sort (Requests);
        System.out.println ("Sequence of head movement :- ");
        ArrayList <Integer> difference = new ArrayList <> ();
        int idx = Requests.indexOf (pos);
        int count = idx;
        while (count != 0) {
            if ( count == idx ) {
                difference.add (Math.abs (Requests.get (count) - Requests.get (count - 1)));
            } else {
                difference.add (Math.abs (Requests.get (count) - Requests.get (count - 1)));
                System.out.print (Requests.get (count) + " ");
            }
            count--;

        }
        count = 0;
        int i = 1;
        while (count != Requests.size () - 1) {
            difference.add (Math.abs (Requests.get (count) - Requests.get (idx + i)));
            System.out.print (Requests.get (count) + " ");
            count = idx + i;
            i++;
        }
        System.out.print (Requests.get (Requests.size () - 1) + " ");
        //System.out.println ("\n"+difference );
        int total = 0;
        for (int j = 0 ; j < difference.size () ; j++) {
            total = total + difference.get (j);
        }
        System.out.print ("\nTotal Head movement = " + total + " Cylinder");
    }

    //this algorithm default as right direction
    void C_Scan (ArrayList <Integer> Req,int pos) {
        System.out.println ("\n---------------- C Scan Algorithm --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        Requests.add (pos);
        Requests.add (start);
        Requests.add (end);
        Collections.sort (Requests);
        ArrayList <Integer> greater = new ArrayList <> ();
        int idx = Requests.indexOf (pos);
        greater.addAll (Requests.subList (idx,Requests.size ()));
        ArrayList <Integer> lessthan = new ArrayList <> ();
        lessthan.addAll (Requests.subList (0,idx));
        ArrayList <Integer> difference = new ArrayList <> ();
        Requests.clear ();
        Requests.addAll (greater);
        Requests.addAll (lessthan);
        //System.out.println (Requests );
        System.out.print ("Sequence of head movement :- ");
        for (int i = 0 ; i < Requests.size () - 1 ; i++) {
            if ( i == 0 ) {
                difference.add (Math.abs (Requests.get (i) - Requests.get (i + 1)));
            } else {
                difference.add (Math.abs (Requests.get (i) - Requests.get (i + 1)));
                System.out.print (Requests.get (i) + " ");
            }
        }
        System.out.print (Requests.get (Requests.size () - 1));
        int total = 0;
        for (int i = 0 ; i < difference.size () ; i++) {
            total += difference.get (i);

        }
        System.out.println ("\nTotal Head movement = " + total + " Cylinder");


    }

    public void Look (ArrayList <Integer> Requests,int HeadPos) {
        System.out.println ("----------------Look Algorithm --------------------");
        int total_head_movement = 0;
        int distance, current_loc;
        ArrayList <Integer> left, right, sequence;
        left = new ArrayList <> ();
        right = new ArrayList <> ();
        sequence = new ArrayList <> ();

        for (int i = 0 ; i < Requests.size () ; i++) {
            if ( Requests.get (i) < HeadPos )
                left.add (Requests.get (i));
            if ( Requests.get (i) >= HeadPos )
                right.add (Requests.get (i));
        }
        //to sort arr left and right
        Collections.sort (left);
        Collections.sort (right);
        for (int i = 0 ; i < right.size () ; i++) {
            current_loc = right.get (i);
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }
        for (int i = left.size () - 1 ; i >= 0 ; i--) {
            current_loc = left.get (i);
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;

        }


        System.out.print ("Sequence of head movement:- ");
        for (int i = 0 ; i < sequence.size () ; i++) {
            System.out.print (sequence.get (i) + " ");
        }
        System.out.println ("\nThe Total Head Movement To Look Algorithm  " + total_head_movement + " Cylinder");

    }

    public void C_Look (ArrayList <Integer> Requests,int HeadPos) {
        System.out.println ("----------------C Look Algorithm --------------------");
        int total_head_movement = 0;
        int distance, current_loc;
        ArrayList <Integer> left, right, sequence;
        left = new ArrayList <> ();
        right = new ArrayList <> ();
        sequence = new ArrayList <> ();

        for (int i = 0 ; i < Requests.size () ; i++) {
            if ( Requests.get (i) < HeadPos )
                left.add (Requests.get (i));
            if ( Requests.get (i) > HeadPos )
                right.add (Requests.get (i));
        }
        //to sort arr left and right
        Collections.sort (left);
        Collections.sort (right);


        for (int i = 0 ; i < right.size () ; i++) {
            current_loc = right.get (i);
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }
        for (int i = 0 ; i < left.size () ; i++) {
            current_loc = left.get (i);
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }
        System.out.print ("Sequence of head movement:- ");
        for (int i = 0 ; i < sequence.size () ; i++) {
            System.out.print (sequence.get (i) + " ");
        }
        System.out.println ("\nThe Total Head Movement To C_Look Algorithm  " + total_head_movement + " Cylinder");

    }

    public void Optimized (ArrayList <Integer> Requests) {
        System.out.println ("----------------Optimized Algorithm --------------------");
        Collections.sort (Requests);
        int start = 0, current_loc, total_head_movement = 0, distance;
        for (int i = 0 ; i < Requests.size () ; i++) {
            current_loc = Requests.get (i);

            // to absolute value
            distance = Math.abs (current_loc - start);

            total_head_movement = total_head_movement + distance;
            start = current_loc;
        }

        System.out.print ("Sequence of head movement:- ");
        for (int i = 0 ; i < Requests.size () ; i++) {
            System.out.print (Requests.get (i) + " ");
        }
        System.out.println ("\nThe Total Head Movement To Optimized Algorithm  " + total_head_movement + " Cylinder");


    }
}
