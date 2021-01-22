package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class win extends JFrame
{
    private pole gameP;
    private int slogn;
    private class myKey implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            int key_ = e.getKeyCode();
            if(key_==27)System.exit(0);
            else if(key_==65)
            {
                if(gameP.x-10>-48)gameP.x-=20;
                else gameP.x =1600;
            }
            else if(key_==68)
            {
                if(gameP.x+10<1600)gameP.x+=20;
                else gameP.x=-48;

            }
        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    //key
    }
    public win(int slogn, int speed)
    {
        this.slogn = slogn;
        addKeyListener(new myKey());
        setBounds(100,100,1600,800);
        setTitle("Game NewYear");
        gameP = new pole(slogn, speed);
        Container con = getContentPane();
        con.add(gameP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        setResizable(false);
        setVisible(true);
        //window
    }

}
