package quoridor.controller;

import quoridor.model.QuoridorModel;
import quoridor.model.BoardState;
import quoridor.view.QuoridorView;

import java.awt.event.*;
import javax.swing.SwingUtilities;

public class QuoridorControl implements KeyListener, ActionListener {
    private final QuoridorModel model;
    private final QuoridorView view;

    private boolean placeVertical = true; // standardläge
    private int currentPlayer = 1;          

    public QuoridorControl(QuoridorModel model, QuoridorView view) {
        this.model = model;
        this.view = view;

        // Tangenter
        view.addKeyListener(this);
        view.setFocusable(true);

        // Vägg-knappar 
        view.verticalWall.addActionListener(this);
        view.horizontalWall.addActionListener(this);

        // Cell-klick: välj cell där vägg ska placeras 
        int n = model.boardState.size;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                final int row = r;
                final int col = c;
                view.cells[r][c].addActionListener(e -> wallClick(row, col)); // gör knappar klickbara
            }
        }

        view.requestFocusInWindow();
    }

    // Hjälpmetod som byter tur om modellen faktiskt ändrades.
    private boolean switchTurn(BoardState before) {
        if (model.boardState != before) {       
            currentPlayer = 3 - currentPlayer;  
            view.showMessage("Tur: Spelare " + currentPlayer);
            return true;
        }
        return false;
    }

    /** När användaren klickar på en cell för att lägga vägg */
    private void wallClick(int i, int j) {
        BoardState before = model.boardState;
        model.placeWall(before, currentPlayer, i, j, placeVertical);
        view.render();
        if (!switchTurn(before)) {
            view.showMessage("Ogiltig väggplacering - försök igen.");
        } else if (model.hasWinner(model.boardState)) {
            view.showMessage("Spelet är slut! Vinnare: Spelare " + (3 - currentPlayer));
        }
    }

    /** När användaren klickar på vägg-knappar */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.verticalWall) {
            placeVertical = true;
            view.showMessage("Väljer vertikal vägg.");
        } else if (e.getSource() == view.horizontalWall) {
            placeVertical = false;
            view.showMessage("Väljer horisontell vägg.");
        }
        view.requestFocusInWindow();
    }

    /** Tangenttryckningar för att flytta pjäs (flytta den som har turen) */
    @Override
    public void keyReleased(KeyEvent e) {
        int r = (currentPlayer == 1) ? model.boardState.p1r : model.boardState.p2r; 
        int c = (currentPlayer == 1) ? model.boardState.p1c : model.boardState.p2c;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                c++;
                break;
            case KeyEvent.VK_LEFT:
                c--;
                break;
            case KeyEvent.VK_UP:
                r--;
                break;
            case KeyEvent.VK_DOWN:
                r++;
                break;
            default:
                return;
        }

        BoardState before = model.boardState;
        model.movePlayer(before, currentPlayer, r, c); // använd currentPlayer
        view.render();

        if (!switchTurn(before)) {
            view.showMessage("Ogiltigt drag - försök igen.");
            return;
        }
        if (model.hasWinner(model.boardState)) {
            view.showMessage("Spelet är slut! Vinnare: Spelare " + (3 - currentPlayer));
        }
    }

    @Override 
    public void keyPressed(KeyEvent e) {}
    @Override 
    public void keyTyped(KeyEvent e) {}

    public void run() {
        view.render();
        view.showMessage("""
            Spelet startar!
            Tur: Spelare 1
            Flytta med piltangenterna.
            Placera vägg: välj 'Vertical/Horizontal Wall' och klicka på en cell (i,j) som topp-vänster.
            """);
        SwingUtilities.invokeLater(() -> view.requestFocusInWindow());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuoridorModel model = new QuoridorModel();
            QuoridorView view = new QuoridorView(model); // konstruktorn utan boolean
            new QuoridorControl(model, view).run();
        });
    }
}
