import java.util.Scanner;

public class StepTracker {
    public int goalByStepsPerDay = 10000;
    public Scanner scanner;
    public MonthData[] monthToData = new MonthData[12];
    MonthData monthData = new MonthData();
    Converter converter = new Converter();

    public StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");

        int month = scanner.nextInt();
        if (month >= 1 && month <= 12) {
            System.out.println("Введите номер дня(от 1 до 30 включительно): ");
            int day = scanner.nextInt();
            if (day >= 1 && day <= 30) {
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                if (steps > 0) {
                    MonthData monthData = monthToData[month - 1];
                    monthData.days[day - 1] = steps;
                } else {
                    System.out.println("Количество шагов должно быть больше 0");
                }
            } else {
                System.out.println("Такого дня нет.");
            }
        } else {
            System.out.println("Такого месяца нет.");
        }
    }

    public void changeStepGoal() {
        System.out.println("Введите цель по количеству шагов:");
        int goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay <= 0) {
            System.out.println("Введите другое число, цель должна быть больше 0");
        } else {
            System.out.println("Ваша цель по количеству шагов = " + goalByStepsPerDay);
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month >= 1 && month <= 12) {

            monthData = monthToData[month - 1];
            int sumSteps = monthData.sumStepsFromMonth();
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Сумма всех шагов за месяц:" + sumSteps);
            System.out.println("Максимальное количество шагов за месяц:" + monthData.maxSteps());
            System.out.println(sumSteps / monthData.days.length);
            System.out.println(converter.convertToKm(sumSteps));
            System.out.println(converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        }
    }
}