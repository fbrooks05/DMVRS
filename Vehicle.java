package EE333;

/**
 * File: Vehicle.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Vehicle {
    private static java.util.ArrayList<Vehicle> Vehicles = new java.util.ArrayList<Vehicle>();

    private static boolean verifyVIN(String VIN) {
        boolean results = false;
        int index = 0;
        
        while(( index < Vehicles.size() ) && ( results == false )) {
            if( Vehicles.get(index).VIN.compareToIgnoreCase(VIN) == 0 ){
                results = true;
            } else {
                index++;
            }
        }
        
        return( results );
    }
    
    /**
     * @return the status
     */
    public EE333.Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(EE333.Status status) {
        this.status = status;
    }
    
    private String VIN; // vehicle ID number (AKA unique ID)
    private String make;
    private String model;
    private String subModel;
    private int year;
    private String color; // limits to a single color - consider a collection?
    private int weight; // generic enough... (size?)
    private EE333.Motor motor;
    private EE333.Status status;
    
    public Vehicle() {
        this.VIN = "";
        this.make = "";
        this.model = "";
        this.subModel = "";
        this.year = 0;
        this.color = "";
        this.weight = 0;
        this.motor = new EE333.Motor();
        this.status = EE333.Status.unknown;
    }
    
    public Vehicle( String VIN, String make, String model, String subModel, int year, String color, int weight, EE333.Motor motor ) {
        this.status = EE333.Status.unknown;
        
        this.VIN = "";
        this.make = "";
        this.model = "";
        this.subModel = "";
        this.year = 0;
        this.color = "";
        this.weight = 0;
        this.motor = new EE333.Motor();
        this.status = EE333.Status.valid;
        
        if (( VIN != null ) && ( VIN.length() > 0 ) ) {
            this.VIN = VIN;
        } else {
            this.status = EE333.Status.unknown;
        }
        
        if (( make != null ) && ( make.length() > 0 )) {
            this.make = make;
        } else {
            this.status = EE333.Status.unknown;
        }
        
        if (( model != null ) && ( model.length() > 0 )) {
            this.model = model;
        } else {
            this.status = EE333.Status.unknown;
        }
        
        // do this ^^ for model & year
        
        if ( subModel == null ) {
            this.subModel = "";
        } else {
            this.subModel = subModel;
        }
        
        if (color == null) {
            this.color = "";
        } else { 
            this.color = color;
        }
        
        this.year = year;
        this.weight = weight;
        this.motor = motor;
        
        
        // Old code (keep until this^ works)
        /*
        if (( VIN == null ) || ( VIN.length() == 0 ) || ( EE333.Vehicle.verifyVIN(VIN) == true )) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if (( make == null ) || ( make.length() == 0 )) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if (( model == null ) || ( model.length() == 0 )) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if (( subModel == null ) || ( subModel.length() == 0 )) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if ( year == 0 ) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if (( color == null ) || ( color.length() == 0 )) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else if ( weight == 0 ) {
            this.VIN = "";
            this.make = "";
            this.model = "";
            this.subModel = "";
            this.year = 0;
            this.color = "";
            this.weight = 0;
            this.motor = new EE333.Motor();
            this.status = EE333.Status.unknown;
        } else {
            this.VIN = VIN;
            this.make = make;
            this.model = model;
            this.subModel = subModel;
            this.year = year;
            this.color = color;
            this.weight = weight;
            this.status = EE333.Status.active;
            EE333.Vehicle.Vehicles.add(this);
        }
        */
        
        
    }
    

    /**
     * @return the VIN
     */
    public String getVIN() {
        return VIN;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the subModel
     */
    public String getSubModel() {
        return subModel;
    }

    /**
     * @param subModel the subModel to set
     */
    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the motor
     */
    public EE333.Motor getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(EE333.Motor motor) {
        this.motor = motor;
    }
    
    public static Vehicle importCustom( String customString ) {
        Vehicle tempVehicle = null;
        EE333.Motor tempMotor = null;
        String VIN = "";
        String make = "";
        String model = "";
        String subModel = "";
        int year = 0;
        String color = "";
        int weight = 0;
        
        EE333.Status status = EE333.Status.unknown;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ){
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {
                if ( chunks[0].compareToIgnoreCase("VIN") == 0 ) {
                    VIN = chunks[1]; 
                } else if ( chunks[0].compareToIgnoreCase("make") == 0 ) {
                    make = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("model") == 0 ) {
                    model = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("subModel") == 0 ) {
                    subModel = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("year") == 0 ) {
                    try {
                        year = Integer.parseInt( chunks[1] );
                    } catch ( NumberFormatException ex ) {
                        System.out.println(ex.toString());
                        year = 0;
                    }
                } else if ( chunks[0].compareToIgnoreCase("color") == 0 ) {
                    color = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("weight") == 0 ) {
                    try {
                        weight = Integer.parseInt( chunks[1] );
                    } catch ( NumberFormatException ex ) {
                        System.out.println(ex.toString());
                        weight = 0;
                    } 
                } else if ( chunks[0].compareToIgnoreCase("status") == 0 ) {
                    try {
                        status = EE333.Status.valueOf(chunks[1]); 
                    } catch ( java.lang.IllegalArgumentException ex) {
                        System.out.println(ex.toString());
                        status = EE333.Status.unknown;   
                    }
                }
            }
        }
        tempMotor = EE333.Motor.importCustom(customString);
        
        if ( VIN.length() > 0 ) {
            tempVehicle = new Vehicle(VIN, make, model, subModel, year, color, weight, tempMotor);
        } else {
            tempVehicle = new Vehicle(); 
        }
        
        tempVehicle.setStatus(status);
        
        return( tempVehicle );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "VIN: " + this.VIN + '\n';
        output += "make: " + this.make + '\n';
        output += "model: " + this.model + '\n';
        output += "subModel: " + this.subModel + '\n';
        output += "year: " + this.year + '\n';
        output += "Color: " + this.color + '\n';
        output += "Weight: " + this.weight + '\n';
        output += this.motor.exportCustom();
        output += "Status: " + this.getStatus() + '\n';
        
        return( output );
    }
    
}

enum Status {
    active, inactive, unknown, valid
}


