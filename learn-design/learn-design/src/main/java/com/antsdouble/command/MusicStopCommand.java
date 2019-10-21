package com.antsdouble.command;

/**
 * @ClassName MusicStopCommand
 * @Description 停止
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class MusicStopCommand implements Command {
    private  Music music;

    public MusicStopCommand(Music music) {
        this.music = music;
    }

    public void execute() {
        music.stopMusic();
    }
}
