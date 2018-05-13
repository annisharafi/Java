package diskschedulling;
import static java.lang.Math.abs;
import java.util.*;
public class diskalgo {


    public int [] que;

    //fcfs ( first come first serve) method
    public int fcfs(int x[]){
        int seek=0;
        for(int i=1; i<x.length; i++){
            seek+=abs(x[i]-x[i-1]);
        }
        return seek;
    }
    
    
    //sstf (shortest seek first ) method
    public int sstf(int x[],int head){
        que= new int [x.length];
        int seek=0;
       
        for (int i=0; i<x.length; i++){
            que[i]= abs(head-x[i]);
        }
        int temp=0;
        for (int i=0; i<x.length; i++){
            for (int j=i+1; j<x.length; j++){
                if ( que[i]>que[j]){
                   temp=que[i];
                   que[i]=que[j];
                   que[j]=temp;
                   
                   temp=x[i];
                   x[i]=x[j];
                   x[j]=temp;
                }
            }
        }
        
        for( int i=1; i<x.length; i++){
            seek+=abs(head-x[i]);
            head=x[i];
        }
        return seek;
    }
    
    
    //scan(elevator) method
    public int scan_algo (int x[],int head) {
       
        int disloc = 0;
        int seek=0;
        Arrays.sort(x);
        for(int i=0; i<x.length;i++){
            if(head==x[i]){
                disloc=i;
                break;
            } 
        }
        
        for (int i=disloc; i>=0; i--){
         seek+=abs(head-x[i]);
         head=x[i];
        }
        for(int i=disloc+1; i<x.length-1; i++){
            seek+=abs(head-x[i]);
            head=x[i];
        }
        return seek;
        
        
    }
    
    //circular scan method
    public int cir_scan_algo (int x[],int head) {
        
        int disloc = 0;
        int seek=0;
        Arrays.sort(x);
        for(int i=0; i<x.length;i++){
            if(head==x[i]){
                disloc=i;
                break;
            } 
        }
        
        for (int i=disloc; i>=0; i--){
         seek+=abs(head-x[i]);
         head=x[i];
        }
        for(int i=x.length-1; i>disloc+1; i--){
            seek+=abs(x[i]-x[i-1]);

        }
        return seek;
        
        
    }
    
    //look method
     public int look_algo (int x[],int head) {
        int disloc = 0;
        int seek=0;
        Arrays.sort(x);
        for(int i=0; i<x.length;i++){
            if(head==x[i]){
                disloc=i;
                break;
            } 
        }
        
        for (int i=disloc; i>0; i--){
         seek+=abs(head-x[i]);
         head=x[i];
        }
       for(int i=disloc+1; i<x.length-1; i++){
            seek+=abs(head-x[i]);
           head=x[i];
        }
        return seek;
        
        
    }
    
     //circular look method
      public int cir_look_algo (int x[],int head) {
        int disloc = 0;
        int seek=0;
        Arrays.sort(x);
        for(int i=0; i<x.length;i++){
            if(head==x[i]){
                disloc=i;
                break;
            } 
        }
        
        for (int i=disloc; i>0; i--){
            
         seek+=abs(head-x[i]);
         head=x[i];
        }
        for(int i=x.length-1; i>disloc+1; i--){
            seek+=abs(x[i]-x[i-1]);
            
        }
        return seek;
        
        
    }
}
