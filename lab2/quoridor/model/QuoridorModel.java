package quoridor.model;

public class QuoridorModel {
  public BoardState boardState;

  public QuoridorModel() {
  this.boardState = BoardState.initial(9, 10); // 9x9, 10 väggar per spelare
}

  public void movePlayer(BoardState s, int player, int toR, int toC) {
      if (QuoridorEngine.isValidMove(s, player, toR, toC)) {
        boardState = QuoridorEngine.applyMove(s, player, toR, toC);
      }
      else { System.out.println("Invalid move!"); }
  }

  public void placeWall(BoardState s, int player, int i, int j, boolean vertical) {
      if (QuoridorEngine.canPlaceWall(s, i, j, vertical))
        boardState = QuoridorEngine.applyWall(s, player, i, j, vertical);
      else
        System.out.println("Invalid wall placement!");
    }
  public boolean hasWinner(BoardState s) {
    return QuoridorEngine.hasWinner(s);
}
}