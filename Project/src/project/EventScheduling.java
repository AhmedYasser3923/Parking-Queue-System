
package project;
import java.util.Random;
import java.util.Scanner;

class FE {

    public int clock;
    public int s;
    public int n;
    public int f;
    public int LQ;
    public int LS;
    public String fel;
    public String eevent;
    public int b;
    public int Mq;
    
}

class Event {

    public int iat;
    public int R_iat;
    public int random_st;
    public int st;
    public int R_st;
    public int sst;
    public int at;
    public int custN;
    public int dt;
    public int clk;
    public int wt;
    public String ffel;
    public String event;

}


public class EventScheduling {
 public static Event[] e;
    public static int custn;
    public static int F;
    public static FE[] fe;

    public static void Simulate() {
        int MQ = 0;
        e = new Event[custn];
        fe = new FE[custn * 2];
       
       

        Random random = new Random();
        
        //random nums of service time
        for (int i = 0; i < custn; i++) {
            e[i] = new Event();
            e[i].R_st = random.nextInt((100));
            if (e[i].R_st >= 0 && e[i].R_st <= 10) {
                e[i].st = 1;
            } else if (e[i].R_st > 10 && e[i].R_st <= 30) {
                e[i].st = 2;
            } else if (e[i].R_st > 30 && e[i].R_st <= 60) {
                e[i].st = 3;
            } else if (e[i].R_st > 60 && e[i].R_st <= 85) {
                e[i].st = 4;
            } else if (e[i].R_st > 85 && e[i].R_st <= 95) {
                e[i].st = 5;
            } else if (e[i].R_st > 95 && e[i].R_st <= 101) {
                e[i].st = 6;
            }

        }
        //random nums of iat
        for (int i = 0; i < custn; i++) {
            e[i].R_iat = random.nextInt((1000));
            if (e[i].R_iat >= 0 && e[i].R_iat <= 125) {
                e[i].iat = 1;
            } else if (e[i].R_iat > 125 && e[i].R_iat <= 250) {
                e[i].iat = 2;
            } else if (e[i].R_iat > 250 && e[i].R_iat <= 375) {
                e[i].iat = 3;
            } else if (e[i].R_iat > 375 && e[i].R_iat <= 500) {
                e[i].iat = 4;
            } else if (e[i].R_iat > 500 && e[i].R_iat <= 625) {
                e[i].iat = 5;
            } else if (e[i].R_iat > 625 && e[i].R_iat <= 750) {
                e[i].iat = 6;
            } else if (e[i].R_iat > 750 && e[i].R_iat <= 875) {
                e[i].iat = 7;
            } else if (e[i].R_iat > 875 && e[i].R_iat <= 1001) {
                e[i].iat = 8;
            }

        }
        
        //declaration of first customers
        e[0].at = e[0].iat;
        e[0].dt = e[0].at + e[0].st;
        e[0].sst = e[0].at;
        
        //calc the begining of the rest of the customers
        for (int i = 1; i < custn; i++) {

            e[i].at = e[i - 1].at + e[i].iat;
            
            if (e[i].at == e[i - 1].dt) {
                e[i].sst = e[i - 1].dt;
            } else if (e[i].at > e[i - 1].dt) {
                e[i].sst = e[i].at;
            } else if (e[i].at < e[i - 1].dt) {
                e[i].sst = e[i - 1].dt;
            }

            e[i].dt = e[i].sst + e[i].st;
            e[i].wt = e[i].sst - e[i].at;
        }

//        dis();
        
        //declaration of the big table array of objects
        for (int i = 0; i < custn * 2; i++) {
            fe[i] = new FE();

        }
        
        
        
        //the main for loop of the big table and the simulation
        for (int i = 1; i < custn * 2; i++) {
            int minIndex = 0;
            int minValue = 199999;

            // Search for the event with the smallest unused at or dt value
            for (int j = 1; j < custn; j++) {
                if (e[j].at < minValue && e[j].at != -1) {
                    minValue = e[j].at;
                    minIndex = j;

                }
                if (e[j - 1].dt < minValue && e[j - 1].dt != -1) {
                    minValue = e[j - 1].dt;
                    minIndex = j - 1;
                }
            }

            fe[0].LQ = 0;
            fe[0].LS = 1;
            fe[0].s = 0;
            fe[0].n = 0;
            fe[0].f = 0;
            fe[0].eevent = "A";
            fe[0].b = 0;
            fe[0].Mq = 0;
            fe[0].clock = e[0].at;
            
            //calc all stats when the event is arrival
            if (minValue == e[minIndex].at) {
                //calc LQ and LS when the event is arrival
                if (fe[i - 1].LS == 1) {

                    fe[i].LQ = fe[i - 1].LQ + 1;
                    fe[i].LS = 1;
                } else {

                    fe[i].LS = 1;

                }
                fe[i].clock = e[minIndex].clk = e[minIndex].at;
                fe[i].eevent = e[minIndex].event = "A";
                fe[i].s = fe[i - 1].s;
                fe[i].n = fe[i - 1].n;
                
                fe[i].f=fe[i-1].f;
                
                
                

                if (fe[i - 1].LS == 0) {

                    fe[i].b = fe[i - 1].b;

                } else {
                    fe[i].b = fe[i - 1].b + (fe[i].clock - fe[i - 1].clock);
                }

            }
            //calc all stats when the event is departure
             if (minValue == e[minIndex].dt) {
                //calc LQ and LS when the event is departure
                if (fe[i - 1].LQ > 0) {

                    fe[i].LQ = fe[i - 1].LQ - 1;
                    fe[i].LS = 1;
                } else {
                    fe[i].LQ = 0;
                    fe[i].LS = 0;

                }

                fe[i].clock = e[minIndex].clk = e[minIndex].dt;
                fe[i].eevent = e[minIndex].event = "D";
                fe[i].s = fe[i - 1].s + e[minIndex].st + e[minIndex].wt;
                fe[i].n = fe[i - 1].n + 1;
                
                if( (e[minIndex].st + e[minIndex].wt)>= F){                 
                    fe[i].f =fe[i-1].f+1;                 
                }                
                else {                 
                    fe[i].f=fe[i-1].f;                 
                }
                
               
                
                if (fe[i - 1].LS == 0) {

                    fe[i].b = fe[i - 1].b;

                } else {
                    fe[i].b = fe[i - 1].b + (fe[i].clock - fe[i - 1].clock);
                }
            }
            
            
            
            

            if (minIndex != -1) {

                if (minValue == e[minIndex].at) {
                    e[minIndex].at = -1;
                }
                if (minValue == e[minIndex].dt) {
                    e[minIndex].dt = -1;
                }
            }

            
            
            
            //print the last row
            if (i == (custn * 2) - 1) {
                minValue = e[i / 2].dt;
                minIndex = i / 2;

                if (fe[i - 1].LQ > 0) {

                    fe[i].LQ = fe[i - 1].LQ - 1;
                    fe[i].LS = 1;
                } else {
                    fe[i].LQ = 0;
                    fe[i].LS = 0;

                }

                fe[i].clock = e[minIndex].clk = e[minIndex].dt;
                fe[i].eevent = e[minIndex].event = "D";

                fe[i].s = fe[i - 1].s + e[minIndex].st + e[minIndex].wt;

                fe[i].n = fe[i - 1].n + 1;
                fe[i].b  = fe[i - 1].b + (fe[i].clock - fe[i - 1].clock);
                fe[i].Mq = fe[i - 1].Mq;
                   
                if( (e[minIndex].st + e[minIndex].wt)>= F){                 
                    fe[i].f =fe[i-1].f+1;                 
                }                
                else {                 
                    fe[i].f=fe[i-1].f;                 
                }
            }

            
        }
        

        for (int z = 1; z < custn * 2; z++) {

            if (fe[z].LQ > MQ) {
                MQ = fe[z].LQ;
            }
            fe[z].Mq = MQ;
        }
        

        
       

    }
     static void calc_fel(){
    for(int i=0 ;i<custn*2-2 ;i++ ){

    fe[i].fel=fe[i+1].eevent+fe[i+1].clock+" , "+fe[i+2].eevent+fe[i+2].clock;
    

      }
     }
     
     
      static void calc_fel_last(){
    
    fe[custn*2-2].fel=fe[custn*2-1].eevent+fe[custn*2-1].clock+"     ";
     }

    static void display() {
        // Table headers
        System.out.println("Type   " + " |   " + "Clock   " + " |   " + "LQ_t   " + " |   " + "LS_t "
                + " " + " |   " + "Future Event list   " + " |       " + "S   " + " |   " + "N   "
                + "  | " + "B   " + " |   " + "MQ   "+" |   " + "F   ");

        System.out.println("----------------------------------------------------------------------------"
                + "-------------------------------------------------------------------");

        for (int i = 0; i < custn * 2; i++) {
            System.out.println("   " + fe[i].eevent + "  \t" + "      " + fe[i].clock + "  \t" + "  "
                    + "   " + fe[i].LQ + "  \t" + " " + fe[i].LS + "  \t" + "        " + fe[i].fel + "           " + " \t" + fe[i].s + " \t" + ""
                    + " " + fe[i].n + " \t" + "  " + fe[i].b + "  \t" + "  " + fe[i].Mq + "  \t" + "  "+ 
                    fe[i].f + "  \t" + "  ");

        }
    }

    static void dis() {

        for (int i = 0; i < custn; i++) {
            System.out.println("   " + e[i].at + "  \t" + "   " + e[i].sst + "  \t" + "   " + e[i].st +
                    "  \t" + " "
                    + "  " + e[i].dt + "  \t" + "   " + e[i].wt + "  \t" + "   ");

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter num of cust");
        custn = sc.nextInt();
        System.out.println("enter f");
        F=sc.nextInt();

        Simulate();
        calc_fel();
        calc_fel_last();
//      dis();
        display();
    }

    public static String Print_Event_Scheduling_Table(){
       StringBuilder tableHeader1 = new StringBuilder();
        StringBuilder EventTable = new StringBuilder();
        tableHeader1.append("Clock   \t").append("    ").append("Event   \t").append("    "
        ).append("LS   \t").append("    ").append("LQ           \t").append("          ").append("Future Event List          \t"
        ).append("            ").append("S          \t").append("            ").append("N           \t").append("             "
        ).append("F             \t").append("              ").append("B             \t").append("              ").append("MQ");
        for(int i = 0; i < custn *2; i++){
        EventTable.append(fe[i].clock).append("      \t").append("     ").append(fe[i].eevent).append("      \t").append("       "
        ).append(fe[i].LS).append("        \t").append("      ").append(fe[i].LQ).append("            \t").append("             "
        ).append(fe[i].fel).append("              \t").append("                   ").append(fe[i].s).append("              \t").append("               "
        ).append(fe[i].n).append("             \t").append("             ").append(fe[i].f).append("             \t").append("               ").append(fe[i].b
        ).append("            \t").append("               ").append(fe[i].Mq).append("\n");  
        } 
        return tableHeader1.toString() + "\n"+ EventTable.toString();
    }
}