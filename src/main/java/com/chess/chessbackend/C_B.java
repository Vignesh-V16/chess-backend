package com.chess.chessbackend;

import java.util.*;
class Chess_board
{
   
    

    public static void resetBoardOnly() {
        chessBoard = new String[][]{
            {"R1","H1","B1","WQ","WK","B2","H2","R2"},
            {"P","P","P","P","P","P","P","P"},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".","."},
            {"p","p","p","p","p","p","p","p"},
            {"r1","h1","b1","q","k","b2","h2","r2"}
        };
    }
    

    public static String chessBoard[][]={
        {"R1","H1","B1","WQ","WK","B2","H2","R2"},{"P","P","P","P","P","P","P","P"},
        {".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".","."},
        {".",".",".",".",".",".",".","."},{".",".",".",".",".",".",".","."},
        {"p","p","p","p","p","p","p","p"},{"r1","h1","b1","q","k","b2","h2","r2"}};
    static String dum_chessBoard[][]=new String[8][8];
    void copy()
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                dum_chessBoard[i][j]=chessBoard[i][j];
            }
        }
    }
    void display()
    {
        for(int i=0;i<chessBoard.length;i++)
        {
            for(int j=0;j<chessBoard[i].length;j++)
            {
                System.out.print(chessBoard[i][j]+"   ");
            }
            System.out.println();
        }
    }  
    void Ddisplay()
    {
        System.out.println("\tDummy"+"\n\n");
        for(int i=0;i<dum_chessBoard.length;i++)
        {
            for(int j=0;j<dum_chessBoard[i].length;j++)
            {
                System.out.print(dum_chessBoard[i][j]+"   ");
            }
            System.out.println();
        }
    }
    String[][] getDummyBoard()
{
    return dum_chessBoard;
}

    void pathDisplay(int x,int y)
    {
        dum_chessBoard[x][y]="_";
    }
    void attackDisplay(int p,int q)
    {
        dum_chessBoard[p][q]="x";
    }
}
class White_Pawn extends Chess_board
{
    
    White_Pawn(int i,int j)
    {
        copy();
        int a=i,b=j;
        if(j<7)
        {
            if(chessBoard[++a][++b]!="." && chessBoard[a][b].equals((chessBoard[a][b].toLowerCase())))
            {
                attackDisplay(a,b);
            }
            a--;
            b--;
        }
        if(j>0 && (chessBoard[++a][--b]!=".") && chessBoard[a][b].equals(chessBoard[a][b].toLowerCase()))
        {
            attackDisplay(a,b);
        }
        if(i==1)
        {
            if(chessBoard[++i][j]==".")
            {            
                pathDisplay(i,j);
                if(chessBoard[++i][j]==".")
                {
                    pathDisplay(i,j);
                }
            }
        }          
        else
        {
            if(chessBoard[++i][j]==".")
            {
                pathDisplay(i,j);
            }
        }
    }
}
class Black_Pawn extends Chess_board
{
    
    Black_Pawn(int i,int j)
    {
        copy();
        int a=i,b=j;
        if(j<7)
        {
            if(chessBoard[--a][++b]!="." && chessBoard[a][b].equals((chessBoard[a][b].toUpperCase())))
            {
                attackDisplay(a,b);
            }
            a++;
            b--;
        }
        if(j>0 && (chessBoard[--a][--b]!=".") && chessBoard[a][b].equals(chessBoard[a][b].toUpperCase()))
        {
            attackDisplay(a,b);
        }
        if(i==6)
        {
            if(chessBoard[--i][j]==".")
            {            
                pathDisplay(i,j);
                if(chessBoard[--i][j]==".")
                {
                    pathDisplay(i,j);
                }
            }
        }          
        else
        {
            if(chessBoard[--i][j]==".")
            {
                pathDisplay(i,j);
            }
        }
    }
}
class White_Rook extends Chess_board
{
    int up,dw,rg,lf;
    White_Rook(int i,int j)
    {
        copy();
        up=i;
        while(up!=0)
        {
            if(chessBoard[--up][j]==".")
            {
                pathDisplay(up,j);
            }
            else
            {
                if(chessBoard[up][j].equals(chessBoard[up][j].toLowerCase()))
                {
                    attackDisplay(up,j);
                }
                up=0;
            }
        }
        dw=i;
        while(dw!=7)
        {
            if(chessBoard[++dw][j]==".")
            {
                pathDisplay(dw,j);
            }
            else
            {
                if(chessBoard[dw][j].equals(chessBoard[dw][j].toLowerCase()))
                {
                    attackDisplay(dw,j);
                }
                dw=7;
            }
        }
        rg=j;
        while(rg!=7)
        {
            if(chessBoard[i][++rg]==".")
            {
                pathDisplay(i,rg);
            }
            else
            {
                if(chessBoard[i][rg].equals(chessBoard[i][rg].toLowerCase()))
                {
                    attackDisplay(i,rg);
                }
                rg=7;
            }
        }
        lf=j;
        while(lf!=0)
        {
            if(chessBoard[i][--lf]==".")
            {
                pathDisplay(i,lf);
            }
            else
            {
                if(chessBoard[i][lf].equals(chessBoard[i][lf].toLowerCase()))
                {
                    attackDisplay(i,lf);
                }
                lf=0;
            }
        }
    }
}
class Black_Rook extends Chess_board
{
    int up,dw,rg,lf;
    Black_Rook(int i,int j)
    {
        copy();
        up=i;
        while(up!=0)
        {
            if(chessBoard[--up][j]==".")
            {
                pathDisplay(up,j);
            }
            else
            {
                if(chessBoard[up][j].equals(chessBoard[up][j].toUpperCase()))
                {
                    attackDisplay(up,j);
                }
                up=0;
            }
        }
        dw=i;
        while(dw!=7)
        {
            if(chessBoard[++dw][j]==".")
            {
                pathDisplay(dw,j);
            }
            else
            {
                if(chessBoard[dw][j].equals(chessBoard[dw][j].toUpperCase()))
                {
                    attackDisplay(dw,j);
                }
                dw=7;
            }
        }
        rg=j;
        while(rg!=7)
        {
            if(chessBoard[i][++rg]==".")
            {
                pathDisplay(i,rg);
            }
            else
            {
                if(chessBoard[i][rg].equals(chessBoard[i][rg].toUpperCase()))
                {
                    attackDisplay(i,rg);
                }
                rg=7;
            }
        }
        lf=j;
        while(lf!=0)
        {
            if(chessBoard[i][--lf]==".")
            {
                pathDisplay(i,lf);
            }
            else
            {
                if(chessBoard[i][lf].equals(chessBoard[i][lf].toUpperCase()))
                {
                    attackDisplay(i,lf);
                }
                lf=0;
            }
        }
    }
}
class White_Bishop extends Chess_board
{
    int dw_i,dw_j,up_i,up_j;
    White_Bishop(int i,int j)
    {
        copy();
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=7)
        {
            if(chessBoard[++dw_i][++dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toLowerCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=0)
        {
            if(chessBoard[++dw_i][--dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toLowerCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=0)
        {
            if(chessBoard[--up_i][--up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toLowerCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=7)
        {
            if(chessBoard[--up_i][++up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toLowerCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
    }
}
class Black_Bishop extends Chess_board
{
    int dw_i,dw_j,up_i,up_j;
    Black_Bishop(int i,int j)
    {
        copy();
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=7)
        {
            if(chessBoard[++dw_i][++dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toUpperCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=0)
        {
            if(chessBoard[++dw_i][--dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toUpperCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=0)
        {
            if(chessBoard[--up_i][--up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toUpperCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=7)
        {
            if(chessBoard[--up_i][++up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toUpperCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
    }
}
class White_Queen extends Chess_board
{
    int up,dw,rg,lf,dw_i,dw_j,up_i,up_j;
    White_Queen(int i,int j)
    {
        copy();
        up=i;
        while(up!=0)
        {
            if(chessBoard[--up][j]==".")
            {
                pathDisplay(up,j);
            }
            else
            {
                if(chessBoard[up][j].equals(chessBoard[up][j].toLowerCase()))
                {
                    attackDisplay(up,j);
                }
                up=0;
            }
        }
        dw=i;
        while(dw!=7)
        {
            if(chessBoard[++dw][j]==".")
            {
                pathDisplay(dw,j);
            }
            else
            {
                if(chessBoard[dw][j].equals(chessBoard[dw][j].toLowerCase()))
                {
                    attackDisplay(dw,j);
                }
                dw=7;
            }
        }
        rg=j;
        while(rg!=7)
        {
            if(chessBoard[i][++rg]==".")
            {
                pathDisplay(i,rg);
            }
            else
            {
                if(chessBoard[i][rg].equals(chessBoard[i][rg].toLowerCase()))
                {
                    attackDisplay(i,rg);
                }
                rg=7;
            }
        }
        lf=j;
        while(lf!=0)
        {
            if(chessBoard[i][--lf]==".")
            {
                pathDisplay(i,lf);
            }
            else
            {
                if(chessBoard[i][lf].equals(chessBoard[i][lf].toLowerCase()))
                {
                    attackDisplay(i,lf);
                }
                lf=0;
            }
        }    
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=7)
        {
            if(chessBoard[++dw_i][++dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toLowerCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=0)
        {
            if(chessBoard[++dw_i][--dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toLowerCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=0)
        {
            if(chessBoard[--up_i][--up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toLowerCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=7)
        {
            if(chessBoard[--up_i][++up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toLowerCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
    }
}
class Black_Queen extends Chess_board
{
    int up,dw,rg,lf,dw_i,dw_j,up_i,up_j;
    Black_Queen(int i,int j)
    {
        copy();
        up=i;
        while(up!=0)
        {
            if(chessBoard[--up][j]==".")
            {
                pathDisplay(up,j);
            }
            else
            {
                if(chessBoard[up][j].equals(chessBoard[up][j].toUpperCase()))
                {
                    attackDisplay(up,j);
                }
                up=0;
            }
        }
        dw=i;
        while(dw!=7)
        {
            if(chessBoard[++dw][j]==".")
            {
                pathDisplay(dw,j);
            }
            else
            {
                if(chessBoard[dw][j].equals(chessBoard[dw][j].toUpperCase()))
                {
                    attackDisplay(dw,j);
                }
                dw=7;
            }
        }
        rg=j;
        while(rg!=7)
        {
            if(chessBoard[i][++rg]==".")
            {
                pathDisplay(i,rg);
            }
            else
            {
                if(chessBoard[i][rg].equals(chessBoard[i][rg].toUpperCase()))
                {
                    attackDisplay(i,rg);
                }
                rg=7;
            }
        }
        lf=j;
        while(lf!=0)
        {
            if(chessBoard[i][--lf]==".")
            {
                pathDisplay(i,lf);
            }
            else
            {
                if(chessBoard[i][lf].equals(chessBoard[i][lf].toUpperCase()))
                {
                    attackDisplay(i,lf);
                }
                lf=0;
            }
        }    
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=7)
        {
            if(chessBoard[++dw_i][++dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toUpperCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        dw_i=i;
        dw_j=j;
        while(dw_i!=7 && dw_j!=0)
        {
            if(chessBoard[++dw_i][--dw_j]==".")
            {
                pathDisplay(dw_i,dw_j);
            }
            else
            {
                if(chessBoard[dw_i][dw_j].equals(chessBoard[dw_i][dw_j].toUpperCase()))
                {
                    attackDisplay(dw_i,dw_j);
                }
                dw_i=7;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=0)
        {
            if(chessBoard[--up_i][--up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toUpperCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
        up_i=i;
        up_j=j;
        while(up_i!=0 && up_j!=7)
        {
            if(chessBoard[--up_i][++up_j]==".")
            {
                pathDisplay(up_i,up_j);
            }
            else
            {
                if(chessBoard[up_i][up_j].equals(chessBoard[up_i][up_j].toUpperCase()))
                {
                    attackDisplay(up_i,up_j);
                }
                up_i=0;
            }
        }
    }
}
class White_Horse extends Chess_board
{
    White_Horse(int i,int j)
    {
        copy();
        int count=0,arri[]={i-1,i-2,i-2,i-1,i+1,i+2,i+2,i+1},arrj[]={j-2,j-1,j+1,j+2,j+2,j+1,j-1,j-2};
        while(count<8)
        {
            int ti=arri[count];
            int tj=arrj[count];
            if(ti>-1 && ti<8)
            {
                if(tj>-1 && tj<8)
                {
                    if(chessBoard[ti][tj]==".")
                    {
                        pathDisplay(ti,tj);
                    }
                    else
                    {
                        if(chessBoard[ti][tj].equals(chessBoard[ti][tj].toLowerCase()))
                        {
                            attackDisplay(ti,tj);
                        }
                    }
                }
            }
            count++;
        }
    }
}
class Black_Horse extends Chess_board
{
    Black_Horse(int i,int j)
    {
        copy();
        int count=0,arri[]={i-1,i-2,i-2,i-1,i+1,i+2,i+2,i+1},arrj[]={j-2,j-1,j+1,j+2,j+2,j+1,j-1,j-2};
        while(count<8)
        {
            int ti=arri[count];
            int tj=arrj[count];
            if(ti>-1 && ti<8)
            {
                if(tj>-1 && tj<8)
                {
                    if(chessBoard[ti][tj]==".")
                    {
                        pathDisplay(ti,tj);
                    }
                    else
                    {
                        if(chessBoard[ti][tj].equals(chessBoard[ti][tj].toUpperCase()))
                        {
                            attackDisplay(ti,tj);
                        }
                    }
                }
            }
            count++;
        }
    }
}
class White_King extends Chess_board
{ 
    White_King(int i,int j) 
    { 
        copy();
        for(int x=i-1;x<i+2;x++) 
        { 
            if(x>=0 && x<=7) 
            { 
                for(int y=j-1;y<j+2;y++) 
                { 
                    if(y>=0 && y<=7) 
                    { 
                        if(chessBoard[x][y]==".") 
                        { 
                            pathDisplay(x,y); 
                        } 
                        else 
                        { 
                            if(chessBoard[x][y].equals(chessBoard[x][y].toLowerCase())) 
                            { 
                                attackDisplay(x,y); 
                            } 
                        } 
                    } 
                } 
            } 
        } 
    }
}
class Black_King extends Chess_board
{ 
    Black_King(int i,int j) 
    { 
        copy();
        for(int x=i-1;x<i+2;x++) 
        { 
            if(x>=0 && x<=7) 
            { 
                for(int y=j-1;y<j+2;y++) 
                { 
                    if(y>=0 && y<=7) 
                    { 
                        if(chessBoard[x][y]==".") 
                        { 
                            pathDisplay(x,y); 
                        } 
                        else 
                        { 
                            if(chessBoard[x][y].equals(chessBoard[x][y].toUpperCase())) 
                            { 
                                attackDisplay(x,y); 
                            } 
                        } 
                    } 
                } 
            } 
        } 
    }
}
class Move extends Chess_board
{
    static int a,b;
    static String pic;
    Move(int i,int j)
    {
        a=i;
        b=j;
        pic=chessBoard[i][j];
    }
    Move(int i,int j,int k)
    {
        chessBoard[a][b]=".";
        chessBoard[i][j]=pic;
        display();
    }
}
public class C_B
{   
     public static String currentTurn = "WHITE"; // WHITE starts

    public static boolean gameOver = false;
    public static String winner = ""; // "WHITE" or "BLACK"
    public static Stack<String[][]> history = new Stack<>();
    public static Stack<String> turnHistory = new Stack<>();
    
    
    public static String[][] calculateMoves(int row, int col) {

    // Empty board (default)
    String[][] empty = new String[8][8];
    for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
            empty[i][j] = ".";

    // ❌ Game already over → no moves
    if (gameOver) return empty;

    String piece = Chess_board.chessBoard[row][col];

    // ❌ Empty square
    if (piece == null || piece.equals(".") || piece.equals(" "))
        return empty;

    // 🔒 TURN VALIDATION
    boolean isWhitePiece = piece.equals(piece.toUpperCase());

    if (currentTurn.equals("WHITE") && !isWhitePiece)
        return empty;

    if (currentTurn.equals("BLACK") && isWhitePiece)
        return empty;

    /* ===============================
       PIECE MOVE CALCULATION
    =============================== */

    // ♙ WHITE PAWN
    if (piece.equals("P")) {
        return new White_Pawn(row, col).getDummyBoard();
    }

    // ♟ BLACK PAWN
    if (piece.equals("p")) {
        return new Black_Pawn(row, col).getDummyBoard();
    }

    // ♖ WHITE ROOK
    if (piece.equals("R1") || piece.equals("R2")) {
        return new White_Rook(row, col).getDummyBoard();
    }

    // ♜ BLACK ROOK
    if (piece.equals("r1") || piece.equals("r2")) {
        return new Black_Rook(row, col).getDummyBoard();
    }

    // ♘ WHITE KNIGHT
    if (piece.equals("H1") || piece.equals("H2")) {
        return new White_Horse(row, col).getDummyBoard();
    }

    // ♞ BLACK KNIGHT
    if (piece.equals("h1") || piece.equals("h2")) {
        return new Black_Horse(row, col).getDummyBoard();
    }

    // ♗ WHITE BISHOP
    if (piece.equals("B1") || piece.equals("B2")) {
        return new White_Bishop(row, col).getDummyBoard();
    }

    // ♝ BLACK BISHOP
    if (piece.equals("b1") || piece.equals("b2")) {
        return new Black_Bishop(row, col).getDummyBoard();
    }

    // ♕ WHITE QUEEN
    if (piece.equals("WQ")) {
        return new White_Queen(row, col).getDummyBoard();
    }

    // ♛ BLACK QUEEN
    if (piece.equals("q")) {
        return new Black_Queen(row, col).getDummyBoard();
    }

    // ♔ WHITE KING
    if (piece.equals("WK")) {
        return new White_King(row, col).getDummyBoard();
    }

    // ♚ BLACK KING
    if (piece.equals("k")) {
        return new Black_King(row, col).getDummyBoard();
    }

    return empty; // safety
}

public static String[][] copyBoard(String[][] board) {
    String[][] copy = new String[8][8];
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            copy[i][j] = board[i][j];
        }
    }
    return copy;
}
 public static void resetGame() {
        Chess_board.resetBoardOnly();
        currentTurn = "WHITE";
        gameOver = false;
        winner = "";
        history.clear();
        turnHistory.clear();
    }
public static boolean makeMove(int fr, int fc, int tr, int tc) {

    // ❌ Game already over
    if (gameOver) return false;

    String piece = Chess_board.chessBoard[fr][fc];
    if (piece == null || piece.equals(".")) return false;

    boolean isWhitePiece = piece.equals(piece.toUpperCase());

    // 🔒 TURN VALIDATION
    if (currentTurn.equals("WHITE") && !isWhitePiece) return false;
    if (currentTurn.equals("BLACK") && isWhitePiece) return false;

    String[][] moves = calculateMoves(fr, fc);

    // ❌ Invalid destination
    if (!"_".equals(moves[tr][tc]) &&
        !"x".equals(moves[tr][tc])) {
        return false;
    }

    // 💾 SAVE FOR UNDO
    history.push(copyBoard(Chess_board.chessBoard));
    turnHistory.push(currentTurn);

    String target = Chess_board.chessBoard[tr][tc];

    // 👑 KING CAPTURE → GAME OVER
    if ("WK".equals(target)) {
        gameOver = true;
        winner = "BLACK";
    } else if ("k".equals(target)) {
        gameOver = true;
        winner = "WHITE";
    }

    // ✅ EXECUTE MOVE
    Chess_board.chessBoard[tr][tc] = piece;
    Chess_board.chessBoard[fr][fc] = ".";

    // 🔁 SWITCH TURN
    currentTurn = currentTurn.equals("WHITE") ? "BLACK" : "WHITE";

    return true;
}

public static boolean undoMove() {

    if (history.isEmpty()) return false;

    Chess_board.chessBoard = history.pop();
    currentTurn = turnHistory.pop();

    gameOver = false;
    winner = "";

    return true;
}
}