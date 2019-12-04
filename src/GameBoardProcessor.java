import javax.swing.*;
import java.awt.*;

class GameBoardProcessor {

    private GameConfigPanel gameConfigPanel;
    private String panelTitle = "Please enter width and height";

    GameBoardProcessor(GameConfigPanel gameConfigPanel) {
        this.gameConfigPanel = gameConfigPanel;
    }

    void loadBoard() {
        int option = JOptionPane.OK_OPTION;
        boolean isValid = false;
        while (option == JOptionPane.OK_OPTION && !isValid) {
            option = configDialog(panelTitle);
            if (option == JOptionPane.OK_OPTION) {
                try {
                    int width = this.gameConfigPanel.getWidthValue();
                    int height = this.gameConfigPanel.getHeightValue();
                    if (width >= 3 && height >= 3) {
                        isValid = true;
                        GridLayout layout = new GridLayout(height, width, 5, 5);
                        Board board = new Board(width, height, layout);
                        Utils.createBoard(board);
                    }
                } catch (NumberFormatException e) {
                    panelTitle = "Please enter values more than 0";
                }
            } else {
                System.out.println("Game canceled");
            }
        }
    }

    private int configDialog(String title) {
        return JOptionPane.showConfirmDialog(null, this.gameConfigPanel, title, JOptionPane.OK_CANCEL_OPTION);
    }
}
