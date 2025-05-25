package project;

import java.util.Random;
import java.util.Scanner;

class Inventory{
public int RandomDigit_DayType;
public String DayType;
public int RandomDigit_Demands;
public int Demand;
public double RevenueSale;
public double LostProfit_ForExcess_Demand;
public double Salvage_FromSale_Scrap;
public double DailyProfit;
}
public class Classical_Inventory {
public static int Days;
public static double priceBuy;
public static double priceSell;
public static double priceScrap;
public static  double priceLostProfit;
public static double number_of_purchase_tickets;
public static Inventory [] t;

public static void Calc_DayType(){
for (int i = 0; i < Days; i++){
if(t[i].RandomDigit_DayType >= 1 && t[i].RandomDigit_DayType <= 35){
t[i].DayType = "Good";
}
else if (t[i].RandomDigit_DayType >= 36 && t[i].RandomDigit_DayType <= 80){
t[i].DayType = "Fair";
}
else {
t[i].DayType = "Poor";
}
}
}

public static void Calc_Demand(){
for (int i = 0; i < Days; i++){
 if(t[i].DayType == "Good"){
 if(t[i].RandomDigit_Demands >= 1 && t[i].RandomDigit_Demands <= 3){
 t[i].Demand = 40;
 }
 else if(t[i].RandomDigit_Demands >= 4 && t[i].RandomDigit_Demands <= 8){
 t[i].Demand = 50;
 }
  else if(t[i].RandomDigit_Demands >= 9 && t[i].RandomDigit_Demands <= 23){
 t[i].Demand = 60;
 }
 else if(t[i].RandomDigit_Demands >= 24 && t[i].RandomDigit_Demands <= 43){
 t[i].Demand = 70;
 }
  else if(t[i].RandomDigit_Demands >= 44 && t[i].RandomDigit_Demands <= 78){
 t[i].Demand = 80;
 }
 else if(t[i].RandomDigit_Demands >= 79 && t[i].RandomDigit_Demands <= 93){
 t[i].Demand = 90;
 }
 else{
 t[i].Demand = 100;
 }
 }
 else if (t[i].DayType == "Fair"){
  if(t[i].RandomDigit_Demands >= 1 && t[i].RandomDigit_Demands <= 10){
 t[i].Demand = 40;
 }
 else if(t[i].RandomDigit_Demands >= 11 && t[i].RandomDigit_Demands <= 28){
 t[i].Demand = 50;
 }
  else if(t[i].RandomDigit_Demands >= 29 && t[i].RandomDigit_Demands <= 68){
 t[i].Demand = 60;
 }
 else if(t[i].RandomDigit_Demands >= 69 && t[i].RandomDigit_Demands <= 88){
 t[i].Demand = 70;
 }
  else if(t[i].RandomDigit_Demands >= 89 && t[i].RandomDigit_Demands <= 96){
 t[i].Demand = 80;
 }
 else {
 t[i].Demand = 90;
 }
 }
  else if (t[i].DayType == "Poor"){
  if(t[i].RandomDigit_Demands >= 1 && t[i].RandomDigit_Demands <= 44){
 t[i].Demand = 40;
 }
 else if(t[i].RandomDigit_Demands >= 45 && t[i].RandomDigit_Demands <= 66){
 t[i].Demand = 50;
 }
  else if(t[i].RandomDigit_Demands >= 67 && t[i].RandomDigit_Demands <= 82){
 t[i].Demand = 60;
 }
 else if(t[i].RandomDigit_Demands >= 83 && t[i].RandomDigit_Demands <= 94){
 t[i].Demand = 70;
 }
  else {
 t[i].Demand = 80;
 }
 }
}
}

public static void Simulate(){
t = new Inventory[Days];
    Random r = new Random();
    double cost_of_tickets = (number_of_purchase_tickets * priceBuy) /100.0;
for(int i = 0; i < Days; i++){
t[i] = new Inventory();
t[i].RandomDigit_DayType = r.nextInt(100);
t[i].RandomDigit_Demands = r.nextInt(100);
}
Calc_DayType();
Calc_Demand();

for(int i = 0; i < Days; i++){
if(t[i].Demand > number_of_purchase_tickets){
t[i].RevenueSale = (number_of_purchase_tickets * priceSell)/100.0;
}
else{
t[i].RevenueSale = (t[i].Demand *  priceSell) /100.0;
}
if(t[i].Demand > number_of_purchase_tickets){
t[i].LostProfit_ForExcess_Demand = ((t[i].Demand - number_of_purchase_tickets) * priceLostProfit)/100.0;
}
else {
t[i].Salvage_FromSale_Scrap = ((number_of_purchase_tickets - t[i].Demand) * priceScrap)/100.0;
  }
t[i].DailyProfit = ((t[i].RevenueSale)  - (cost_of_tickets) -(t[i].LostProfit_ForExcess_Demand) 
        + (t[i].Salvage_FromSale_Scrap));
}
}

public static void PrintSimulation(){
    System.out.println("          Random                         Random                         Revenue       LostProfit for     Salvage From");
    System.out.println("Day \t" + "  "  + "DayType \t" + "  " + "DayType \t" + "  " + "Demand \t"  +  "  " + "Demand \t"  +  "  " 
            + "forSale \t" + "  "  +  "ExcessDemand \t"  + "    " + "Sale of Scrap \t" + "  " + "Daily Profit");
    
for (int i = 0; i < Days; i++){
    System.out.println(" "+(i+1) + "   \t" + "    " + t[i].RandomDigit_DayType + "   \t" + "    "
            + t[i].DayType + "   \t" + "    " + t[i].RandomDigit_Demands + "   \t" + "    " +t[i].Demand + "   \t" + "    " 
    + t[i].RevenueSale + "$   \t" + "    "  + t[i].LostProfit_ForExcess_Demand + "$       \t" + "    " 
    + t[i].Salvage_FromSale_Scrap + "$        \t" + "       " +t[i].DailyProfit+ "$");
}
}

public static String PrintSimulation1(){
     StringBuilder tableHeader1 = new StringBuilder();
        StringBuilder tableHeader2 = new StringBuilder();
        StringBuilder ClassicTable = new StringBuilder();
   tableHeader1.append("                      Random                                                    Random                                              Revenue                    LostProfit for             Salvage From");
    tableHeader2.append("Day  \t").append("     " ).append( "DayType     \t").append(  "      " ).append( "DayType    \t" ).append( "        " ).append( "Demand     \t"  
    ).append(  "        " ).append("Demand       \t"  ).append(  "       " 
    ).append( "forSale     \t" ).append( "      "  ).append(  "ExcessDemand \t"  ).append( "    "
    ).append( "Sale of Scrap   \t" ).append( "         " ).append("Daily Profit");
    
for (int i = 0; i < Days; i++){
    ClassicTable.append(" ").append((i+1)).append(  "      \t").append(  "        "
    ).append( t[i].RandomDigit_DayType ).append( "        \t" ).append( "              "
    ).append( t[i].DayType ).append( "            \t" ).append( "              " 
    ).append( t[i].RandomDigit_Demands ).append( "        \t" ).append( "            " ).append(t[i].Demand ).append( "          \t" ).append( "         " 
    ).append( t[i].RevenueSale ).append( "$          \t").append(  "           "  ).append( t[i].LostProfit_ForExcess_Demand ).append( "$             \t" ).append( "             " 
    ).append( t[i].Salvage_FromSale_Scrap ).append( "$             \t" ).append( "                 " ).append(t[i].DailyProfit).append( "$").append("\n");
}
 return tableHeader1.toString() + "\n" + tableHeader2.toString() + "\n" + ClassicTable.toString();
}
public static void Total(){
double total_Revenue = 0;
double total_LostProfit = 0;
double total_Scrap = 0;
double total_DailyProfit = 0;
for(int i = 0 ; i < Days; i++){
total_Revenue += t[i].RevenueSale;
total_LostProfit += t[i].LostProfit_ForExcess_Demand;
total_Scrap += t[i].Salvage_FromSale_Scrap;
total_DailyProfit += t[i].DailyProfit;
}
     System.out.println("Total Revenue of sale : " + total_Revenue+"$");
     System.out.println("Total Lost Profit : " + total_LostProfit+"$");
     System.out.println("Total Salvage from sale Scrap  : " + total_Scrap+"$");
     System.out.println("Total Daily Profit : " + total_DailyProfit+"$");
}
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of simulation days :");
        Days = in.nextInt();
        System.out.println("Enter the number of purchase of tickets");
        number_of_purchase_tickets = in.nextDouble();
        System.out.println("Enter the price buy of each ticket");
        priceBuy = in.nextDouble();
        System.out.println("Enter the price sell of each ticket");
        priceSell = in.nextDouble();
        priceLostProfit = (priceSell - priceBuy);
         System.out.println("Enter the price scrap of each ticket");
         priceScrap = in.nextDouble();
        Simulate();
        PrintSimulation();
        System.out.println("");
        Total();
    }
}
