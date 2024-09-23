//VehicleDatabase.java
//9/23/2024
//Alexander Cox

import javax.swing.*;
public class VehicleDatabase{
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[5];
        int x;
        for(x = 0;x<vehicles.length; ++x){
            String userEntry;
            int vehcileType;
            userEntry = JOptionPane.showInputDialog(null, "Please select the type of\n" + "vehicle you want to enter: \n 1 - Sailboat\n" + " 2 - Bicycle");
            vehcileType = Integer.parseInt(userEntry);
            if(vehcileType == 1)
                vehicles[x] = new Sailboat();
            else    
                vehicles[x] = new Bicycle();
        }
        StringBuffer outString = new StringBuffer();
        for(x=0; x < vehicles.length; ++x){
            outString.append("\n#" + (x+1) + " ");
            outString.append(vehicles[x].toString());
        }
        JOptionPane.showMessageDialog(null,"Our avaliable Vehicles include:\n" + outString);
    }
}