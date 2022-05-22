import java.util.Scanner;

public class StepTracker {
    int[][] data = new int[12][30];
    int goalStepsPerDay = 10000; //цель шагов в день
    int sumSteps = 0;   // сумма шагов
    int maxSteps = 0;   // максимальное количество шагов
    int averageSteps = 0;   // среднее количество шагов, оставил int

    Converter converter = new Converter();

    void saveSteps(int month, int day, int steps) {
        for (int j = 0; j < data[month].length; j++) {
            data[month][day - 1] = steps;
            if (steps < 0) {
                steps = 0;
                System.out.println("Количество пройденных шагов не может быть отрицательным! " +
                        "Повторите ввод!");
                return;
            }
        }
    }

    void getStatistics(int month) { // количество пройденных шагов по дням
        sumSteps = 0; /* обнулил счетчик шагов, чтобы не прибавлялось сохраненное в sumSteps
                      значение при вызове метода getStatistics();*/
        for (int j = 0; j < data[month].length; j++) {
            System.out.print(j + 1 + " день: " + data[month][j] + ", ");
        }
        System.out.println(); //перенос строки для печати меню

         // общее количество шагов за месяц
        for (int j = 0; j < data[month].length; j++) {
            sumSteps = sumSteps + data[month][j];
        }
        System.out.println("Общее количество шагов за месяц: " + sumSteps);

        // максимальное количество шагов
        for (int j = 0; j < data[month].length; j++) {
            if (data[month][j] > maxSteps ) {
                maxSteps = data[month][j];
            }
        }
        System.out.println("Максимальное количество шагов в месяце: " + maxSteps);

        // среднее количество шагов
        for (int j = 0; j < data[month].length; j++) {
            averageSteps = sumSteps/data[month].length;
        }
        System.out.println("Среднее количество шагов в день за текущий месяц: " + averageSteps);

        converter.getDistance(sumSteps);
        converter.getCcal(sumSteps);

        //лучшая серия шагов
        int lastConsequence = 0; //последняя последовательность
        int currentConsequence = 0; //текущая последовательность
        boolean prevElement = false; // предыдущий элемент?

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int current = data[month][j];
                if (current >= goalStepsPerDay) {
                    currentConsequence++;
                    prevElement = true;
                } else {
                    if (prevElement) {
                        if(currentConsequence >= lastConsequence) {
                            lastConsequence = currentConsequence;
                        }
                        currentConsequence = 0;
                        prevElement = false;
                    }
                }
            }
        }
        if (currentConsequence > lastConsequence) {
            System.out.println("Максимальное количество подряд идущих дней, " +
                    "в течение которых количество шагов за день было равно " +
                    "или выше целевого: " + currentConsequence);
        } else {
            System.out.println("Максимальное количество подряд идущих дней, " +
                    "в течение которых количество шагов за день было равно " +
                    "или выше целевого: " + lastConsequence);
        }
    }

    void changeTargets(int newTarget) {
        sumSteps = 0; /* обнулил счетчик шагов, чтобы не прибавлялось сохраненное в
                         sumSteps значение при вызове метода changeTargets();*/
        if (newTarget < 0) {
            System.out.println("Новая цель не может быть отрицательной!");
            return;
        } else {
            goalStepsPerDay = newTarget;
        }
        System.out.println("Новая цель " + goalStepsPerDay);
    }
}