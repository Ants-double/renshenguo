package com.antsdouble.rpcs;

import java.io.IOException;

public class RPCTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        RPCClient rpcClient=new RPCClient();
        System.out.println(rpcClient.call("20"));
    }



}
