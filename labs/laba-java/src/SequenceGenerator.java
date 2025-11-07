public class SequenceGenerator {
    private String sequence = "";
    private int sum = 0;
    private int length = 0;
    private double arithmeticMean = 0;
    
    public void generateSequence(int start, int finish, int step) {
        if (step == 0) {
            System.out.println("Step can't be a zero");
            return;
        }
        for (int i = start; i < finish; i += step) {
            sequence += i + " ";
            sum += i;
            length += 1;
            arithmeticMean = (double) sum / (double) length;

        }
        System.out.println("Generated sequence: " + sequence);
        System.out.println("Sum: " + sum);
        System.out.println("length: " + length);
        System.out.println("Arithmetic mean: " + arithmeticMean);
    }

}
