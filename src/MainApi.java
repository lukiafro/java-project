
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/*
 * Klasa odpowiadająca za główny wygląd aplikacji.
 */

public class MainApi implements ActionListener {

    private JFrame mainWindow;
    private JLabel leftPicture;
    private JLabel rightPicture, top, center;
    private JPanel buttonPanel;
    private JButton lewa, prawa, statystyka;
    private URL path1, path2;
    private int ilosc, i, k;
    private Random rand;
    private String a, b;
    private Best best;
    private int index = 0;
    private List<Integer> wyniki;

    public MainApi() {
        mainWindow = new JFrame("Piekności z całego świata");
        best = new Best();
        ilosc = 600;
       // wyniki = new int[3];
        wyniki = new ArrayList<Integer>();
        
        
        best.setIntegers(0, 0, 0);

    }

    /*
     * Wybiera początkowe sciezki zdjec przy starcie aplikacji.
     */
    void imageStartPaths() throws MalformedURLException {

        checkRepeatability();
        /*
         * Przykladowe zdjecia z sieci, później ścieżka ta będzię sie odwoływać do konkretnego hosta,
         * na którym będzie stworzona baza danych.
         */
        path1 = new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + a + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_444.jpg");
        path2 = new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + b + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_333.jpg");

    }
    /*
     * Metoda odpowiadająca za stworzenie obiektów oraz ich określenie, np. przycisków.
     */

    void setDisplay() {

        top = new JLabel("Wybierz która lepsza !!! Aplikacja szuka zdjęć w internecie i sporządza ranking. Miłej zabawy!");

        statystyka = new JButton("Statystyka");


        leftPicture = new JLabel();
        leftPicture.setMinimumSize(new Dimension(330, 450));
        leftPicture.setMaximumSize(new Dimension(330, 450));
        leftPicture.setPreferredSize(new Dimension(330, 450));
        ImageIcon image = new ImageIcon(path1);

        leftPicture.setBackground(new Color(0, 0, 0));
        leftPicture.setForeground(new Color(255, 255, 255));
        leftPicture.setOpaque(true);
        rightPicture = new JLabel();
        rightPicture.setSize(330, 450);
        ImageIcon image2 = new ImageIcon(path2);

        if (image.getImageLoadStatus() == 8 && image2.getImageLoadStatus() == 8) {


            rightPicture.setIcon(image2);
            leftPicture.setIcon(image);
        } else {
            try {
                imageStartPaths();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainApi.class.getName()).log(Level.SEVERE, null, ex);
            }
            setDisplay();
        }

        rightPicture.setBackground(new Color(0, 0, 0));
        rightPicture.setForeground(new Color(255, 255, 255));
        rightPicture.setOpaque(true);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 0, 0));
        buttonPanel.setOpaque(true);
        top = new JLabel("Wybierz która lepsza !!! Aplikacja szuka zdjęć w internecie i sporządza ranking. Miłej zabawy!");
        top.setBackground(new Color(0, 0, 0));
        top.setForeground(new Color(255, 255, 255));
        top.setOpaque(true);
        center = new JLabel();
        center.setBackground(new Color(0, 0, 0));
        center.setForeground(new Color(255, 255, 255));
        center.setOpaque(true);







        lewa = new JButton("Lewa");
        lewa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                score(i);
                change();

            }
        });
        prawa = new JButton("Prawa");
        prawa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(k);
                score(k);
                change();
            }
        });
        buttonPanel.add(lewa);
        buttonPanel.add(prawa);
        buttonPanel.add(statystyka);

        statystyka.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                best.showBest();




            }
        });

    }

    /*
     * Sprawdzanie niepowtarzalności liczb w losowaniu.
     */
    void checkRepeatability() {
        i = randomization(ilosc);
        k = randomization(ilosc);
        while (k == i) {
            k = randomization(ilosc);
        }
        a = Integer.toString(i);
        b = Integer.toString(k);



    }

    /*
     * Zmiana obrazków. Wywoływana w trakcie wyboru, czyli akcji obiektow prawa, lewa.
     */
    void change() {
        try {

            checkRepeatability();
            path1 = new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + a + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_444.jpg");
            path2 = new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + b + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_333.jpg");

            ImageIcon image = new ImageIcon(path1);
            ImageIcon image2 = new ImageIcon(path2);
            if (image.getImageLoadStatus() == 8 && image2.getImageLoadStatus() == 8) {


                rightPicture.setIcon(image2);
                leftPicture.setIcon(image);
            } else {
                change();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        best.setIntegers(wyniki.get(0), wyniki.get(1), wyniki.get(2));
    }

    /*
     * Losowanie liczby.
     */
    int randomization(int i) {

        rand = new Random();
        i = rand.nextInt(i) + 1;
        return i;
    }

    /*
     * Wyświetlenie zawartosci i ustawienia okna.
     */
    void content(int x,int y, boolean visible) {

        mainWindow.getContentPane().add(leftPicture, BorderLayout.WEST);
        mainWindow.getContentPane().add(rightPicture, BorderLayout.EAST);
        mainWindow.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        mainWindow.getContentPane().add(top, BorderLayout.NORTH);
        mainWindow.getContentPane().add(center, BorderLayout.CENTER);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.setEnabled(true);
        mainWindow.setSize(x, y);
        mainWindow.setVisible(visible);
    }

    /*
     * Zapis kolejnych wyników.
     */
    void score(int i) {
        if(index==3){
            index=0;
            wyniki.clear();
        }
        
        wyniki.add(i);
        index++;
        
        

        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
