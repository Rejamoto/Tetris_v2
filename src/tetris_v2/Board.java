package tetris_v2;

/*
 * 
 * Programmer: Thanh Do
 * Date: 06/08/2012
 * Project: Tetris Class Project v2
 * 
 * Completed: 06/23/2012 13:39 - Thanh Do
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
    int typeOfShape, lines, score, gameTime;
    boolean go, next, turned, running;
    int[][] coord;
    boolean[][] boardShape, currentShape;
    
    Timer time = new Timer(1000, new TimeListener());
    BlockValidate valBlocks = new BlockValidate();
    
    public Board(){
        setBoo();
        setInt();
        setPreferredSize(new Dimension(301, 541));
        setFocusable(true);
        addKeyListener(new KeyInput());
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int y = 0; y < 18; y++){
            for(int x = 0; x < 10; x++){
                g.setColor(Color.white);
                if(boardShape[y + 4][x]){
                    g.drawRect(30 * x, 30 * y, 30, 30);
                    g.setColor(Color.orange);
                    g.fillRect(30 * x + 1, 30 * y + 1, 29, 29);
                }
                else if(currentShape[y + 4][x]){
                    g.drawRect(30 * x, 30 * y, 30, 30);
                    g.setColor(Color.orange);
                    g.fillRect(30 * x + 1, 30 * y + 1, 29, 29);
                }
                else{
                    g.setColor(Color.black);
                    g.fillRect(30 * x, 30 * y, 30, 30);
                }
            }
        }
    }
    
    private void setInt(){
        typeOfShape = -1;
        lines = 0;
        score = 0;
        gameTime = 0;
        coord = new int[4][2];
    }
    
    private void setBoo(){
        go = false;
        next = true;
        turned = false;
        running = true;
        boardShape = new boolean[22][10];
        currentShape = new boolean[22][10];
    }
    
    private void turn(){
        if(valBlocks.checkTurn(coord, boardShape, typeOfShape)){
            coord = valBlocks.newCoord(coord, typeOfShape);
            typeOfShape = valBlocks.newType(typeOfShape);
            turned = true;
            currentShape = new boolean[22][10];
            int x, y;
            for(int i = 3; i >= 0; i--){
                if(i > -1){
                    x = coord[i][0];
                    y = coord[i][1];
                    currentShape[y][x] = true;
                }
            }
        }
    }
    
    private void right(){
        for(int i = currentShape.length - 1; i >= 0; i--)
            for(int j = currentShape[i].length - 1; j >= 0; j--)
                if(currentShape[i][j] && j + 1 != 10 && j + 1 != -1){
                    currentShape[i][j] = false;
                    currentShape[i][j + 1] = true;
                }
        coord[0][0]++;
        coord[1][0]++;
        coord[2][0]++;
        coord[3][0]++;
    }
    
    private void left(){
        for(int i = currentShape.length - 1; i >= 0; i--)
            for(int j = 0; j < currentShape[i].length; j++)
                if(currentShape[i][j] && j - 1 != 10 && j - 1 != -1){
                    currentShape[i][j] = false;
                    currentShape[i][j - 1] = true;
                }
        coord[0][0]--;
        coord[1][0]--;
        coord[2][0]--;
        coord[3][0]--;
    }
    
    private boolean moveBlock(){
        int x, y;
        if(valBlocks.checkBottom(coord, boardShape)){
            currentShape = new boolean[22][10];
            for(int i = 3; i >= 0; i--){
                if(turned && coord[i][1] < 21)
                    coord[i][1]++;
                
                x = coord[i][0];
                y = coord[i][1];
                
                if(y < 21){
                    currentShape[y][x] = false;
                    currentShape[y + 1][x] = true;
                    if(!turned)
                        coord[i][1]++;
                }
            }
            turned = false;
            return turned;
        }
        else{
            for(int g = 0; g < 2; g++){
                for(int i = 0; i < 4; i++){
                    x = coord[i][0];
                    y = coord[i][1];

                    boardShape[y][x] = currentShape[y][x];
                }
            }
            next = true;
            return next;
        }
    }
    
    private void removeLine(){
        int fullLine = valBlocks.checkLine(boardShape);
        
        while(fullLine != -1){
            currentShape = new boolean[22][10];
            for(int i = fullLine; i >= 4; i--)
                for(int j = 0; j < boardShape[i].length; j++)
                    boardShape[i][j] = boardShape[i - 1][j];
            lines++;
            score += (int)((Math.random() * lines) + (Math.random() * 11) + (gameTime / 60));
            fullLine = valBlocks.checkLine(boardShape);
        }
    }
    
    public boolean lose(){
        return valBlocks.topLineCheck(boardShape);
    }
    
    public boolean pause(){
        try{
            running = false;
            go = true;
            //System.out.println("Paused\nTime:" + gameTime + "\nScore:" + score + "\nLines:" + lines);
            time.stop();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
    
    public boolean start(){
        try{
            running = true;
            time.start();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
    
    public boolean next(){
        return next;
    }
    
    public void getShape(boolean[][] newShape){
        currentShape = new boolean[22][10];
        typeOfShape = valBlocks.checkType(newShape);
        if(typeOfShape != -1){
            int move = 0;
            for(int y = 0; y < newShape.length; y++)
                for(int x = 0; x < newShape[y].length; x++){
                    currentShape[y][x + 3] = newShape[y][x];
                    if(newShape[y][x]){
                        coord[move][0] = x + 3;
                        coord[move][1] = y;
                        move++;
                    }
                }
            next = false;
            time.start();
        }
    }
    
    public int getScore(){
        return score;
    }
    
    public int getLines(){
        return lines;
    }
    
    public int getTime(){
        return gameTime;
    }
    
    public boolean restart(){
        setBoo();
        setInt();
        time.start();
        return true;
    }
    
    class KeyInput implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(running){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        turn();
                        break;
                    case KeyEvent.VK_LEFT:
                        if(valBlocks.checkLeft(coord, boardShape))
                            left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(valBlocks.checkRight(coord, boardShape))
                            right();
                        break;
                    case KeyEvent.VK_DOWN:
                        if(valBlocks.checkBottom(coord, boardShape))
                            moveBlock();
                        break;
                }
                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_PAUSE){
                if(!running)
                    start();
                else
                    pause();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    class TimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(go)
                time.setDelay(1000);
            go = false;
            gameTime++;
            if(moveBlock())
                removeLine();
            repaint();
            if(lose())
                time.stop();
        }
    }
}
