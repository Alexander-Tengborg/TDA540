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
        }
        return a;
    }

    public static double[] note(int pitch, double duration) {
        double freq = 440*Math.pow(2, pitch/12.0);
        return pluck(freq, duration);
    }

    public static double[] average(double[] t1, double[] t2) {
        double[] t3 = new double[t1.length];
        for(int i = 0; i < t1.length; i++) {
            t3[i] = (t1[i] + t2[i]) / 2;
        }
        return t3;
    }

    public static double[] harmonic(int pitch, double duration) {
        double[] t1 = note(pitch, duration);
        double[] t2 = note(pitch-12, duration);
        double[] t3 = note(pitch+12, duration);

        double[] harm1 = average(t1, t2);
        double[] harm2 = average(harm1, t3);

        return harm2;
    }
}
