import java.awt.*;

public interface IGamePlay {
    boolean checkMoves();
    boolean checkNeighbour(Marble currentMarble, Marble neighbour);
    void checkMarble(int row, int column, Color selectedBackground);
    void removeMarble(Marble current);
    boolean wonGame();
    void moveRight();
    void moveDown();
}
