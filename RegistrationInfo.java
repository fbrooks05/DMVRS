package EE333;

/**
 * File: RegistrationInfo.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class RegistrationInfo {
    private String regID;
    private String policyNumber;
    private String VIN;
    private String tagExpires;
    private String tagNumber;
    private double salesTax;
    private double adValTax;
    
    public RegistrationInfo() {
        // change to RegID, PolicyNumber, VIN;
        this.regID = "";
        this.policyNumber = "";
        this.VIN = "";
        this.tagExpires = "";
        this.tagNumber = "";
        this.salesTax = 0.0;
        this.adValTax = 0.0;
    }
    
    // public RegistrationInfo( EE333.Registrant registrant, EE333.InsuranceInfo insuranceInfo, EE333.Car car, String tagExpires, String tagNumber, double salesTax, double adValTax ) {}
    public RegistrationInfo( String regID, String policyNumber, String VIN, String tagExpires, String tagNumber, double salesTax, double adValTax ) {
        this.regID = "";
        this.policyNumber = "";
        this.VIN = "";
        this.tagExpires = "";
        this.tagNumber = "";
        this.salesTax = 0.0;
        this.adValTax = 0.0;
        
        if (regID == null) {
            this.regID = "";
        } else {
            this.regID = regID;
        }
        
        if (policyNumber == null) {
            this.policyNumber = "";
        } else {
            this.policyNumber = policyNumber;
        }
        
        if (VIN != null) {
            this.VIN = VIN;
        }
        
        if (tagExpires != null) {
            this.tagExpires = tagExpires;
        }
        
        if (tagNumber != null) {
            this.tagNumber = tagNumber;
        }
        
        this.salesTax = salesTax;
        this.adValTax = adValTax;
        
//        if ((regID == null) && (regID.length() == 0)) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if ((policyNumber == null) && (policyNumber.length() == 0)) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if ((VIN == null) && (VIN.length() == 0)) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if ((tagExpires == null) || (tagExpires.length() == 0)) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if ((tagNumber == null) || (tagExpires.length() == 0)) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if (salesTax == 0.0) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else if (adValTax == 0.0) {
//            this.regID = "";
//            this.policyNumber = "";
//            this.VIN = "";
//            this.tagExpires = "";
//            this.tagNumber = "";
//            this.salesTax = 0.0;
//            this.adValTax = 0.0;
//        } else { // we have a valid registrant
//            this.regID = regID;
//            this.policyNumber = policyNumber;
//            this.VIN = VIN;
//            this.tagExpires = tagExpires;
//            this.tagNumber = tagNumber;
//            this.salesTax = salesTax;
//            this.adValTax = adValTax;
//        }
    }

    

    /**
     * @return the tagExpires
     */
    public String getTagExpires() {
        return tagExpires;
    }

    /**
     * @param tagExpires the tagExpires to set
     */
    public void setTagExpires(String tagExpires) {
        this.tagExpires = tagExpires;
    }

    /**
     * @return the tagNumber
     */
    public String getTagNumber() {
        return tagNumber;
    }

    /**
     * @return the salesTax
     */
    public double getSalesTax() {
        return salesTax;
    }

    /**
     * @param salesTax the salesTax to set
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * @return the adValTax
     */
    public double getAdValTax() {
        return adValTax;
    }

    /**
     * @param adValTax the adValTax to set
     */
    public void setAdValTax(double adValTax) {
        this.adValTax = adValTax;
    }
    
    public static RegistrationInfo importCustom( String customString ) {
        RegistrationInfo tempRegistrationInfo = null;
        String regID = "";
        String policyNumber = "";
        String VIN = "";
        String tagExpires = "";
        String tagNumber = "";
        double salesTax = 0.0;
        double adValTax = 0.0;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ){
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {
                if ( chunks[0].compareToIgnoreCase("tagExpires") == 0 ) {
                    tagExpires = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("tagNumber") == 0 ) {
                    tagNumber = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("salesTax") == 0 ) {
                    try {
                        salesTax = Double.parseDouble(chunks[1]);
                    } catch (NumberFormatException ex) {
                        salesTax = 0.0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("adValTax") == 0 ){
                    try {
                        adValTax = Double.parseDouble(chunks[1]);
                    } catch (NumberFormatException ex) {
                        adValTax = 0.0;
                    }
                    
                } else if ( chunks[0].compareToIgnoreCase("regID") == 0 ){
                    regID = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("policyNumber") == 0 ){
                    policyNumber = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("VIN") == 0 ){
                    VIN = chunks[1];
                } else {
                    // ignore it
                }
            } else {
                // ignore it
            }
        }
        
        if (( tagExpires.length() > 0 ) && ( tagNumber.length() > 0 ) && ( salesTax > 0.0 ) && ( adValTax > 0.0 )) {
            tempRegistrationInfo = new RegistrationInfo(regID, policyNumber, VIN, tagExpires, tagNumber, salesTax, adValTax);
//            System.out.println("Good reg info");
        } else {
            tempRegistrationInfo = new RegistrationInfo();
//            System.out.println("bad reg info");
        }
        
        return( tempRegistrationInfo );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "regID: " + this.regID + '\n';
        output += "policyNumber: " + this.policyNumber + '\n';
        output += "VIN: " + this.VIN + '\n';
        output += "TagExpires: " + this.tagExpires + '\n';
        output += "TagNumber: " + this.tagNumber + '\n';
        output += "SalesTax: " + this.salesTax + '\n';
        output += "AdValTax: " + this.adValTax + '\n';
        
        
        return( output );
    }

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @return the VIN
     */
    public String getVIN() {
        return VIN;
    }
    
}
