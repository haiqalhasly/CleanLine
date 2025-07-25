package service;

//This class contains the information for the laundry request
//Customer name, temperature, and priority
//It will be passed to the queue system
//This is the main service class for every customer's request

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

    //Other constructor if only want these two parameters
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
