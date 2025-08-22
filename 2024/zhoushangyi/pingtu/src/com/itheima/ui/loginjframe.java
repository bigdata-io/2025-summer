package com.itheima.ui;

import user.User;
import yuanzhenma.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class loginjframe extends JFrame implements MouseListener {

    static ArrayList<User> allUsers = new ArrayList<>();
    static {
        allUsers.add(new User("zhoushangyi","123"));
        allUsers.add(new User("tiaodan","930"));
    }
    JButton login = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();

    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    JLabel rightCode = new JLabel();
    public loginjframe() {

        initJFrame();

        initView();

        this.setVisible(true);
    }
    public void initView() {

        JLabel usernameText = new JLabel(new ImageIcon("..\\pingtu\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);


        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        JLabel passwordText = new JLabel(new ImageIcon("..\\pingtu\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);


        JLabel codeText = new JLabel(new ImageIcon("..\\pingtu\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);


        String codeStr = CodeUtil.getCode();

        rightCode.setText(codeStr);

        rightCode.addMouseListener(this);

        rightCode.setBounds(300, 256, 50, 30);

        this.getContentPane().add(rightCode);


        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("..\\pingtu\\image\\login\\登录按钮.png"));

        login.setBorderPainted(false);

        login.setContentAreaFilled(false);

        login.addMouseListener(this);
        this.getContentPane().add(login);


        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("..\\pingtu\\image\\login\\注册按钮.png"));

        register.setBorderPainted(false);

        register.setContentAreaFilled(false);

        register.addMouseListener(this);
        this.getContentPane().add(register);


        JLabel background = new JLabel(new ImageIcon("..\\pingtu\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

    }

    public void initJFrame() {
        this.setSize(488,430);
        this.setTitle("拼图单机版 登录");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            System.out.println("点击了登录按钮");

            String usernameInput = username.getText();
            String passwordInput = password.getText();

            String codeInput = code.getText();


            User userInfo = new User(usernameInput, passwordInput);
            System.out.println("用户输入的用户名为" + usernameInput);
            System.out.println("用户输入的密码为" + passwordInput);

            if (codeInput.length() == 0) {
                showJDialog("验证码不能为空");
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {

                System.out.println("用户名或者密码为空");


                showJDialog("用户名或者密码为空");


            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("验证码输入错误");
            } else if (contains(userInfo)) {
                System.out.println("用户名和密码正确可以开始玩游戏了");

                this.setVisible(false);

                new gamejframe();
            } else {
                System.out.println("用户名或密码错误");
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource() == register) {
            System.out.println("点击了注册按钮");
        } else if (e.getSource() == rightCode) {
            System.out.println("更换验证码");

            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }
    public void showJDialog(String content) {

        JDialog jDialog = new JDialog();

        jDialog.setSize(200, 150);

        jDialog.setAlwaysOnTop(true);

        jDialog.setLocationRelativeTo(null);

        jDialog.setModal(true);


        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);


        jDialog.setVisible(true);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("..\\pingtu\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\pingtu\\image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("..\\pingtu\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("..\\pingtu\\image\\login\\注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean contains(User userInput){
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if(userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())){

                return true;
            }
        }

        return false;
    }
}
