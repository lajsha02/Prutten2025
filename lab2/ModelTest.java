package quoridor.model;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest {

  @Test
  public void testValidMove() {
    QuoridorModel model = new QuoridorModel();
    BoardState s0 = model.boardState;
    int r0 = s0.p1r;
    int c0 = s0.p1c;

    model.movePlayer(s0, 1, r0 + 1, c0);

    BoardState s1 = model.boardState;
    assertEquals(r0 + 1, s1.p1r);
    assertEquals(c0, s1.p1c);
  }

  @Test
  public void testInvalidMove() {
    QuoridorModel model = new QuoridorModel();
    BoardState s0 = model.boardState;
    int r0 = s0.p1r;
    int c0 = s0.p1c;

    model.movePlayer(s0, 1, r0 + 2, c0);
    BoardState s1 = model.boardState;
    assertSame(s0, s1);
    assertEquals(r0, s1.p1r);
    assertEquals(c0, s1.p1c);
  }

  @Test
  public void testValidWall() {
    QuoridorModel model = new QuoridorModel();
    BoardState s0 = model.boardState;
    int r0 = s0.p1r;
    int c0 = s0.p1c;
    model.placeWall(s0, 1, r0, c0, true);
    BoardState s1 = model.boardState;
    assertEquals(s0.p1WallsLeft - 1, s1.p1WallsLeft);
    assertEquals(s0.p2WallsLeft, s1.p2WallsLeft);
    assertTrue(s1.vWalls[r0][c0]);
    assertFalse(s1.hWalls[r0][c0]);

  }

  @Test
  public void testInvalidWall() {
    QuoridorModel model = new QuoridorModel();
    BoardState s0 = model.boardState;

    model.placeWall(s0, 1, 0, 8, false);
    BoardState s1 = model.boardState;
    assertSame(s0, s1);
    assertEquals(s0.p1WallsLeft, s1.p1WallsLeft);
    assertEquals(s0.p2WallsLeft, s1.p2WallsLeft);

    
  }

  @Test
  public void hasWinner() {
    QuoridorModel model = new QuoridorModel();
    BoardState s0 = model.boardState;
    assertFalse(model.hasWinner(s0));
  }  
}

//cd src
//javac -d out -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar *.java
//KÖR:
// java -cp out:./junit-4.13.2.jar:./hamcrest-core-1.3.jar org.junit.runner.JUnitCore quoridor.model.ModelTest

