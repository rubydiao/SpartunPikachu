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


public class state1 extends JPanel implements ActionListener {

    public ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("forest.png"));
    public ImageIcon nextstate = new ImageIcon(this.getClass().getResource("gonext.png"));
    public ImageIcon feildover = new ImageIcon(this.getClass().getResource("gameover.png"));
    public ImageIcon header = new ImageIcon(this.getClass().getResource("header.jpg"));
    public ImageIcon ex = new ImageIcon(this.getClass().getResource("exit.gif"));
    public ImageIcon flag = new ImageIcon(this.getClass().getResource("flag.png"));
    public ImageIcon shut = new ImageIcon(this.getClass().getResource("shut.png"));
    public ImageIcon next = new ImageIcon(this.getClass().getResource("go next.png"));
    public ImageIcon gu = new ImageIcon(this.getClass().getResource("give up.png"));

    public ArrayList<pidgey> sb = new ArrayList<pidgey>();
    public ArrayList<cater> ca = new ArrayList<cater>();
    public ArrayList<electroball> et = new ArrayList<electroball>();
    public ArrayList<electroball2> et2 = new ArrayList<electroball2>();

    pikachu_R p = new pikachu_R();
    public JButton Bnext = new JButton(next);
    public JButton Bgu = new JButton(gu);

    public JButton Bshut = new JButton(shut);
    public JButton Bex = new JButton(ex);
    public JLabel score = new JLabel();
    public int bs1 = 1;
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

    Thread pidgey = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (st == false) {
                        Thread.sleep((int) (Math.random() * 8000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (st == false) {
                    sb.add(new pidgey());
                }
            }
        }
    });
    Thread cater = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (st == false) {
                        Thread.sleep((int) (Math.random() * 8000) + 500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (st == false) {
                    ca.add(new cater());
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

    state1() {
        this.setFocusable(true);
        this.setLayout(null);
        Bshut.setBounds(850, -30, 150, 150);
        Bshut.setOpaque(false);
        Bshut.setBorderPainted(false);
        Bshut.setContentAreaFilled(false);
        Bex.setBounds(800, 500, 300, 90);
        Bex.setOpaque(false);
        Bex.setBorderPainted(false);
        Bex.setContentAreaFilled(false);
        Bex.addActionListener(this);
        Bnext.setBounds(800, 500, 400, 90);
        Bnext.setOpaque(false);
        Bnext.setBorderPainted(false);
        Bnext.setContentAreaFilled(false);
        Bnext.addActionListener(this);
        Bgu.setBounds(100, 500, 400, 90);
        Bgu.setOpaque(false);
        Bgu.setBorderPainted(false);
        Bgu.setContentAreaFilled(false);
        Bgu.addActionListener(this);

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
        p.x = 0;
        p.y = 600;
        time.start();
        pidgey.start();
        cater.start();
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
            g.drawImage(flag.getImage(), 1200, 600, 80, 100, this);
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

            for (int i = 0; i < et2.size(); i++) {
                for (int j = 0; j < sb.size(); j++) {
                    if (Intersect(et2.get(i).getbound(), sb.get(j).getbound())) {
                        sb.remove(j);
                        et2.remove(i);
                        sc += 10;

                    }
                }
            }
            for (int i = 0; i < et.size(); i++) {
                for (int j = 0; j < sb.size(); j++) {
                    if (Intersect(et.get(i).getbound(), sb.get(j).getbound())) {
                        sb.remove(j);
                        et.remove(i);
                        sc += 10;

                    }
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
                g.drawImage(ca.get(i).getImage(), ca.get(i).getX(), ca.get(i).getY(), 180, 180, this);
                if (Intersect(ca.get(i).getbound(), p.getbound())) {
                    eg -= 1;
                    ca.remove(i);
                }
            }

            for (int i = 0; i < sb.size(); i++) {
                g.drawImage(sb.get(i).getImage(), sb.get(i).getX(), sb.get(i).getY(), 250, 250, this);
                if (Intersect(sb.get(i).getbound(), p.getbound())) {
                    eg -= 1;
                    sb.remove(i);
                }
            }
            if (p.x < 0) {
                p.x = 0;
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
            g.drawString("STATE : " + bs1, 500, 80);
            if (p.x > 1120 && sc>=100) {
                this.setLayout(null);
                this.removeAll();
                g.drawImage(nextstate.getImage(), 0, 0, 1280, 780, this);
                g.setColor(Color.BLACK);
                g.drawString("YOUR SCORE THIS STAGE=  " + sc, 330, 700);
                this.add(Bnext);
                this.add(Bgu);
                this.remove(Bex);
                this.remove(Bshut);

            }
            else if(p.x > 1120){
                p.x = 1120;
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
