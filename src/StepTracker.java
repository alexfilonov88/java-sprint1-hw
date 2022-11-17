import java.util.Scanner;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData;

    int goalSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void enterSteps() {
        System.out.println("Введите номер месяца");
        int selectedMonth = scanner.nextInt();
        System.out.println("Введите номер дня");
        int selectedDay = scanner.nextInt();
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        MonthData monthData = monthToData[selectedMonth];
        monthData.days[selectedDay] = steps;
    }

    public void printStats() {
        System.out.println("Введите номер месяца");
        int selectedMonth = scanner.nextInt();
        MonthData monthData = monthToData[selectedMonth];
        int count = 0;
        int maxSteps = 0;
        int bestDays = 0;
        int series = 0; // Счетчик для максимальной серии
        for (int i = 1; i < monthData.days.length; i++) {
            count += monthData.days[i];
            if (monthData.days[i] > maxSteps) {
                maxSteps = monthData.days[i];
            }
            if (monthData.days[i] > goalSteps) {
                series++;
            } else {
                if (bestDays < series) {
                    bestDays = series;
                }
                series = 0;
            }
            System.out.println(i + " день: " + monthData.days[i]);
        }
        System.out.println("За месяц пройдено шагов: " + count);
        System.out.println("Среднее количество шагов за месяц: " + count / 30);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Пройденная дистанция (в км): " + Converter.convertToDistance(count));
        System.out.println("Количество сожжённых килокалорий: " + Converter.convertToCalories(count));
        System.out.println("Лучшая серия: " + bestDays);
    }

    public void changeGoalStepts() {
        System.out.println("Введите новую цель");
        goalSteps = scanner.nextInt();
    }

    class MonthData {
        int[] days = new int[31];
    }
}