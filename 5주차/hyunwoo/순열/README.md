## Info
<a href="https://www.acmicpc.net/problem/9742" rel="nofollow">순열</a>

## 풀이 코드
```java
import java.util.*;

public class Main {

    static int count;
    static String answer;
    static char[] arr;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();

            System.out.println(solution(str, n));
        }
    }

    private static String solution(String str, int n) {
        answer = null;
        flag = false;
        count = 0;
        arr = new char[str.length()];
        visited = new boolean[str.length()];

        dfs(0, str, n);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(" ").append(n).append(" = ");

        if(answer == null) return sb.append("No permutation").toString();
        else {
            return sb.append(answer).toString();
        }
    }

    private static void dfs(int depth, String str, int n) {
        if (flag) return;

        if (depth == str.length()) {
            count++;
            if(count == n) {
                answer = new String(arr);
                flag = true;
                return;
            }
            return;
        }
        for(int i=0; i<str.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = str.charAt(i);
                dfs(depth+1, str, n);
                visited[i] = false;
            }
        }
    }
}

```

## ❗ 풀이 방법
문제를 말로 풀어서 설명하자면, 입력받은 String에서 String의 길이만큼 뽑아서 나열하는 순열을 코드로 작성하라는 뜻이다.  
순열은 보통 재귀로 작성하면 되는데,
```java
private static void dfs(int depth, String str, int n) {
    if (flag) return;

    if (depth == str.length()) {
        count++;
        if(count == n) {
            answer = new String(arr);
            flag = true;
            return;
        }
        return;
    }
    for(int i=0; i<str.length(); i++) {
        if(!visited[i]) {
            visited[i] = true;
            arr[depth] = str.charAt(i);
            dfs(depth+1, str, n);
            visited[i] = false;
        }
    }
}
```

위의 코드를 살펴보면 depth를 1씩 늘려나가고, str.length()까지 늘리는 것을 종료조건으로 잡았다.

visited로 문자열에서 사용된 곳의 인덱스 번호를 체크하고, arr에 순열을 완성시켜가면서 재귀를 호출해준 뒤, depth가 문자열의 길이만큼 되었을 때 순열의 갯수(count)를 1 증가시켜주고, count가 n번째가 되었다면 answer에 완성되어져 있는 순열을 넣어주는 로직이다.

## 🙂 후기
* 입출력 방식이 약간 까다롭고 지저분해서 좋은 문제는 아닌 것 같다.. 하지만 순열을 연습해보기엔 나쁘지는 않은것 같기도.. 

