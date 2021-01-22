package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class podar {
    public Image img;
    public int x,y;
    public Boolean act;
    private Timer timerUpdate;
    private int speed;


    public podar(Image img, int speed)
    {
        this.speed = speed;
        timerUpdate = new Timer(150, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                vniz();
            }
        });
        this.img = img;
        act = false;
    }
    public void start()
    {
        timerUpdate.setDelay(150);
        timerUpdate.start();
        y = 0;
        x = (int)(Math.random()*700);
        act = true; //
    }
    public void vniz()
    {
        if(act == true)
        {
            y+=5;
        }
        if((y+img.getHeight(null))>=1570)
        {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics gr)
    {
        if(act == true)
        {
            gr.drawImage(img,x,y,null);
        }
    }
}