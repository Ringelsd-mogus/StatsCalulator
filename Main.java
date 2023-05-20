import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for(int i = 4; i < 16; i++) {
            double[] yeah = new double[i];
            Arrays.setAll(yeah, j -> ((int) (Math.random() * 100)));
            StatsCalculator amongus = new StatsCalculator(yeah);
            amongus.sortData();
            amongus.print();
            amongus.printSorted();
            System.out.println();
            System.out.println("max: " + amongus.calculateMax());
            System.out.println("min: " + amongus.calculateMin());
            System.out.println("First Quartile: " + amongus.calculateFirstQuartile());
            System.out.println("median: " + amongus.calculateMedian());
            System.out.println("Third Quartile: " + amongus.calculateThirdQuartile());
            System.out.println("Sum: " + amongus.calculateSum());
            System.out.println("Mean: " + amongus.calculateMean());
            System.out.println();
            amongus.printFiveNumberSummary();
        }
    }
}