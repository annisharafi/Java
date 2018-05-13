package diskschedulling;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiskSchedulling {

    public static void main(String[] args) {
        //inisialisasi class dan variable
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        diskalgo DiskAlgo = new diskalgo();
        int x[];
        int hasil[];
        hasil = new int [6];
        String process[]={"FCFS","SSTF","SCAN","Circular Scan","LOOK","Circular LOOK"};
        
        //input dengan random generator
        System.out.print("Input total sector: ");
        int n = scan.nextInt();
        x = new int[n + 1];
        x[n] = 0;
        for (int i = 0; i < n; i++) {
            x[i] = rand.nextInt(2000) + 1;

        }
        //print the sector number
        System.out.println("Number sector being operate in algorithm");
        for (int i = 0; i < n; i++) {
            System.out.println(x[i]);
        }
        
        //input head of the algorithm
        System.out.print("Input head of sector: ");
        int head = scan.nextInt();

        
        hasil[0]=DiskAlgo.fcfs(x);
        hasil[1]=DiskAlgo.sstf(x, head);
        hasil[2]=DiskAlgo.scan_algo(x, head);
        hasil[3]=DiskAlgo.cir_scan_algo(x, head);
        hasil[4]=DiskAlgo.look_algo(x, head);
        hasil[5]=DiskAlgo.cir_look_algo(x, head);
        
        System.out.println("FCFS Process: " +hasil[0]);
        System.out.println("Average time: "+hasil[0]/n);
        System.out.println("");
        
        System.out.println("SSTF Process: "+hasil[1]);
        System.out.println("Average time: "+hasil[1]/n);
        System.out.println("");
        
        System.out.println("SCAN Process: "+ hasil[2]);
        System.out.println("Average time: "+hasil[2]/n);
        System.out.println("");
        
        System.out.println("Circular SCAN Process: "+hasil[3]);
        System.out.println("Average time: "+hasil[3]/n);
        System.out.println("");
        
        System.out.println("LOOK Process: "+hasil[4]);
        System.out.println("Average time: "+hasil[4]/n);
        System.out.println("");
        
        System.out.println("Circular LOOK Process: "+ hasil[5]);
        System.out.println("Average time: "+hasil[5]/n);
        
        //find the best algorithm
        int temp=0;
        for(int i=0; i<5; i++){
            if(hasil[i]>hasil[i+1]){
                temp=i+1;
            } else {
                temp=i;
            }
        }
        System.out.println("Best Algorithm"+process[temp]);
        
    }

}
