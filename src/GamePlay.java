import java.awt.*;

public class GamePlay implements IGamePlay {

    private Marble[][] marbles;
    private int width;
    private int height;
    private int currentlyRemoved = 0;
    private Marble bottom;
    private Marble top;
    private Marble right;
    private Marble left;

    public int getCurrentlyRemoved() {
        return currentlyRemoved;
    }

    public void setCurrentlyRemoved(int currentlyRemoved) {
        this.currentlyRemoved = currentlyRemoved;
    }

    public GamePlay(Marble[][] marbles, int width, int height) {
        this.marbles = marbles;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean checkMoves() {
        for (int row = 0; row < this.marbles.length; row++) {
            for (int column = 0; column < marbles[0].length; column++) {
                Marble current = marbles[row][column];
                if (row - 1 >= 0) {
                    Marble neighbour = this.marbles[row - 1][column];
                    if (checkNeighbour(current, neighbour)) {
                        return true;
                    }
                }
                if (row + 1 < this.width) {
                    Marble neighbour = marbles[row + 1][column];
                    if (checkNeighbour(current, neighbour)) {
                        return true;
                    }
                }
                if (column - 1 >= 0) {
                    Marble neighbour = marbles[row][column - 1];
                    if (checkNeighbour(current, neighbour)) {
                        return true;
                    }
                }
                if (column + 1 < this.width) {
                    Marble neighbour = marbles[row][column + 1];
                    if (checkNeighbour(current, neighbour)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkNeighbour(Marble currentMarble, Marble neighbour) {
        return (currentMarble.getColor() != Color.BLACK && currentMarble.getColor() == neighbour.getColor());
    }

    @Override
    public void checkMarble(int row, int column, Color selectedBackground) {
        Marble current = marbles[row][column];
        if (row + 1 < this.height) {

            bottom = marbles[row + 1][column];

            if (bottom != null && selectedBackground == bottom.getColor()) {
                removeMarble(current);
                checkMarble(row + 1, column, selectedBackground);

            }
        }
        if (row - 1 >= 0 && row - 1 < this.height) {

            top = marbles[row - 1][column];

            if (top != null && selectedBackground == top.getColor()) {
                removeMarble(current);
                checkMarble(row - 1, column, selectedBackground);

            }
        }
        if (column + 1 < this.width) {

            right = marbles[row][column + 1];

            if (right != null && selectedBackground == right.getColor()) {
                removeMarble(current);
                checkMarble(row, column + 1, selectedBackground);
            }
        }
        if (column - 1 >= 0 && column - 1 < this.width) {

            left = marbles[row][column - 1];

            if (left != null && selectedBackground == left.getColor()) {
                removeMarble(current);
                checkMarble(row, column - 1, selectedBackground);

            }

        }
        if (bottom != null) {
            System.out.println(left.getColor());
            System.out.println(top.getColor());
            System.out.println(bottom.getColor());
            System.out.println(right.getColor());
            if (bottom.getColor() == Color.BLACK || top.getColor() == Color.BLACK
                    || left.getColor() == Color.BLACK || right.getColor() == Color.BLACK) {
                removeMarble(current);
            } else {
                current.setColor(selectedBackground);
            }
        }
    }

    @Override
    public void removeMarble(Marble current) {
        if (current.getColor() != Color.BLACK) {
            current.setColor(Color.BLACK);
            currentlyRemoved++;
        }
    }

    @Override
    public boolean wonGame() {
        if (this.marbles.length > 0 && this.marbles[0].length > 0) {
            for (int row = 0; row < this.marbles.length; row++) {
                for (int column = 0; column < this.marbles[0].length; column++) {
                    Marble current = this.marbles[row][column];
                    if (current.getColor() != Color.BLACK) {
                        return false;
                    }
                }

            }
            return true;
        }
        return false;
    }

    @Override
    public void moveRight() {
        for (int i = this.height - 1; i >= 0; i--) {
            for (int j = this.width - 1; j >= 0; j--) {
                if (marbles[i][j].getColor() == Color.BLACK) {
                    Color blackColor = marbles[i][j].getColor();
                    if (j - 1 > -1) {
                        Color color = marbles[i][j - 1].getColor();
                        if (color != Color.BLACK) {
                            marbles[i][j].setColor(color);
                            marbles[i][j - 1].setColor(blackColor);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void moveDown() {
        for (int j = this.width - 1; j >= 0; j--) {
            for (int i = this.height - 1; i >= 0; i--) {
                if (marbles[i][j].getColor() == Color.BLACK) {
                    Color blackColor = marbles[i][j].getColor();
                    if (i - 1 > -1) {
                        Color color = marbles[i - 1][j].getColor();
                        if (color != Color.BLACK) {
                            marbles[i][j].setColor(color);
                            marbles[i - 1][j].setColor(blackColor);
                        }
                    }
                }
            }
        }
    }
}
