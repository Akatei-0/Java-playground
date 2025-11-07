
public class TextAnalyzer {

    private char ch;
    private int letters;
    private int numbers;
    private int spaces;
    private int others;

    public void analyzeText (String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            ch = userInput.charAt(i);
            if (Character.isLetter(ch)) {letters++;}
            else if (Character.isDigit(ch)) {numbers++;}
            else if (Character.isWhitespace(ch)) {spaces++;}
            else {others++;}
        }
        System.out.println("Letters: " + letters);
        System.out.println("Numbers: " + numbers);
        System.out.println("Spaces: " + spaces);
        System.out.println("Others characters: " + others);
        
    }


}
