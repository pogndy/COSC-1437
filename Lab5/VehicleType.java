package Lab5;

public enum VehicleType {
    TRUCK(5, "road"),
    AIRSHIP(25, "air"),
    SHIP(15, "water"),
    TRAIN(100, "rail");

    private final int weight;
    private final String type;

    VehicleType(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }

    public static VehicleType fromString(String typeStr) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.getType().equalsIgnoreCase(typeStr)) {
                return vehicleType;
            }
        }
        throw new IllegalArgumentException("No VehicleType with type " + typeStr + " found.");
    }
}