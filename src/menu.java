import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    public JButton button1;
    public JPanel menu;
    public JPanel loginmain = new JPanel(new CardLayout());
    public menu()
    {
        loginmain.add(menu,"menu");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==button1)
                {
                    CardLayout cardLayout = (CardLayout) loginmain.getLayout();
                    cardLayout.show(loginmain,"login");
                }
            }
        });
    }
}
