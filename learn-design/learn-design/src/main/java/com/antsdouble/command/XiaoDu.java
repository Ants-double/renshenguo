package com.antsdouble.command;

/**
 * @ClassName XiaoDu
 * @Description 小度
 * @date 4/9/2019
 * @Author liyy
 * @Version 1.0
 */
public class XiaoDu {
    private  Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void doCommand(){
        command.execute();
    }
}
