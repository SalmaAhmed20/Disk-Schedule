
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Driver {
    public static void main ( String[] args ) {
        /*test program*/
        ArrayList <Integer> Requests = new ArrayList<> ();
        Requests.add ( 98 );
        Requests.add ( 183 );
        Requests.add ( 37 );
        Requests.add ( 122 );
        Requests.add ( 14 );
        Requests.add ( 124 );
        Requests.add ( 65 );
        Requests.add ( 67 );

        int HeadPos = 53;
        DiskScheduling test1;
        //test1.FCFS(Requests,HeadPos);
        //test1.SSTF(Requests,HeadPos);
        //test1.Scan(Requests,HeadPos);
        //test1.C_Scan(Requests,HeadPos);
        //test1.Look(Requests,HeadPos);
        //test1.C_Look(Requests,HeadPos);
        //test1.Optimized(Requests);
        while (true)
        {

            Requests.clear ();
            Scanner sc = new Scanner ( System.in );
            System.out.println ( "1- to Make Requests" );
            System.out.println ( "2-Quit" );
            int option = sc.nextInt ();
            int numR;
            int Req;
            if (option==1){
                System.out.print ("Enter Number of requests: ");
                numR = sc.nextInt ();
                System.out.print ("\nEnter "+numR+ " requests between 0 to 199 : ");
                for ( int i = 0 ; i < numR ; i++ ) {
                    Req=sc.nextInt ();
                    if (Req <0 ||Req >199)
                    {
                        System.out.println ("Exceed disk width");
                        exit ( 0 );
                    }
                    Requests.add ( Req );
                }
                System.out.print ("\nEnter Head position  ");
                HeadPos= sc.nextInt ();
                //test1.FCFS(Requests,HeadPos);
                //test1.SSTF(Requests,HeadPos);
                //test1.Scan(Requests,HeadPos);
                //test1.C_Scan(Requests,HeadPos);
                //test1.Look(Requests,HeadPos);
                //test1.C_Look(Requests,HeadPos);
                //test1.Optimized(Requests);
            }else
                exit(0);

        }




    }
}
