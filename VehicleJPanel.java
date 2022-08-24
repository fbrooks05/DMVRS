/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE333;

/**
 *
 * @author Brooks
 */
public class VehicleJPanel extends javax.swing.JPanel {

    private EE333.Vehicle vehicle;
    private EE333.Motor tempMotor;
    EE333.Cycle tempCycle = new EE333.Cycle();
    EE333.Car tempCar = new EE333.Car();
    EE333.Truck tempTruck = new EE333.Truck();
    
    public String returnVehicleVIN() {
        return( this.jTextVIN.getText() );
    }
    
    public String returnVehicleStatus() {
        return(  this.jComboStatus.getSelectedItem().toString() );
    }
    
    public String getVin() {
        return( this.vehicle.getVIN() );
    }
    
    public EE333.Vehicle getVehicle() {
        return( this.vehicle );
    }
    
    public void setVehicle( EE333.Vehicle vehicle ) {
        this.vehicle = vehicle;
    }
    
    public EE333.Cycle getTempCycle() {
        return( this.tempCycle );
    }
    
    public EE333.Car getTempCar() {
        return( this.tempCar );
    }
    
    public EE333.Truck getTempTruck() {
        return( this.tempTruck );
    }
    
    public String getType() {
        return( this.jTextType.getText() );
    }
    
    /**
     * Creates new form VehicleJPanel
     */
    public VehicleJPanel() {
        initComponents();
        java.io.File InputFile;
        
        this.jComboStatus.removeAllItems();
        for (Status status : EE333.Status.values() ) {
            this.jComboStatus.addItem( status.toString() );
            
        }
        
        InputFile = new java.io.File("sample.user");
        this.importCustom(InputFile); 
    }
    
     public boolean importCustom( java.io.File customFile ) {
        // accept a .user file
        boolean results = true;
        String contents = "";
        
        contents = importString(customFile);
        if (contents == "" ) {
            // this means no string was found ( or no file was found )
            results = false;
        } else {
            // we want to parse the contents of the file...
            if (importCustom(contents) == false) {
                results = false;
            } else {
                results = true; // we need to update our GUI (potentially)
            }
        }
        
        return( results );
    } 
     
    public boolean importCustom( String customString ) {
        boolean results = true;
        String classification = classificationIdentifier(customString);
        // User tempUser;
        
        this.vehicle = EE333.Vehicle.importCustom(customString);
        
        // something isn't right with the motor
        this.tempMotor = EE333.Motor.importCustom(customString);
        
        if (classification.compareToIgnoreCase("car") == 0 ) {
            this.tempCar = EE333.Car.importCustom(customString);
        } else if ( classification.compareToIgnoreCase("cycle") == 0) {
            this.tempCycle = EE333.Cycle.importCustom(customString);
        } else if ( classification.compareToIgnoreCase("truck") == 0) {
            this.tempTruck = EE333.Truck.importCustom(customString);
        }
        
        if(this.vehicle.getStatus() == EE333.Status.unknown) {
            
            this.jTextVIN.setText( "" );
            this.jTextMake.setText( "" );
            this.jTextModel.setText( "" );
            this.jTextSubModel.setText( "" );
            this.jTextYear.setText( "" );
            this.jTextColor.setText( "" );
            this.jTextWeight.setText( "" );
            
            this.jComboStatus.setSelectedItem(this.vehicle.getStatus());
            results = false;
            
        } else {
            
//            updateUnderlyingObject();
            updateControls();
            
            this.jComboStatus.setSelectedItem(this.vehicle.getStatus());
            
            this.jTextType.setText(classification);
            
            if (classification.compareToIgnoreCase("car") == 0 ) {
                this.carJPanel2.updateControls(tempCar);
            } else if ( classification.compareToIgnoreCase("cycle") == 0) {
                this.cycleJPanel2.updateControls(tempCycle);
            } else if ( classification.compareToIgnoreCase("truck") == 0) {
                this.truckJPanel2.updateControls(tempTruck);
            }
            
            this.motorJPanel1.updateControls(tempMotor);
            
            results = true;
        }
        
        return( results );
    }
     
    public String classificationIdentifier( String customString ) {
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
    
    private String importString( java.io.File inputFile ) {
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
                // check chunks for type: car/truck/cycle!!!
                
                inputBufferedReader.close();
            } else {
                results = "";
            }
        } catch (java.lang.Exception ex) {
            System.out.println( ex.toString() );
        }
        
        return( results );
    } 
    
    public boolean updateControls() {
        boolean results = true;
        
        this.jTextVIN.setText( this.vehicle.getVIN() );
        this.jTextMake.setText( this.vehicle.getMake() );
        this.jTextModel.setText( this.vehicle.getModel() );
        this.jTextSubModel.setText( this.vehicle.getSubModel() );
        this.jTextYear.setText( String.valueOf( this.vehicle.getYear() ));
        this.jTextColor.setText( this.vehicle.getColor() );
        this.jTextWeight.setText( String.valueOf( this.vehicle.getWeight() ));
        
        
//        this.jTextType.setText( this.vehicle.get);
        
        return( results );
    }
    
    public boolean updateUnderlyingObject() {
        boolean results = true;
        int year = 0;
        int weight = 0;
        
        EE333.Motor tempMotor = new EE333.Motor();
        motorJPanel1.updateUnderlyingObject();
        tempMotor = this.motorJPanel1.getMotor();
        
        // add try catches
        
        try {
            weight = Integer.parseInt(jTextWeight.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
            weight = 0;
        }
        
        try {
            year = Integer.parseInt(jTextYear.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
            year = 0;
        }
        
        this.vehicle = new Vehicle(jTextVIN.getText(), jTextMake.getText(), jTextModel.getText(), jTextSubModel.getText(), year, jTextColor.getText(), weight, tempMotor);
        
        this.vehicle.setStatus( EE333.Status.valueOf( this.jComboStatus.getSelectedItem().toString() ) );
        
        if ( this.jTextType.getText().compareToIgnoreCase("Cycle") == 0 ) {
            
            cycleJPanel2.updateUnderlyingObject();
        
            tempCycle = new Cycle(vehicle, cycleJPanel2.getWheelCount()); 
        
        } else if ( this.jTextType.getText().compareToIgnoreCase("car") == 0 ) {
            // must be a car
            
            carJPanel2.updateUnderlyingObject();
            
            tempCar = new Car(vehicle, carJPanel2.getWheelCount(), carJPanel2.getDoorCount() );
            
        } else if ( this.jTextType.getText().compareToIgnoreCase("truck") == 0 ) {
            
            truckJPanel2.updateUnderlyingObject();
            
            tempTruck = new Truck(vehicle, truckJPanel2.getDoorCount(), truckJPanel2.getPayload(), truckJPanel2.getWheelCount() );
            
        } else {
            
        }
        
        // need a way to set the VIN without a setter
        // need a way to set make/model without a setter
        
//        this.vehicle.setSubModel( this.jTextSubModel.getText() );
//        this.vehicle.setYear( Integer.valueOf( this.jTextYear.getText() ));
//        this.vehicle.setColor( this.jTextColor.getText() );
//        this.vehicle.setWeight( Integer.valueOf( this.jTextWeight.getText() ));
        
        return( results );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextVIN = new javax.swing.JTextField();
        jTextMake = new javax.swing.JTextField();
        jTextModel = new javax.swing.JTextField();
        jTextSubModel = new javax.swing.JTextField();
        jTextWeight = new javax.swing.JTextField();
        jTextType = new javax.swing.JTextField();
        jTextColor = new javax.swing.JTextField();
        jTextYear = new javax.swing.JTextField();
        motorJPanel1 = new EE333.MotorJPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        carJPanel2 = new EE333.CarJPanel();
        jPanel2 = new javax.swing.JPanel();
        cycleJPanel2 = new EE333.CycleJPanel();
        jPanel3 = new javax.swing.JPanel();
        truckJPanel2 = new EE333.TruckJPanel();

        jLabel1.setText("VIN");

        jLabel2.setText("Make");

        jLabel3.setText("Model");

        jLabel4.setText("Year");

        jLabel5.setText("Color");

        jLabel6.setText("Submodel");

        jLabel7.setText("Weight");

        jLabel8.setText("Type");

        jLabel9.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Car", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cycleJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cycleJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cycle", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(truckJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(truckJPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Truck", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextMake, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextModel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextSubModel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextType, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(motorJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextMake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextSubModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motorJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EE333.CarJPanel carJPanel2;
    private EE333.CycleJPanel cycleJPanel2;
    private javax.swing.JComboBox<String> jComboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextColor;
    private javax.swing.JTextField jTextMake;
    private javax.swing.JTextField jTextModel;
    private javax.swing.JTextField jTextSubModel;
    private javax.swing.JTextField jTextType;
    private javax.swing.JTextField jTextVIN;
    private javax.swing.JTextField jTextWeight;
    private javax.swing.JTextField jTextYear;
    private EE333.MotorJPanel motorJPanel1;
    private EE333.TruckJPanel truckJPanel2;
    // End of variables declaration//GEN-END:variables
}
