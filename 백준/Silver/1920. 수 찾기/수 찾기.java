import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bf.readLine()); //5
        int[] array = new int[M];
        String line = bf.readLine(); // 4 1 5 2 3
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            array[i] = num;
        }
        Arrays.sort(array);

        int N = Integer.parseInt(bf.readLine()); //5
        String originLine = bf.readLine();
        StringTokenizer originSt = new StringTokenizer(originLine);
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(originSt.nextToken());

            //이분 탐색시작
            int left = 0;
            int right = M - 1;
            boolean isCheck = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] < num) {
                    left = mid + 1;
                } else if(array[mid] > num) {
                    right = mid - 1;
                }else {
                    bw.write("1");
                    if(i != N-1)
                        bw.newLine();
                    isCheck = true;
                    break;
                }
            }
            if (!isCheck) {
                bw.write("0");
                if(i != N-1)
                    bw.newLine();
            }

        }

        bw.flush();
        bw.close();
    }
}