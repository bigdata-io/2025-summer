public class RentalRecord {
    String username,vehicleId,vehicleInfo;
    int days;
    double cost;
    String date;

    public RentalRecord(String username, String vehicleId, String vehicleInfo, int days, double cost, String date) {
        this.username = username;
        this.vehicleId = vehicleId;
        this.vehicleInfo = vehicleInfo;
        this.days = days;
        this.cost = cost;
        this.date = date;
    }

    public String toString() {
        return date + " - " + username + " 租赁了 " + vehicleInfo + "，租期 " + days + "天，费用 " + cost + "元";
    }
}