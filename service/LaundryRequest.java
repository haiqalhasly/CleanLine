package service;


public class LaundryRequest {
    //code the input from user here
    private String customerName;
    private String temperature;
    private String priorityType;


    //Constructor
    public LaundryRequest(String customerName, String temperature, String priorityType){
        
        this.customerName = customerName;
        this.temperature = temperature;
        this.priorityType = priorityType;
    }

    public LaundryRequest(String customerName, String temperature) {

        this.customerName = customerName;
        this.temperature = temperature;
    }

    //Getters

    public String getCustomerName(){ return customerName;}
    public String getTemperature() {return temperature;}
    public String getPriorityType() {return priorityType;}
    
    //Setters
    public void setCustomerName(String customerName){this.customerName = customerName;}
    public void setTemperature(String temperature) {this.temperature = temperature;}
    public void setPriorityType(String priorityType) {this.priorityType = priorityType;}
    
}
