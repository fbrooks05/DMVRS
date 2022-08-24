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
public class CarJPanel extends javax.swing.JPanel {
    
    private int wheelCount;
    private int doorCount;
    private EE333.Car car;
    
    public EE333.Car getCar() {
      return(this.car);
      
    }
    
    public int getWheelCount() {
        return( this.wheelCount );
    }
    
    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }
    
    /**
     * @return the doorCount
     */
    public int getDoorCount() {
        return doorCount;
    }

    /**
     * @param doorCount the doorCount to set
     */
    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    /**
     * Creates new form CarJPanel
     */
    public CarJPanel() {
        initComponents();
    }
    
    
    public boolean updateControls() {
    boolean results = true;
    
    // take values from the car to update GUI controls
    this.jTextWheelCount.setText( String.valueOf(this.car.getWheelCount()) );
    this.jTextDoorCount.setText( String.valueOf(this.car.getDoorCount()) );
    
    
    return(results);
    }
    
    public boolean updateControls(EE333.Car tempCar) {
    boolean results = true;
    
    this.car = tempCar;
    
    // take values from the car to update GUI controls
    this.jTextDoorCount.setText( String.valueOf(this.car.getDoorCount()) );
    this.jTextWheelCount.setText( String.valueOf(this.car.getWheelCount()) );
    
    return(results);
    }
    
    public boolean updateUnderlyingObject() {
        boolean results = true;
        
        int wheelCount = 0;
        int doorCount = 0;
        
        try {
            wheelCount = Integer.parseInt( jTextWheelCount.getText() );
        } catch ( NumberFormatException ex ) {
            System.out.println(ex.toString());
            wheelCount = 0;
        }
        
        try {
            doorCount = Integer.parseInt( jTextDoorCount.getText() );
        } catch ( NumberFormatException ex ) {
            System.out.println(ex.toString());
            doorCount = 0;
        }
        
        this.setWheelCount( wheelCount );
        this.setDoorCount( doorCount );
        
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
        jTextWheelCount = new javax.swing.JTextField();
        jTextDoorCount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("WheelCount");

        jLabel2.setText("DoorCount");

        jLabel3.setText("Car Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextWheelCount, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDoorCount, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextWheelCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextDoorCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextDoorCount;
    private javax.swing.JTextField jTextWheelCount;
    // End of variables declaration//GEN-END:variables

    
}