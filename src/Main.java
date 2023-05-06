import javax.swing.*;
import java.awt.*;

public class Main
{
    private final JPanel pom = new JPanel(new CardLayout());
    JFrame frame = new JFrame("main");
    public static void main(String[] args)
    {
        Main okno = new Main();
        okno.frame.setPreferredSize(new Dimension(1000,900));
        okno.frame.add(okno.pom);
        okno.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.frame.pack();
        okno.frame.setVisible(true);
    }
    public Main()
    {
        login login = new login();
        pom.add(login.menu.loginmain,"login");

    }
}