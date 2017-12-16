public class Day15J {

    public static void main(String[] args) {
        long afactor = 16807;
        long bfactor = 48271;
        long prevA = 65;
        long prevB = 8921;
        int mask = ((1<<16) - 1);

        for (int i = 0; i < 5; i++) {
            prevA *= afactor;
            prevB *= bfactor;
            System.out.println(prevA << (64 - 16) == prevB << (64-16));
        }

    }
}
