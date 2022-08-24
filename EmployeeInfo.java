package EE333;

/**
 * File: EmployeeInfo.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class EmployeeInfo {

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
    private String ID;
    private String FirstName;
    private String LastName;
    private EE333.Status status;

    public EmployeeInfo() {
        this.status = EE333.Status.unknown;
        this.ID = "";
        this.FirstName = "";
        this.LastName = "";
    }
    
    public EmployeeInfo(String ID, String FirstName, String LastName) {
        
        this.status = EE333.Status.unknown;
        this.ID = "";
        this.FirstName = "";
        this.LastName = "";
        
        if((ID != null) && ( ID.length() > 0 )) {
            this.ID = ID;
            this.status = EE333.Status.active;
        } else {
            this.ID = "";
        }
        
        if(FirstName == null) {
            this.FirstName = "";
        } else {
            this.FirstName = FirstName;
        }
        
        if(LastName == null) {
            this.LastName = "";
        } else {
            this.LastName = LastName;
        }
        
//        if ((ID == null) || (ID.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//        } else if ((FirstName == null) || (FirstName.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//        } else if ((LastName == null) || (LastName.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//        } else { // we have all valid values
//            this.status = EE333.Status.active;
//            this.ID = ID;
//            this.FirstName = FirstName;
//            this.LastName = LastName;
//        }
    }
    
    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public static EmployeeInfo importCustom( String customString ) {
        EmployeeInfo tempEmployeeInfo = null;
        String ID = "";
        String firstName = "";
        String lastName = "";
        
        EE333.Status status = EE333.Status.unknown;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ){
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {
                if ( chunks[0].compareToIgnoreCase("ID") == 0 ) {
                    ID = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("firstName") == 0 ) {
                    firstName = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("lastName") == 0 ) {
                    lastName = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("status") == 0 ) {
                    try {
                     status = EE333.Status.valueOf(chunks[1]);   
                    } catch ( java.lang.IllegalArgumentException ex) {
                     status = EE333.Status.unknown;   
                    }  
                } else {
                    // do nothing 
                }
            } else {
                // ignore it
            }
        }
        
        if (( ID.length() > 0 ) && ( firstName.length() > 0 ) && ( lastName.length() > 0 )) {
            tempEmployeeInfo = new EmployeeInfo(ID, firstName, lastName);
        } else {
            tempEmployeeInfo = new EmployeeInfo();
        }
        
        tempEmployeeInfo.status = status;
        
        return( tempEmployeeInfo );
    }
    public String exportCustom() {
        String output = "";
        
        output += "ID: " + this.ID + '\n';
        output += "FirstName: " + this.FirstName + '\n';
        output += "LastName: " + this.LastName + '\n';
        output += "Status: " + this.status + '\n';
        
        return( output );
    }
}


