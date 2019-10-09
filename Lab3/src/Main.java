import java.io.File;

public class Main {
    public static void main(String[] args) {
        SoundDevice device = new SoundDevice();
        Song song = new Song(10);
        song.add(MusicUtils.harmonic(-9, 0.4));
        song.add(MusicUtils.harmonic(-9, 0.4));
        song.add(MusicUtils.harmonic(-9, 0.4));
        song.add(MusicUtils.harmonic(-5, 0.4));
        song.add(MusicUtils.harmonic(-7, 0.4));
        song.add(MusicUtils.harmonic(-7, 0.4));
        song.add(MusicUtils.harmonic(-7, 0.4));
        song.add(MusicUtils.harmonic(-4, 0.4));
        song.add(MusicUtils.harmonic(-5, 0.4));
        song.add(MusicUtils.harmonic(-5, 0.4));
        song.add(MusicUtils.harmonic(-7, 0.4));
        song.add(MusicUtils.harmonic(-7, 0.4));
        song.add(MusicUtils.harmonic(-9, 1));
        song.play(device);
        song.save(device.getFormat(),new File("twotones.wav"));
    }//main
}//Main
