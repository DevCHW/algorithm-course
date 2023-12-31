## Info
<a href="https://www.acmicpc.net/problem/7568" rel="nofollow">덩치</a>

## 풀이 코드
___
``` java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weightArr = new int[n];
        int[] heightArr = new int[n];
        for(int i=0; i<n; i++) {
            weightArr[i] = sc.nextInt();
            heightArr[i] = sc.nextInt();
        }

        for(int x : solution(n, heightArr, weightArr)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int n, int[] heightArr, int[] weightArr) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            int rank = 1;
            int weight1 = weightArr[i];
            int height1 = heightArr[i];

            for(int j=0; j<n; j++) {
                int weight2 = weightArr[j];
                int height2 = heightArr[j];

                if (weight1 < weight2 && height1 < height2) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}
```

## 아이디어
___
간단하게 완전탐색으로 풀었다.

## ❗ 풀이 방법
___
1. 무게를 담은 배열과 키를 담은 배열로 나눠서 입력받은 뒤, solution에 보냈다.
2. 모든사람의 등수를 초기값 1등으로 설정한 뒤 (`int rank = 1;`), 다른 사람들과 비교하여 키, 몸무게가 둘다 자신보다 크다면 등수를 1씩 증가시켜주어 정답 배열에 담아주었다.
```java
for(int j=0; j<n; j++) {
    int weight2 = weightArr[j];
    int height2 = heightArr[j];

    if (weight1 < weight2 && height1 < height2) {
        rank++;
    }
}
```

