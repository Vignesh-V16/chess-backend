package com.chess.chessbackend;

import java.util.*;
class Chess_board
{
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
    static String[][] calculateMoves(int row, int col)
{
    String piece = Chess_board.chessBoard[row][col];

    if (piece.equals("P")) {
        White_Pawn p = new White_Pawn(row, col);
        return p.getDummyBoard();
    }
    else if (piece.equals("p")) {
        Black_Pawn p = new Black_Pawn(row, col);
        return p.getDummyBoard();
    }
    else if (piece.equals("R1") || piece.equals("R2")) {
        White_Rook r = new White_Rook(row, col);
        return r.getDummyBoard();
    }
    else if (piece.equals("r1") || piece.equals("r2")) {
        Black_Rook r = new Black_Rook(row, col);
        return r.getDummyBoard();
    }

    return null;
}

    public static void main(String args[])
    {
        boolean who=true;
        String piece;
        int mov=0,count=0;
        Scanner ip =new Scanner(System.in);
        Chess_board obj=new Chess_board();
        obj.display(); 
        int a=0;
        int b=0;  
        do
        {
            count++;
            while(mov==0)
            {
                System.out.println("PIECE\n\n");
                a=ip.nextInt();
                b=ip.nextInt();
                piece=obj.chessBoard[a][b];
                if(who==false)
                {
                    
                    if(piece.equals("p"))
                    {
                        Black_Pawn pn = new Black_Pawn(a,b);
                        String[][] moves = pn.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("r1") || piece.equals("r2"))
                    {
                        Black_Rook rk=new Black_Rook(a,b);
                        String[][] moves = rk.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("h1") || piece.equals("h2"))
                    {
                        Black_Horse he=new Black_Horse(a,b);
                        String[][] moves = he.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("b1") || piece.equals("b2"))
                    {
                        Black_Bishop bp=new Black_Bishop(a,b);
                        String[][] moves = bp.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("q"))
                    {
                        Black_Queen qn=new Black_Queen(a,b);
                        String[][] moves = qn.getDummyBoard();
                        Move m=new Move(a,b);
                    } 
                    else if(piece.equals("k"))
                    {
                        Black_King kg=new Black_King(a,b);
                        String[][] moves = kg.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else
                    {
                        if(obj.dum_chessBoard[a][b]=="_" || obj.dum_chessBoard[a][b]=="x")
                        {
                            mov=1;
                        }
                    }
                }
                else
                {
                    if(piece.equals("P"))
                    {
                        White_Pawn PN = new White_Pawn(a,b);
                        String[][] moves = PN.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("R1") || piece.equals("R2"))
                    {
                        White_Rook RK=new White_Rook(a,b);
                        String[][] moves = RK.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("H1") || piece.equals("H2"))
                    {
                        White_Horse HE=new White_Horse(a,b);
                        String[][] moves = HE.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("B1") || piece.equals("B2"))
                    {
                        White_Bishop BP=new White_Bishop(a,b);
                        String[][] moves = BP.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else if(piece.equals("Q"))
                    {
                        White_Queen QN=new White_Queen(a,b);
                        String[][] moves = QN.getDummyBoard();
                        Move m=new Move(a,b);
                    } 
                    else if(piece.equals("K"))
                    {
                        White_King KG=new White_King(a,b);
                        String[][] moves = KG.getDummyBoard();
                        Move m=new Move(a,b);
                    }
                    else
                    {
                        if(obj.dum_chessBoard[a][b]=="_" || obj.dum_chessBoard[a][b]=="x")
                        {
                            mov=1;
                        }
                    }
                }
            } 
            mov=0;
            Move nm=new Move(a,b,1);
            who= !who;
    }while(count<10);
}
}