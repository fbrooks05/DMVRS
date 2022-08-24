package EE333;

/**
 * File: Registrant.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class Registrant {

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
    private EE333.ContactInfo contactInfo;
    private EE333.Status status;
    
    public Registrant() {
        this.status = EE333.Status.unknown;
        this.ID = "";
        this.FirstName = "";
        this.LastName = "";
        this.contactInfo = new EE333.ContactInfo();
    }
    
    public Registrant( String ID, String FirstName, String LastName, EE333.ContactInfo contactInfo ) {
        this.status = EE333.Status.unknown;
        this.ID = "";
        this.FirstName = "";
        this.LastName = "";
        this.contactInfo = new EE333.ContactInfo();
        
        if (ID == null) {
            this.ID = "";
        } else {
            this.ID = ID;
            this.status = EE333.Status.valid;
        }
        
        if (FirstName == null) {
            this.FirstName = "";
        } else {
            this.FirstName = FirstName;
        }
        
        if (LastName == null) {
            this.LastName = "";
        } else {
            this.LastName = LastName;
        }
        
        this.contactInfo = contactInfo;
//        if ((ID == null) || (ID.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//            this.contactInfo = new EE333.ContactInfo();
//        } else if ((FirstName == null) || (LastName.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//            this.contactInfo = new EE333.ContactInfo();
//        } else if ((LastName == null) || (LastName.length() == 0)) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//            this.contactInfo = new EE333.ContactInfo();
//        } else if (contactInfo == new EE333.ContactInfo() ) {
//            this.status = EE333.Status.unknown;
//            this.ID = "";
//            this.FirstName = "";
//            this.LastName = "";
//            this.contactInfo = new EE333.ContactInfo();
//        } else { // we have a valid registrant
//            this.status = EE333.Status.active;
//            this.ID = ID;
//            this.FirstName = FirstName;
//            this.LastName = LastName;
//            this.contactInfo = contactInfo;
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

    /**
     * @return the contactInfo
     */
    public EE333.ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(EE333.ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public static Registrant importCustom( String customString ) {
        Registrant tempRegistrant = null;
        ContactInfo tempContactInfo = null;
        String ID = "";
        String FirstName = "";
        String LastName = "";
        Status status = EE333.Status.unknown;
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[ index ].split(": ");
            if ( chunks.length == 2 ) {// 2 pieces of info per line; label: value;
                if ( chunks[0].compareToIgnoreCase("ID") == 0 ) {
                    ID = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("firstName") == 0 ) {
                    FirstName = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("lastName") == 0 ) {
                    LastName = chunks[1];
                } else if ( chunks[0].compareToIgnoreCase("status") == 0 ) {
                    //
                    try {
                        status = EE333.Status.valueOf(chunks[1]);   
                    } catch ( java.lang.IllegalArgumentException ex) {
                        status = EE333.Status.unknown;   
                    }
                } else {
                    // we ignore it;
                }
            } else {
                // we ignore it;
            }
        }
        
        tempContactInfo = EE333.ContactInfo.importCustom(customString);
        
        if (( ID.length() > 0 ) && ( FirstName.length() > 0 ) && ( LastName.length() > 0 )) {
            tempRegistrant = new Registrant(ID, FirstName, LastName, tempContactInfo);
        } else { 
            tempRegistrant = new Registrant();
        }
        
        tempRegistrant.setStatus(status);
        
        return( tempRegistrant );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "ID: " + this.ID + '\n';
        output += "FirstName: " + this.FirstName + '\n';
        output += "LastName: " + this.LastName + '\n';
        output += this.contactInfo.exportCustom();
        output += "Status: " + this.status.toString() + '\n';
        
        
        return( output );
    }
    
}


