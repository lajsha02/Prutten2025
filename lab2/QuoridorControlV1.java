package quoridor.controller;

import quoridor.model.QuoridorModel;
import quoridor.model.BoardState;
import quoridor.view.QuoridorView;

import java.util.Scanner;

public class QuoridorControl {
    private final QuoridorModel model;
    private final QuoridorView view;

    public QuoridorControl(QuoridorModel model, QuoridorView view) {
        this.model = model;
        this.view = view;
    }

    // metod för att köra spelet i enkel textbaserad loop
    public void run() {
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 1;

        while (true) {
            view.render();

            if (model.hasWinner(model.boardState)) {
                view.showMessage("Spelet är slut! Vinnare finns.");
                break;
            }

            System.out.printf("Spelare %d - skriv: move r c | wall i j v|h | q\n> ", currentPlayer);
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("q")) break;
            if (line.isEmpty()) { view.showMessage("Tomt kommando."); continue; }

            String[] p = line.split(" ");  
            String cmd = p[0].toLowerCase();

            boolean success = false;
            BoardState before = model.boardState;

            try {
                switch (cmd) {
                    case "move": {
                        if (p.length != 3) { view.showMessage("Använd: move r c"); break; }
                        int r = Integer.parseInt(p[1]);
                        int c = Integer.parseInt(p[2]);
                        model.movePlayer(before, currentPlayer, r, c);
                        success = (model.boardState != before);
                        if (!success) view.showMessage("Ogiltigt drag.");
                        break;
                    }
                    case "wall": {
                        if (p.length != 4) { view.showMessage("Använd: wall i j v|h"); break; }
                        int i = Integer.parseInt(p[1]);
                        int j = Integer.parseInt(p[2]);
                        char vh = Character.toLowerCase(p[3].charAt(0));
                        if (vh != 'v' && vh != 'h') { view.showMessage("Sista tecken måste vara v eller h."); break; }
                        boolean vertical = (vh == 'v');
                        model.placeWall(before, currentPlayer, i, j, vertical);
                        success = (model.boardState != before);
                        if (!success) view.showMessage("Ogiltig väggplacering.");
                        break;
                    }
                    default:
                        view.showMessage("Okänt kommando.");
                }
            } catch (NumberFormatException e) {
                view.showMessage("Fel format: använd heltal för koordinater.");
            }

            // Om draget lyckades byts spelare
            if (success) {
                view.render();
                if (model.hasWinner(model.boardState)) {
                    view.showMessage("Spelet är slut! Vinnare finns.");
                    break;
                }
                currentPlayer = 3 - currentPlayer; 
            }
        }
    }

    public static void main(String[] args) {
        QuoridorModel model = new QuoridorModel();
        QuoridorView view = new QuoridorView(model);   
        new QuoridorControl(model, view).run();
    }
}
