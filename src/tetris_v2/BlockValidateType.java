package tetris_v2;

public class BlockValidateType {
    private final boolean _F = false;
    private final boolean _T = true;
    
    private final boolean[][] block_I1 = { {_F,_T,_F,_F},           // Long block |
                                           {_F,_T,_F,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_T,_F,_F} };
    
    private final boolean[][] block_I2 = { {_T,_T,_T,_T},           // Long block -
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    
    private final boolean[][] block_t1 = { {_F,_T,_F,_F},           // T block _|_
                                           {_T,_T,_T,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_t2 = { {_F,_T,_F,_F},           // T block |-
                                           {_F,_T,_T,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_t3 = { {_F,_F,_F,_F},           // T block T
                                           {_T,_T,_T,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_t4 = { {_F,_T,_F,_F},           // T block -|
                                           {_T,_T,_F,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_L1 = { {_F,_T,_F,_F},           // L block L
                                           {_F,_T,_F,_F},
                                           {_F,_T,_T,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_L2 = { {_F,_F,_T,_F},          // L block __|
                                           {_T,_T,_T,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_L3 = { {_T,_T,_F,_F},         // L block
                                           {_F,_T,_F,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_L4 = { {_F,_F,_F,_F},         // L block
                                           {_T,_T,_T,_F},
                                           {_T,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    
    private final boolean[][] block_l1 = { {_F,_T,_F,_F},         // Reverse L
                                           {_F,_T,_F,_F},
                                           {_T,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_l2 = { {_F,_F,_F,_F},
                                           {_T,_T,_T,_F},
                                           {_F,_F,_T,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_l3 = { {_F,_T,_T,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_l4 = { {_T,_F,_F,_F},
                                           {_T,_T,_T,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    
    private final boolean[][] block_Z1 = { {_F,_F,_T,_F},         // Z Block
                                           {_F,_T,_T,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_Z2 = { {_T,_T,_F,_F},
                                           {_F,_T,_T,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    
    private final boolean[][] block_z1 = { {_T,_F,_F,_F},         // Reverse Z
                                           {_T,_T,_F,_F},
                                           {_F,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_z2 = { {_F,_F,_F,_F},
                                           {_F,_T,_T,_F},
                                           {_T,_T,_F,_F},
                                           {_F,_F,_F,_F} };
    
    private final boolean[][] block_S1 = { {_T,_T,_F,_F},
                                           {_T,_T,_F,_F},
                                           {_F,_F,_F,_F},
                                           {_F,_F,_F,_F} };
    
    // Return block pattern
    public boolean[][] getShapeType(int next){
        switch(next){
            case(0):
                return block_I1;
            case(1):
                return block_I2;
            case(2):
                return block_t1;
            case(3):
                return block_t2;
            case(4):
                return block_t3;
            case(5):
                return block_t4;
            case(6):
                return block_L1;
            case(7):
                return block_L2;
            case(8):
                return block_L3;
            case(9):
                return block_L4;
            case(10):
                return block_l1;
            case(11):
                return block_l2;
            case(12):
                return block_l3;
            case(13):
                return block_l4;
            case(14):
                return block_Z1;
            case(15):
                return block_Z2;
            case(16):
                return block_z1;
            case(17):
                return block_z2;
            case(18):
            default:
                return block_S1;
                
        }
    }
}
