import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiskScheduling {
    final int start=0;
    final  int end=199;


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

        for (int i=0;i<Requests.size();i++)
        {
            if(Requests.get(i)<HeadPos)
                left.add(Requests.get(i));
            if(Requests.get(i)>=HeadPos)
                right.add(Requests.get(i));
        }
        //to sort arr left and right
        Collections.sort(left);
        Collections.sort(right);
        int x=1,diraction_right=1;
        while (x!=5) {

            if(diraction_right==1) {
                for (int i = 0; i < right.size(); i++) {
                    current_loc = right.get(i);
                    sequence.add(current_loc);

                    // to absolute value
                    distance = Math.abs(current_loc - HeadPos);

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
                for(int i = 0; i < sequence.size(); i++)
                {
                    System.out.println(sequence.get(i)+" ");
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
                for(int i = 0; i < sequence.size(); i++)
                {
                    System.out.println(sequence.get(i)+" ");
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

        for (int i=0;i<Requests.size();i++)
        {
            if(Requests.get(i)<HeadPos)
                left.add(Requests.get(i));
            if(Requests.get(i)>HeadPos)
                right.add(Requests.get(i));
        }
        //to sort arr left and right
        Collections.sort(left);
        Collections.sort(right);

                for (int i = 0; i < right.size(); i++) {
                    current_loc = right.get(i);
                    sequence.add(current_loc);

                    // to absolute value
                    distance = Math.abs(current_loc - HeadPos);

                    total_head_movement = total_head_movement + distance;
                    HeadPos = current_loc;
                }

                for (int i = 0; i < left.size(); i++) {
                    current_loc = left.get(i);
                    sequence.add(current_loc);

                    // to absolute value
                    distance = Math.abs(current_loc - HeadPos);

                    total_head_movement = total_head_movement + distance;
                    HeadPos = current_loc;
                }
        System.out.println("\n ---------  right direction ---------");
        System.out.println ("Sequence of head movement:- ");
        for(int i = 0; i < sequence.size(); i++)
        {
            System.out.println(sequence.get(i)+" ");
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
        for(int i = 0; i < sequence.size(); i++)
        {
            System.out.println(sequence.get(i)+" ");
        }
        System.out.println ("\nThe Total Head Movement To C_Look Algorithm  " + total_head_movement + " Cylinder");

    }
    public  void Optimized(ArrayList<Integer> Requests)
    {
        System.out.println ("\n----------------Optimized Algorithm --------------------");
        Collections.sort(Requests);
        int start=0,current_loc,total_head_movement = 0,distance;
        for(int i = 0; i < Requests.size(); i++)
        {
            current_loc = Requests.get(i);

            // to absolute value
            distance = Math.abs(current_loc -start);

            total_head_movement=total_head_movement+ distance;
            start = current_loc;
        }

        System.out.println ("Sequence of head movement:- ");
        for (int i = 0 ; i < Requests.size () ; i++) {
            System.out.println (Requests.get (i) + " ");
        }
        System.out.println ("\nThe Total Head Movement To Optimized Algorithm  " + total_head_movement + " Cylinder");


    }
}