## Info
<a href="https://www.acmicpc.net/problem/1018" rel="nofollow">체스판 다시 칠하기</a>

## 풀이 코드
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n 입력받기
        int n = sc.nextInt();

        // m 입력받기
        int m = sc.nextInt();

        // board 입력받기
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.println(solution(n, m, board));
    }

    private static int solution(int n, int m, char[][] board) {
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n-7; i++) {
            for(int j=0; j<m-7; j++) {
                answer = Math.min(answer, getCount(i, j, board));
            }
        }
        return answer;
    }

    private static int getCount(int x, int y, char[][] board) {
        int count = 0;

        char currentColor = board[x][y];

        for(int i=x; i<x+8; i++) {
            for(int j=y; j<y+8; j++) {
                if(board[i][j] != currentColor) {
                    count++;
                }
                currentColor = change(currentColor);
            }
            currentColor = change(currentColor);
        }
        return Math.min(count, 64 - count);
    }

    private static char change(char currentColor) {
        if(currentColor == 'W') {
            return 'B';
        } else {
            return 'W';
        }
    }
}

```

## 아이디어
일단 주어진 board의 크기에서 8*8 크기로 자를 수 있는 경우의 수 만큼 체스판을 일단 잘라본 다음, 다시 체스판을 칠해야 하는 갯수를 센다. 이 때 W로 시작하거나 B로 시작하는 두가지의 경우의 수는 하나의 경우의 수를 세어 64-count와 count 둘 중 작은 수를 리턴하면 된다.

## ❗ 풀이 방법
```java
private static int solution(int n, int m, char[][] board) {
    int answer = Integer.MAX_VALUE;

    for(int i=0; i<n-7; i++) {
        for(int j=0; j<m-7; j++) {
            answer = Math.min(answer, getCount(i, j, board));
        }
    }
    return answer;
}
```
i와 j 0부터 n,m -7까지 한칸씩 옮겨서 체스판을 잘라보고, 자른 기준위치(체스판의 왼쪽 모서리라고 생각하면 됨)를 getCount의 파라미터로 보낸다.

```java
private static int getCount(int x, int y, char[][] board) {
    int count = 0;

    char currentColor = board[x][y];

    for(int i=x; i<x+8; i++) {
        for(int j=y; j<y+8; j++) {
            if(board[i][j] != currentColor) {
                count++;
            }
            currentColor = change(currentColor);
        }
        currentColor = change(currentColor);
    }
    return Math.min(count, 64 - count);
}

private static char change(char currentColor) {
    if(currentColor == 'W') {
        return 'B';
    } else {
        return 'W';
    }
}
```
`getCount` 메소드에서는 체스판을 자른 기준위치(x, y)부터 8*8 크기만큼을 탐색하면서 다시 색을 칠해야 하는 갯수를 카운팅한다.

W로 시작하는 경우의 수와 B로 시작하는 경우의 수 두가지 중 작은 수를
`Math.min(count, 64 - count)`를 통하여 return한다.

## 🙂 새로 알게된 점
* 복잡한 알고리즘을 떠올릴 필요 없이 완전탐색으로 모든 경우의 수에 대하여 충실히 구현하면 되는 문제였다.

