package EE333;

/**
 * File: InsuranceInfo.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class InsuranceInfo {
    private String policyNumber;
    private String expirationDate;
    private String firstName;
    private String lastName;
    
    public InsuranceInfo() {
        this.policyNumber = "";
        this.expirationDate = "";
        this.firstName = "";
        this.lastName = "";
    }
    
    public InsuranceInfo( String policyNumber, String expirationDate, String firstName, String lastName ) {
        
        this.policyNumber = "";
        this.expirationDate = "";
        this.firstName = "";
        this.lastName = "";

        if(policyNumber == null) {
            this.policyNumber = "";
        } else {
            this.policyNumber = policyNumber;
        }
        
        if(expirationDate == null) {
            this.expirationDate = "";
        } else {
            this.expirationDate = expirationDate;
        }
        
        if(firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
        
        if(lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
        
//        if ((policyNumber == null) || (policyNumber.length() == 0)) {
//            this.policyNumber = "";
//            this.expirationDate = "";
//            this.firstName = "";
//            this.lastName = "";
//        } else if ((expirationDate == null) || (expirationDate.length() == 0)) {
//            this.policyNumber = "";
//            this.expirationDate = "";
//            this.firstName = "";
//            this.lastName = "";
//        } else if ((firstName == null) || (firstName.length() == 0)) {
//            this.policyNumber = "";
//            this.expirationDate = "";
//            this.firstName = "";
//            this.lastName = "";
//        } else if ((lastName == null) || (lastName.length() == 0)) {
//            this.policyNumber = "";
//            this.expirationDate = "";
//            this.firstName = "";
//            this.lastName = "";
//        } else {
//            this.policyNumber = policyNumber;
//            this.expirationDate = expirationDate;
//            this.firstName = firstName;
//            this.lastName = lastName;
//        }
    }

    /**
     * @return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @return the expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     * Only needed if the insurance has been renewed with the same policy number
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public static InsuranceInfo importCustom( String customString ) {
        InsuranceInfo tempInsuranceInfo = null;
        String policyNumber = "";
        String expirationDate = "";
        String firstName = "";
        String lastName = "";
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {
                if ( chunks[0].compareToIgnoreCase("policyNumber") == 0 ){
                    policyNumber = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("expirationDate") == 0 ) {
                    expirationDate = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("firstName") == 0 ) {
                    firstName = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("lastName") == 0 ) {
                    lastName = chunks[1];
                }
            }
        }
        
        if (( policyNumber.length() > 0 ) && ( expirationDate.length() > 0 ) && ( firstName.length() > 0 ) && ( lastName.length() > 0 )) {
            tempInsuranceInfo = new InsuranceInfo(policyNumber, expirationDate, firstName, lastName);
        } else {
            tempInsuranceInfo = new InsuranceInfo();
        }
        
        return( tempInsuranceInfo );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "PolicyNumber: " + this.policyNumber + '\n';
        output += "ExpirationDate: " + this.expirationDate + '\n';
        output += "FirstName: " + this.firstName + '\n';
        output += "LastName: " + this.lastName + '\n';
        
        return( output );
    }
}
