package net;

import gui.Grid;
import gui.GridMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI
{
    public static int    PORT;

    public static void showGrid(String NameOfFrame)
    {
        JFrame      frame       = new JFrame(NameOfFrame);
        JPanel      panel       = new JPanel();
        JMenu       menu        = new JMenu("Меню");
        JMenuBar    menuBar     = new JMenuBar();
        JMenuItem   menuItem    = new JMenuItem("Выход");
        Client      client      = new Client(PORT, NameOfFrame);
        Grid        grid        = new Grid(400, 400, 8, 8, client);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                //client.resetGame();
                //grid.resetBoard(client);
                //frame.setFocusable(true);
                //frame.revalidate();
                //frame.repaint();
            }
        });
        BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bl);

        panel.add(new JLabel("Board"));
        grid.addMouseListener(new GridMouseListener());
        panel.add(grid);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void showMenu(int newPort)
    {
        PORT=newPort;

        JButton     StartBtn    = new JButton("Начать игру");
        JButton     ExitBtn     = new JButton("Выход");
        JFrame      Menu        = new JFrame("Меню");
        JPanel      ButtonPanel    = new JPanel();

        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu.setBounds(700,300,350,200);

        ButtonPanel.setLayout(new GridLayout(2,0,0,0));

        StartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibleBoards();
                Menu.setVisible(false);
            }
        });

        ExitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        ButtonPanel.add(StartBtn);
        ButtonPanel.add(ExitBtn);
        ButtonPanel.setBorder(BorderFactory.createEmptyBorder(50,30,50,30));

        Menu.add(ButtonPanel);
        Menu.setVisible(true);
    }

    public static void closeBoards(JFrame frame, Client client)
    {
        frame=null;
        client =null;
    }
    
    public static void setVisibleBoards()
    {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        showGrid("WHITE");
                    }
                }
        );

        javax.swing.SwingUtilities.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        showGrid("BLACK");
                    }
                }
        );
    }
}
