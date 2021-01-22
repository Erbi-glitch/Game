package main;

import javax.swing.*;

public class main
{
    public static void main(String[] args)
    {
        String rez = JOptionPane.showInputDialog(null, "Введите сложность игры от 1 до 3:","сложность игры",1);
        int slogn = rez.charAt(0)-'0';
        int speed = slogn*10;
        if((slogn>=1)&&(slogn<=3))
        {
            win window = new win(slogn, speed);
        }
    }
}