package quoridor.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import quoridor.model.BoardState;
import quoridor.model.QuoridorModel;

interface ViewInterface {
    void render();
    void showMessage(String msg);
}

public class QuoridorView extends JFrame implements ViewInterface {
    private final QuoridorModel model;
    private final JPanel boardPanel = new JPanel();
    private final JTextArea messageBox = new JTextArea(3, 20);
    public JButton[][] cells;
    public JButton verticalWall = new JButton("Place Vertical Wall");
    public JButton horizontalWall = new JButton("Place Horizontal Wall");

    public QuoridorView(QuoridorModel model) {
        this.model = model;

        setTitle("Quoridor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        int n = model.boardState.size;
        boardPanel.setLayout(new GridLayout(n, n));
        cells = new JButton[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                JButton b = new JButton();
                b.setFocusable(false);
                b.setFont(b.getFont().deriveFont(Font.BOLD, 16f));
                b.setMargin(new Insets(0, 0, 0, 0));
                b.setBackground(Color.WHITE);
                cells[r][c] = b;
                boardPanel.add(b);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // enkel messageBox längst ned
        messageBox.setEditable(false);
        messageBox.setFocusable(false);
        messageBox.setBackground(new Color(255, 235, 238));
        add(new JScrollPane(messageBox), BorderLayout.SOUTH);

        // knappar för att placera väggar, välj v / h
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(verticalWall);
        buttonPanel.add(horizontalWall);
        add(buttonPanel, BorderLayout.NORTH);


        setSize(600, 650);
        setLocationRelativeTo(null);
        setVisible(true);

        render();
    }

    @Override
    public void render() {
        BoardState s = model.boardState;
        int n = s.size;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int v = s.cells[r][c];
                cells[r][c].setText(v == 0 ? "" : String.valueOf(v));

                int top = 0, left = 0, bottom = 0, right = 0;

                if (r > 0     && s.hWalls[r - 1][c]) top = 3;
                if (r < n - 1 && s.hWalls[r][c])     bottom = 3;
                if (c > 0     && s.vWalls[r][c - 1]) left = 3;
                if (c < n - 1 && s.vWalls[r][c])     right = 3;

                Border wall = new MatteBorder(top, left, bottom, right, Color.BLACK);
                Border grid = new MatteBorder(1, 1, 1, 1, new Color(220, 220, 220));
                cells[r][c].setBorder(BorderFactory.createCompoundBorder(wall, grid));
            }
        }

        messageBox.setText("P1 walls: " + s.p1WallsLeft + " | P2 walls: " + s.p2WallsLeft);
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    @Override
    public void showMessage(String msg) {
        if (!messageBox.getText().isEmpty()) messageBox.append("\n");
        messageBox.append(msg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuoridorModel model = new QuoridorModel();
            new QuoridorView(model);
        });
    }
}


//javac -d out *.java 
//java -cp out quoridor.controller.QuoridorControl