import java.util.Arrays;
public class StatsCalculator {
   private double[] values;
   private double[] sortedValues;
   public StatsCalculator(){
       values = new double[20];
   }
   public StatsCalculator(double[] ref){
       values = ref;
   }
   public void sortData(){
       sortedValues = values;
       for(int i = 0 ; i < sortedValues.length;i++) {
           for (int j = i + 1; j < sortedValues.length; j++) {
               if (sortedValues[i] > sortedValues[j]) {
                   double temp = sortedValues[i];
                   sortedValues[i] = sortedValues[j];
                   sortedValues[j] = temp;

               }
           }
       }
   }
   public double calculateMax(){
       double max = values[1];
       for(int i = 0; i < values.length;i++){
           if(values[i] > max){
               max = values[i];
           }
       }
       return max;
   }
    public double calculateMin(){
        double min = values[1];
        for(int i = 0; i < values.length;i++){
            if(values[i] < min){
                min = values[i];
            }
        }
        return min;
    }
    public double calculateMedian(){
       sortData();
       double median = 0;
       int length = sortedValues.length;
       if((length % 2) != 0){
           median = sortedValues[length / 2];
       }else{
           median =  (sortedValues[(int)((length/2)+0.5)]+sortedValues[(int)((length/2)-0.5)])/2;
       }
       return median;
    }
    public double calculateFirstQuartile(){
        sortData();
        double fQ = 0;
        int length = sortedValues.length;
        if((length % 2) != 0){
            //excluding median...?
            //not exactly sure what Mr. Smith wanted here
            length--;
        }
        if(length%4 != 0){
            fQ = sortedValues[(int)((length/4)+0.5)];
        }else{
            fQ = (sortedValues[(length/4)-1]+sortedValues[(length/4)])/2;
        }
        return fQ;

    }
    public double calculateThirdQuartile(){
        sortData();
        double fQ = 0;
        int length = sortedValues.length;
        if((length%2)!=0){
            length = length - 1;
        }
        double index = (length * 0.75);
        if(index%1 == 0){
            int f = (int)(index)-1;
            fQ = ((sortedValues[f]+sortedValues[f+1])/2);
        } else{
            int f = (int)(index);
            fQ = sortedValues[f];
        }
        return fQ;
    }
    public double calculateSum(){
       return Arrays.stream(values).sum();
    }
    public double calculateMean(){
       sortData();
       return (Arrays.stream(values).sum())/(values.length);
    }
   public void printSorted(){

       for(double i : sortedValues){
           System.out.print(i+", ");
       }
       System.out.println();
   }
    public void print(){

        for(double i : values){
            System.out.print(i+", ");
        }
        System.out.println();
    }
    public void printFiveNumberSummary(){
        System.out.println("Your five number summary is: ");
        System.out.println("     "+this.calculateMin());
        System.out.println("     "+this.calculateFirstQuartile());
        System.out.println("     "+this.calculateMedian());
        System.out.println("     "+this.calculateThirdQuartile());
        System.out.println("     "+this.calculateMax());
        System.out.println();


    }
}
