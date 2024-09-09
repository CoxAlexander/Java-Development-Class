// SpaService.java
//9/4/2024
//Alexander Cox

public class SpaService{
    public SpaService(){
        this("XXX", 0);
    } 
    public SpaService(String desc, double pr){
        serviceDescription = desc;
        price = pr;
    }
    private String serviceDescription;
    private double price;
    public void setServiceDescription(String service) {
        serviceDescription=service;
    }
    public void setPrice(double servicePrice){
        price = servicePrice;
    }
    public String getServiceDescription(){
        return serviceDescription;
    }
    public double getPrice(){
        return price;
    }
    
}