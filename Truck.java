package EE333;

/**
 * File: Truck.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Truck extends EE333.LandVehicle{
    private int payload;
    private int wheelCount;
    private int doorCount;
    private EE333.Vehicle vehicle;
    
    public int getWheelCount() {
        // return( this.wheelCount );
        return( super.getTractionCount() );
    }

    /**
     * @return the payload
     */
    public int getPayload() {
        return payload;
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
    
    public Truck() {
        this.doorCount = 0;
        this.payload = 0;
        this.wheelCount = 0;
        this.vehicle = new EE333.Vehicle();
    }
    
    public Truck( EE333.Vehicle vehicle, int doorCount, int payload, int wheelCount ) {
        if ( doorCount == 0 ) {
            this.doorCount = 0;
            this.payload = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else if ( payload == 0 ) {
            this.doorCount = 0;
            this.payload = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else if ( wheelCount == 0 ) {
            this.doorCount = 0;
            this.payload = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else if ( vehicle == new EE333.Vehicle() ) {
            this.doorCount = 0;
            this.payload = 0;
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else {
            this.doorCount = doorCount;
            this.payload = payload;
            this.wheelCount = wheelCount;
            this.vehicle = vehicle;
        }
    }
    
    public static Truck importCustom( String customString ) {
        Truck tempTruck = null;
        Vehicle tempVehicle = null; 
        int wheelCount = 0;
        int doorCount = 0;
        int payload = 0;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {// 2 pieces of info per line; label: value;
                if ( chunks[0].compareToIgnoreCase("wheelCount") == 0 ) {
                    try {
                        wheelCount = Integer.parseInt(chunks[1]);  
                    } catch ( NumberFormatException ex ) {
                        wheelCount = 0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("doorCount") == 0 ) {
                    try {
                        doorCount = Integer.parseInt(chunks[1]);  
                    } catch ( NumberFormatException ex ) {
                        doorCount = 0;
                    }
                } else if ( chunks[0].compareToIgnoreCase("payload") == 0 ) {
                    try {
                        payload = Integer.parseInt(chunks[1]);  
                    } catch ( NumberFormatException ex ) {
                        payload = 0;
                    }
                } else {
                    // we ignore it!
                }
            } else {
                // we ignore it!
            }
        }
        
        tempVehicle = EE333.Vehicle.importCustom(customString);
        
        if (( wheelCount > 0 ) && ( doorCount > 0 ) && ( payload > 0 )) {
            tempTruck = new Truck(tempVehicle, doorCount, payload, wheelCount);
        } else {
            tempTruck = new Truck();
        }
        
        return( tempTruck );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += this.vehicle.exportCustom();
        output += "WheelCount: " + this.wheelCount + '\n';
        output += "DoorCOunt: " + this.doorCount + '\n';
        output += "Payload: " + this.payload + '\n';
        output += "Classification: Truck" + '\n';
         
        return( output );
    }
    
    
}
