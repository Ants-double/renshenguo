package com.antsdouble.flyweight;

/**
 * @ClassName BlackPiece
 * @Description 黑色的
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class BlackPiece implements Piece {
    public String pieceColor() {
        return "黑色";
    }

    public void show() {
        System.out.println("棋子是黑色的!!");
    }
}
