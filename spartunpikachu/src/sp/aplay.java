package sp;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class aplay extends JFrame implements ActionListener {

    index startgame = new index();
    tutorial t = new tutorial();
    boss1 BS1 = new boss1();
    boss2 BS2 = new boss2();
    state1 s1 = new state1();
    state2 s2 = new state2();

    public aplay() {
        this.setSize(1290, 780);
        this.add(startgame);
        startgame.Btutorial.addActionListener(this);
        startgame.BStart.addActionListener(this);
        startgame.Bexit.addActionListener(this);
        BS1.Bshut.addActionListener(this);
        BS1.Bex.addActionListener(this);
        BS1.Bnext.addActionListener(this);
        BS1.Bgu.addActionListener(this);
        BS2.Bshut.addActionListener(this);
        BS2.Bex.addActionListener(this);
        s1.Bshut.addActionListener(this);
        s1.Bex.addActionListener(this);
        s1.Bnext.addActionListener(this);
        s1.Bgu.addActionListener(this);
        s2.Bshut.addActionListener(this);
        s2.Bex.addActionListener(this);
        s2.Bnext.addActionListener(this);
        s2.Bgu.addActionListener(this);
        t.Bback.addActionListener(this);
        t.Bback.addActionListener(this);
        

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startgame.Bexit || e.getSource() == BS1.Bex || e.getSource() == BS1.Bshut || e.getSource() == BS1.Bgu || e.getSource() == s2.Bgu|| e.getSource() == s2.Bshut ||e.getSource() == s2.Bex
                || e.getSource() == s1.Bex || e.getSource() == s1.Bshut || e.getSource() == BS2.Bshut || e.getSource() == BS2.Bex) {
            System.exit(0);
        } else if (e.getSource() == startgame.BStart) {
            this.setLocationRelativeTo(null);
            this.remove(startgame);
            this.setSize(1290, 780);
            this.add(s1);
            s1.requestFocusInWindow();
            s1.timestart = false;
            s1.sc = 0;
            s1.eg = 10;
            s1.enemy = 10;
            s1.times = 300;
            s1.st = false;
            s1.timestart = false;
        } else if (e.getSource() == s1.Bnext) {
            this.setLocationRelativeTo(null);
            this.remove(s1);
            this.setSize(1290, 780);
            this.add(BS1);
            BS1.requestFocusInWindow();
            BS1.timestart = false;
            BS1.sc = s1.sc;
            BS1.eg = s1.eg+3;
            BS1.enemy = 10;
            BS1.times = s1.times;
            BS1.st = false;
            BS1.timestart = false;
        }
        else if (e.getSource() == s2.Bnext) {
            this.setLocationRelativeTo(null);
            this.remove(s2);
            this.setSize(1290, 780);
            this.add(BS2);
            BS2.requestFocusInWindow();
            BS2.timestart = false;
            BS2.sc = s2.sc;
            BS2.eg = s2.eg+5;
            BS2.enemy = 20;
            BS2.times = s1.times;
            BS2.st = false;
            BS2.timestart = false;
        } 
        else if (e.getSource() == BS1.Bnext) {
            this.setLocationRelativeTo(null);
            this.remove(BS1);
            this.setSize(1290, 780);
            this.add(s2);
            s2.requestFocusInWindow();
            s2.timestart = false;
            s2.sc = BS1.sc;
            s2.eg = 15;
            s2.enemy = 15;
            s2.times = BS1.times;
            s2.st = false;
            s2.timestart = false;
        } 
        else if (e.getSource() == startgame.Btutorial) {
            this.setLocationRelativeTo(null);
            this.remove(startgame);
            this.setSize(1290, 780);
            this.add(t);
            t.requestFocusInWindow();
        } else if (e.getSource() == t.Bback) {
            this.setLocationRelativeTo(null);
            this.remove(t);
            this.setSize(1290, 780);
            this.add(startgame);
            startgame.requestFocusInWindow();
        }
        this.validate();
        this.repaint();

    }

    public static void main(String[] args) {
        JFrame jf = new aplay();
        jf.setSize(1290, 780);
        jf.setTitle("Spartun Pikachu");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
