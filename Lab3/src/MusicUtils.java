import java.util.Random;

public class MusicUtils {
    public static final double K = -0.52;

    public static double[] sine(double freq, double duration) {
        int n = (int)(duration*SoundDevice.SAMPLING_RATE);
        double[] a = new double[n];
        double dx = 2*Math.PI*freq / SoundDevice.SAMPLING_RATE;
        for (int i = 0; i < n; i = i + 1) {
            a[i] = Math.sin(i * dx);
        }
        return a;
    }//sine

    public static double[] pluck(double freq, double duration) {
        int n = (int)(duration*SoundDevice.SAMPLING_RATE);
        int p = (int)(SoundDevice.SAMPLING_RATE/freq);
        double[] a = new double[n];

        for(int i = 0; i < n; i++) {
            if(i < p) {
                a[i] = (new Random().nextDouble() * 2) -1;
            } else {
                a[i] = (a[i-p] + a[i-(p-1)])*K;
            }
            System.out.println(i);
        }
        return a;
    }


}
