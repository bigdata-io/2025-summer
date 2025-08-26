public class Bus extends Vehicle {
    int capacity;
    public Bus(String id, String brand, String model, double dailyRate, int capacity) {
        super(id, brand, model, dailyRate, "巴士");
        this.capacity = capacity;
    }

    public String toString() {
        return super.toString() + ", 载客量: " + capacity + "人";
    }
}