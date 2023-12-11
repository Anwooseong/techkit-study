import java.io.*;
import java.util.*;

class Time{
    int startTime;
    int finishTime;

    Time(int start, int finish){
        this.startTime = start;
        this.finishTime = finish;
    }
}

public class Main {

    static int N;
    static Time[] subjects;
    static Stack<Time> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        subjects = new Time[N];
        stack = new Stack<>();

        for(int i = 0;i<N; i++){
            int startTime = sc.nextInt();
            int finishTime = sc.nextInt();
            subjects[i] = new Time(startTime, finishTime);
        }

        Arrays.sort(subjects, (c1,c2) -> c1.startTime - c2.startTime);
        Arrays.sort(subjects, (c1,c2) -> c1.finishTime - c2.finishTime);
        

        stack.push(subjects[0]);
        for(int i = 1; i<N; i++){
            Time peek = stack.peek();
            if(peek.finishTime <= subjects[i].startTime){
                stack.push(subjects[i]);
            }
        }

        System.out.println(stack.size());


    }
}

