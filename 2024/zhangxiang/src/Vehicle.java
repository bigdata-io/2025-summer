public class Vehicle {
    String id,brand,model;
    double dailyRate;
    boolean isRented;
    String type;

    public Vehicle(String id, String brand, String model, double dailyRate, String type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
        this.type = type;
    }

    public String toString() {
        return type + " - " + brand + " " + model + " (ID: " + id + ", 日租金: " + dailyRate + "元)";
    }
}