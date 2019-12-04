import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Board extends JPanel implements ActionListener {

    private Marble[][] marbles;
    private int points = 0;
    private GamePlay gamePlay;


    Board(int width, int height, GridLayout layout) {
        setBackground(Color.BLACK);
        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        marbles = new Marble[width][height];
        generateMarbles();
        gamePlay = new GamePlay(this.marbles, width, height);
    }

    private void generateMarbles() {
        for (int row = 0; row < marbles.length; row++) {
            for (int column = 0; column < marbles[0].length; column++) {
                marbles[row][column] = new Marble(Utils.generateRandomColor());
                add(marbles[row][column]);
                marbles[row][column].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Marble selectedMarble = (Marble) source;

        Color selectedBackgroundColor = selectedMarble.getColor();
        for (int row = 0; row < marbles.length; row++) {
            for (int column = 0; column < marbles[0].length; column++) {
                if (selectedMarble == marbles[row][column]) {
                    gamePlay.checkMarble(row, column, selectedBackgroundColor);
                    gamePlay.moveDown();
                    gamePlay.moveRight();
                }
            }
            gamePlay.moveDown();
            gamePlay.moveRight();
        }

        points += gamePlay.getCurrentlyRemoved() *  gamePlay.getCurrentlyRemoved();
        gamePlay.setCurrentlyRemoved(0);

        boolean won = gamePlay.wonGame();
        if (won) {
            JOptionPane.showMessageDialog(null, "Congratulations!!! You won and your Score: " + points, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            marbles = new Marble[0][0];
        } else {
            boolean movesPossible = gamePlay.checkMoves();
            if (!movesPossible) {
                JOptionPane.showMessageDialog(null, "No Moves Possible. Your Score: " + points, "Game Over", JOptionPane.ERROR_MESSAGE);
                marbles = new Marble[0][0];
            }
        }

    }
}
