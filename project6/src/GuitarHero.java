public class GuitarHero {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C 
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] string37 = new GuitarString[keyboard.length()];
        for(int i = 0; i<keyboard.length();i++) {
        	double freq = 440 * Math.pow(1.05956, i-24);
        	GuitarString stringX = new GuitarString(freq);
        	string37[i] = stringX;
        }
       

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key) != -1){
                	string37[keyboard.indexOf(key)].pluck();
                }
                // pluck the corresponding string
               
            }

            // compute the superposition of the samples
            double sample=0;
            for(int i = 0;i<keyboard.length();i++) {
            	sample += string37[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0;i<keyboard.length();i++) {
            	string37[i].tic();
            }
        }
    }
}