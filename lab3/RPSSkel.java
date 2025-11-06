import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class RPSSkel extends JFrame implements ActionListener, Runnable {
  Gameboard myboard, computersboard;
  int counter;
  Socket socket;
  BufferedReader in;
  PrintWriter out;
  JButton closebutton;
  String player_move;

  RPSSkel () {
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  closebutton = new JButton("Close");
  closebutton.addActionListener(new CloseListener());
  myboard = new Gameboard("You", this);
  computersboard = new Gameboard("Computer");
  JPanel boards = new JPanel();
  boards.setLayout(new GridLayout(1,2));
  boards.add(myboard);
  boards.add(computersboard);
  add(boards, BorderLayout.CENTER);
  add(closebutton, BorderLayout.SOUTH);
  setSize(350, 650);
  setVisible(true);

  connectServer();
  }

    private class CloseListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        disconnectServer();
        System.exit(0);
      }
    }

    private void connectServer() {
      try {
        socket = new Socket("localhost", 4713);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Lisa");
        String hello = in.readLine();
        System.out.println(hello);
      }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Kunde inte koppla upp: " + ex.getMessage());
        }
      }

    private void disconnectServer() {
      try {
        if (socket != null && socket.isConnected() && !socket.isClosed()) {
          if (out != null) {
            out.println("");
            out.flush();
          }
            String bye = in.readLine();
            if (bye != null) System.out.println(bye);

        }
      } 
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Kunde inte koppla ned: " + ex.getMessage());
        }
        // stänger inström samt utström och socket
        finally {
          try { if (in != null) in.close(); } catch (IOException ignore) {} // 
          try { if (out != null) out.close(); } catch (Exception ignore) {}
          try { if (socket != null && !socket.isClosed()) socket.close(); } catch (IOException ignore) {}
      }
    }

  @Override
  public void actionPerformed(ActionEvent e) {
    String choice = e.getActionCommand(); // spelarens "STEN", "PASE" eller "SAX"


    if ((choice.equals("STEN") || choice.equals("PASE") || choice.equals("SAX")) && counter <= 2) {
        counter++;
        showCount(counter);

      if (counter == 3) {
        player_move = choice;
        counter = 0;
        myboard.markPlayed((JButton) e.getSource());
        new Thread(this).start();       //bakgrundstråd
      }      
    }
  }

  /* Metod som avgör utfallet av spelet */
  private void outcome(String player_move, String computer_move) {
      if (player_move.equals(computer_move)) {
        myboard.setLower("Draw");
        computersboard.setLower("Draw");
        return;
        }

      boolean win =
          (player_move.equals("STEN") && computer_move.equals("SAX")) ||
          (player_move.equals("SAX")  && computer_move.equals("PASE")) ||
          (player_move.equals("PASE") && computer_move.equals("STEN"));

      if (win) {
          myboard.wins();
          myboard.setLower("Win");
          computersboard.setLower("Lose");
      } else {
          myboard.setLower("Lose");
          computersboard.setLower("Win");
          computersboard.wins();
      }


  }
  /* Metod som visar antalet drag under knapparna */
  private void showCount(int c) {
    switch (c) {
    case 1:
      // rensa tidigare markeringar
      if (myboard != null) myboard.resetColor();        
      if (computersboard != null) computersboard.resetColor();

      myboard.setLower("ETT");
      computersboard.setLower("ETT");
      break;
    case 2:
      myboard.setLower("TVÅ");
      computersboard.setLower("TVÅ");
      break;
    default:
      break;
    } 
  }

  @Override
  public void run() { 
    try {
      out.println(player_move);         // skicka spelarens drag
      String computer_move = in.readLine();       // läs datorns drag

      SwingUtilities.invokeLater(() -> {
        outcome(player_move, computer_move);

        myboard.setUpper(player_move);
        computersboard.setUpper(computer_move);
        computersboard.markPlayed(computer_move);  
      });
    }
    catch (IOException ex) {
      SwingUtilities.invokeLater(() ->
          JOptionPane.showMessageDialog(this, "Trådfel: " + ex.getMessage()));
    }
  }

  public static void main (String[] u) {
    new RPSSkel();
  }
}
