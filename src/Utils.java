import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Utils {
    private static Random random = new Random();
    static Color generateRandomColor() {
        int randomColor = random.nextInt(3);
        Color color;
        switch (randomColor) {
            case 0:
                color = Color.red;
                break;
            case 1:
                color = Color.green;
                break;
            case 2:
                color = Color.blue;
                break;
            default:
                color = Color.black;
                break;
        }
        return color;
    }

    static void createBoard(Board board){
        JFrame frame = new JFrame("Magic Marbles");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setContentPane(board);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New");
        fileMenu.add(newGame);
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        newGame.addActionListener(e -> {
            new Game();
            frame.dispose();
        });
        exit.addActionListener(e -> System.exit(0));

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
