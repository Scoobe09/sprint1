import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int com = scanner.nextInt();
            if (com == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (com == 2) {
                stepTracker.changeStepGoal();
            } else if (com == 3) {
                stepTracker.printStatistic();
            } else if (com == 4) {
                System.out.println("Пока");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите, что вы хотите сделать:");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Изменить цель по количеству шагов в день.");
        System.out.println("3 - Напечатать статистику за определённый месяц.");
        System.out.println("4 - Выйти из приложения.");
    }
}
