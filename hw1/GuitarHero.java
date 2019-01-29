import synthesizer.GuitarString;

public class GuitarHero {

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        double f = 440.0;
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] gs = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            double freq = f * Math.pow(2, (i - 24) / 12);
            gs[i] = new GuitarString(freq);
        }

        GuitarString string = gs[0];

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    string = gs[index];
                    string.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = string.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string.tic();
        }
    }

}
