
public class Converter {

    int convertToKm(int steps) {
        int sum = (steps * 75 / 100000);
        return sum;
    }

    int convertStepsToKilocalories(int steps) {
        int kilC = steps * 50 / 1000;
        return kilC;
    }
}

