public class User {
    String username,password;
    boolean isVip;
    double balance;
    public User(String username, String password, boolean isVip) {
        this.username = username;
        this.password = password;
        this.isVip = isVip;
        this.balance = 0.0;
    }
    public String toString() {
        return username + (isVip ? "(VIP)" : "") + " - 余额: " + balance + "元";
    }
}