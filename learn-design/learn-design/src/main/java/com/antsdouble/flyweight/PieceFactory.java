package com.antsdouble.flyweight;

import java.util.HashMap;

/**
 * @ClassName PieceFactory
 * @Description factory
 * @date 4/8/2019
 * @Author liyy
 * @Version 1.0
 */
public class PieceFactory {
//参见单例
    private  static  PieceFactory pieceFactory=new PieceFactory();
    private static HashMap<String,Piece> maps;
    private  PieceFactory(){
        maps=new HashMap<String, Piece>();
        Piece white,black;
        white=new WhitePiece();
        maps.put("white",white);
        black=new BlackPiece();
        maps.put("black",black);

    }

    public static PieceFactory getPieceFactory(){
        return  pieceFactory;
    }

    public static  Piece getPiece(String flag){
        return maps.get(flag);
    }

}
