package quoridor.view;

import quoridor.model.BoardState;
import quoridor.model.QuoridorModel;

interface ViewInterface {
    void render();
    void showMessage(String msg);
}

public class QuoridorView implements ViewInterface {
    private final QuoridorModel model;

    public QuoridorView(QuoridorModel model) {
        this.model = model;
    }

    @Override
    public void render() {
        BoardState s = model.boardState;
        int n = s.size;

        // Skriver kolumnnummer på brädet
        System.out.print("  ");
        for (int c = 0; c < n; c++) {
            System.out.printf("%d  ", c);        
            if (c < n - 1) System.out.print(" "); 
        }
        System.out.println();

        for (int r = 0; r < n; r++) {
            System.out.print(r);
            // Rad med celler + vertikala väggar
            for (int c = 0; c < n; c++) {

                int v = s.cells[r][c];
                char ch = (v == 0) ? '.' : (v == 1 ? '1' : '2');
                System.out.print(" " + ch + " ");
                if (c < n - 1) System.out.print(s.vWalls[r][c] ? "|" : " ");
            }
            System.out.println();

            // Rad med horisontella väggar 
            if (r < n - 1) {
                for (int c = 0; c < n; c++) {
                    System.out.print(s.hWalls[r][c] ? "---" : "   ");
                    if (c < n - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }

        System.out.println("P1 walls: " + s.p1WallsLeft + " | P2 walls: " + s.p2WallsLeft);
        System.out.println();
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
