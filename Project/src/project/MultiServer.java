package project;

import java.util.Random;
import java.util.Scanner;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

class Car {

    private int IAT;
    private int IAT_Random_digit;
    private int ArrivalTime;
    private int WaitingTime;
    private int ServiceTime_Random_digit;
    private int car_number;
    private int ServiceTime_Able;
    private int ServiceTime_Baker;
    private int ServiceTime_NitroG;
    private int ServiceBegin_Able;
    private int ServiceBegin_Baker;
    private int ServiceBegin_NitroG;
    private int ServiceEnd_Able;
    private int ServiceEnd_Baker;
    private int ServiceEnd_NitroG;

    public int getIAT() {
        return IAT;
    }

    public void setIAT(int IAT) {
        this.IAT = IAT;
    }

    public int getIAT_Random_digit() {
        return IAT_Random_digit;
    }

    public void setIAT_Random_digit(int IAT_Random_digit) {
        this.IAT_Random_digit = IAT_Random_digit;
    }

    public int getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(int ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public int getWaitingTime() {
        return WaitingTime;
    }

    public void setWaitingTime(int WaitingTime) {
        this.WaitingTime = WaitingTime;
    }

    public int getServiceTime_Random_digit() {
        return ServiceTime_Random_digit;
    }

    public void setServiceTime_Random_digit(int ServiceTime_Random_digit) {
        this.ServiceTime_Random_digit = ServiceTime_Random_digit;
    }

    public int getCar_number() {
        return car_number;
    }

    public void setCar_number(int car_number) {
        this.car_number = car_number;
    }

    public int getServiceTime_Able() {
        return ServiceTime_Able;
    }

    public void setServiceTime_Able(int ServiceTime_Able) {
        this.ServiceTime_Able = ServiceTime_Able;
    }

    public int getServiceTime_Baker() {
        return ServiceTime_Baker;
    }

    public void setServiceTime_Baker(int ServiceTime_Baker) {
        this.ServiceTime_Baker = ServiceTime_Baker;
    }

    public int getServiceTime_NitroG() {
        return ServiceTime_NitroG;
    }

    public void setServiceTime_NitroG(int ServiceTime_NitroG) {
        this.ServiceTime_NitroG = ServiceTime_NitroG;
    }

    public int getServiceBegin_Able() {
        return ServiceBegin_Able;
    }

    public void setServiceBegin_Able(int ServiceBegin_Able) {
        this.ServiceBegin_Able = ServiceBegin_Able;
    }

    public int getServiceBegin_Baker() {
        return ServiceBegin_Baker;
    }

    public void setServiceBegin_Baker(int ServiceBegin_Baker) {
        this.ServiceBegin_Baker = ServiceBegin_Baker;
    }

    public int getServiceBegin_NitroG() {
        return ServiceBegin_NitroG;
    }

    public void setServiceBegin_NitroG(int ServiceBegin_NitroG) {
        this.ServiceBegin_NitroG = ServiceBegin_NitroG;
    }

    public int getServiceEnd_Able() {
        return ServiceEnd_Able;
    }

    public void setServiceEnd_Able(int ServiceEnd_Able) {
        this.ServiceEnd_Able = ServiceEnd_Able;
    }

    public int getServiceEnd_Baker() {
        return ServiceEnd_Baker;
    }

    public void setServiceEnd_Baker(int ServiceEnd_Baker) {
        this.ServiceEnd_Baker = ServiceEnd_Baker;
    }

    public int getServiceEnd_NitroG() {
        return ServiceEnd_NitroG;
    }

    public void setServiceEnd_NitroG(int ServiceEnd_NitroG) {
        this.ServiceEnd_NitroG = ServiceEnd_NitroG;
    }


    public Car() {
    }

}

public class MultiServer {

    public static int Simulation_length;
    public static Car[] c;
    public static int Able_busy;
    public static int Baker_busy;
    public static int NitroG_busy;
    public static int count;

// compute Arrival Time
    public static void compute_ArrivalTime() {
        c[0].setArrivalTime(c[0].getIAT());
        for (int i = 1; i < Simulation_length; i++) {
            c[i].setArrivalTime(c[i].getIAT() + c[i - 1].getArrivalTime());
        }
    }
// Calculate IAT

    public static void Calc_IAT() {
        for (int m = 0; m < Simulation_length; m++) {
            if (c[m].getIAT_Random_digit() >= 1 && c[m].getIAT_Random_digit() <= 25) {
                c[m].setIAT(1);
            } else if (c[m].getIAT_Random_digit() >= 26 && c[m].getIAT_Random_digit() <= 65) {
                c[m].setIAT(2);
            } else if (c[m].getIAT_Random_digit() >= 66 && c[m].getIAT_Random_digit() <= 85) {
                c[m].setIAT(3);
            } else {
                c[m].setIAT(4);
            }
        }
    }

//Calculate Service Time for Able Server
    public static void Calc_ServiceTime_Able() {
        for (int b = 0; b < Simulation_length; b++) {
            if (c[b].getServiceTime_Random_digit() >= 1 && c[b].getServiceTime_Random_digit() <= 30) {
                c[b].setServiceTime_Able(2);
            } else if (c[b].getServiceTime_Random_digit() >= 31 && c[b].getServiceTime_Random_digit() <= 58) {
                c[b].setServiceTime_Able(3);
            } else if (c[b].getServiceTime_Random_digit() >= 59 && c[b].getServiceTime_Random_digit() <= 83) {
                c[b].setServiceTime_Able(4);
            } else {
                c[b].setServiceTime_Able(5);
            }
        }
    }

//Calculate Service Time for Baker Server
    public static void Calc_ServiceTime_Baker() {
        for (int b = 0; b < Simulation_length; b++) {
            if (c[b].getServiceTime_Random_digit() >= 1 && c[b].getServiceTime_Random_digit() <= 35) {
                c[b].setServiceTime_Baker(3);
            } else if (c[b].getServiceTime_Random_digit() >= 36 && c[b].getServiceTime_Random_digit() <= 60) {
                c[b].setServiceTime_Baker(4);
            } else if (c[b].getServiceTime_Random_digit() >= 61 && c[b].getServiceTime_Random_digit() <= 80) {
                c[b].setServiceTime_Baker(5);
            } else {
                c[b].setServiceTime_Baker(6);
            }
        }
    }
//Calculate Service Time for NitroG Server

    public static void Calc_ServiceTime_NitroG() {
        for (int n = 0; n < Simulation_length; n++) {
            if (c[n].getServiceTime_Random_digit() >= 1 && c[n].getServiceTime_Random_digit() <= 20) {
                c[n].setServiceTime_NitroG(4);
            } else if (c[n].getServiceTime_Random_digit() >= 21 && c[n].getServiceTime_Random_digit() <= 64) {
                c[n].setServiceTime_NitroG(5);
            } else {
                c[n].setServiceTime_NitroG(6);
            }
        }
    }

//Simulate
    public static void Simulate() {
        c = new Car[Simulation_length];
        Random rand = new Random();
        for (int i = 0; i < Simulation_length; i++) {

            c[i] = new Car();
            count += 1;
            c[i].setCar_number(count);
            c[i].setIAT_Random_digit(rand.nextInt(100));
            c[i].setServiceTime_Random_digit(rand.nextInt(100));

        }
        Calc_IAT();
        Calc_ServiceTime_Able();
        Calc_ServiceTime_Baker();
        Calc_ServiceTime_NitroG();
        compute_ArrivalTime();
        for (int a = 0; a < Simulation_length; a++) {
            if (a == 0) {
                c[a].setServiceBegin_Able(c[a].getArrivalTime());
                c[a].setServiceBegin_Baker(0);
                c[a].setServiceBegin_NitroG(0);
            } else {
                if (c[a].getArrivalTime() >= Able_busy) {
                    c[a].setServiceBegin_Able(c[a].getArrivalTime());
                    c[a].setServiceBegin_Baker(0);
                    c[a].setServiceBegin_NitroG(0);
                } else if (Able_busy <= Baker_busy && Able_busy <= NitroG_busy) {
                    c[a].setServiceBegin_Able(Math.max(c[a].getArrivalTime(), Able_busy));
                    c[a].setServiceBegin_Baker(0);
                    c[a].setServiceBegin_NitroG(0);
                } else if (c[a].getArrivalTime() >= Baker_busy) {
                    c[a].setServiceBegin_Baker(Math.max(Baker_busy, c[a].getArrivalTime()));
                    c[a].setServiceBegin_Able(0);
                    c[a].setServiceBegin_NitroG(0);
                } else if (Baker_busy <= NitroG_busy) {
                    c[a].setServiceBegin_Baker(Math.max(Baker_busy, c[a].getArrivalTime()));
                    c[a].setServiceBegin_Able(0);
                    c[a].setServiceBegin_NitroG(0);
                } else {
                    c[a].setServiceBegin_NitroG(Math.max(NitroG_busy, c[a].getArrivalTime()));
                    c[a].setServiceBegin_Able(0);
                    c[a].setServiceBegin_Baker(0);
                }
            }
            if (c[a].getServiceBegin_Able() >= c[a].getArrivalTime()) {
                c[a].setServiceEnd_Able(c[a].getServiceBegin_Able() + c[a].getServiceTime_Able());
                Able_busy = c[a].getServiceEnd_Able();
                c[a].setWaitingTime(c[a].getServiceBegin_Able() - c[a].getArrivalTime());
                c[a].setServiceTime_Baker(0);
                c[a].setServiceTime_NitroG(0);
            } else if (c[a].getServiceBegin_Baker() >= c[a].getArrivalTime()) {
                c[a].setServiceEnd_Baker(c[a].getServiceBegin_Baker() + c[a].getServiceTime_Baker());
                Baker_busy = c[a].getServiceEnd_Baker();
                c[a].setWaitingTime(c[a].getServiceBegin_Baker() - c[a].getArrivalTime());
                c[a].setServiceTime_Able(0);
                c[a].setServiceTime_NitroG(0);
            } else {
                c[a].setServiceEnd_NitroG(c[a].getServiceBegin_NitroG() + c[a].getServiceTime_NitroG());
                NitroG_busy = c[a].getServiceEnd_NitroG();
                c[a].setWaitingTime(c[a].getServiceBegin_NitroG() - c[a].getArrivalTime());
                c[a].setServiceTime_Able(0);
                c[a].setServiceTime_Baker(0);
            }

        }
    }

    public static String print_Simulation_Table() {
        StringBuilder tableHeader1 = new StringBuilder();
        StringBuilder tableHeader2 = new StringBuilder();
        StringBuilder MultiTable = new StringBuilder();
        tableHeader1.append("                                                                                                         Able                       Able                       Able"
        ).append("                            Baker                  Baker                   Baker").append("                               NitroG                  NitroG                    NitroG");
        tableHeader2.append("Car#        \t").append("IAT\n            Random      \t").append("IAT    \t").append("ArrivalTime    \t").append("Ser_Rand      \t"
        ).append("ServiceBegin     \t").append("ServiceTime     \t"
        ).append("ServiceEnd      \t").append("ServiceBegin     \t").append("ServiceTime     \t").append("ServiceEnd      \t"
        ).append("ServiceBegin     \t").append("ServiceTime     \t").append("ServiceEnd      \t").append("Wating Time");
        for (int r = 0; r < Simulation_length; r++) {
            MultiTable.append(" ").append(c[r].getCar_number()).append("     \t").append("    ").append(c[r].getIAT_Random_digit()).append("     \t").append("       ").append(c[r].getIAT()).append("       \t").append("      ").append(c[r].getArrivalTime()).append("         \t").append("      ").append(c[r].getServiceTime_Random_digit()).append("        \t").append("      ").append(c[r].getServiceBegin_Able()).append("         \t").append("                   ").append(c[r].getServiceTime_Able()).append("             \t").append("            ").append(c[r].getServiceEnd_Able()).append("          \t").append("           ").append(c[r].getServiceBegin_Baker()).append("           \t").append("          ").append(c[r].getServiceTime_Baker()).append("           \t").append("           ").append(c[r].getServiceEnd_Baker()).append("            \t").append("              ").append(+c[r].getServiceBegin_NitroG()).append("         \t").append("                ").append(c[r].getServiceTime_NitroG()).append("         \t").append("               ").append(c[r].getServiceEnd_NitroG()).append("        \t").append("                ").append(c[r].getWaitingTime()).append("\n");
        }
        return tableHeader1.toString() + "\n" + tableHeader2.toString() + "\n" + MultiTable.toString();
    }

    public static void print_Simulation_Table1() {
        StringBuilder tableBuilder = new StringBuilder();
        StringBuilder tableHeader2 = new StringBuilder();
        StringBuilder MultiTable = new StringBuilder();
        System.out.println("                                                           Able          Able            Able"
                + "                Baker          Baker         Baker" + "         NitroG           NitroG          NitroG");
        System.out.println("Car#   \t" + "IAT\n        Random   " + "IAT  \t" + "ArrivalTime \t" + "Ser_Rand     \t" + "ServiceBegin   \t" + "ServiceTime   \t"
                + "ServiceEnd    \t" + "ServiceBegin   \t" + "ServiceTime   \t" + "ServiceEnd    \t"
                + "ServiceBegin   \t" + "ServiceTime   \t" + "ServiceEnd    \t"
                + "Wating Time");
        for (int r = 0; r < Simulation_length; r++) {
            System.out.print(" " + c[r].getCar_number() + "   \t" + " " + c[r].getIAT_Random_digit() + "   \t" + "  " + c[r].getIAT() + "   \t" + "   " + c[r].getArrivalTime() + "       \t" + " "
                    + c[r].getServiceTime_Random_digit() + "    \t" + "  "
                    + "          " + c[r].getServiceBegin_Able() + "    \t" + "    " + c[r].getServiceTime_Able() + "    \t" + "    "
                    + c[r].getServiceEnd_Able() + "    \t" + "    " + c[r].getServiceBegin_Baker() + "    \t" + "    " + c[r].getServiceTime_Baker()
                    + "    \t" + "    " + c[r].getServiceEnd_Baker() + "      \t" + "    "
                    + +c[r].getServiceBegin_NitroG() + "    \t" + "    " + c[r].getServiceTime_NitroG()
                    + "    \t" + "    " + c[r].getServiceEnd_NitroG() + "    \t"
                    + "    " + c[r].getWaitingTime() + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.println("Enter the number of cars");
        Simulation_length = n.nextInt();
        Simulate();
        print_Simulation_Table1();

        Statistics();
    }

    public static void Statistics() {
        double total_Able_servicetime = 0.0;
        double total_Baker_servicetime = 0.0;
        double total_NitroG_servicetime = 0.0;
        double Able_count = 0.0;
        double Baker_count = 0.0;
        double NitroG_count = 0.0;
        double Waiting_count = 0.0;
        double Max_Able_serviceEnd = 0.0; // simulation Time Able
        double Max_Baker_serviceEnd = 0.0; // simulation Time Baker
        double Max_NitroG_serviceEnd = 0.0; // simulation Time NitroG
        double Total_WaitingTime = 0.0;
        double Total_IAT = 0.0;
        for (int i = 0; i < Simulation_length; i++) {
            total_Able_servicetime += c[i].getServiceTime_Able();
            total_Baker_servicetime += c[i].getServiceTime_Baker();
            total_NitroG_servicetime += c[i].getServiceTime_NitroG();
            Total_WaitingTime += c[i].getWaitingTime();
            Total_IAT += c[i].getIAT();
            if (c[i].getWaitingTime() != 0) {
                Waiting_count++;
            }
            if (c[i].getServiceTime_Able() != 0) {
                Able_count++;
                if (c[i].getServiceEnd_Able() > Max_Able_serviceEnd) {
                    Max_Able_serviceEnd = c[i].getServiceEnd_Able();
                }
            } else if (c[i].getServiceTime_Baker() != 0) {
                Baker_count++;
                if (c[i].getServiceEnd_Baker() > Max_Baker_serviceEnd) {
                    Max_Baker_serviceEnd = c[i].getServiceEnd_Baker();
                }
            } else {
                NitroG_count++;
                if (c[i].getServiceEnd_NitroG() > Max_NitroG_serviceEnd) {
                    Max_NitroG_serviceEnd = c[i].getServiceEnd_NitroG();
                }
            }
        }

        double able_utilization = (total_Able_servicetime / Max_Able_serviceEnd);
        System.out.println("Probability of Abel utilization = (Abel Service Time /Simulation Time)");
        System.out.println("                                       =  " + total_Able_servicetime + "/" + Max_Able_serviceEnd
                + " = " + able_utilization + "%");

        double baker_utilization = (total_Baker_servicetime / Max_Baker_serviceEnd);
        System.out.println("Probability of Baker utilization = (Baker Service Time /Simulation Time)");
        System.out.println("                                       =  " + total_Baker_servicetime + "/" + Max_Baker_serviceEnd
                + " = " + baker_utilization + "%");

        double nitroG_utilization = (total_NitroG_servicetime / Max_NitroG_serviceEnd);
        System.out.println("Probability of NitroG utilization = (NitroG Servsice Time /Simulation Time)");
        System.out.println("                                       =  " + total_NitroG_servicetime + "/" + Max_NitroG_serviceEnd
                + " = " + nitroG_utilization + "%");

        System.out.println("Probability of Number of customer service time by Able = " + Able_count
                + " / " + Simulation_length + " = " + ((Able_count / Simulation_length) * 100) + "%");
        System.out.println("Probability of Number of customer service time by Baker = " + Baker_count
                + " / " + Simulation_length + " = " + ((Baker_count / Simulation_length) * 100) + "%");
        System.out.println("Probability of Number of customer service time by NitrorG = " + NitroG_count
                + " / " + Simulation_length + " = " + ((NitroG_count / Simulation_length) * 100) + "%");

        System.out.println("Able average service time = " + total_Able_servicetime
                + " / " + Simulation_length + " = " + ((total_Able_servicetime / Simulation_length) * 100) + " min");
        System.out.println("Baker average service time =" + total_Baker_servicetime
                + " / " + Simulation_length + " = " + ((total_Baker_servicetime / Simulation_length) * 100) + " min");
        System.out.println("NitroG average service time =" + total_NitroG_servicetime
                + " / " + Simulation_length + " = " + ((total_NitroG_servicetime / Simulation_length) * 100) + " min");

        System.out.println("Average waiting time for all = (waiting time/number of customer)"
                + Total_WaitingTime + " / " + Simulation_length + "= " + (Total_WaitingTime / Simulation_length) + " min");
        System.out.println("Average waiting time for customers who wait = (Waiting time/ number of customer who wait)"
                + Total_WaitingTime + " / " + Waiting_count + " = " + ((Total_WaitingTime / Waiting_count)) + " min");

        System.out.println("Average interarrival times = (Sum of all interarrival times)/number of customers ="
                + Total_IAT + " / " + Simulation_length + " = " + (Total_IAT / Simulation_length) + " min");
    }

}
