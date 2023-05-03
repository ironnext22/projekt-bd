import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    public JButton back;
    public JPanel menu;
    private JPanel main;
    private JPanel manu;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    public JPanel loginmain = new JPanel(new CardLayout());
    private test t = new test();
    public menu()
    {
        main.add(t.test,"test");
        loginmain.add(menu,"menu");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== back)
                {
                    CardLayout cardLayout = (CardLayout) loginmain.getLayout();
                    cardLayout.show(loginmain,"login");
                }
            }
        });
    }
}
