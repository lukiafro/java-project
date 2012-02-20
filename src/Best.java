import java.awt.BorderLayout;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author afro
 */
public class Best {

    private JFrame frame;
    private JLabel label, label2, label3;
    private String a, b, c;
    private int  i, j, k;
    private ImageIcon best, best2, best3;

    

    void setIntegers(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    void showBest() {
        try {
            a = Integer.toString(i);
            b = Integer.toString(j);
            c = Integer.toString(k);
            System.out.println(a + " " + b + " " + c);
            /*
             * Gdy jeszcze nie wybrano przynajmniej 3 zdjęć.
             */
            if(i==0 || j==0 || k==0){
                JOptionPane.showMessageDialog(frame, "Musisz wybrać przynajmniej 3 zdjecia! ");
                
            }
            else{
                
            
            frame = new JFrame("Najlepsze 3 wyniki!!!");

            URL url=new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + a + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_444.jpg");
            URL url2=new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + b + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_444.jpg");
            URL url3=new URL("http://mobitapety.pl/download.php?id=240x320/Kobiety/" + c + ".jpg&id2=Mobitapety_pl_240x320_Kobiety_444.jpg");
            
            best=new ImageIcon(url);
            best2=new ImageIcon(url2);
            best3=new ImageIcon(url3);
            
            label=new JLabel(best);
            label.setBackground(new Color(0,0,0));
            label.setOpaque(true);
            
            label2=new JLabel(best2);
            label2.setBackground(new Color(0,0,0));
            label2.setOpaque(true);
            
            label3=new JLabel(best3);
            label3.setBackground(new Color(0,0,0));
            label3.setOpaque(true);
            
            frame.getContentPane().add(label, BorderLayout.WEST);
            frame.getContentPane().add(label2, BorderLayout.CENTER);
            frame.getContentPane().add(label3, BorderLayout.EAST);
            
            frame.setSize(800, 300);
            frame.setVisible(true);
            }
                  
        } catch (MalformedURLException ex) {
            Logger.getLogger(Best.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


        







    
}
