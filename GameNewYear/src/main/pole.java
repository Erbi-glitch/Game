package main;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

class pole extends JPanel {

    private Image basket;
    private Image fon;
    public int x = 400;
    private int slogn;
    private Image end_game;
    private podar[] gamePodar;
    public Timer timerUpdate, timerDraw;

    public pole(int slogn, int speed) {
        this.slogn = slogn;

        try {
            basket = ImageIO.read(new File("./backed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fon = ImageIO.read(new File("./background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            end_game = ImageIO.read(new File("./end.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gamePodar = new podar[7];
        for (int i = 0; i < 7; i++) {
            try {
                gamePodar[i] = new podar(ImageIO.read(new File("./p1.png")),speed);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        timerUpdate = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();


        timerDraw = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
        timerDraw.start();
    }

    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        gr.drawImage(fon, 0, 0, null);
        gr.drawImage(basket, x, 600, null);

        for (int i=0;i<7;i++)
        {
            gamePodar[i].draw(gr);
            if (gamePodar[i].act==true)
            {
                if ((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=700)
                {
                    if (Math.abs(gamePodar[i].x - x) > 75)
                    {
                        gr.drawImage(end_game, 0, 0, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    }
                    else gamePodar[i].act=false;
                }
            }
        }
    }

    private void updateStart()
    {
        int kol=0;
        for (int i=0;i<7;i++)
        {
            if (gamePodar[i].act==false)
            {
                if (kol<slogn)
                {
                    gamePodar[i].start();
                    break;
                }
            }
            else kol++;
        }
    }
}




