import java.io.File;

public class Main {
    public static void main(String[] args) {
        SoundDevice device = new SoundDevice();
        Song song = new Song(5);
        //song.add(MusicUtils.sine(440,2));
        //song.add(MusicUtils.sine(880,2));
        song.add(MusicUtils.pluck(440, 0.1));
        song.play(device);
        song.save(device.getFormat(),new File("twotones.wav"));
    }//main
}//Main
