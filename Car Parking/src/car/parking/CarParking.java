package car.parking;
import java.util.ArrayList;
import java.util.Scanner;
public class CarParking {
static int check(int arr[],int length){
    int counter=0;
    for(int i=0;i<100;i++){
        if(counter==length){
            return (i-counter);
        }
        if(arr[i]==0){
            counter++;
        }else{
            counter=0;
        }
    }
    return -1;
}
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int trucks=0;
        int cars=0;
        int motors=0;
        int bus=0;
       ArrayList <vechile> garage  ;
       int []spaces=new int[100];   
       for(int i=0;i<100;i++){
           spaces[i]=0;
       }
       garage=new ArrayList <vechile> ();
        while(true){  
            System.out.println("enter a number ");
            System.out.println("1- add a vechile");
            System.out.println("2- remove a vechile ");
            System.out.println("3- print the status  ");
            System.out.println("4- to exit  ");
            int g=input.nextInt();
            if(g==4){
            break;
            }
            if(g==1){
                String type;
                int id,duration1;  
                System.out.println("enter the type ");
                type=input.next();
                System.out.println("enter the ID");
                id=input.nextInt();
                System.out.println("enter the current Time ");
                duration1=input.nextInt();
                if("Car".equalsIgnoreCase(type)){
                    if(check(spaces,5)!=-1){
                        Car c1=new Car(duration1,id,5);
                        garage.add(c1);
                        cars++;
                         int start=check(spaces,5);
                         if(start!=-1){
                            for (int i = start; i < start+5; i++) {
                            spaces[i]=id;
                            } 
                         }
                        
                    }else{
                        System.out.println("there isn't enough space");
                    }
                }
                 if("Bus".equalsIgnoreCase(type)){
                    if(check(spaces,10)!=-1){
                        Bus b1=new Bus(duration1,id,10);
                        garage.add(b1);
                        bus++;
                        int start=check(spaces,10);
                        if(start!=-1){
                            for (int i = start; i < start+10; i++) {
                            spaces[i]=id;
                        }
                        }
                        
                        
                    }else{
                        System.out.println("there isn't enough space");
                    }
                }
                  if("Motor".equalsIgnoreCase(type)){
                    if(check(spaces,2)!=-1){
                        Motor b1=new Motor(duration1,id,2);
                        garage.add(b1);
                        motors++;
                         int start=check(spaces,2);
                         if(start!=-1){
                             for (int i = start; i < start+2; i++) {
                            spaces[i]=id;
                                }
                            }
                     
                    }
                    else{
                        System.out.println("there isn't enough space");
                    }
                  }
                  if("Truck".equalsIgnoreCase(type)){
                    if(check(spaces,7)!=-1){
                        Truck b1=new Truck(duration1,id,7);
                        garage.add(b1);
                        trucks++;
                         int start=check(spaces,7);
                        if(start!=-1){
                           for (int i = start; i < start+7; i++) {
                            spaces[i]=id;
                        } 
                        }
                        
                    }
                    else{
                        System.out.println("there isn't enough space");
                    }
                }
                
                
            }
            
            if(g==2){
                System.out.println("Enter Your Car ID");
                int ID=input.nextInt();
                 System.out.println("Enter the current time");
                int duration2=input.nextInt();
                for(int i=0;i<garage.size();i++){
                     int id2=garage.get(i).id;
                     if(ID==id2){
                         for(int z=0;z<100;z++){
                             if(spaces[z]==ID){
                                 spaces[z]=0;
                             }
                         }
                        int value1= garage.get(i).calcMoney();
                        int value2=0;
                        int l=garage.get(i).length;
                       
                        if(l==10){
                            value2=duration2*15;
                            int res=value2-value1;
                            System.out.println("The cost for the Vehicle is : "+res);
                            bus--;
                            
                        }
                        else if(l==7){
                            value2=duration2*15;
                            int res=value2-value1;
                            System.out.println("The cost for the Vehicle is : "+res);
                            trucks--;
                            
                        }
                         else if(l==5){
                            value2=duration2*10;
                            int res=value2-value1;
                            System.out.println("The cost for the Vehicle is : "+res);
                            cars--;
                            
                        }
                         else if(l==2){
                            value2=duration2*5;
                            int res=value2-value1;
                            System.out.println("The cost for the Vehicle is : "+res);
                            motors--;
                            
                        }
                        
                        garage.remove(i);
                        System.out.println("The Car removed1");
                        
                     }else{
                         System.out.println("The Car isn't found");
                     }
                }
                
            }

            if(g==3){
                System.out.println("there are:"+cars+" Cars in garage");
                System.out.println("there are:"+bus+" Bus in garage");
                System.out.println("there are:"+trucks+" Trucks in garage");
                System.out.println("there are:"+motors+" Motor in garage");
                
                for(int i=0;i<100;){
                    int free=0; 
                    int occupied=0;
                    if(spaces[i]==0){
                        
                        while(i<100&&spaces[i]==0)
                        {
                            free++;
                            i++;
                        }
                        System.out.println("available space: "+free);
                       
                    }else if(spaces[i]!=0){
                         while(i<100&&spaces[i]!=0)
                        {
                            occupied++;
                            i++;
                        }
                        System.out.println("occupied space: "+occupied);
                    }
                    
                }
                for(int i=0;i<100;i++){
                    if(spaces[i]!=0){
                      System.out.print("#");
                    }else{
                         System.out.print("-");
                    }
                }
                System.out.println();
             
            }
            
            
        }
    }
  

   
}
