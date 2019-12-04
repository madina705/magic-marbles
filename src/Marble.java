import javax.swing.*;
import java.awt.*;

class Marble extends JButton {

    Marble(Color color){
        setBackground(color);
    }

    Color getColor() {
        return getBackground();
    }

    void setColor(Color color) {
        this.setBackground(color);
    }
}
