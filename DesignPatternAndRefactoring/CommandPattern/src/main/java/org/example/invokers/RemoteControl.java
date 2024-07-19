package org.example.invokers;

import org.example.interfaces.Command;
import org.example.interfaces.NoCommand;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    Command undoCommand;

    public RemoteControl() {
        int NUM_SLOTS = 7;
        onCommands = new Command[NUM_SLOTS];
        offCommands = new Command[NUM_SLOTS];

        Command noCommand = new NoCommand();
        for (int i = 0; i < NUM_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuff = new StringBuilder();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}
