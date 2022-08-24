package EE333;

/**
 * File: Cycle.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Cycle extends EE333.LandVehicle {
    // what does a cycle need??
    private int wheelCount;
    private EE333.Vehicle vehicle;

    /**
     * @return the wheelCount
     */
    public int getWheelCount() {
        return wheelCount;
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
    
    public Cycle() {
        this.wheelCount = 0;
        this.vehicle = new EE333.Vehicle();
    }
    
    public Cycle( EE333.Vehicle vehicle, int wheelCount ) {
        if ( wheelCount == 0 ) {
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else if ( vehicle == new EE333.Vehicle() ) {
            this.wheelCount = 0;
            this.vehicle = new EE333.Vehicle();
        } else {
            this.wheelCount = wheelCount;
            this.vehicle = vehicle;
        }
    }
    
    public static Cycle importCustom( String customString ) {
        Cycle tempCycle = null;
        Vehicle tempVehicle = null; 
        int wheelCount = 0;
        
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
                    
                } else {
                    // we ignore it!
                }
            } else {
                // we ignore it!
            }
        }
        
        tempVehicle = EE333.Vehicle.importCustom(customString);
        
        if ( wheelCount > 0 ) {
            tempCycle = new Cycle(tempVehicle, wheelCount);
        } else {
            tempCycle = new Cycle();
        }
        
        return( tempCycle );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += this.vehicle.exportCustom();
        output += "wheelCount: " + this.wheelCount + '\n';
        output += "Classification: Cycle" + '\n';
        
        return( output );
    }
    
}
