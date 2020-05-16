package sp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.RepaintManager;

public class boss2 extends JPanel implements ActionListener {

    public ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("source1.gif"));
    public ImageIcon nextstate = new ImageIcon(this.getClass().getResource("uwon.jpg"));
    public ImageIcon feildover = new ImageIcon(this.getClass().getResource("gameover.png"));
    public ImageIcon header = new ImageIcon(this.getClass().getResource("header.jpg"));
    public ImageIcon ex = new ImageIcon(this.getClass().getResource("exit.gif"));
    public ImageIcon shut = new ImageIcon(this.getClass().getResource("shut.png"));

    public ArrayList<nidoran> ca = new ArrayList<nidoran>();
    public ArrayList<ghost> go = new ArrayList<ghost>();
    public ArrayList<haunter> ht = new ArrayList<haunter>();
    public ArrayList<electroball> et = new ArrayList<electroball>();
    public ArrayList<electroball2> et2 = new ArrayList<electroball2>();

    pikachu_R p = new pikachu_R();

    public JButton Bshut = new JButton(shut);
    public JButton Bex = new JButton(ex);
    public JLabel score = new JLabel();
    public int bs2 = 2;
    public int times;
    public int eg;
    public int enemy = 20;
    boolean timestart = true;
    boolean st = false;
    public int sc = 0;

    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart == false) {
                    repaint();
                }
            }
        }
    });

    Thread cater = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (st == false) {
                        Thread.sleep((int) (Math.random() * 10000) + 1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (st == false) {
                    ca.add(new nidoran());
                }
            }
        }
    });
    Thread gas = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (st == false) {
                        Thread.sleep((int) (Math.random() * 1000) + 600);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (st == false) {
                    go.add(new ghost());
                }
            }
        }
    });
    Thread haunt = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (st == false) {
                        Thread.sleep((int) (Math.random() * 10000) + 4000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (st == false) {
                    ht.add(new haunter());
                }
            }
        }
    });

    Thread t = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    boss2() {
        this.setFocusable(true);
        this.setLayout(null);
        Bshut.setBounds(850, -30, 150, 150);
        Bshut.setOpaque(false);
        Bshut.setBorderPainted(false);
        Bshut.setContentAreaFilled(false);
        Bex.setBounds(800, 650, 300, 90);
        Bex.setOpaque(false);
        Bex.setBorderPainted(false);
        Bex.setContentAreaFilled(false);
        Bex.addActionListener(this);

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int a = e.getKeyCode();
                if (a == KeyEvent.VK_LEFT) {
                    p.x -= 10;
                    p.count++;
                } else if (a == KeyEvent.VK_RIGHT) {
                    p.x += 10;
                    p.count++;
                }
                if (p.count >= 4) {
                    p.count = 0;

                } else if (a == KeyEvent.VK_UP) {
                    p.count = 5;
                    et2.add(new electroball2(p.x, p.y));
                } else if (a == KeyEvent.VK_SPACE) {
                    p.count = 6;
                    et.add(new electroball(p.x, p.y));
                }
            }

            public void keyReleased(KeyEvent e) {
                p.count = p.count;
            }

        });
        p.x = 160;
        p.y = 600;
        time.start();
        cater.start();
        haunt.start();
        gas.start();
        t.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (times <= 0 || eg <= 0) {
            this.setLayout(null);
            this.remove(Bshut);
            this.add(Bex);
            g.drawImage(feildover.getImage(), 0, 0, 1280, 740, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 100));
            g.drawString("YOUR TOTAL SCORE =  " + sc, 330, 700);

        } else if (times <= 400 || eg > 0) {
            this.setLayout(null);
            this.add(Bshut);
            this.add(score);
            this.remove(Bex);
            g.drawImage(imgstate1.getImage(), 0, 0, 1280, 740, this);
            g.drawImage(header.getImage(), 0, 0, 3000, 150, this);
            g.drawImage(p.im[p.count].getImage(), p.x, p.y, 100, 120, this);
            for (int i = 0; i < et.size(); i++) {
                electroball etb = et.get(i);
                g.drawImage(etb.ET.getImage(), etb.x, etb.y, 100, 100, null);
                etb.move();
                if (etb.x > 1200) {
                    et.remove(i);
                }
            }
            for (int i = 0; i < et2.size(); i++) {
                electroball2 etb2 = et2.get(i);
                g.drawImage(etb2.ET.getImage(), etb2.x, etb2.y, 100, 100, null);
                etb2.move();
                if (etb2.y < 120) {
                    et2.remove(i);
                }
            }

            for (int i = 0; i < et.size(); i++) {
                for (int j = 0; j < ca.size(); j++) {
                    if (Intersect(et.get(i).getbound(), ca.get(j).getbound())) {
                        ca.remove(j);
                        et.remove(i);
                        sc += 10;

                    }
                }
            }
            for (int i = 0; i < ca.size(); i++) {
                g.drawImage(ca.get(i).getImage(), ca.get(i).getX(), ca.get(i).getY(), 150, 150, this);
                if (Intersect(ca.get(i).getbound(), p.getbound())) {
                    eg -= 1;
                    ca.remove(i);
                }
            }
            for (int i = 0; i < ht.size(); i++) {
                g.drawImage(ht.get(i).getImage(), ht.get(i).getX(), ht.get(i).getY(), 250, 250, this);
            }

            for (int i = 0; i < et2.size(); i++) {
                for (int j = 0; j < ht.size(); j++) {
                    if (Intersect(et2.get(i).getbound(), ht.get(j).getbound())) {
                        et2.remove(i);
                        sc += 20;
                        enemy -= 1;

                    }
                }
            }

            for (int i = 0; i < go.size(); i++) {
                g.drawImage(go.get(i).getImage(), go.get(i).getX(), go.get(i).getY(), 300, 300, this);
                if (Intersect(go.get(i).getbound(), p.getbound())) {
                    eg -= 1;
                    go.remove(i);
                }
            }
            if (p.x < 0) {
                p.x = 0;
            }
            if (p.x > 1120) {
                p.x = 1120;

            }
            g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 40));
            g.setColor(Color.RED);
            g.drawString("SCORE =  " + sc, 360, 130);
            g.setColor(Color.WHITE);
            g.drawString("TIME LEFT: " + times + " " + "S", 60, 130);
            g.drawString("ENERGY PK: " + eg, 660, 130);
            g.drawString("ENEMY LIFE : " + enemy, 960, 130);
            g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
            g.setColor(Color.MAGENTA);
            g.drawString("BOSS STATE : " + bs2, 500, 80);
            if (p.x > 1120) {
                p.x = 1120;

            }
            if (enemy <= 0) {
                this.setLayout(null);
                this.remove(Bshut);
                g.drawImage(nextstate.getImage(), 0, 0, 1280, 780, this);
                g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 80));
                g.setColor(Color.WHITE);
                g.drawString("FINALLY SCORE =  " + sc, 330, 650);
                this.add(Bex);
            }

        }

    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
