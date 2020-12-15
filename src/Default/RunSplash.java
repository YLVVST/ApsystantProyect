package Default;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.UIManager;
import DataBase.Connect;

import Main.MainUI;

/**
 *
 * @author YLVVST
 */
public class RunSplash extends JWindow
{

    Splash s;

    public RunSplash() throws InterruptedException
    {
        s = new Splash();
        MainUI window = new MainUI();
        window.setLocationRelativeTo(null);
        this.add(s, BorderLayout.CENTER);
        this.setSize(s.getWidth(), s.getHeight());
        this.setLocationRelativeTo(null);
        setVisible(true);
        s.splashParameters();
        this.dispose();
        window.setVisible(true);
    }

    public static void main(String args[]) throws InterruptedException
    {
        Connect test = new Connect();
        test.connect();
        new RunSplash();
    }
}
