package com.antsdouble.flyweight;

/**
 * @ClassName WhitePiece
 * @Description 白棋子
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class WhitePiece implements Piece {
    public String pieceColor() {
        return "白色";
    }

    public void show() {
        System.out.println("棋子是白色的！");
    }
}
