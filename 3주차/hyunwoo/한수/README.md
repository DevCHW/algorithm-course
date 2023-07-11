## Info
<a href="https://www.acmicpc.net/problem/1065" rel="nofollow">한수</a>

## 풀이코드
```java
import java.util.*;

public class Main {

    static int answer;

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            int len = arr.length;
            boolean flag = true;
            if(len >= 2) {
                int gap = arr[1] - arr[0];
                for(int j=2; j<len; j++) {
                    if (arr[j] - arr[j-1] != gap) flag = false;
                }
            }

            if (flag) answer++;
        }
        return answer;
    }


    /**
     * print() 구현
     */
    private static void print(String str) {
        System.out.println(str);
    }

    /**
     * print() 구현
     */
    private static void print(int number) {
        System.out.println(number);
    }
}

```

## ❗ 풀이 방법
```java
for(int i=1; i<=n; i++) {
    char[] arr = String.valueOf(i).toCharArray();
    int len = arr.length;
    boolean flag = true; //한수 판별 변수
    if(len >= 2) {
        int gap = arr[1] - arr[0];
        for(int j=2; j<len; j++) {
            if (arr[j] - arr[j-1] != gap) flag = false;
        }
    }

    if (flag) answer++;
}
```

1. i를 1부터 n까지 증가시켜주면서, i를 String 타입으로 바꾼 다음 char 배열로 변환해준다.  
2. flag를 true라고 선언한 뒤, char 배열의 길이가 2 이상이라면 gap을 구하여 char 배열을 2부터 탐색하여 전부 gap이 일정한지 탐색해본다.
3. gap이 다르다면 flag를 false로 바꿔주고 탐색을 멈춘다.
4. 무사히 탐색을 마쳤다면 flag는 그대로 true 상태일 것이므로(i는 한수라는 뜻) answer를 증가시켜준다.

## 🙂 새로 알게된 점

* 1이상 N 이하의 모든 수들에 대하여 한수인지 판별하는 로직만 짤 수 있다면 쉽게 풀 수 있는 문제였다.

