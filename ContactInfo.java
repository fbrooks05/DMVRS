package EE333;

/**
 * File: ContactInfo.java
 * Author: Fisher Brooks
 * Assignment: DMVRS EE333 Spring 2021
 * 
 * Vers: 1.0.0 05/28/2021 - initial coding
 * 
 */
public class ContactInfo {
    private String address;
    private String city;
    private String state; // 2 letter or full name
    private String zip;
    private String email;
    private String phoneNumber; // consider changing to another more specific class.
    
    public ContactInfo() {
        // set all default values.
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.email = "";
        this.phoneNumber = "";
    }
    
    public ContactInfo( String address, String city, String state, String zip, String email, String phoneNumber) {
        
        if ((address == null) || (address.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else if ((city == null) || (city.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else if ((state == null) || (city.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else if ((zip == null) || (zip.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else if ((email == null) || (email.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else if ((phoneNumber == null) || (phoneNumber.length() == 0)) {
            this.address = "";
            this.city = "";
            this.state = "";
            this.zip = "";
            this.email = "";
            this.phoneNumber = "";
        } else { // we have all valid values
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return (this.address); // return address
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public static ContactInfo importCustom( String customString ) {
        ContactInfo tempContactInfo = null; 
        String address = "";
        String city = "";
        String state = "";
        String zip = "";
        String email = "";
        String phoneNumber = "";
        
        String[] lines;
        String[] chunks;
        
        lines = customString.split("\n");
        for( int index = 0; index < lines.length; index++ ) {
            chunks = lines[index].split(": ");
            if( chunks.length == 2) {
                if( chunks[0].compareToIgnoreCase("address") == 0) {
                    // we have found the address
                    address = chunks[1];
                } else if (chunks[0].compareToIgnoreCase("city") == 0) {
                    city = chunks[1];
                } else if (chunks[0].compareToIgnoreCase("state") == 0) {
                    state = chunks[1];
                } else if (chunks[0].compareToIgnoreCase("zip") == 0) {
                    zip = chunks[1];
                } else if (chunks[0].compareToIgnoreCase("email") == 0) {
                    email = chunks[1];
                } else if (chunks[0].compareToIgnoreCase("phoneNumber") == 0 ) {
                    phoneNumber = chunks[1];
                } else {
                    // we ignore it
                }
                
            } else {
                // we ignore it
            }
        }
        
        if ((address.length() > 0) && (city.length() > 0) && (state.length() > 0) && (zip.length() > 0) && (email.length() > 0) && (phoneNumber.length() > 0)) {
            tempContactInfo = new ContactInfo(address, city, state, zip, email, phoneNumber);
        } else {
            tempContactInfo = new ContactInfo();
        }
        
        return( tempContactInfo );
    }
    
    public String exportCustom() {
        String output = "";
        
        output += "address: " + this.address + '\n';
        output += "city: " + this.city + '\n';
        output += "state: " + this.state + '\n';
        output += "zip: " + this.zip + '\n';
        output += "email: " + this.email + '\n';
        output += "phoneNumber: " + this.phoneNumber + '\n';
        
        
        return( output );
    
    }
      
    public String toCSV() {
        String output = "";
        
        output += this.address + ",";
        output += this.city + ",";
        output += this.state + ",";
        output += this.zip + ",";
        output += this.email + ",";
        output += this.phoneNumber + 'n';
        
        return ( output );

    }
}
