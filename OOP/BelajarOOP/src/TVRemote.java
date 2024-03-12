import java.util.Comparator;

public class TVRemote extends Remote implements Repairable, Programmable {
    @Override
    public void pressPowerButton() {
        System.out.println("TV power button pressed");
    }

    @Override
    public void repair() {
        System.out.println("TV was repaired");
    }

    @Override
    public void setChannel(int channel) {

    }

    @Override
    public void setVolume(int volume) {

    }

}
