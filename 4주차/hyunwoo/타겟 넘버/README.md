## Info
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/43165" rel="nofollow">타겟 넘버</a>

## 풀이 코드
```java
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(0, 0, numbers, target);
        return answer;
    }
    
    private int dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if (sum == target) return 1;
            else return 0;
        }
        return dfs(depth+1, sum + numbers[depth], numbers, target) + 
            dfs(depth+1, sum - numbers[depth], numbers, target);    //더하거나, 빼거나
    } 
}
```

## ❗ 풀이 방법
numbers의 배열을 원소 하나 당 할 수 있는 경우의 수는 ***더하거나, 빼거나 2가지이다.***  
따라서, depth를 하나씩 늘려가며 재귀를 호출하고 depth가 numbers의 길이만큼 재귀가 호출되었을 때 만들어진 sum을 target과 비교하여 1 또는 0을 return해주었다.

## 🙂 새로 알게된 점

* 재귀 호출 방식을 머릿속에서 이해한다면 쉽게 풀 수 있는 문제이다.

