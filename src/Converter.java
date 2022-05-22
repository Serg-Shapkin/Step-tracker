public class Converter {
    double stepLength  = 0.75; // длина шага в метрах
    double stepCcal = 0.05; // 50 калорий на шаг = 50/1000

    void getDistance(int steps) {
        double distance = stepLength * steps / 1000;
        System.out.println("Пройденная дистанция в километрах: " + distance);
    }

    void getCcal(int steps) {
        double energy = stepCcal * steps;
        System.out.println("Количество сожженых килокалорий: " + energy);
    }
}
