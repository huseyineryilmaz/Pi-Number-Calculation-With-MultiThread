import java.util.Scanner;

public class PiCalculation {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int threadNumber = 0;
        int operationNumber = 0;
        double[] taylorSerie;
        
        while(threadNumber<1 || threadNumber>64){
        System.out.print("Please enter thread number(between 1 and 64): ");
        threadNumber = sc.nextInt();
        System.out.println();
        }
        
        while(operationNumber<1){
        System.out.print("Please enter operation number: ");
        operationNumber = sc.nextInt();
        if(operationNumber<1)
                System.out.println("Please enter a positive integer!");
        System.out.println();
        }
        
        
        //Generate Taylor Serie
        taylorSerie = new double[operationNumber];
        for (int i = 0; i < taylorSerie.length; i++) {
            taylorSerie[i] = Math.pow(-1, i)/(2*i +1); 
        }
        
        double realPiNumber = 3.1415926535897932;
        
        MasterThread master = new MasterThread(threadNumber);
        
        long start = System.currentTimeMillis();
        double result = 4*master.parallelSum(taylorSerie);
        long time = System.currentTimeMillis() - start;
        
         
        System.out.println("Pi: " + result);
        System.out.println("Completed in : " + time + "ms");
        System.out.println("Approximation error is: " + Math.abs(realPiNumber-4*master.parallelSum(taylorSerie)));
        
    }
}
