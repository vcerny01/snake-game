package menu;
import javax.swing.*;
import java.awt.*;

public class HeaderText extends JTextField {
    public HeaderText(String text, JPanel motherElement){
        super(text);
        this.setFont(new Font("Arial", Font.BOLD, 42));
        this.setEditable(false);
        this.setBackground(motherElement.getBackground());
    }
}