import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker stepTracker = new StepTracker();

        while(true) {
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите номер месяца, где:");
                System.out.println("0 - Январь; 1 - Февраль; 2 - Март; 3 - Апрель; 4 - Май; " +
                        "5 - Июнь;\n6 - Июль; 7 - Август; 8 - Сентябрь; 9 - Октябрь; 10 - Ноябрь; 11 - Декабрь;");
                int monthNumber = scanner.nextInt();
                System.out.println("Введите номер дня от 1 до 30:");
                int dayNumber = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов:");
                int numberOfSteps = scanner.nextInt();
                stepTracker.saveSteps(monthNumber, dayNumber, numberOfSteps);
                printMenu();
            } else if(userInput == 2) {
                System.out.println("Введите номер месяца, за который хотете получить данные, где:");
                System.out.println("0 - Январь; 1 - Февраль; 2 - Март; 3 - Апрель; 4 - Май; " +
                        "5 - Июнь;\n6 - Июль; 7 - Август; 8 - Сентябрь; 9 - Октябрь; 10 - Ноябрь; 11 - Декабрь;");
                int monthForStatistics = scanner.nextInt();
                stepTracker.getStatistics(monthForStatistics);
                printMenu();
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов в день: ");
                int target = scanner.nextInt();
                stepTracker.changeTargets(target);
                printMenu();
            } else if (userInput == 4) {
                System.out.println("Выход из приложения");
                break;
            } else {
                System.out.println("Такой команды нет, введите команду из списка:");
                printMenu();
            }
        }
    }
    public static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход");
    }
}
