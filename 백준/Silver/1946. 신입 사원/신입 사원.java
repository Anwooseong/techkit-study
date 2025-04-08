import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
    int firstScore;
    int secondScore;

    public Person(int firstScore, int secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    @Override
    public int compareTo(Person o) {
        return this.firstScore - o.firstScore;
    }
}

public class Main {

    static int T, N, answer;
    static Person[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {

            N = Integer.parseInt(bf.readLine());
            people = new Person[N];
            answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int firstScore = Integer.parseInt(st.nextToken());
                int secondScore = Integer.parseInt(st.nextToken());
                people[i] = new Person(firstScore, secondScore);
            }

            Arrays.sort(people);
            int prevFirstScore = people[0].firstScore;
            int prevSecondScore = people[0].secondScore;
            answer++; //무조건 제일 처음은 제일 높은 사람이므로 +1

            for (int i = 1; i < N; i++) {
                int firstScore = people[i].firstScore;
                int secondScore = people[i].secondScore;

                if (prevSecondScore > secondScore) {
                    prevSecondScore = secondScore;
                    answer++;
                }

            }

            System.out.println(answer);

        }
    }
}
