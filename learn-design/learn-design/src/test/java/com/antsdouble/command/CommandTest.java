package com.antsdouble.command;

import org.junit.Test;

/**
 * @ClassName CommandTest
 * @Description test
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class CommandTest {

    @Test
    public void commandTest(){

        XiaoDu xiaoDu=new XiaoDu();
        Music music=new Music();
        MusicPlayCommand musicPlayCommand=new MusicPlayCommand(music);
        System.out.println("小度 小度，放首歌");
        xiaoDu.setCommand(musicPlayCommand);
        xiaoDu.doCommand();
        System.out.println("------------------");
        MusicStopCommand musicStopCommand=new MusicStopCommand(music);
        System.out.println("小度 小度，停止播放");
        xiaoDu.setCommand(musicStopCommand);
        xiaoDu.doCommand();

    }
}
