public class MusicControllerRemote extends Remote implements Repairable{
    public void pressPowerButton() {
        System.out.println("Music controller power button pressed");
    }

    @Override
    public void repair() {
        System.out.println("Music controller was repaired");
    }
}
