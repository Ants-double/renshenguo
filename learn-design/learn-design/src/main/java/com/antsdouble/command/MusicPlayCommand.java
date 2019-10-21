package com.antsdouble.command;

/**
 * @ClassName MusicPlayCommand
 * @Description 放歌
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class MusicPlayCommand implements Command {
    private Music music;

    public MusicPlayCommand(Music music) {
        this.music = music;
    }

    public void execute() {
        music.playMusic();
    }
}
