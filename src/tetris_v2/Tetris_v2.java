package tetris_v2;

import javax.swing.JFrame;

public class Tetris_v2 extends JFrame {
    public Tetris_v2(){
        add(new TetrisGUI());
        pack();
    }
    
    public static void main(String[] args) {
        Tetris_v2 box = new Tetris_v2();
        
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setLocationRelativeTo(null);
        box.setVisible(true);
    }
}
