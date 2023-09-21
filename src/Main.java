import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while(true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите номер месяца, где:");
                System.out.println("1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; " +
                        "6 - Июнь;\n7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь;");
                int monthNumber = scanner.nextInt() - 1;
                System.out.println("Введите номер дня от 1 до 30 (включительно):");
                int dayNumber = scanner.nextInt();
                System.out.println("Введите количество пройденных шагов:");
                int numberOfSteps = scanner.nextInt();
                stepTracker.saveSteps(monthNumber, dayNumber, numberOfSteps);
            } else if(userInput == 2) {
                System.out.println("Введите номер месяца, за который хотете получить данные, где:");
                System.out.println("1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; " +
                        "6 - Июнь;\n7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь;");
                int monthForStatistics = scanner.nextInt() - 1;
                stepTracker.getStatistics(monthForStatistics);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов в день: ");
                int target = scanner.nextInt();
                stepTracker.changeTargets(target);
            } else if (userInput == 4) {
                System.out.println("Будем ждать вас снова. До свидания!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет. Пожалуйста, введите команду от 1 до 4");
            }
        }
    }
    public static void printMenu() {
        System.out.println("\nЧто необходимо сделать?\nУкажите номер команды из меню:");
        System.out.println("1 - ввести количество шагов за определенный день");
        System.out.println("2 - напечатать статистику за определенный месяц");
        System.out.println("3 - изменить цель по количеству шагов в день");
        System.out.println("4 - выйти из приложения");
    }
}
