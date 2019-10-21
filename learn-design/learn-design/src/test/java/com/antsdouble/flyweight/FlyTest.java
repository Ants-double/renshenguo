package com.antsdouble.flyweight;

import org.junit.Test;

/**
 * @ClassName FlyTest
 * @Description test
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class FlyTest {

    @Test
    public void flyWeightTest(){
        PieceFactory pieceFactory = PieceFactory.getPieceFactory();
        System.out.println(pieceFactory);
        Piece white = PieceFactory.getPiece("white");
        Piece black = PieceFactory.getPiece("black");
        Piece white2= PieceFactory.getPiece("white");
        Piece black2 = PieceFactory.getPiece("black");
        System.out.println(white==white2);
        System.out.println(black==black2);

    }
}
