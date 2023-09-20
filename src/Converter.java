public class Converter {
    double stepLength  = 0.75; // длина шага в метрах
    double stepCcal = 0.05; // 50 калорий на шаг = 50/1000

    void getDistance(int steps) {
        double distance = stepLength * steps / 1000;
        System.out.println("--- пройденная дистанция в километрах: " + distance + " км.");
    }

    void getCcal(int steps) {
        double energy = stepCcal * steps;
        System.out.println("--- количество сожженых килокалорий: " + energy + " ккал.");
    }
}
