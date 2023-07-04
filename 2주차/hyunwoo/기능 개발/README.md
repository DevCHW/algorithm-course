## Info
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/42586" rel="nofollow">기능 개발</a>

## 풀이 코드
___
``` java
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //map으로 배포되는 기능들 중복카운팅 하기.(배포되는 일자, 배포되는 기능 횟수)
        Map<Integer, Integer> map = new LinkedHashMap<>();
        
        //탐색 배열 길이 뽑기
        int len = progresses.length;
        int[] arr = new int[len];
        
        // 작업들의 남은 일 수 계산하여 arr에 넣기
        int beforeWorkDay = 0;
        for(int i=0; i<len; i++) {
            int percent = progresses[i];
            int speed = speeds[i];
            
            int workDay = calculateWorkDay(percent, speed);
            if (beforeWorkDay > workDay) workDay = beforeWorkDay;
            
            map.put(workDay, map.getOrDefault(workDay, 0) + 1);
            beforeWorkDay = workDay;
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for(int key : map.keySet()) {
            answer[idx] = map.get(key);
            idx++;
        }
        return answer;
    }
    
    // 남은 작업일자 계산
    private int calculateWorkDay(int percent, int speed) {
        int workDay = 0;
        
        while(percent < 100) {
            workDay++;
            percent += speed;
        }
        return workDay;
    }
}
```

<br>

## ❗ 풀이 방법
___
LinkedHashMap을 사용하여.
map의 key 값은 `배포되는 일자`, value값은 `배포되는 기능의 갯수`로 하여 
`Map<Integer, Integer> map = new LinkedHashMap<>();` 로 선언한다.

progresses와 speeds의 배열의 길이는 같으므로 `int len = progresses.length;`로 따로 탐색범위 len을 선언한다.

len 만큼 반복문을 돌면서, 각 작업당 남은 작업의 일자를 `calculateWorkDay` 메소드를 통하여 알아낸 뒤, 이전 작업의 남은 작업일자와 비교하여 배포되는 날짜를 알아내어 map에 put 하여 카운팅한다.

반복문의 마지막에는 `beforeWorkDay` (이전 작업의 남은 작업일자)를 갱신시켜주어 다음 반복문을 수행한다.

반복문이 끝나면, map의 value값을 **순서대로** answer 배열에 옮겨담아준다.
순서가 중요하기 때문에 HashMap 대신에 LinkedHashMap을 사용하여 풀었다.

<br>

## 🙂 새로 알게된 점
___

* 이전에는 Queue와 List를 사용하여 풀었었다. 다음은 Queue와 List를 사용한 풀이 코드이다.

``` java
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int a = progresses[i];
            int b = speeds[i];
            if((100-a)%b == 0) {
                queue.offer((100-a)/b);
            } else {
                queue.offer(((100-a)/b)+1);
            }
        }
        
        int a = queue.poll();
        int count = 1;
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int b = queue.poll();
            
            if(a >= b) {
                count++;
            } else {
                list.add(count);
                count = 1;
                a = b;
            }
        }
        list.add(count);
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
```

해당 풀이는 각 작업들의 남은 작업일자를 계산하여 Queue에 담고, 순차적으로 Queue를 탐색하면서 같은일자에 배포되는 기능들을 카운팅하여 list에 담고, list를 answer 배열에 담아주어서 return하여 풀었다.

해당 풀이보다는 Map을 사용한 풀이가 조금 더 코드도 깔끔하고, 메모리도 덜 낭비하고 시간도 적게 쓰기 때문에 Map을 사용한 풀이가 조금 더 깔끔한 것 같다.

