import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    CardLayout cardLayout;
    JPanel mainPanel;
    SystemManager systemManager;

    JPanel rolePanel, userLoginPanel, adminLoginPanel, registerPanel, userPanel, adminPanel;

    public MainFrame() {
        setTitle("汽车租赁系统");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        systemManager = new SystemManager();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            int value = JOptionPane.showConfirmDialog(MainFrame.this,"确定要退出吗","提示",JOptionPane.YES_NO_OPTION);
            if(value == JOptionPane.YES_OPTION){
                System.exit(0);
            }
            }
        });

        createRolePanel();
        createUserLoginPanel();
        createAdminLoginPanel();
        createRegisterPanel();
        createUserPanel();
        createAdminPanel();

        mainPanel.add(rolePanel, "role");
        mainPanel.add(userLoginPanel, "userLogin");
        mainPanel.add(adminLoginPanel, "adminLogin");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(userPanel, "user");
        mainPanel.add(adminPanel, "admin");

        add(mainPanel);
        cardLayout.show(mainPanel, "role");
    }

    public void createRolePanel() {
        rolePanel = new JPanel();
        rolePanel.setLayout(new BorderLayout());
        rolePanel.setBorder(BorderFactory.createEmptyBorder(200,0,200,0));

        JLabel label = new JLabel("请选择用户类型", JLabel.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 24));
        rolePanel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        JButton userBtn = new JButton("用户");
        JButton adminBtn = new JButton("管理员");

        userBtn.addActionListener(e -> cardLayout.show(mainPanel, "userLogin"));
        adminBtn.addActionListener(e -> cardLayout.show(mainPanel, "adminLogin"));

        buttonPanel.add(userBtn);
        buttonPanel.add(adminBtn);

        rolePanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void createUserLoginPanel() {
        userLoginPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        userLoginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("用户登录", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 20));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("用户名:"));
        JTextField userField = new JTextField(15);
        userPanel.add(userField);

        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("密码:"));
        JPasswordField passField = new JPasswordField(15);
        passPanel.add(passField);

        JPanel buttonPanel = new JPanel();
        JButton loginBtn = new JButton("登录");
        JButton backBtn = new JButton("返回");
        JButton registerBtn = new JButton("注册");

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (systemManager.login(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功！");
                cardLayout.show(mainPanel, "user");
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
            }
        });

        backBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            cardLayout.show(mainPanel, "role");
        });

        registerBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            cardLayout.show(mainPanel, "register");
        });

        buttonPanel.add(loginBtn);
        buttonPanel.add(backBtn);
        buttonPanel.add(registerBtn);

        userLoginPanel.add(title);
        userLoginPanel.add(userPanel);
        userLoginPanel.add(passPanel);
        userLoginPanel.add(buttonPanel);
    }

    public void createAdminLoginPanel() {
        adminLoginPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        adminLoginPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("管理员登录", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 20));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("用户名:"));
        JTextField userField = new JTextField(15);
        userPanel.add(userField);

        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("密码:"));
        JPasswordField passField = new JPasswordField(15);
        passPanel.add(passField);

        JPanel buttonPanel = new JPanel();
        JButton loginBtn = new JButton("登录");
        JButton backBtn = new JButton("返回");

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (systemManager.login(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功！");
                cardLayout.show(mainPanel, "admin");
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！");
            }
        });

        backBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            cardLayout.show(mainPanel, "role");
        });

        buttonPanel.add(loginBtn);
        buttonPanel.add(backBtn);

        adminLoginPanel.add(title);
        adminLoginPanel.add(userPanel);
        adminLoginPanel.add(passPanel);
        adminLoginPanel.add(buttonPanel);
    }

    public void createRegisterPanel() {
        registerPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("用户注册", JLabel.CENTER);
        title.setFont(new Font("宋体", Font.BOLD, 20));

        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("用户名:"));
        JTextField userField = new JTextField(15);
        userPanel.add(userField);

        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("密码:"));
        JPasswordField passField = new JPasswordField(15);
        passPanel.add(passField);

        JPanel vipPanel = new JPanel();
        JCheckBox vipCheck = new JCheckBox("VIP用户");
        vipPanel.add(vipCheck);

        JPanel buttonPanel = new JPanel();
        JButton registerBtn = new JButton("注册");
        JButton backBtn = new JButton("返回");

        registerBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            boolean isVip = vipCheck.isSelected();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "用户名和密码不能为空！");
                return;
            }

            if (systemManager.registerUser(username, password, isVip)) {
                JOptionPane.showMessageDialog(this, "注册成功！");
                userField.setText("");
                passField.setText("");
                vipCheck.setSelected(false);
                cardLayout.show(mainPanel, "userLogin");
            } else {
                JOptionPane.showMessageDialog(this, "用户名已存在！");
            }
        });

        backBtn.addActionListener(e -> {
            userField.setText("");
            passField.setText("");
            vipCheck.setSelected(false);
            cardLayout.show(mainPanel, "userLogin");
        });

        buttonPanel.add(registerBtn);
        buttonPanel.add(backBtn);

        registerPanel.add(title);
        registerPanel.add(userPanel);
        registerPanel.add(passPanel);
        registerPanel.add(vipPanel);
        registerPanel.add(buttonPanel);
    }

    public void createUserPanel() {
        userPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton viewBtn = new JButton("查看车辆");
        JButton rentBtn = new JButton("租车");
        JButton returnBtn = new JButton("还车");
        JButton payBtn = new JButton("充值");
        JButton balanceBtn = new JButton("查看余额");
        JButton logoutBtn = new JButton("退出登录");

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);

        viewBtn.addActionListener(e -> {
            ArrayList<Vehicle> vehicles = systemManager.getAvailableVehicles();
            StringBuilder sb = new StringBuilder();
            sb.append("可用车辆:\n");
            for (Vehicle vehicle : vehicles) {
                sb.append(vehicle.toString()).append("\n");
            }
            infoArea.setText(sb.toString());
        });

        rentBtn.addActionListener(e -> {
            String vehicleId = JOptionPane.showInputDialog(this, "请输入车辆ID:");
            if (vehicleId != null && !vehicleId.isEmpty()) {
                String daysStr = JOptionPane.showInputDialog(this, "请输入租用天数:");
                try {
                    int days = Integer.parseInt(daysStr);
                    if (systemManager.rentVehicle(vehicleId, days)) {
                        JOptionPane.showMessageDialog(this, "租车成功！");
                    } else {
                        JOptionPane.showMessageDialog(this, "租车失败！");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "请输入有效的天数！");
                }
            }
        });

        returnBtn.addActionListener(e -> {
            String vehicleId = JOptionPane.showInputDialog(this, "请输入要归还的车辆ID:");
            if (vehicleId != null && !vehicleId.isEmpty()) {
                if (systemManager.returnVehicle(vehicleId)) {
                    JOptionPane.showMessageDialog(this, "还车成功！");
                } else {
                    JOptionPane.showMessageDialog(this, "还车失败！");
                }
            }
        });

        payBtn.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog(this, "请输入充值金额:");
            try {
                double amount = Double.parseDouble(amountStr);
                systemManager.getCurrentUser().balance += amount;
                JOptionPane.showMessageDialog(this, "充值成功！当前余额: " +
                        systemManager.getCurrentUser().balance + "元");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的金额！");
            }
        });

        balanceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "当前余额: " +
                    systemManager.getCurrentUser().balance + "元");
        });

        logoutBtn.addActionListener(e -> {
            systemManager.logout();
            cardLayout.show(mainPanel, "role");
        });

        buttonPanel.add(viewBtn);
        buttonPanel.add(rentBtn);
        buttonPanel.add(returnBtn);
        buttonPanel.add(payBtn);
        buttonPanel.add(balanceBtn);
        buttonPanel.add(logoutBtn);

        userPanel.add(buttonPanel, BorderLayout.NORTH);
        userPanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }

    public void createAdminPanel() {
        adminPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton viewBtn = new JButton("查看车辆");
        JButton addBtn = new JButton("添加车辆");
        JButton removeBtn = new JButton("删除车辆");
        JButton revenueBtn = new JButton("查看营业额");
        JButton usersBtn = new JButton("查看用户");
        JButton rechargeBtn = new JButton("用户充值");
        JButton recordsBtn = new JButton("租赁记录");
        JButton logoutBtn = new JButton("退出登录");

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);

        viewBtn.addActionListener(e -> {
            ArrayList<Vehicle> vehicles = systemManager.getAllVehicles();
            StringBuilder sb = new StringBuilder();
            sb.append("所有车辆:\n");
            for (Vehicle vehicle : vehicles) {
                sb.append(vehicle.toString()).append(vehicle.isRented ? " (已租出)" : " (可用)").append("\n");
            }
            infoArea.setText(sb.toString());
        });

        addBtn.addActionListener(e -> {
            JDialog dialog = new JDialog(this, "添加车辆", true);
            dialog.setSize(400, 300);
            dialog.setLayout(new GridLayout(6, 2, 5, 5));

            dialog.add(new JLabel("类型:"));
            JComboBox<String> typeBox = new JComboBox<>(new String[]{"小汽车", "巴士", "卡车"});
            dialog.add(typeBox);
            dialog.add(new JLabel("ID:"));
            JTextField idField = new JTextField();
            dialog.add(idField);
            dialog.add(new JLabel("品牌:"));
            JTextField brandField = new JTextField();
            dialog.add(brandField);
            dialog.add(new JLabel("型号:"));
            JTextField modelField = new JTextField();
            dialog.add(modelField);
            dialog.add(new JLabel("日租金:"));
            JTextField rateField = new JTextField();
            dialog.add(rateField);
            JButton okBtn = new JButton("确定");
            JButton cancelBtn = new JButton("取消");

            okBtn.addActionListener(ev -> {
                try {
                    String type = (String) typeBox.getSelectedItem();
                    String id = idField.getText();
                    String brand = brandField.getText();
                    String model = modelField.getText();
                    double rate = Double.parseDouble(rateField.getText());

                    Vehicle vehicle = null;
                    if ("小汽车".equals(type)) {
                        vehicle = new Car(id, brand, model, rate);
                    } else if ("巴士".equals(type)) {
                        vehicle = new Bus(id, brand, model, rate, 45);
                    } else if ("卡车".equals(type)) {
                        vehicle = new Trunk(id, brand, model, rate, 10);
                    }

                    if (vehicle != null && systemManager.addVehicle(vehicle)) {
                        JOptionPane.showMessageDialog(dialog, "添加成功！");
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog, "添加失败！");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "输入有误！");
                }
            });

            cancelBtn.addActionListener(ev -> dialog.dispose());

            dialog.add(okBtn);
            dialog.add(cancelBtn);

            dialog.setVisible(true);
        });

        removeBtn.addActionListener(e -> {
            String vehicleId = JOptionPane.showInputDialog(this, "请输入要删除的车辆ID:");
            if (vehicleId != null && !vehicleId.isEmpty()) {
                if (systemManager.removeVehicle(vehicleId)) {
                    JOptionPane.showMessageDialog(this, "删除成功！");
                } else {
                    JOptionPane.showMessageDialog(this, "删除失败！");
                }
            }
        });

        revenueBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "总营业额: " + systemManager.getTotalRevenue() + "元");
        });

        usersBtn.addActionListener(e -> {
            ArrayList<User> users = systemManager.getAllUsers();
            StringBuilder sb = new StringBuilder();
            sb.append("所有用户:\n");
            for (User user : users) {
                sb.append(user.toString()).append("\n");
            }
            infoArea.setText(sb.toString());
        });

        rechargeBtn.addActionListener(e -> {
            String username = JOptionPane.showInputDialog(this, "请输入用户名:");
            if (username != null && !username.isEmpty()) {
                String amountStr = JOptionPane.showInputDialog(this, "请输入充值金额:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (systemManager.rechargeUser(username, amount)) {
                        JOptionPane.showMessageDialog(this, "充值成功！");
                    } else {
                        JOptionPane.showMessageDialog(this, "充值失败！");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "请输入有效的金额！");
                }
            }
        });

        recordsBtn.addActionListener(e -> {
            ArrayList<RentalRecord> records = systemManager.getRentalRecords();
            StringBuilder sb = new StringBuilder();
            sb.append("租赁记录:\n");
            for (RentalRecord record : records) {
                sb.append(record.toString()).append("\n");
            }
            infoArea.setText(sb.toString());
        });

        logoutBtn.addActionListener(e -> {
            systemManager.logout();
            cardLayout.show(mainPanel, "role");
        });

        buttonPanel.add(viewBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(revenueBtn);
        buttonPanel.add(usersBtn);
        buttonPanel.add(rechargeBtn);
        buttonPanel.add(recordsBtn);
        buttonPanel.add(logoutBtn);

        adminPanel.add(buttonPanel, BorderLayout.NORTH);
        adminPanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }
}
