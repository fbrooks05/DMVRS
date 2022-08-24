package EE333;

/**
 * File: Motor.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Motor {
    private static java.util.ArrayList<Motor> Motors = new java.util.ArrayList<Motor>();
    
    private int torque;
    private int hp; // horsepower
    private MotorType motorType;
    private int cylinders;
    private String Orientation;
    
    public Motor() {
        this.hp = 0;
        this.torque = 0;
        this.motorType = EE333.MotorType.unknown;
        this.cylinders = 0;
        this.Orientation = "";
    }
    
    public Motor( int hp, int torque ) {
        // checks to see if the engine has valid specifications
        // modify like vehicle
        if (hp == 0) {
            this.hp = 0;
            this.torque = 0;
            this.motorType = EE333.MotorType.unknown;
            this.cylinders = 0;
            this.Orientation = "";
        } else if (torque == 0) {
            this.hp = 0;
            this.torque = 0;
            this.motorType = EE333.MotorType.unknown;
            this.cylinders = 0;
            this.Orientation = "";
        } else {
            this.hp = hp;
            this.torque = torque;
            EE333.Motor.Motors.add(this);
            this.motorType = EE333.MotorType.unknown;
            this.cylinders = 0;
            this.Orientation = "";
        }
        
    }
    
    public Motor( int hp, int torque, EE333.MotorType type, int cylinders, String orientation ) {
        this.hp = 0;
        this.torque = 0;
        this.motorType = EE333.MotorType.unknown;
        this.cylinders = 0;
        this.Orientation = "";
        
        if (type != EE333.MotorType.unknown) {
            this.motorType = type;
        } else {
            this.motorType = EE333.MotorType.unknown;
        }
        
        this.hp = hp;
        this.torque = torque;
        this.cylinders = cylinders;
        
        if (orientation != null) {
            this.Orientation= orientation;
        } else {
            this.Orientation = "";
        }
        
//        if (hp == 0) {
//            this.hp = 0;
//            this.torque = 0;
//            this.motorType = EE333.MotorType.unknown;
//            this.cylinders = 0;
//            this.Orientation = "";
//        } else if (torque == 0) {
//            this.hp = 0;
//            this.torque = 0;
//            this.motorType = EE333.MotorType.unknown;
//            this.cylinders = 0;
//            this.Orientation = "";
//        } else if (type == EE333.MotorType.unknown) {
//            this.hp = 0;
//            this.torque = 0;
//            this.motorType = EE333.MotorType.unknown;
//            this.cylinders = 0;
//            this.Orientation = "";
//        } else if (cylinders == 0) {
//            this.hp = 0;
//            this.torque = 0;
//            this.motorType = EE333.MotorType.unknown;
//            this.cylinders = 0;
//            this.Orientation = "";
//        } else if (orientation == null) {
//            this.hp = 0;
//            this.torque = 0;
//            this.motorType = EE333.MotorType.unknown;
//            this.cylinders = 0;
//            this.Orientation = "";
//        } else {
//            this.hp = hp;
//            this.torque = torque;
//            this.motorType = type;
//            this.cylinders = cylinders;
//            this.Orientation = orientation;
//        }
    }
    public void setTorque( int torque ) {
        this.torque = torque;
    }
    
    public int getTorque() {
        return torque;
    }
    
    public void setHP( int hp ) {
        this.hp = hp;
    }
    
    public int getHP() {
        return hp;
    }
    
    
    
    public static java.util.ArrayList<Motor> getMotors() {
        return Motors;
    }

    /**
     * @return the type
     */
    public MotorType getMotorType() {
        return this.motorType; // might be more helpful
    }

    /**
     * @return the cylinders
     */
    public int getCylinders() {
        return cylinders;
    }

    /**
     * @return the Orientation
     */
    public String getOrientation() {
        return Orientation;
    }
    
    public static Motor importCustom( String customString ) {
        Motor tempMotor = null;
        int torque = 0;
        int hp = 0;
        MotorType type = EE333.MotorType.unknown;
        int cylinders = 0;
        String orientation = "";
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[ index ].split(": ");
            if( chunks.length == 2) {
                if( chunks[0].compareToIgnoreCase("torque") == 0 ) {
                    try {
                        torque = Integer.parseInt(chunks[1]);
                    } catch ( NumberFormatException ex ) {
                        System.out.println(ex.toString());
                        torque = 0;
                    }
                } else if ( chunks[0].compareToIgnoreCase("hp") == 0 ) {
                    try {
                        hp = Integer.parseInt(chunks[1]);
                    } catch ( NumberFormatException ex ) {
                        System.out.println(ex.toString());
                        hp = 0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("type") == 0 ) {
                    try {
                        type = MotorType.valueOf(chunks[1]);
                    } catch ( java.lang.IllegalArgumentException ex ) {
                        System.out.println(ex.toString());
                        type = EE333.MotorType.unknown;
                    }
                } else if ( chunks[0].compareToIgnoreCase("cylinders") == 0 ) {
                    try {
                        cylinders = Integer.parseInt(chunks[1]);
                    } catch ( NumberFormatException ex ) {
                        System.out.println(ex.toString());
                        cylinders = 0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("orientation") == 0 ) {
                    orientation = chunks[1];
                } else {
                    // we did not find any valid data, so we ignore that line.
                }
            } else {
                // we ignore it. we do not have the correct file type
            }
        }
        
//        if (( torque != 0 ) && ( hp != 0 ) && ( type != EE333.MotorType.unknown ) && ( cylinders >= 0 ) && ( orientation.length() > 0 )) {
        if ( type != EE333.MotorType.unknown ) {
            tempMotor = new Motor( torque, hp, type, cylinders, orientation );
        } else if (( torque != 0 ) && ( hp != 0 )) {
            System.out.println("MotorType = unknown");
            tempMotor = new Motor( torque, hp );
        } else {
            tempMotor = new Motor();
        }
        
        
        return( tempMotor );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "Torque: " + this.torque + '\n';
        output += "HP: " + this.hp + '\n';
        output += "Type: " + this.motorType + '\n';
        output += "Cylinders: " + this.cylinders + '\n';
        output += "Orientation: " + this.Orientation + '\n';
        
        return( output );
    }

    /**
     * @param cylinders the cylinders to set
     */
    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    /**
     * @param Orientation the Orientation to set
     */
    public void setOrientation(String Orientation) {
        this.Orientation = Orientation;
    }
    
}

//class Electric extends EE333.Motor {
//    public Electric (EE333.Motor motor) {
//        // this.motor = motor;
//    }
//    
//}
//
//// could compine gas and diesel into a petroleum class
//class Gasoline extends EE333.Motor {
//    private Type Type;
//    private String cylinders;
//    private String orientation;
//    
//    public Gasoline () {
//        this.Type = type;
//    }
//    
//}

// may not need this 
enum MotorType {
    Electric, Gas, Diesel, unknown
}


