/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.parking;

/**
 *
 * @author johna
 */
public class Bus extends vechile {
    int duration1;
   

    public Bus(int duration1, int id, int length) {
        super(id, length);
        this.duration1 = duration1;
        
    }

   public int getDuration1() {
        return duration1;
    }

    public void setDuration1(int duration1) {
        this.duration1 = duration1;
    }

   
    public int calcMoney(){
        return duration1*15;
    }
  
    
    
}
