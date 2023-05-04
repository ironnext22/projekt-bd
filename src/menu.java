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
    private okno1 t = new okno1();
    private okno2 t2 = new okno2();
    public menu()
    {
        main.add(t.test,"okno1");
        main.add(t2.okno,"okno2");
        loginmain.add(menu,"menu");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    CardLayout cardLayout = (CardLayout) loginmain.getLayout();
                    cardLayout.show(loginmain,"login");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) main.getLayout();
                    cardLayout.show(main,"okno1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) main.getLayout();
                    cardLayout.show(main,"okno2");

            }
        });
    }
}
