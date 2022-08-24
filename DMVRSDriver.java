package EE333;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * File: DMVRSDriver.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class DMVRSDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // use a for loop to look at the elements in the args array
        System.out.println("args.length: " + args.length);
        for ( int index = 0; index < args.length; index++ ) {
            System.out.println("args[ " + index + " ]: " + args[ index ]);
        }
        
        if (( args.length == 1 ) && (( args[ 0 ].equalsIgnoreCase("/?") == true ) || ( args[ 0 ].equalsIgnoreCase("/h") == true ))) {
            help(); // explicit call for help
        } else if ((args.length == 3) && (args[0].equalsIgnoreCase("/View") == true ) && (args[1].equalsIgnoreCase("/Custom") == true )){
            //display the custom vehicle file referring to a certain VIN
            displayVIN(args[2]);
        } else if ((args.length == 3) && (args[0].equalsIgnoreCase("/ViewAll") == true) && (args[1].equalsIgnoreCase("/Active") == true ) && (args[2].equalsIgnoreCase("/Custom") == true )) {
            //Display all Active vehicles in a custom file format
            displayActive();
        } else if ((args.length == 3) && (args[0].equalsIgnoreCase("/ViewAll") == true) && (args[1].equalsIgnoreCase("/Inactive") == true ) && (args[2].equalsIgnoreCase("/Custom") == true )) {
            //Display all Inactive vehicles in a custom file format
            displayInactive();
        } else if ((args.length == 3) && (args[0].equalsIgnoreCase("/ViewAll") == true) && (args[1].equalsIgnoreCase("/Unknown") == true ) && (args[2].equalsIgnoreCase("/Custom") == true )) { 
            //Display all Unknown vehicles in a custom file format
            displayUnknownn();
        } else {
           help(); // implicit call for help
        }
        
    }
    
    public static void help() {
        System.out.println("Usage: ");
        System.out.println("    /h              ...calls help");
        System.out.println("    /?              ...calls help");
        System.out.println("    /View   /Custom    <VIN>   ...Views a Custom file with information corresponding to <VIN>");
        System.out.println("    /ViewAll    /Active     /Custom    ...Shows all active vehicles in a CSV format");
        System.out.println("    /ViewAll    /Inactive     /Custom    ...Shows all inactive vehicles in a CSV format");
        System.out.println("    /ViewAll    /Unknown     /Custom    ...Shows all unknown vehicles in a CSV format");
    }
    
    public static void displayVIN( String VIN ) {
        // finds a VIN, then displays the vehicle.txt file info
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
        
        java.io.File unknownFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Unknown");
        java.io.File activeFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Active");
        java.io.File inactiveFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Inactive");
        
        java.io.File unknownVINFolder = new java.io.File(unknownFolder.getAbsolutePath() + "\\" + VIN );
        java.io.File activeVINFolder = new java.io.File(activeFolder.getAbsolutePath() + "\\" + VIN );
        java.io.File inactiveVINFolder = new java.io.File(inactiveFolder.getAbsolutePath() + "\\" + VIN );
        
        boolean resultsActive = FileExistsActive(VIN, "Vehicle.txt");
        boolean resultsInactive = FileExistsInactive(VIN, "Vehicle.txt");
        boolean resultsUnknown = FileExistsUnknown(VIN, "Vehicle.txt");
        
        EE333.Car tempCar = new EE333.Car();
        EE333.Cycle tempCycle = new EE333.Cycle();
        EE333.Truck tempTruck = new EE333.Truck();
        
        String vehicleContents = "";
        String vehicleClassification = "";
        
        if( resultsActive == true ) {
            // we need to read the file in the active folder
            java.io.File inputFile = new java.io.File(activeVINFolder.getAbsolutePath() + "\\" + "Vehicle.txt");
            
            vehicleContents = importString(inputFile);
            
            vehicleClassification = classificationIdentifier(vehicleContents);
            
            if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                tempCar = EE333.Car.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                tempCycle = EE333.Cycle.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                tempTruck = EE333.Truck.importCustom(vehicleContents);
            }
            
            if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                System.out.println( tempCar.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                System.out.println( tempCycle.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                System.out.println( tempTruck.exportCustom() );
            } else {
                System.out.println("Vehicle object is invalid!");
            }
            
        } else if ( resultsInactive == true ) {
            // we need to read the file in the inactive folder
            java.io.File inputFile = new java.io.File(inactiveVINFolder.getAbsolutePath() + "\\" + "Vehicle.txt");
            
            vehicleContents = importString(inputFile);
            
            vehicleClassification = classificationIdentifier(vehicleContents);
            
            if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                tempCar = EE333.Car.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                tempCycle = EE333.Cycle.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                tempTruck = EE333.Truck.importCustom(vehicleContents);
            }
            
            if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                System.out.println( tempCar.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                System.out.println( tempCycle.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                System.out.println( tempTruck.exportCustom() );
            } else {
                System.out.println("Vehicle object is invalid!");
            }
            
        } else if ( resultsUnknown == true ) {
            // we need to read the file in the unknown folder
            java.io.File inputFile = new java.io.File(unknownVINFolder.getAbsolutePath() + "\\" + "Vehicle.txt");
            
            vehicleContents = importString(inputFile);
            
            vehicleClassification = classificationIdentifier(vehicleContents);
            
            if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                tempCar = EE333.Car.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                tempCycle = EE333.Cycle.importCustom(vehicleContents);
            } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                tempTruck = EE333.Truck.importCustom(vehicleContents);
            }
            
            if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                System.out.println( tempCar.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                System.out.println( tempCycle.exportCustom() );
            } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                System.out.println( tempTruck.exportCustom() );
            } else {
                System.out.println("Vehicle object is invalid!");
            }
            
        } else {
            System.out.println("Vehicle does not exist!");
        }
    }
    
    public static void displayActive() {
        // cycle through the active folder and read all vehicle files
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
        java.io.File activeFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Active");
        
        EE333.Car tempCar = new EE333.Car();
        EE333.Cycle tempCycle = new EE333.Cycle();
        EE333.Truck tempTruck = new EE333.Truck();
        
        String vehicleContents = "";
        String vehicleClassification = "";
        
        java.io.File[] activeContents;
        
        activeContents = readDir(activeFolder);
        
        //cycle through contents, import, and print each file's contents
        if (activeContents != null) {
            for (java.io.File f : activeContents) {
                java.io.File inputFile = new java.io.File(f.getAbsolutePath() + "\\" + "Vehicle.txt");
                
                vehicleContents = importString(inputFile);
                
                vehicleClassification = classificationIdentifier(vehicleContents);

                if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                    tempCar = EE333.Car.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                    tempCycle = EE333.Cycle.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                    tempTruck = EE333.Truck.importCustom(vehicleContents);
                }

                if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                    System.out.println( tempCar.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                    System.out.println( tempCycle.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                    System.out.println( tempTruck.exportCustom() );
                } else {
                    System.out.println("Vehicle object is invalid!");
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }
        
        
    }
    
    public static void displayInactive() {
        // cycle through the inactive folder and read all vehicle files
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
        java.io.File inactiveFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Inactive");
        
        EE333.Car tempCar = new EE333.Car();
        EE333.Cycle tempCycle = new EE333.Cycle();
        EE333.Truck tempTruck = new EE333.Truck();
        
        String vehicleContents = "";
        String vehicleClassification = "";
        
        java.io.File[] inactiveContents;
        
        inactiveContents = readDir(inactiveFolder);
        //cycle through contents, import, and print each file's contents
        if (inactiveContents != null) {
            for( java.io.File f : inactiveContents) {
                java.io.File inputFile = new java.io.File(f.getAbsolutePath() + "\\" + "Vehicle.txt");
                
                vehicleContents = importString(inputFile);
                
                vehicleClassification = classificationIdentifier(vehicleContents);

                if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                    tempCar = EE333.Car.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                    tempCycle = EE333.Cycle.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                    tempTruck = EE333.Truck.importCustom(vehicleContents);
                }

                if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                    System.out.println( tempCar.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                    System.out.println( tempCycle.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                    System.out.println( tempTruck.exportCustom() );
                } else {
                    System.out.println("Vehicle object is invalid!");
                }
            }
            
        } else {
            System.out.println("Directory is empty!");
        }
    }
    
    public static void displayUnknownn() {
        // cycle through the unknown folder and read all vehicle files
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
        java.io.File unknownFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Unknown");
        
        EE333.Car tempCar = new EE333.Car();
        EE333.Cycle tempCycle = new EE333.Cycle();
        EE333.Truck tempTruck = new EE333.Truck();
        
        String vehicleContents = "";
        String vehicleClassification = "";
        
        java.io.File[] unknownContents;
        
        unknownContents = readDir(unknownFolder);
        
        //cycle through contents, import, and print each file's contents
        if (unknownContents != null) {
            for( java.io.File f : unknownContents) {
                java.io.File inputFile = new java.io.File(f.getAbsolutePath() + "\\" + "Vehicle.txt");
                
                vehicleContents = importString(inputFile);
                
                vehicleClassification = classificationIdentifier(vehicleContents);

                if (vehicleClassification.compareToIgnoreCase("car") == 0 ) {
                    tempCar = EE333.Car.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("cycle") == 0) {
                    tempCycle = EE333.Cycle.importCustom(vehicleContents);
                } else if ( vehicleClassification.compareToIgnoreCase("truck") == 0) {
                    tempTruck = EE333.Truck.importCustom(vehicleContents);
                }

                if ( (vehicleClassification.compareToIgnoreCase("car") == 0) && (tempCar != null) ) {
                    System.out.println( tempCar.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("cycle") == 0) && (tempCycle != null) ) {
                    System.out.println( tempCycle.exportCustom() );
                } else if ( (vehicleClassification.compareToIgnoreCase("truck") == 0) && (tempTruck != null) ) {
                    System.out.println( tempTruck.exportCustom() );
                } else {
                    System.out.println("Vehicle object is invalid!");
                }
            }
        } else {
            System.out.println("Directory is empty!");
        }
        
        
    }
    
    public static java.io.File[] readDir(java.io.File inputFile) {
        java.io.File[] contents = inputFile.listFiles();
        
        if (contents != null) {
            for (java.io.File f : contents) {
                System.out.println(f.getName());
            }
//            System.out.println("Contents of " + inputFile.toString() + " are not equal to null");
        } else {
            System.out.println("Directory is empty!");
        }
        
        return( contents );
    }
    
    public static boolean FileExistsUnknown( String VIN, String fileName ) {
        boolean results = false;
        
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
//        vehiclesFolder.mkdirs();
        java.io.File unknownFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Unknown");
//        unknownFolder.mkdirs();
        java.io.File VINFolder = new java.io.File(unknownFolder.getAbsolutePath() + "\\" + VIN);
//        VINFolder.mkdirs();
        java.io.File outputFile = new java.io.File(VINFolder.getAbsolutePath() + "\\" + fileName);
        
//        System.out.println(VINFolder.toString());
        
        if ( outputFile.exists() == true ) {
            results = true;
        } else {
            
        }
        
        return( results );
    }
    
    public static boolean FileExistsActive( String VIN, String fileName ) {
        boolean results = false;
        
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
//        vehiclesFolder.mkdirs();
        java.io.File activeFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Active");
//        unknownFolder.mkdirs();
        java.io.File VINFolder = new java.io.File(activeFolder.getAbsolutePath() + "\\" + VIN);
//        VINFolder.mkdirs();
        java.io.File outputFile = new java.io.File(VINFolder.getAbsolutePath() + "\\" + fileName);
        
//        System.out.println(VINFolder.toString());
        
        if ( outputFile.exists() == true ) {
            results = true;
        } else {
            
        }
        
        return( results );
    }
    
    public static boolean FileExistsInactive( String VIN, String fileName ) {
        boolean results = false;
        
        java.io.File vehiclesFolder = new java.io.File("..\\..\\Vehicles");
//        vehiclesFolder.mkdirs();
        java.io.File inactiveFolder = new java.io.File(vehiclesFolder.getAbsolutePath() + "\\" + "Inactive");
//        unknownFolder.mkdirs();
        java.io.File VINFolder = new java.io.File(inactiveFolder.getAbsolutePath() + "\\" + VIN);
//        VINFolder.mkdirs();
        java.io.File outputFile = new java.io.File(VINFolder.getAbsolutePath() + "\\" + fileName);
        
//        System.out.println(VINFolder.toString());
        
        if ( outputFile.exists() == true ) {
            results = true;
        } else {
            
        }
        
        return( results );
    }
    
    public static String classificationIdentifier( String customString ) {
        String results = "n/a";
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ){
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2) {
                if ( chunks[0].compareToIgnoreCase("classification") == 0 ) {
                    results = chunks[1];
                } else {
                    // do nothing
                }
            } else {
                // do nothing
            }
        }
        
        
        
        return (results);
    }
    
    private static String importString( java.io.File inputFile ) {
        String results = "";
        String line = "";
        java.io.FileReader inputFileReader;
        java.io.BufferedReader inputBufferedReader;       
        
        try {
            if (inputFile.exists() == true) {
                inputFileReader = new java.io.FileReader(inputFile);
                inputBufferedReader = new java.io.BufferedReader(inputFileReader);
                
                while ((line = inputBufferedReader.readLine()) != null) {
                    results += line + '\n'; // appends the contents line by line.
                }
                
                inputBufferedReader.close();
            } else {
                results = "";
            }
        } catch (java.lang.Exception ex) {
            System.out.println( ex.toString() );
        }
        
        return( results );
    } 
    
}
