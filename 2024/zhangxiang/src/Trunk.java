public class Trunk extends Vehicle {
    double loadCapacity;

    public Trunk(String id, String brand, String model, double dailyRate, double loadCapacity) {
        super(id, brand, model, dailyRate, "卡车");
        this.loadCapacity = loadCapacity;
    }
    public String toString() {
        return super.toString() + ", 载重量: " + loadCapacity + "吨";
    }
}
