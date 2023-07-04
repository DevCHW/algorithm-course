## Info
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/12909" rel="nofollow">올바른 괄호</a>

## 풀이 코드
___
```java
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char x : s.toCharArray()) {
            if(x == '(') stack.push(x);
            else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) answer = true;
        else answer = false;
        return answer;
    }
}
```
<br>

## 아이디어
___
스택을 이용하여 풀면 되는 간단한 문제이다.

<br>

## ❗ 풀이 방법
___
1. `Stack<Character> stack = new Stack<>();` 으로 Character가 들어갈 수 있는 스택을 선언한다.
2. s 문자열을 `toCharArray()` 메소드를 통하여 char 타입의 배열로 만든 뒤 탐색하며 다음의 로직을 수행한다.
    - 현재 문자가 `여는 괄호` 라면 stack에 `push()` 한다.
    - 현재 문자가 `닫는 괄호` 라면
        - stack이 비어있지 않는 경우 stack에서 `pop()` 한다.
        - stack이 비어있다면 올바른 괄호가 아니므로, 바로 `return false` 한다.

3. s 문자열의 탐색이 끝나고 난 뒤에 stack이 비어있다면 `answer = true`, stack이 비어있지 않다면 `answer = false`로 하여 answer를 최종적으로 return한다. 

<br>

## 🙂 새로 알게된 점
___

* 간단한 문제이기 때문에 새로 알게된 점은 없다. 앞으로 괄호의 쌍을 찾는 문제나 무언가의 쌍을 찾는 문제라면 일단 stack을 고려해보면 될 것 같다.

