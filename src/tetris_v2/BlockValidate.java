package tetris_v2;

public class BlockValidate {
    BlockValidateType valType = new BlockValidateType();
    
    public int checkType(boolean[][] shape){
        int type = 0;
        int mark = 0;
        while(true){
            boolean[][] temp = valType.getShapeType(type);                      // Get block pattern
            for(int i = 0; i < shape.length; i++)
                for(int j = 0; j < shape[i].length; j++)
                    if(shape[i][j] == true)
                        if(shape[i][j] == temp[i][j])                           // Compare block with block pattern
                            mark++;                                             // Mark if both blocks matches
            if(mark == 4)
                return type;                                                    // Return type number
            else{
                if(type == 18)
                    break;                                                      // Break out of loop if all types failed
                else
                    type++;                                                     // Increments to next pattern
            }
            mark = 0;                                                           // Reset marks if current pattern failed
        }
        return -1;                                                              // Return -1 for invalid block
    }
    
    public boolean checkRight(int[][] coord, boolean[][] board){
        if(coord[0][0] == board[0].length - 1 || coord[1][0] == board[0].length - 1 || coord[2][0] == board[0].length - 1 || coord[3][0] == board[0].length - 1)
                return false;
        for(int i = 0; i < 4; i++)
            if(board[coord[i][1]][coord[i][0] + 1])
                return false;
        return true;
    }
    
    public boolean checkLeft(int[][] coord, boolean[][] board){
        if(coord[0][0] == 0 || coord[1][0] == 0 || coord[2][0] == 0 || coord[3][0] == 0)
                return false;
        for(int i = 0; i < 4; i++)
            if(board[coord[i][1]][coord[i][0] - 1])
                return false;
        return true;
    }
    
    public boolean checkBottom(int[][] coord, boolean[][] board){
        for(int i = 0; i < 4; i++)
            if(coord[i][1] == board.length - 1)
                return false;
        if(board[coord[0][1] + 1][coord[0][0]] || board[coord[1][1] + 1][coord[1][0]] || board[coord[2][1] + 1][coord[2][0]] || board[coord[3][1] + 1][coord[3][0]])
                return false;
        return true;
    }

    public boolean checkTurn(int[][] coord, boolean[][] board, int type){
        return compare(coords(coord, type), board);
    }
    
    public int[][] newCoord(int[][] coord, int type){
        return coords(coord, type);
    }

    public int newType(int type){
        switch(type){
            case(0):
                return 1;
            case(1):
                return 0;
            case(2):
                return 3;
            case(3):
                return 4;
            case(4):
                return 5;
            case(5):
                return 2;
            case(6):
                return 7;
            case(7):
                return 8;
            case(8):
                return 9;
            case(9):
                return 6;
            case(10):
                return 11;
            case(11):
                return 12;
            case(12):
                return 13;
            case(13):
                return 10;
            case(14):
                return 15;
            case(15):
                return 14;
            case(16):
                return 17;
            case(17):
                return 16;
            case(18):
                return 18;
            default:
                return -1;
        }
    }

    public int checkLine(boolean[][] board){
        int marks = 0;
        for(int i = board.length - 1; i > 3; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j])
                    marks++;
                if(marks == 10)
                    return i;
            }
            marks = 0;
        }
        return -1;
    }

    public boolean topLineCheck(boolean[][] board){
        for(int i = 3; i >= 0; i--)
            for(int j = 0; j < board[i].length; j++)
                if(board[i][j])
                    return true;
        return false;
    }
    
    private int[][] coords(int[][] coord, int type){
        int[][] temp = new int[coord.length][coord[0].length];
        for(int i = 0; i < coord.length; i++)
            for(int j = 0; j < coord[i].length; j++)
                temp[i][j] = coord[i][j];
        switch(type){
            case(0):
                temp[0][0] = coord[0][0] - 1;
                temp[2][0] = coord[2][0] + 1;
                temp[3][0] = coord[3][0] + 2;
                temp[0][1] = coord[0][1] + 1;
                temp[2][1] = coord[2][1] - 1;
                temp[3][1] = coord[3][1] - 2;
                break;
            case(1):
                temp[0][0] = coord[0][0] + 1;
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0] - 2;
                temp[0][1] = coord[0][1] - 1;
                temp[2][1] = coord[2][1] + 1;
                temp[3][1] = coord[3][1] + 2;
                break;
            case(2):
                temp[1][0] = coord[1][0] + 1;
                temp[2][0] = coord[2][0] + 1;
                temp[3][0] = coord[3][0] - 1;
                temp[3][1] = coord[3][1] + 1;
                break;
            case(3):
                temp[0][0] = coord[0][0] - 1;
                temp[0][1] = coord[0][1] + 1;
                break;
            case(4):
                temp[0][0] = coord[0][0] + 1;
                temp[0][1] = coord[0][1] - 1;
                temp[1][0] = coord[1][0] - 1;
                temp[2][0] = coord[2][0] - 1;
                break;
            case(5):
                temp[3][0] = coord[3][0] + 1;
                temp[3][1] = coord[3][1] - 1;
                break;
            case(6):
                temp[0][0] = coord[0][0] + 1;
                temp[1][0] = coord[1][0] - 1;
                temp[2][1] = coord[2][1] - 1;
                temp[3][1] = coord[3][1] - 1;
                break;
            case(7):
                temp[0][0] = coord[0][0] - 2;
                temp[1][0] = coord[1][0] + 1;
                temp[3][0] = coord[3][0] - 1;
                temp[1][1] = coord[1][1] - 1;
                temp[3][1] = coord[3][1] + 1;
                break;
            case(8):
                temp[2][0] = coord[2][0] + 1;
                temp[3][0] = coord[3][0] - 1;
                temp[0][1] = coord[0][1] + 1;
                temp[1][1] = coord[1][1] + 1;
                break;
            case(9):
                temp[0][0] = coord[0][0] + 1;
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0] + 2;
                temp[0][1] = coord[0][1] - 1;
                temp[2][1] = coord[2][1] + 1;
                break;
            case(10):
                temp[0][0] = coord[0][0] - 1;
                temp[2][0] = coord[2][0] + 2;
                temp[3][0] = coord[3][0] + 1;
                temp[0][1] = coord[0][1] + 1;
                temp[2][1] = coord[2][1] - 1;
                break;
            case(11):
                temp[0][0] = coord[0][0] + 1;
                temp[1][0] = coord[1][0] + 1;
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0] - 1;
                temp[0][1] = coord[0][1] - 1;
                temp[1][1] = coord[1][1] - 1;
                break;
            case(12):
                temp[0][0] = coord[0][0] - 1;
                temp[1][0] = coord[1][0] - 2;
                temp[3][0] = coord[3][0] + 1;
                temp[1][1] = coord[1][1] + 1;
                temp[3][1] = coord[3][1] - 1;
                break;
            case(13):
                temp[0][0] = coord[0][0] + 1;
                temp[1][0] = coord[1][0] + 1;
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0] - 1;
                temp[2][1] = coord[2][1] + 1;
                temp[3][1] = coord[3][1] + 1;
                break;
            case(14):
                temp[0][0] = coord[0][0] - 2;
                temp[1][0] = coord[1][0];
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0] + 1;
                
                temp[0][1] = coord[0][1];
                temp[1][1] = coord[1][1] - 1;
                temp[2][1] = coord[2][1];
                temp[3][1] = coord[3][1] - 1;
                break;
            case(15):
                temp[0][0] = coord[0][0] + 2;
                temp[1][0] = coord[1][0];
                temp[2][0] = coord[2][0] + 1;
                temp[3][0] = coord[3][0] - 1;
                
                temp[0][1] = coord[0][1];
                temp[1][1] = coord[1][1] + 1;
                temp[2][1] = coord[2][1];
                temp[3][1] = coord[3][1] + 1;
                break;
            case(16):
                temp[0][0] = coord[0][0] + 1;
                temp[1][0] = coord[1][0] + 2;
                temp[2][0] = coord[2][0] - 1;
                temp[3][0] = coord[3][0];
                
                temp[0][1] = coord[0][1] + 1;
                temp[1][1] = coord[1][1];
                temp[2][1] = coord[2][1] + 1;
                temp[3][1] = coord[3][1];
                break;
            case(17):
                temp[0][0] = coord[0][0] - 1;
                temp[1][0] = coord[1][0] - 2;
                temp[2][0] = coord[2][0] + 1;
                temp[3][0] = coord[3][0];
                
                temp[0][1] = coord[0][1] - 1;
                temp[1][1] = coord[1][1];
                temp[2][1] = coord[2][1] - 1;
                temp[3][1] = coord[3][1];
                break;
            case(18):
                break;
        }
        return temp;
    } 

    private boolean compare(int[][] temp, boolean[][] board){
        for(int i = 0; i < temp.length; i++)
            for(int j = 0; j < temp[i].length; j++){
                if(temp[i][0] > 9 || temp[i][0] < 0)
                    return false;
                if(temp[i][1] >= board.length)
                    return false;
            }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(board[i][j])
                    for(int m = temp.length - 1; m >= 0; m--)
                        if(temp[m][0] == j && temp[m][1] == i && m != -1)
                            return false;
        return true;
    }
}