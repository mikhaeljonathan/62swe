package org.example;

import org.example.commands.*;
import org.example.invokers.RemoteControl;
import org.example.invokers.SimpleRemoteControl;
import org.example.receivers.CeilingFan;
import org.example.receivers.GarageDoor;
import org.example.receivers.Light;
import org.example.receivers.Stereo;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("Living Room");

        remoteControl.setCommand(0,
                new LightOnCommand(livingRoomLight),
                new LightOffCommand(livingRoomLight));

        remoteControl.setCommand(1,
                new LightOnCommand(kitchenLight),
                new LightOffCommand(kitchenLight));

        remoteControl.setCommand(2,
                new CeilingFanOnCommand(ceilingFan),
                new CeilingFanOffCommand(ceilingFan));

        remoteControl.setCommand(3,
                new GarageDoorUpCommand(garageDoor),
                new GarageDoorDownCommand(garageDoor));

        remoteControl.setCommand(4,
                new StereoOnWithCDCommand(stereo),
                new StereoOffCommand(stereo));

        System.out.println(remoteControl);

        // simulation
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        remoteControl.undoButtonWasPushed();
    }

    private void simpleRemoteTest() {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        remote.setCommand(new LightOnCommand(new Light("")));

        remote.buttonWasPressed();
    }
}