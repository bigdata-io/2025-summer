package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gamejframe  extends JFrame implements KeyListener, ActionListener {

    int[][] data = new int[4][4];

    int x = 0;
    int y = 0;

    String path = "..\\pingtu\\image\\animal\\animal3\\";

    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0},
    };

    int cnt = 0;

    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reloginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    public gamejframe() {

        initjframe();

        initjmenuBar();

        initdata();

        initimage();

        this.setVisible(true);
    }

    private void initdata() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = arr[i];
        }
    }

    private void initimage() {
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel win = new JLabel(new ImageIcon("D:\\java\\pingtu\\image\\win.png"));
            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);
        }

        JLabel cntstep = new JLabel("步数: " + cnt);
        cntstep.setBounds(50, 30, 100, 20);
        this.getContentPane().add(cntstep);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                JLabel label = new JLabel(new ImageIcon(path + number + ".jpg"));
                label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                label.setBorder(new BevelBorder(1));
                this.getContentPane().add(label);
            }
        }
        ImageIcon bg = new ImageIcon("..\\pingtu\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, bg.getIconWidth(), bg.getIconHeight());
        this.getContentPane().add(background);

        this.getContentPane().repaint();
    }

    private void initjmenuBar() {
        JMenuBar menubar = new JMenuBar();

        JMenu functionjmenu = new JMenu("功能");

        JMenu aboutjmenu = new JMenu("关于我们");

        JMenu changeimage = new JMenu("更换图片");

        changeimage.add(girl);
        changeimage.add(sport);
        changeimage.add(animal);
        functionjmenu.add(changeimage);
        functionjmenu.add(replayItem);
        functionjmenu.add(reloginItem);
        functionjmenu.add(closeItem);

        aboutjmenu.add(accountItem);
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        menubar.add(functionjmenu);
        menubar.add(aboutjmenu);

        this.setJMenuBar(menubar);
    }

    private void initjframe() {
        this.setSize(603, 680);

        this.setTitle("拼图单机版 v2.5");

        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(null);

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 69) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            ImageIcon bg = new ImageIcon("..\\pingtu\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, bg.getIconWidth(), bg.getIconHeight());
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 65) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y -1];
            ;
            data[x][y - 1] = 0;
            y--;
            cnt++;
            initimage();
        } else if (code == 87) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            ;
            data[x - 1][y] = 0;
            x--;
            cnt++;
            initimage();
        } else if (code == 68) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            ;
            data[x][y + 1] = 0;
            y++;
            cnt++;
            initimage();
        } else if (code == 83) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            ;
            data[x + 1][y] = 0;
            x++;
            cnt++;
            initimage();
        } else if (code == 69) {
            initimage();
        } else if (code == 82) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initimage();
        }
    }

    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            initdata();
            cnt = 0;
            initimage();
        } else if (obj == reloginItem) {
            this.setVisible(false);
            new loginjframe();
        } else if (obj == closeItem) {
            System.exit(0);
        } else if (obj == accountItem) {
            JDialog jd = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("D:\\java\\pingtu\\image\\IMG_20250726_191006.jpg"));
            jLabel.setBounds(0, 0, 258, 258);
            jd.getContentPane().add(jLabel);
            jd.setSize(344, 344);
            jd.setAlwaysOnTop(true);
            jd.setLocationRelativeTo(null);
            jd.setModal(true);
            jd.setVisible(true);
        } else if (obj == girl) {
            Random rand = new Random();
            int index = rand.nextInt(11) + 1;
            path = "..\\pingtu\\image\\girl\\girl" + index + "\\";
            initdata();
            cnt = 0;
            initimage();
        } else if (obj == animal) {
            Random rand = new Random();
            int index = rand.nextInt(8) + 1;
            path = "..\\pingtu\\image\\animal\\animal" + index + "\\";
            initdata();
            cnt = 0;
            initimage();
        } else if (obj == sport) {
            Random rand = new Random();
            int index = rand.nextInt(10) + 1;
            path = "..\\pingtu\\image\\sport\\sport" + index + "\\";
            initdata();
            cnt = 0;
            initimage();
        }
    }
}
