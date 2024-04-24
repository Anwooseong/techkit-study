#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    for (int testCase = 1; testCase <= T; testCase++) {
        int arr[100001] = {0}; // 배열 초기화

        int N;
        cin >> N;

        for (int i = 0; i < N; i++) {
            string numStr;
            cin >> numStr;
            int gap = abs(stoi(numStr)); // 절대값으로 변환

            arr[gap]++;
        }

        // 결과 출력
        for (int i = 0; i < 100001; i++) {
            if (arr[i] != 0) {
                cout << "#" << testCase << " " << i << " " << arr[i] << "\n";
                break;
            }
        }
    }

    return 0;
}
