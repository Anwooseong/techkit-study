import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
//            System.out.println(""+i+" "+line.charAt(i));
            char alphabet = line.charAt(i);
            if (alphabet >= 'a' && alphabet <= 'z') {
                char newAlphabetAlpha = (char) (alphabet + 13) > 'z' ? (char) (alphabet - 13):(char) (alphabet + 13);
                System.out.print(newAlphabetAlpha);
            } else if (alphabet >= 'A' && alphabet <= 'Z') {
                char newAlphabetAlpha = (char) (alphabet + 13) > 'Z' ? (char) (alphabet - 13):(char) (alphabet + 13);
                System.out.print(newAlphabetAlpha);
            } else {
                System.out.print(alphabet);
            }
        }

    }
}
