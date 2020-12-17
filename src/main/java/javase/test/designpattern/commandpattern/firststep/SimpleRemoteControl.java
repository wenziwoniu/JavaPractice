package javase.test.designpattern.commandpattern.firststep;

/**
 * 调用者
 */
public class SimpleRemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }

}
