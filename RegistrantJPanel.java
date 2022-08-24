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
public class RegistrantJPanel extends javax.swing.JPanel {

    private Registrant registrant;
    
    public EE333.Registrant getRegistrant() {
        return( this.registrant );
    }
    
    public void setRegistrant( EE333.Registrant registrant ) {
        this.registrant = registrant;
    }
    
    /**
     * Creates new form RegistrantJPanel
     */
    public RegistrantJPanel() {
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
        
        this.registrant = EE333.Registrant.importCustom(customString);
        
        if(this.registrant.getStatus() == EE333.Status.unknown) {
            this.jTextID.setText("");
            this.jTextFirstname.setText("");
            this.jTextLastname.setText("");
             this.contactInfoJpanel1.updateControls();
            
            this.jComboStatus.setSelectedItem(this.registrant.getStatus());
            results = false;
        } else {
//             we need to update our GUI...
            this.jTextID.setText(this.registrant.getID());
            this.jTextFirstname.setText(this.registrant.getFirstName());
            this.jTextLastname.setText(this.registrant.getLastName());
            this.contactInfoJpanel1.updateControls();
            this.jComboStatus.setSelectedItem( this.registrant.getStatus());
            
            this.contactInfoJpanel1.setContactInfo(this.registrant.getContactInfo());
            this.contactInfoJpanel1.updateControls();
            
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
        
        this.jTextID.setText( this.registrant.getID() );
        this.jTextFirstname.setText( this.registrant.getFirstName() );
        this.jTextLastname.setText( this.registrant.getLastName() );
        this.jComboStatus.setSelectedItem( this.registrant.getStatus() );
        
        return( results );
    }
    
    public boolean updateUnderlyingObject() {
        boolean results = true;
        EE333.ContactInfo tempContactInfo = new EE333.ContactInfo();
        contactInfoJpanel1.updateUnderlyingObject(); // adds information to contactInfo from the fields
        tempContactInfo = this.contactInfoJpanel1.getContactInfo();
        
        // need way to set ID wihtout using a setter
        this.registrant = new Registrant( jTextID.getText(), jTextFirstname.getText(), jTextLastname.getText(), tempContactInfo);
        this.registrant.setStatus( EE333.Status.valueOf( this.jComboStatus.getSelectedItem().toString()) );
//        this.registrant.setFirstName( this.jTextFirstname.getText() );
//        this.registrant.setLastName( this.jTextLastname.getText() );
        
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
        jTextID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFirstname = new javax.swing.JTextField();
        jTextLastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox<>();
        contactInfoJpanel1 = new EE333.ContactInfoJpanel();

        jLabel1.setText("Registrant");

        jLabel2.setText("ID");

        jLabel3.setText("FirstName");

        jLabel4.setText("LastName");

        jLabel5.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextID, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jTextFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jTextLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jComboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(contactInfoJpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactInfoJpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EE333.ContactInfoJpanel contactInfoJpanel1;
    private javax.swing.JComboBox<String> jComboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFirstname;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextLastname;
    // End of variables declaration//GEN-END:variables
}
