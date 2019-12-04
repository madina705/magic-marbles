import javax.swing.*;

public class GameConfigPanel extends JPanel {

    private JTextField width;
    private JTextField height;

    GameConfigPanel(){
        JLabel widthTitle = new JLabel("Width");
        JLabel heightTitle = new JLabel("Height");
        width = new JTextField(8);
        height = new JTextField(8);

        this.add(widthTitle);
        this.add(width);
        this.add(heightTitle);
        this.add(height);
    }

    int getWidthValue(){
        return Integer.parseInt(this.width.getText());
    }

    int getHeightValue(){
        return Integer.parseInt(this.height.getText());
    }
}
