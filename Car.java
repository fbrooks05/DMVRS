package EE333;

/**
 * File: Car.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Car extends EE333.LandVehicle {
    // consider having a wheelCount
    // two options:
    private int wheelCount;
    private int doorCount;
    private EE333.Vehicle vehicle;
    
    
    
    public int getWheelCount() {
         return( this.wheelCount );
//        return( super.getTractionCount() );
    }

    /**
     * @return the doorCount
     */
    public int getDoorCount() {
        return doorCount;
    }
    
    public void setStatus( EE333.Status status) {
        this.vehicle.setStatus(status);
    }
    
    /**
     * @return the vehicle
     */
    public EE333.Vehicle getVehicle() {
        return vehicle;
    }
    
    public Car() {
        this.doorCount = 0;
        this.wheelCount = 0;
        this.vehicle = new EE333.Vehicle();
    }
    
    public Car( EE333.Vehicle vehicle, int wheelCount, int doorCount ) {
        if ( wheelCount == 0 ) {
        this.wheelCount = 0;
        this.doorCount = 0;
        this.vehicle = new EE333.Vehicle();
        } else if ( doorCount == 0 ) {
            this.doorCount = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else if ( vehicle == new EE333.Vehicle() ) {
            this.doorCount = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else {
            this.wheelCount = wheelCount;
            this.doorCount = doorCount;
            this.vehicle = vehicle;
        }
        
    }
    
    public static Car importCustom( String customString ) {
        Car tempCar = null;
        Vehicle tempVehicle = null; 
        int wheelCount = 0;
        int doorCount = 0;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {// 2 pieces of info per line; label: value;
                if ( chunks[0].compareToIgnoreCase("wheelCount") == 0 ) {
                    try {
                        wheelCount = Integer.parseInt(chunks[1]);  
//                        System.out.println( wheelCount );
                    } catch ( NumberFormatException ex ) {
                        System.out.println( ex.toString() );
                        wheelCount = 0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("doorCount") == 0 ) {
                    try {
                        doorCount = Integer.parseInt(chunks[1]);  
                    } catch ( NumberFormatException ex ) {
                        System.out.println( ex.toString() );
                        doorCount = 0;
                    }
                } else {
                    // we ignore it!
                }
            } else {
                // we ignore it!
            }
        }
        
        tempVehicle = EE333.Vehicle.importCustom(customString);
        
        if (( wheelCount > 0 ) && ( doorCount > 0 )) {
            tempCar = new Car(tempVehicle, wheelCount, doorCount);
        } else {
            tempCar = new Car();
        }
        
        return( tempCar );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += this.vehicle.exportCustom();
        output += "WheelCount: " + this.wheelCount + '\n';
        output += "DoorCount: " + this.doorCount + '\n';
        output += "Classification: Car" + '\n';
         
        return( output );
    }
    
}
