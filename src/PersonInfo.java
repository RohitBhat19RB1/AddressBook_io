public class PersonInfo {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String number;

    public PersonInfo(String firstname, String lastname, String address, String city,String state,String zip,String number){
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.number=number;
    }

    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZip(){
        return zip;
    }
    public String getNumber(){
        return number;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setZip(String zip){
        this.zip=zip;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String toString(){
        return "Firstname:"+firstname+",Lastname:"+lastname+",Address:"+address+",City:"+city+",State:"+state+",Zip:"+zip+",Number:"+number;
    }
}