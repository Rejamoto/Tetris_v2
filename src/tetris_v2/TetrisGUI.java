package tetris_v2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Thanh Do
 * Date: June 4, 2012
 * 
 */

public class TetrisGUI extends JPanel {
    int next;
    Timer time = new Timer(100, new Refresh());
    Board game = new Board();
    BlockValidateType block = new BlockValidateType();
    JTextField score = new JTextField("0");
    JTextField lines = new JTextField("0");
    JTextField gameTime = new JTextField("0");
    
    public TetrisGUI(){
        JPanel sidePanel = new JPanel();
        JButton start = new JButton("Start");
        JButton pause = new JButton("Pause");
        JButton restart = new JButton("Restart");
        JButton close = new JButton("Exit");
        JLabel t = new JLabel("Time");
        JLabel l = new JLabel("Lines");
        JLabel s = new JLabel("Score");
        
        score.setForeground(Color.red);
        score.setBackground(Color.black);
        score.setHorizontalAlignment(JTextField.RIGHT);
        score.setColumns(12);
        score.setEditable(false);
        score.setFocusable(false);
        
        lines.setForeground(Color.red);
        lines.setBackground(Color.black);
        lines.setHorizontalAlignment(JTextField.RIGHT);
        lines.setColumns(12);
        lines.setEditable(false);
        lines.setFocusable(false);
        
        gameTime.setForeground(Color.red);
        gameTime.setBackground(Color.black);
        gameTime.setHorizontalAlignment(JTextField.RIGHT);
        gameTime.setColumns(12);
        gameTime.setEditable(false);
        gameTime.setFocusable(false);
        
        sidePanel.setPreferredSize(new Dimension(150, 541));
        sidePanel.setBackground(Color.gray);
        sidePanel.add(t);
        sidePanel.add(gameTime);
        sidePanel.add(l);
        sidePanel.add(lines);
        sidePanel.add(s);
        sidePanel.add(score);
        sidePanel.add(start);
        sidePanel.add(pause);
        sidePanel.add(restart);
        sidePanel.add(close);
        sidePanel.setFocusable(false);
        
        //start.setBackground(Color.black);
        
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                time.start();
                game.getShape(block.getShapeType((int)(Math.random() * 19)));
            }
        });
        pause.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                game.pause();
            }
        });
        restart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                game.restart();
            }
        });
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });
        start.setFocusable(false);
        pause.setFocusable(false);
        restart.setFocusable(false);
        close.setFocusable(false);
        game.setFocusable(true);
        
        add(game);
        add(sidePanel);
    }
    
    class Refresh implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(game.next())
                game.getShape(block.getShapeType((int)(Math.random() * 19)));
            score.setText(Integer.toString(game.getScore()));
            lines.setText(Integer.toString(game.getLines()));
            gameTime.setText(Integer.toString(game.getTime()));
        }
    }
}
