import java.util.ArrayList;
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
        for (Integer request : Requests) {
            System.out.print (request + "  ");
        }
        System.out.println ("\nTotal Head Movement = " + (Total + sub1)+ " Cylinder");
    }

    public void SSTF (ArrayList <Integer> Req,int HeadPos) {
        System.out.println ("----------------SSTF Algorithm --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        ArrayList <Integer> Movement = new ArrayList <> ();
        int temp, min, result, Total_Movement = 0;
        System.out.println ("Sequence of head movement :- ");
        while (Requests.size () != 0) {
            for (Integer request : Requests) {
                temp = HeadPos - request;
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
        System.out.println ("\nTotal Head Movement = " + Total_Movement+ " Cylinder");
    }

    void Scan (ArrayList <Integer> Req,int pos) {
        System.out.println ("----------------Scan ( Elevator ) Algorithm direction (left)--------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        Requests.add (pos);
        Requests.add (start);
        Collections.sort (Requests);
        System.out.println ("Sequence of head movement :- \n");
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
        for (Integer integer : difference) {
            total = total + integer;
        }
        System.out.print ("\nTotal Head movement = " + total + " Cylinder");
        System.out.println ("\n----------------Scan ( Elevator ) Algorithm direction (Right)--------------------");
        Requests.clear ();
        Requests.addAll (Req);
        Requests.add (pos);
        Requests.add (end);
        difference.clear ();
        Collections.sort (Requests);
        idx=Requests.indexOf (pos);
        System.out.println ("Sequence of head movement :- \n");
        for (int j = idx ; j <Requests.size ()-1  ; j++) {
            if (j == idx)
                difference.add (Math.abs (Requests.get (j) - Requests.get (j+ 1)));
            else
            {
                difference.add (Math.abs (Requests.get (j) - Requests.get (j+1)));
                System.out.print (Requests.get (j)+" ");
            }
        }
        System.out.print (Requests.get (Requests.size ()-1)+" ");
        for (int j = idx-1 ; j >=0  ; j--) {
            if ( j ==idx-1 )
            {
                difference.add (Math.abs (Requests.get (Requests.size ()-1) - Requests.get (j)));
                System.out.print (Requests.get (j)+" ");
            }
            else if ( j==0 ) {
                difference.add (Math.abs (Requests.get (j) - Requests.get (j+1)));
                System.out.print (Requests.get (j)+" ");
                break;
            }

            else
            {
                difference.add (Math.abs (Requests.get (j) - Requests.get (j-1)));
                System.out.print (Requests.get (j)+" ");
            }

        }
        total = 0;
        for (Integer integer : difference) {
            total = total + integer;
        }
        System.out.print ("\nTotal Head movement = " + total + " Cylinder");
    }

    //this algorithm default as right direction
    void C_Scan (ArrayList <Integer> Req,int pos) {
        System.out.println ("\n---------------- C Scan Algorithm direction (left) --------------------");
        ArrayList <Integer> Requests = new ArrayList <> (Req);
        Requests.add (pos);
        Requests.add (start);
        Requests.add (end);
        ArrayList <Integer> difference = new ArrayList <> ();
        Collections.sort (Requests);
        int idx = Requests.indexOf (pos);
        System.out.print ("Sequence of head movement :-\n ");
        for (int i = idx ; i >0 ; i--) {
            if ( i==idx )
                difference.add (Math.abs (Requests.get (i) - Requests.get (i - 1)));
            else {
                difference.add (Math.abs (Requests.get (i) - Requests.get (i - 1)));
                System.out.print (Requests.get (i) + " ");
            }
        }

        ArrayList <Integer> GREATER = new ArrayList <> (Requests.subList (idx+1,Requests.size ()));
        Collections.reverse (GREATER);
        GREATER.add (0,start);
        for (int i = 0 ; i < GREATER.size ()-1 ; i++) {
            difference.add (Math.abs (GREATER.get (i) - GREATER.get (i + 1)));
            System.out.print (GREATER.get (i)+" ");
        }
        System.out.print (GREATER.get (GREATER.size ()-1)+" ");
        int total = 0;
        for (Integer integer : difference) {
            total += integer;

        }
        System.out.println ("\nTotal Head movement = " + total + " Cylinder");

        System.out.println ("---------------- C Scan Algorithm direction (Right) --------------------");
        Requests.clear ();
        Requests.addAll (Req);
        Requests.add (pos);
        Requests.add (start);
        Requests.add (end);
        Collections.sort (Requests);
        idx = Requests.indexOf (pos);
        ArrayList <Integer> greater = new ArrayList <> (Requests.subList (idx,Requests.size ()));
        ArrayList <Integer> lessthan = new ArrayList <> (Requests.subList (0,idx));
        difference.clear ();
        Requests.clear ();
        Requests.addAll (greater);
        Requests.addAll (lessthan);
        System.out.print ("Sequence of head movement :-\n ");
        for (int i = 0 ; i < Requests.size () - 1 ; i++) {
            if ( i == 0 ) {
                difference.add (Math.abs (Requests.get (i) - Requests.get (i + 1)));
            } else {
                difference.add (Math.abs (Requests.get (i) - Requests.get (i + 1)));
                System.out.print (Requests.get (i) + " ");
            }
        }
        System.out.print (Requests.get (Requests.size () - 1));
        total = 0;
        for (Integer integer : difference) {
            total += integer;

        }
        System.out.println ("\nTotal Head movement = " + total + " Cylinder");


    }

    public void Look(ArrayList<Integer>  Requests,int HeadPos)
    {
        System.out.println ("\n----------------Look Algorithm --------------------");
        int total_head_movement=0;
        int distance,current_loc;
        int originalHeadPos=HeadPos;
        ArrayList<Integer> left,right,sequence;
        left=new ArrayList<>();
        right=new ArrayList<>();
        sequence=new ArrayList<>();

        for (Integer request : Requests) {
            if ( request < HeadPos )
                left.add (request);
            if ( request >= HeadPos )
                right.add (request);
        }
        //to sort arr left and right
        Collections.sort(left);
        Collections.sort(right);
        int x=1,diraction_right=1;
        while (x!=5) {

            if(diraction_right==1) {
                for (Integer integer : right) {
                    current_loc = integer;
                    sequence.add (current_loc);

                    // to absolute value
                    distance = Math.abs (current_loc - HeadPos);

                    total_head_movement = total_head_movement + distance;
                    HeadPos = current_loc;
                }
                if(x==1) {
                    diraction_right = 0;
                }
            }
            else if(diraction_right!=1) {
                for (int i = left.size() - 1; i >= 0; i--) {
                    current_loc = left.get(i);
                    sequence.add(current_loc);

                    // to absolute value
                    distance = Math.abs(current_loc - HeadPos);

                    total_head_movement = total_head_movement + distance;
                    HeadPos = current_loc;
                    if(x==3) {
                        diraction_right = 1;
                    }

                }

            }
            if(x==2)
            {
                System.out.println("\n ---------  right direction ---------");
                System.out.println ("Sequence of head movement:- ");
                for (Integer integer : sequence) {
                    System.out.print (integer + " ");
                }
                System.out.println ("\nThe Total Head Movement To Look Algorithm  " + total_head_movement + " Cylinder");
                sequence=new ArrayList<>();
                total_head_movement=0;
                HeadPos=originalHeadPos;
            }
            if(x==4)
            {
                System.out.println("\n --------- left direction ---------");
                System.out.println ("Sequence of head movement:- ");
                for (Integer integer : sequence) {
                    System.out.print (integer + " ");
                }
                System.out.println ("\nThe Total Head Movement To Look Algorithm  " + total_head_movement + " Cylinder");
            }
            x++;

        }



    }
    public void C_Look(ArrayList<Integer>  Requests,int HeadPos)
    {
        System.out.println ("\n----------------C Look Algorithm --------------------");
        int total_head_movement=0;
        int distance,current_loc;
        int originalHeadPos=HeadPos;
        ArrayList<Integer> left,right,sequence;
        left=new ArrayList<>();
        right=new ArrayList<>();
        sequence=new ArrayList<>();

        for (Integer request : Requests) {
            if ( request < HeadPos )
                left.add (request);
            if ( request > HeadPos )
                right.add (request);
        }
        //to sort arr left and right
        Collections.sort(left);
        Collections.sort(right);

        for (Integer integer : right) {
            current_loc = integer;
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }

        for (Integer integer : left) {
            current_loc = integer;
            sequence.add (current_loc);

            // to absolute value
            distance = Math.abs (current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }
        System.out.println("\n ---------  right direction ---------");
        System.out.println ("Sequence of head movement:- ");
        for (Integer integer : sequence) {
            System.out.print (integer + " ");
        }
        System.out.println ("\nThe Total Head Movement To C_Look Algorithm  " + total_head_movement + " Cylinder");
        sequence=new ArrayList<>();
        total_head_movement=0;
        HeadPos=originalHeadPos;

        for (int i = left.size()-1; i >=0 ; i--) {
            current_loc = left.get(i);
            sequence.add(current_loc);

            // to absolute value
            distance = Math.abs(current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }
        for (int i = right.size()-1; i >=0; i--) {
            current_loc = right.get(i);
            sequence.add(current_loc);

            // to absolute value
            distance = Math.abs(current_loc - HeadPos);

            total_head_movement = total_head_movement + distance;
            HeadPos = current_loc;
        }

        System.out.println("\n ---------  left direction ---------");
        System.out.println ("Sequence of head movement:- ");
        for (Integer integer : sequence) {
            System.out.print (integer + " ");
        }
        System.out.println ("\nThe Total Head Movement To C_Look Algorithm  " + total_head_movement + " Cylinder");

    }
    public  void Optimized(ArrayList<Integer> Requests)
    {
        System.out.println ("\n----------------Optimized Algorithm --------------------");
        Collections.sort(Requests);
        int start=0,current_loc,total_head_movement = 0,distance;
        for (Integer request : Requests) {
            current_loc = request;

            // to absolute value
            distance = Math.abs (current_loc - start);

            total_head_movement = total_head_movement + distance;
            start = current_loc;
        }

        System.out.println ("Sequence of head movement:- ");
        for (Integer request : Requests) {
            System.out.print (request + " ");
        }
        System.out.println ("\nThe Total Head Movement To Optimized Algorithm  " + total_head_movement + " Cylinder");


    }
}
