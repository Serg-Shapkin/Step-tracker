import java.util.Scanner;

public class StepTracker {
    int[][] data = new int[12][30];
    int goalStepsPerDay = 10_000; // цель шагов в день
    int sumSteps = 0;   // сумма шагов
    int maxSteps = 0;   // максимальное количество шагов
    int averageSteps = 0;   // среднее количество шагов, оставил int

    Converter converter = new Converter();

    void saveSteps(int month, int day, int steps) {
        System.out.println("Сохраняем шаги за указанный день месяца");
        for (int i = 0; i < data[month].length; i++) {
            data[month][day - 1] = steps;
            if (steps < 0) {
                steps = 0;
                System.out.println("Количество пройденных шагов не может быть отрицательным, поторите ввод.");
                return;
            }
        }
    }

    void getStatistics(int month) { // количество пройденных шагов по дням
        System.out.println("Формируем статистику по вашему запросу: ");
        sumSteps = 0; /* обнулил счетчик шагов, чтобы не прибавлялось сохраненное в sumSteps
                      значение при вызове метода getStatistics();*/
        for (int i = 0; i < data[month].length; i++) {
            System.out.print("- за " + (i + 1) + " день выбранного месяца пройдено " + data[month][i] + " шагов. \n");
        }

        for (int i = 0; i < data[month].length; i++) { // общее количество шагов за месяц
            sumSteps = sumSteps + data[month][i];
        }
        System.out.println("\n--- общее количество шагов за месяц: " + sumSteps);

        for (int i = 0; i < data[month].length; i++) { // максимальное количество шагов
            if (data[month][i] > maxSteps ) {
                maxSteps = data[month][i];
            }
        }
        System.out.println("--- максимальное количество шагов в месяце: " + maxSteps);

        for (int i = 0; i < data[month].length; i++) { // среднее количество шагов
            averageSteps = sumSteps / data[month].length;
        }
        System.out.println("--- среднее количество шагов в день за текущий месяц: " + averageSteps);

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
            System.out.println("--- максимальное количество подряд идущих дней, " +
                    "в течение которых количество шагов за день было равно " +
                    "или выше целевого: " + currentConsequence);
        } else {
            System.out.println("--- максимальное количество подряд идущих дней, " +
                    "в течение которых количество шагов за день было равно " +
                    "или выше целевого: " + lastConsequence);
        }
    }

    void changeTargets(int newTarget) {
        sumSteps = 0; /* обнулил счетчик шагов, чтобы не прибавлялось сохраненное в
                         sumSteps значение при вызове метода changeTargets();*/
        if (newTarget < 0) {
            System.out.println("Цель по количество шагов не может быть отрицательной!");
            return;
        } else {
            goalStepsPerDay = newTarget;
        }
        System.out.println("Новая цель " + goalStepsPerDay + " шагов установлена!");
    }
}