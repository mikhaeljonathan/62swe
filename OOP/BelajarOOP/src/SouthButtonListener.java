import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthButtonListener implements ActionListener {

    private JButton southButton;

    SouthButtonListener(JButton southButton) {
        this.southButton = southButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        southButton.setText("I've been clicked!");
    }

}
