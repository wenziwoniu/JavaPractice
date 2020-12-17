package javase.test.designpattern.commandpattern.firststep.impl;

import javase.test.designpattern.commandpattern.firststep.Command;
import javase.test.designpattern.commandpattern.firststep.Light;

/**
 * 开灯命令
 */
public class LightOnCommand implements Command {

    private Light light;


    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 该方法调用接收对象(light)实现开灯功能
     */
    @Override
    public void execute() {
        light.on();
    }

}
