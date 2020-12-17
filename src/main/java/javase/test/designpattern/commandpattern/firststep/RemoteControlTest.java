package javase.test.designpattern.commandpattern.firststep;

import javase.test.designpattern.commandpattern.firststep.impl.LightOnCommand;

/**
 * 命令模式的客户
 */
public class RemoteControlTest {

    public static void main(String[] args) {

        // 遥控器就是调用者，会传入一个命令对象，可以用来发出请求
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        // 现在创建了一个电灯对象，此对象就是请求的接收者
        Light light = new Light();

        // 这里创建了一个命令，然后将接收者传给他
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        // 把命令传给调用者  可以赋值不同的命令对象，从而实现不同的功能
        remoteControl.setCommand(lightOnCommand);

        remoteControl.buttonWasPressed();
    }
}
