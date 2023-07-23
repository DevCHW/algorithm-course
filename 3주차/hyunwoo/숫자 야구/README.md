## Info
<a href="https://www.acmicpc.net/problem/2503" rel="nofollow">숫자 야구</a>

## 풀이 코드
```java
import java.util.*;

public class Main {
    static class Question {
        String number;
        int strike;
        int ball;

        Question(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Question> questions = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String number = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questions.add(new Question(number, strike, ball));
        }

        print(solution(n, questions));
    }

    /**
     * 풀이 로직
     */
    private static int solution(int n, List<Question> questions) {
        int answer = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if(i == j) continue;
                for(int k=1; k<=9; k++) {
                    if(i == k || j == k) continue;
                    String str = String.valueOf(i) + j + k;

                    boolean flag = true;

                    for(Question question : questions) {
                        int strike = 0;
                        int ball = 0;
                        if (str.charAt(0) == question.number.charAt(0)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(0)))) {
                            ball++;
                        }

                        if (str.charAt(1) == question.number.charAt(1)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(1)))) {
                            ball++;
                        }

                        if (str.charAt(2) == question.number.charAt(2)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(2)))) {
                            ball++;
                        }

                        if(question.strike != strike || question.ball != ball) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer++;
                }
            }
        }

        return answer;
    }

}

```

## ❗ 풀이 방법
3중 for문을 이용하여 3자리의 모든 숫자 조합을 추려낸 뒤, 입력으로 받은 `questions`를 탐색하여 조건에 부합하는지 검사하여 조건에 부합한다면 answer를 카운팅해주는 방식으로 풀었다.

## 🙂 새로 알게된 점
* 숫자 세자리 조합을 삼중 for문으로 구현할 수 있다면 N의 범위가 작기 때문에 어렵지 않게 완전탐색으로 풀 수 있는 문제이다.