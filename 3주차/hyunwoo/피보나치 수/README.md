## Info
<a href="https://www.acmicpc.net/problem/2747" rel="nofollow">피보나치 수</a>

## 풀이 코드
___
``` java
import java.util.*;

public class Main {
    static int[] fibo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        fibo = new int[n+1];
        int answer = recursive(n);
        return answer;
    }

    private static int recursive(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n == 0) return fibo[n] = 0;
        else if(n == 1) return fibo[n] = 1;
        else {
            return fibo[n] = recursive(n-1) + recursive(n-2);
        }
    }
}
```

## ❗ 풀이 방법
1. 메모이제이션 할 int[] fibo 배열을 전역변수로 선언한 뒤, `int n`을 입력받는다.
2. `solution(int n)` 에서 fibo배열의 크기를 n+1로 할당해준 뒤, 재귀함수를 호출한다.
3. 재귀함수에서는 다음과 같은 로직을 수행한다.
    - `fibo[n]`이 초기값이 아니라면, fibo[n] 을 return해준다.
    - 매개변수로 넘어온 n이 0 이라면 fibo배열에 기록하면서 0을 return해준다.
    - 매개변수로 넘어온 n이 1 이라면 fibo배열에 기록하면서 1을 return해준다.
    - 위의 조건에 부합하는 것이 없다면 피보나치의 일반항구하는 공식을 재귀호출로 return 한다.
        - `recursive(n-1) + recursive(n-2);` 

## 🙂 새로 알게된 점
반복문, 단순 재귀, 메모이제이션을 이용하여 풀었다.  
반복문, 메모이제이션으로 푼 방법은 통과하였고, 단순 재귀는 시간초과가 났다.  
효율 면에서도 재귀는 메소드 스택프레임을 사용하기 때문에 반복문으로 코드를 구현하는 것 보다 효율이 떨어지지만, 그럼에도 불구하고 재귀함수를 쓰는 이유는 큰 문제를 분할하여 작은 단위로 쉽게 분할할 수 있는 면에서 쓴다고 한다.  
하지만 피보나치와 같이 간단한 점화식같은 경우는 반복문으로 구현하여도 코드를 이해하는 데에는 크게 문제가 없을 것 같다.


