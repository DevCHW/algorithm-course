## Info
<a href="https://www.acmicpc.net/problem/1182" rel="nofollow">부분수열의 합</a>

## 풀이 코드
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
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, s, arr);
        print(answer);
    }

    private static void solution(int n, int s, int[] arr) {
        recursive(0, n, s, arr, 0);
        if(s == 0) answer--;
    }

    private static void recursive(int depth, int n, int s, int[] arr, int number) {
        if (depth == n) {
            if(number == s) {
                answer++;
            }
        } else {
            recursive(depth+1, n, s, arr, number+arr[depth]);
            recursive(depth+1, n, s, arr, number);
        }
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

## 아이디어
공집합 에서 더하거나, 더하지 않거나의 경우의 수로 2진트리 형식 재귀함수로 뻗어나가는 것을 구현하였다.

## ❗ 풀이 방법
```java
 private static void recursive(int depth, int n, int s, int[] arr, int number) {
    if (depth == n) {
        if(number == s) {
            answer++;
        }
    } else {
        recursive(depth+1, n, s, arr, number+arr[depth]);
        recursive(depth+1, n, s, arr, number);
    }
}
```
depth를 0부터 1씩 늘려가면서 재귀를 호출하고, number의 초기값은 공집합 0으로 초기화한 뒤 더한 것을 재귀로 호출, 더하지 않은것을 재귀로 호출하여 depth가 배열의 길이까지 갔을 때 만든 number가 s와 같다면 answer를 증가시켜주었다.
그런데 처음 공집합일 때가 0이므로, s가 0일 때는 경우의 수가 1가지 더 나오게 되므로 s가 0일 때 answer의 값을 -1시켜주었다.


## 🙂 새로 알게된 점

* 재귀함수가 어떻게 뻗어나가는지 도식화 해보면 쉽게 풀 수 있다.

