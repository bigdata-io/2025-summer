import java.util.ArrayList;
import java.util.Date;

public class SystemManager {
    ArrayList<User> users;
    ArrayList<Vehicle> vehicles;
    ArrayList<RentalRecord> rentalRecords;
    User currentUser;
    double totalRevenue;

    public SystemManager() {
        users = new ArrayList<>();
        vehicles = new ArrayList<>();
        rentalRecords = new ArrayList<>();
        totalRevenue = 0;

        users.add(new User("admin", "admin123", false));
        users.add(new User("user1", "123456", false));
        users.add(new User("vip1", "123456", true));

        vehicles.add(new Car("C001", "丰田", "凯美瑞", 200));
        vehicles.add(new Car("C002", "本田", "雅阁", 220));
        vehicles.add(new Bus("B001", "宇通", "ZK6120", 500, 45));
        vehicles.add(new Trunk("T001", "解放", "J6P", 400, 10));
    }

    public boolean registerUser(String username, String password, boolean isVip) {

        for (User user : users) {
            if (user.username.equals(username)) {
                return false;
            }
        }
        users.add(new User(username, password, isVip));
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public ArrayList<Vehicle> getAvailableVehicles() {
        ArrayList<Vehicle> available = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isRented) {
                available.add(vehicle);
            }
        }
        return available;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public boolean rentVehicle(String vehicleId, int days) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id.equals(vehicleId) && !vehicle.isRented) {
                double cost;
                if(currentUser.isVip){
                    cost = vehicle.dailyRate * days * 0.9;
                }else{
                    cost = vehicle.dailyRate * days;
                }
                if (currentUser.balance >= cost) {
                    vehicle.isRented = true;
                    currentUser.balance -= cost;
                    totalRevenue += cost;
                    String date = new Date().toString();
                    rentalRecords.add(new RentalRecord(currentUser.username,vehicleId,vehicle.toString(),days,cost,date));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id.equals(vehicleId) && vehicle.isRented) {
                vehicle.isRented = false;
                return true;
            }
        }
        return false;
    }

    public boolean addVehicle(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.id.equals(vehicle.id)) {
                return false;
            }
        }
        vehicles.add(vehicle);
        return true;
    }

    public boolean removeVehicle(String vehicleId) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).id.equals(vehicleId)) {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public boolean rechargeUser(String username, double amount) {
        for (User user : users) {
            if (user.username.equals(username)) {
                user.balance += amount;
                return true;
            }
        }
        return false;
    }

    public ArrayList<RentalRecord> getRentalRecords() {
        return rentalRecords;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
