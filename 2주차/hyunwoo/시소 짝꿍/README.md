## Info
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/152996" rel="nofollow">시소 짝꿍</a>

## 풀이 코드
___
``` java
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // 무게배열의 길이는 10만까지 이지만, 무게는 100부터 1000까지만 존재하므로 중복을 제거한다면 최대 길이는 900이므로 중복을 제거하여 map에 담아준다.
        
        // key는 무게, value는 사람 수
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        int size = map.size();
        // 다시 무게배열, 사람 수 배열로 쪼갠다.
        int[] weightArr = new int[size];
        int[] countArr = new int[size];
        
        int idx = 0;
        for(int key : map.keySet()) {
            weightArr[idx] = key;
            countArr[idx] = map.get(key);
            idx++;
        }
        
        
        for(int i=0; i<size; i++) {
            if(countArr[i] > 1) {
                answer += (long) countArr[i] * (countArr[i]-1) / 2;
            }
            
            int weight1 = weightArr[i]; // 무게 1 선언
            int people1 = countArr[i]; //무게1을 가진 사람 수 선언
            for(int j=i+1; j<size; j++) {
                int weight2 = weightArr[j]; // 무게 2 선언
                
                if (isCouple(weight1, weight2)) { //무게 1과 무게2가 짝꿍이 될 수 있다면
                    int people2 = countArr[j]; //무게2를 가진 사람 수
                    
                    answer += (long) people1 * people2; //둘을 곱하여 answer에 누적.
                }
            }
        }
        
        
        return answer;
    }
    
    private boolean isCouple(int weight1, int weight2) {
        if(weight1*2 == weight2*3 ||
           weight1*2 == weight2*4 ||
           weight1*3 == weight2*2 ||
           weight1*3 == weight2*4 ||
           weight1*4 == weight2*2 ||
           weight1*4 == weight2*3) {
            return true;
        } else {
            return false;
        }
    }
}
```

<br>

## 아이디어
___
무게 배열의 길이가 100,000 까지이므로 완전탐색으로 풀게되면 바로 시간초과가 발생한다. 하지만 무게의 범위는 100~1000까지 이므로 무게 배열에서 중복을 제거하게 된다면 최대길이가 900까지 이므로 Map을 사용하여 중복을 제거한 카운팅을 해준 뒤 풀었다.

`Map<무게, 무게를 가진 사람의 수>` 를 선언하고난 뒤 풀면 된다.

<br>

## ❗ 풀이 방법
___

1. 주어진 `weights` 배열을 Map을 사용해서 무게 그룹별 카운팅한다.
``` java
Map<Integer, Integer> map = new HashMap<>();
for(int i=0; i<weights.length; i++) {
    map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
}
```

2. map을 다시 무게배열, 무게를 가진 사람들의 배열로 쪼갠다.

``` java
int size = map.size();
int[] weightArr = new int[size];
int[] countArr = new int[size];

int idx = 0;
for(int key : map.keySet()) {
    weightArr[idx] = key;
    countArr[idx] = map.get(key);
    idx++;
}
```

3. 반복문을 돌면서 다음 로직을 수행한다.
    -  해당 무게를 가진 사람이 2명 이상이라면, answer에 해당 무게를 가진 사람들끼리 짝꿍을 이룰 수 있는 경우의 수를 누적시켜준다.
    만약, 60kg의 무게를 가진 사람이 3명이라면 3명끼리 짝꿍을 이룰 수 있는 경우의 수는 (3 * (3-1)) / 2  = 3 이다.     
    따라서 같은 무게를 가진 사람이 n명이라면 n명끼리 짝꿍을 이룰 수 있는 경우의 수는 (n * (n-1)) / 2 이다.
    왜냐하면 n명 중 2명을 뽑아서 나열하고 중복을 제거한 경우의 수 이기 때문이다!

    - 다음 다른 무게들과 비교하여 짝꿍이 될 수 있는 무게인지 판별하여, 무게1을 가진 사람의 수와 무게2를 가진 사람의 수를 곱하여 answer에 누적시켜준다.

``` java
for(int i=0; i<size; i++) {
    if(countArr[i] > 1) {
        answer += (long) countArr[i] * (countArr[i]-1) / 2;
    }
    
    int weight1 = weightArr[i]; // 무게 1 선언
    int people1 = countArr[i]; //무게1을 가진 사람 수 선언
    for(int j=i+1; j<size; j++) {
        int weight2 = weightArr[j]; // 무게 2 선언
        
        if (isCouple(weight1, weight2)) { //무게 1과 무게2가 짝꿍이 될 수 있다면
            int people2 = countArr[j]; //무게2를 가진 사람 수
            
            answer += (long) people1 * people2; //둘을 곱하여 answer에 누적.
        }
    }
}
```

4. 짝꿍이 될 수 있는지를 판별하는 로직은 따로 메소드로 작성하였다. 이부분은 경우의 수가 많지는 않기 때문에 약간의 하드코딩으로 구현하였다.

``` java
private boolean isCouple(int weight1, int weight2) {
    if(weight1*2 == weight2*3 ||
        weight1*2 == weight2*4 ||
        weight1*3 == weight2*2 ||
        weight1*3 == weight2*4 ||
        weight1*4 == weight2*2 ||
        weight1*4 == weight2*3) {
        return true;
    } else {
        return false;
    }
}
```

<br>

## 🙂 새로 알게된 점
___

* Map을 사용하여 풀긴 하였으나, key의 배열과 value의 배열로 다시 쪼갠다는 점에서 깔끔하게 풀지는 못한것 같다고 생각하였다. 다른 풀이를 보니 좀 더 깔끔한 풀이가 있길래 기록한다.

``` java
class Solution {
    public long solution(int[] weights) {
    	long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
    		double a = i*1.0;
    		double b = (i*2.0)/3.0;
    		double c = (i*1.0)/2.0;
    		double d = (i*3.0)/4.0;
    		if(map.containsKey(a)) answer += map.get(a);
    		if(map.containsKey(b)) answer += map.get(b);
    		if(map.containsKey(c)) answer += map.get(c);
    		if(map.containsKey(d)) answer += map.get(d);
    		map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }
        
        return answer;
    }
}
```
1. 무게 배열을 정렬시킨 뒤, HashMap을 하나 선언한다.
2. 정렬된 무게 배열을 탐색하면서, 현재 무게의 1, 2/3, 1/2, 3/4 를 곱한 값이 map에 존재한다면 answer에 누적시켜준다. 작은 값 부터 탐색해나가므로 해당 4가지 케이스에 대하여만 검사하면 된다, 
3. map에 각각의 case의 무게가 존재한다면 answer에 해당 무게의 갯수를 누적시켜준다.
4. 현재 무게를 map에 넣어주면서 카운팅한다.


의문점은 자바의 `Arrays.sort()`는 `DualPivotQuickSort.sort()`를 사용하는데,
`DualPivotQuickSort.sort()`는 평균적으로 O(NlogN)의 시간복잡도를 갖지만 최악의 경우에는 O(N^2)의 시간복잡도를 발생시킬 수 있다고 한다.  
근데 무게 배열의 길이가 100000까지 허용되므로, 최악의 경우에는 100억의 시간복잡도를 갖게 되어 시간초과가 발생할 수도 있는 것 아닌가? 라는 의문이 들었다.

<br>

## Reference
___
https://mag1c.tistory.com/295

