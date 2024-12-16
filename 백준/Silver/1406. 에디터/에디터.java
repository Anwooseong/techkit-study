import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] arr = bf.readLine().toCharArray();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            leftStack.push(arr[i]);
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            char command = st.nextToken().charAt(0);
            switch (command) {
                case 'L':
                    if(!leftStack.isEmpty()){
                        char moveCharacter = leftStack.pop();
                        rightStack.push(moveCharacter);
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        char moveCharacter = rightStack.pop();
                        leftStack.push(moveCharacter);
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    char addCharacter = st.nextToken().charAt(0);
                    leftStack.push(addCharacter);
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            char moveCharacter = leftStack.pop();
            rightStack.push(moveCharacter);
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            char popCharacter = rightStack.pop();
            sb.append(popCharacter);
        }
        System.out.println(sb.toString());
    }
}