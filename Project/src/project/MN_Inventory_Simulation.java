
package project;

import java.util.Random;
import java.util.Scanner;

class InventorySystem{
public int InventoryBeginning;
public int InventoryEnding;
public int RandomDigit_For_Demand;
public int Demands;
public int Shortage;
public int OrderQuantity;
public int RandomDigits_For_LeadTime;
public int Days_until_order_arrive;
public int cycle;
public int days;
}
public class MN_Inventory_Simulation {
    public static int Cycle;
public static int InventoryStart;
public static int OrderQuantity;
public static int Days_work;
public static InventorySystem [] inv;
public static   int shortage = 0;

public static boolean Recieve = false;
public static int condition;
//Calculate Random digit of demands (widgets)
public static void CalcDemands(){
for(int j = 0; j < Days_work * Cycle; j++){
if(inv[j].RandomDigit_For_Demand >= 1 && inv[j].RandomDigit_For_Demand <= 33){
inv[j].Demands = 0;
}
else if(inv[j].RandomDigit_For_Demand >= 34 && inv[j].RandomDigit_For_Demand <= 58){
inv[j].Demands = 1;
}
else if(inv[j].RandomDigit_For_Demand >= 59 && inv[j].RandomDigit_For_Demand <= 78){
inv[j].Demands = 2;
}
else if(inv[j].RandomDigit_For_Demand >= 79 && inv[j].RandomDigit_For_Demand <= 90){
inv[j].Demands = 3;
}
else{
    inv[j].Demands = 4;
}
}
}


//Calculate Random Digits of lead time 
public static void Calc_leadTime(int j){
if(inv[j].RandomDigits_For_LeadTime >= 1 && inv[j].RandomDigits_For_LeadTime <= 30){
inv[j].Days_until_order_arrive = 1;
}
else if(inv[j].RandomDigits_For_LeadTime >= 31 && inv[j].RandomDigits_For_LeadTime <= 80){
inv[j].Days_until_order_arrive = 2;
}
else {
inv[j].Days_until_order_arrive = 3;
}

}
//Simulation
public static void Simulate(){
 inv = new InventorySystem[Cycle * Days_work];
        Random r = new Random();
        for (int i = 0; i < Cycle * Days_work; i++) {
            inv[i] = new InventorySystem();
            inv[i].cycle = i / Days_work + 1;
            inv[i].days = i % Days_work + 1;
            inv[i].RandomDigit_For_Demand = r.nextInt(100);
        }
        CalcDemands();
        inv[0].InventoryBeginning = InventoryStart;
        inv[0].Days_until_order_arrive = 0;
        
         for (int i = 0; i < Cycle * Days_work; i++) {
            //The inventory at begin of day
            if (i > 0) {
                if (inv[i - 1].Days_until_order_arrive > 0) {
                    inv[i].Days_until_order_arrive = inv[i - 1].Days_until_order_arrive - 1;
                    inv[i].InventoryBeginning = inv[i - 1].InventoryEnding;
                }
                //Add the quantity next day
                else if (Recieve) {
                    inv[i].InventoryBeginning = OrderQuantity + inv[i - 1].InventoryEnding;
                    inv[i].Days_until_order_arrive = 0;
                    Recieve = false;
                } else {
                    inv[i].InventoryBeginning = inv[i - 1].InventoryEnding;
                    inv[i].Days_until_order_arrive = 0;
                }
            }
            //The inventory at end of day and Shortage
            //No Shortage
            if (inv[i].InventoryBeginning >= inv[i].Demands + shortage) {
                inv[i].InventoryEnding = inv[i].InventoryBeginning - inv[i].Demands - shortage;
                inv[i].Shortage = 0;
                shortage = 0;
            }
             //Shortage 
            else {
                inv[i].Shortage = inv[i].Demands - inv[i].InventoryBeginning + shortage;
                shortage = inv[i].Shortage;
                inv[i].InventoryEnding = 0;
            }
            //The order Quantity
            //If there is an order
            if (inv[i].days == Days_work && inv[i].InventoryBeginning <= condition) {
                inv[i].OrderQuantity = OrderQuantity;
                Recieve = true;
                inv[i].RandomDigits_For_LeadTime = r.nextInt(100);
                //Calculate Lead time
                Calc_leadTime(i);
            }//There is no order
            else {
                inv[i].OrderQuantity = 0;
                inv[i].RandomDigits_For_LeadTime= 0;
            }
}
}
public static String PrintSimulation1(){
    StringBuilder tableHeader1 = new StringBuilder();
        StringBuilder tableHeader2 = new StringBuilder();
        StringBuilder MNTable = new StringBuilder();
    tableHeader1.append("                                      Inventoring             Random     "
    ).append("                                             Ending                                                                                    Random                          Daysuntil");
    tableHeader2.append("Cycle\t").append( "  " ).append("Day\t").append("      " 
    ).append("Beginning    \t").append("        " ).append("Demand    \t" ).append("       " 
    ).append("Demands     \t" ).append("     Inventoring  \t").append( "      " ).append( "Shortage     \t" 
    ).append( "       " ).append( "OrderQuantity     \t" ).append("     "
    ).append("LeadTime     \t").append( "     " ).append( "OrderArrive" );
    for(int i = 0; i < Cycle *Days_work; i++){
 
       MNTable.append(" " ).append( (inv[i].cycle) ).append( "      \t" ).append( "     "  ).append( (inv[i].days) ).append( "      \t" 
       ).append("           " ).append( inv[i].InventoryBeginning ).append( "        \t" ).append( "                 "
       ).append( inv[i].RandomDigit_For_Demand ).append( "        \t" ).append("                 " ).append(inv[i].Demands
       ).append( "        \t"  ).append( "                 " ).append( inv[i].InventoryEnding
       ).append( "        \t"  ).append( "                 " ).append( inv[i].Shortage ).append( "        \t" ).append( "                   ").append( inv[i].OrderQuantity 
       ).append( "           \t" ).append( "                   " ).append(inv[i].RandomDigits_For_LeadTime
       ).append( "           \t"  ).append( "                 " ).append( inv[i].Days_until_order_arrive+"\n");
    
    }
     return tableHeader1.toString() + "\n" + tableHeader2.toString() + "\n" + MNTable.toString();
}
public static void PrintSimulation(){
    System.out.println("                  Inventoring    Random     "
            + "                     Ending                                                   Random           Daysuntil");
    System.out.println("Cycle\t" + "  " + "Day\t"  + "  " + "Beginning  \t"+" " + "Demand  \t" + " "
    + "Demands  \t" + "Inventoring  \t"+ " " + "Shortage   \t" + "  " + "OrderQuantity \t" +" "
            + "LeadTime  \t"+ " " + "OrderArrive" );
    for(int i = 0; i < Cycle *Days_work; i++){
 
        System.out.println(" " + (inv[i].cycle) + "  \t" + "   "  + (inv[i].days) + "  \t" + "     " + inv[i].InventoryBeginning + "    \t" + "    "
        + inv[i].RandomDigit_For_Demand + "   \t" +"    " + inv[i].Demands + "   \t" + "   " + inv[i].InventoryEnding
        + "    \t" + "   " + inv[i].Shortage + "     \t" + "       " + inv[i].OrderQuantity 
                + "      \t" + "          " +inv[i].RandomDigits_For_LeadTime
        + "      \t" + "          " + inv[i].Days_until_order_arrive);
    
    }
}
public static void Calculate_Total_Ending_Inventory(){
int total = 0;
for(int e = 0; e < Cycle * Days_work; e++){
total += inv[e].InventoryEnding;
}
    System.out.println("Total of Ending Inventory : " + total);
}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Plz, Enter Inventory Start : ");
        InventoryStart = in.nextInt();
         System.out.println("Plz, Enter Cycle length : ");
        Cycle = in.nextInt();
           System.out.println("Plz, Enter weekly Order Quantity : ");
        OrderQuantity = in.nextInt();
         System.out.println("Plz, Enter the number of condition : ");
        condition = in.nextInt();
          System.out.println("Plz, Enter the number of Days work : ");
        Days_work = in.nextInt();
        Simulate();
      PrintSimulation();
        System.out.println("");
        Calculate_Total_Ending_Inventory();
    }
    
}
