package Lab5;

public class Vehicle{
    
    public enum vehicleType { 
        TRUCK(5), //use enum instead of class since 
        AIRSHIP(25), //the vehicles do the same thing
        SHIP(15), 
        TRAIN(100); 

        private final int weight;

        vehicleType(int weight) {
            this.weight = weight; //intilizes the weight
        }

        public int getWeight() {
            return this.weight; //getter for weight
        }
    }

    private vehicleType type;
    private int currentCargo;

    public Vehicle(vehicleType type) {
        this.type = type;   //constructor for vehicletype
        this.currentCargo = 0;
    }
    
    public vehicleType getType() {
        return type;
    }

    public void setType (vehicleType type) {
        this.type = type;   //sets type of vehicle
    }

    public int currentCargo() {
        return currentCargo;
    }

    public void setCurrentCargo(int currentCargo) {
        int maxLoad = this.type.getWeight();
        if(currentCargo <= maxLoad)
            this.currentCargo += currentCargo;
        else {
            this.currentCargo += maxLoad; //when cargo is too big it
            currentCargo -= maxLoad;    //adds the max load and subtracts from
                                        //the input given
        }
    }
    
}