package Lab5;

public class VehiclePath {
    private Vehicle vehicle;
    private Path path;

    public VehiclePath(Vehicle vehicle, Path path) {
        this.vehicle = vehicle;
        this.path = path;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

}
