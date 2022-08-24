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
public class MotorJPanel extends javax.swing.JPanel {

    private Motor motor;
    
    public EE333.Motor getMotor() {
        return( this.motor );
    }
    
    public void setMotor( EE333.Motor motor ) {
        this.motor = motor;
    }
    
    /**
     * Creates new form MotorJPanel
     */
    public MotorJPanel() {
        initComponents();
        
        this.jComboType.removeAllItems();
        for (MotorType type : EE333.MotorType.values() ) {
            this.jComboType.addItem( type.toString() );
            
        }
        
        
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
        // User tempUser;
        
        this.motor = EE333.Motor.importCustom(customString);
        
        if(this.motor.getMotorType()== EE333.MotorType.unknown) {
            
            this.jComboType.setSelectedItem(this.motor.getMotorType());
            results = false;
        } else {
            
            this.jComboType.setSelectedItem( this.motor.getMotorType());
            
            this.jTextHP.setText(String.valueOf(this.motor.getHP()));
            this.jTextTorque.setText(String.valueOf(this.motor.getTorque()));
            this.jTextOrientation.setText(this.motor.getOrientation());
            this.jTextCylinders.setText(String.valueOf(this.motor.getCylinders()));
            
            results = true;
        }
        
        return( results );
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
//        int torque = 0;
//        int hp = 0;
//        int cylinders = 0;
        
        this.jTextTorque.setText( String.valueOf( this.motor.getTorque() ));
        this.jTextHP.setText( String.valueOf( this.motor.getHP() ) );
        this.jComboType.setSelectedItem( this.motor.getMotorType() );
        this.jTextCylinders.setText( String.valueOf( this.motor.getCylinders() ));
        this.jTextOrientation.setText( this.motor.getOrientation() );
        
        return( results );
    }
    
    public boolean updateControls( EE333.Motor tempMotor ) {
        boolean results = true;
//        int torque = 0;
//        int hp = 0;
//        int cylinders = 0;

        this.motor = tempMotor;
        
        this.jTextTorque.setText( String.valueOf( this.motor.getTorque() ));
        this.jTextHP.setText( String.valueOf( this.motor.getHP() ) );
        this.jComboType.setSelectedItem( this.motor.getMotorType() );
        this.jTextCylinders.setText( String.valueOf( this.motor.getCylinders() ));
        this.jTextOrientation.setText( this.motor.getOrientation() );
        
        return( results );
    }
    
    public boolean updateUnderlyingObject() {
        boolean results = true;
        int hp = 0;
        int torque = 0;
        int cylinders = 0;
        
        try {
            hp = Integer.valueOf( this.jTextHP.getText() );
        } catch ( NumberFormatException ex ) {
            System.out.println(ex.toString());
            hp = 0;
        }
        
        try {
            torque = Integer.valueOf( this.jTextTorque.getText() );
        } catch ( NumberFormatException ex ) {
            System.out.println(ex.toString());
            torque = 0;
        }
        
        try {
            cylinders = Integer.valueOf( this.jTextCylinders.getText() );
        } catch ( NumberFormatException ex ) {
            System.out.println(ex.toString());
            cylinders = 0;
        }
        
//        this.motor.setTorque( Integer.valueOf( this.jTextTorque.getText() ) );
//        this.motor.setHP( Integer.valueOf( this.jTextTorque.getText() ));
        // need to set type with out using setType()!
        
        
        
        this.motor = new Motor(hp , torque, EE333.MotorType.valueOf( this.jComboType.getSelectedItem().toString() ), cylinders, this.jTextOrientation.getText() );
        
        
        
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
        jTextTorque = new javax.swing.JTextField();
        jTextHP = new javax.swing.JTextField();
        jTextCylinders = new javax.swing.JTextField();
        jTextOrientation = new javax.swing.JTextField();
        jComboType = new javax.swing.JComboBox<>();

        jLabel1.setText("Motor");

        jLabel2.setText("Torque");

        jLabel3.setText("HP");

        jLabel4.setText("Type");

        jLabel5.setText("Cylinders");

        jLabel6.setText("Orientation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextTorque)
                    .addComponent(jTextHP, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jTextCylinders, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jTextOrientation, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jComboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextTorque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextCylinders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextCylinders;
    private javax.swing.JTextField jTextHP;
    private javax.swing.JTextField jTextOrientation;
    private javax.swing.JTextField jTextTorque;
    // End of variables declaration//GEN-END:variables
}
