import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));

        SoundDevice device = new SoundDevice();
        Song song = new Song(40);

        //Tempot för country roads: ~65
        //Allstar ~90
        int tempo = Integer.parseInt(args[1]);

        while(sc.hasNextLine()) {
            String nextLine = sc.nextLine().trim();
            if(nextLine.trim().equals("")) continue;

            int pitch = Integer.parseInt(nextLine.split("\\s+")[0].trim());
            double duration = Double.parseDouble(nextLine.split("\\s+")[1].trim()) * 60/(tempo*0.250);

            song.add(MusicUtils.harmonic(pitch, duration));
        }

        song.play(device);
        //song.save(device.getFormat(),new File(args[0].split(".")[0] + ".wav"));
        //song.save(device.getFormat(),new File("countryroads.wav"));
    }//main
}//Main
