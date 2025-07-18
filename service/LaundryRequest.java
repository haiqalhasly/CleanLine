package service;
public class LaundryRequest {
    //code the input from user here
    private String customerName;
    private float temperature;
    private String priorityType;

    //Constructor
    public LaundryRequest(String customerName, float temperature, String priorityType){
        
        this.customerName = customerName;
        this.temperature = temperature;
        this.priorityType = priorityType;
    }

    //Getters

    public String getCustomerName(){ return customerName;}
    public float getTemperature() {return temperature;}
    public String getPriorityType() {return priorityType;}
    
    //Setters
    public void setCustomerName(String customerName){this.customerName = customerName;}
    public void setTemperature(float temperature) {this.temperature = temperature;}
    public void setPriorityType(String priorityType) {this.priorityType = priorityType;}
    
}
