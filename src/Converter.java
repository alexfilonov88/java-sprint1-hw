public class Converter {
    public static double convertToDistance(int steps) {
        return steps * 0.75 / 1000;
    }

    public static int convertToCalories(int steps) {
        return steps * 50 / 1000;
    }
}
