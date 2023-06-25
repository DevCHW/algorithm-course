# 2주차 내용정리

<br>    
    
## 📌 코딩테스트 문자열 메소드

---

## String

- `startsWith(str)` : 문자열이 특정 문자로 시작되는지 판별
- `endsWith(str)` : 문자열이 특정 문자로 끝나는지 판별
- `equal(str)` : String 문자열 값 비교
- `indexOf(str)` : 특정 문자열이 대상 문자열의 몇 번째 인덱스에 위치하는지 반환
    - 특정 문자열이 없을 경우에는 -1을 리턴
- `substring` : 지정한 범위에 속하는 문자열 반환
    - `substring(index)`: index 위치를 포함하여 이후의 모든 문자열을 리턴
    - `substring(beginIndex, endIndex)` : beginIndex에서 endIndex-1까지의 부분 문자열을 반환
- `replace(beforeStr, afterStr)` : 특정 문자열을 새로운 문자열로 치환
- `toLowerCase(str)` : 문자열을 소문자로 변환
- `toUpperCase(str)` : 문자열을 대문자로 변환
- `trim(str)` : 문자열의 앞뒤 공백 제거
    - 단, 문자열 내부의 공백은 `replace(" ", "")`를 사용해야 함
- `charAt(index)` : 문자열 특정 위치에 있는 문자 반환
    - 인덱스 값으로 마이너스 값을 대입하거나, 문자열 길이보다 큰 인덱스 값을 대입하면 `java.lang.StringIndexOutOfBoundsException` 오류 발생
- `String.valueOf(str)` : 지정된 값을 String으로 변환
- `contains(str)` : 특정 문자열이 포함되어 있는지 확인
- `split(regex)` : 문자열을 특정 문자열을 기준으로 나는 후 배열을 반환
- `length` : 문자열의 길이를 반환

<br>

## 📌 코딩테스트 배열 메소드

---

- `Arrays.sort()` : 오름차순으로 정렬
    - 정렬 대상 범위를 지정
        
        ```
        int[] intArr = new int[] {1, 3, 5, 2, 4};
        Arrays.sort(intArr, 2, 5); // intArr[2]~intArr[4]의 값만 정렬
        ```
        
    - 내림차순으로 정렬
        - Wrapper Class로 된 배열(Reference Type Array)만 가능하다.
        - 이미 정의된 메소드를 활용하여 정렬할 수 있다.
            - `Comparator.reverseOrder()`
            - `Collections.reverseOrder()`
            
            ```
            Integer[] integerArr = new Integer[] {1,3,5,2,4};
            String[] stringArr = new String[] {"A","C","B","E","D"};
            
            Arrays.sort(integerArr,Comparator.reverseOrder()); //내림차순
            Arrays.sort(stringArr,Collections.reverseOrder()); //내림차순
            ```
            
- `Arrays.asList(arr)` : 배열을 ArrayList로 변환
- `Arrays.fill(arr, value)` : 배열을 value 값으로 채움
    - `Arrays.fill(arr, start, end, value)` : 배열의 start부터 end-1까지 value 값으로 채움
- `Arrays.copyOf(arr, size)` : 배열의 0번째 원소부터 size만큼 복사 (새로운 배열 생성)
- `Arrays.copyOfRange(arr, start, size)` : 배열의 start원소부터 size만큼 복사 (새로운 배열 생성)

<br>

## 코딩테스트 Math 메소드

---

- `Math.max(n1, n2)` : 두 인자 중 더 큰 값을 반환
- `Math.min(n1, n2)` : 두 인자 중 더 작은 값을 반환
- `Math.abs(n)` : 절댓값을 반환
- `Math.pow(base, exponent)` : 제곱 값을 반환
    - 앞의 인자는 밑, 뒤의 인자는 지수를 뜻함
- `Math.sqrt(n)` : 제곱근 반환
- `Math.round(n)` : 소숫점 첫번째 자리에서 반올림한 결과 반환
- `Math.floor(n)` : 내림 연산 결과 반환
- `Math.ceil(n)` : 올림 연산 결과 반환

<br>

## 📌 Collection Framework 클래스 구조

![출처 : [https://velog.io/@ann0905/알고리즘을-위한-자바-함수-정리](https://velog.io/@ann0905/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%84-%EC%9C%84%ED%95%9C-%EC%9E%90%EB%B0%94-%ED%95%A8%EC%88%98-%EC%A0%95%EB%A6%AC)](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20(6%2028)%200e6d62018d72485494af98fcbb231278/%25EC%259E%2590%25EB%25B0%2594_%25EC%25BB%25AC%25EB%25A0%2589%25EC%2585%2598.png)

출처 : [https://velog.io/@ann0905/알고리즘을-위한-자바-함수-정리](https://velog.io/@ann0905/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%84-%EC%9C%84%ED%95%9C-%EC%9E%90%EB%B0%94-%ED%95%A8%EC%88%98-%EC%A0%95%EB%A6%AC)

<br>

## 📌 Stack, Queue

---

### ✅ Stack

- LIFO(Last In First Out) 구조
- 한쪽이 막혀있는 바구니를 연상하면 됨.
- 활용
    - 재귀
    - DFS
    - 작업 실행 취소와 같은 역추적 작업
    - 괄호 검사
    - 후위 연산법
    - 문자열 역순 출력

선언문 : `Stack stack = new Stack<>();`

- 스택 관련 메소드
    - `push(obj)` : 스택의 top에 값을 삽입
    - `pop()` : 스택의 top 값을 반환한 뒤에 삭제
    - `peek()` : 스택의 top 값 조회
    - `clear()` : 스택의 값을 모두 제거
    - `empty()` : 스택이 비어있는지 확인
    - `contains(obj)` : 스택이 특정 원소를 포함하고 있는지 확인
    - `search(obj)` : 스택에서 특정 원소를 찾아 위치(1부터 시작)를 반환
        - 원소가 스택에 없다면 -1을 반환
- ✏️ 예제문제
    
    [[백준] 괄호](https://www.acmicpc.net/problem/9012)
    
    [[백준] 스택](https://www.acmicpc.net/problem/10828)
    

<br>

### ✅ Queue

- FIFO(First Int First Out) 구조
- 일반적인 큐는 주로 LinkedList 사용
- 활용
    - 데이터를 입력된 순서대로 처리 작업
    - BFS
    - 프로세스 관리
    - 대기 순서 관리

선언문 : `Queue queue = new LinkedList<>();`

- 큐 관련 메소드
    - `add(obj)` : LinkedList 의 마지막에 객체를 추가
    - `offer(obj)` : 큐의 마지막에 객체를 추가
        - 큐의 크기가 꽉 찼을 경우에 `add`는 예외를 발생시키지만 `offer`는 false를 반환
        - *`offerFirst(obj)` : LinkedList의 맨 앞에 객체를 추가*
        - *`offerLast(obj)` : LinkedList의 맨 마지막에 객체를 추가*
    - `poll()` : 큐의 맨 앞에 위치한 값을 반환한 뒤에 삭제
        - *`pollFirst()` : LinkedList의 첫번째 노드르 반환하면서 제거*
        - *`pollLast()` : LinkedList의 마지막 노드르 반환하면서 제거*
    - `peek()` : 큐의 맨 앞에 위치한 값을 반환
        - *`peekFirst()` : LinkedList의 첫번째 노드를 반환*
        - *`peekLast()` : LinkedList의 마지막노드를 반환*
- ✏️ 예제문제
    
    [[백준] 큐](https://www.acmicpc.net/problem/10845)
    

<br>

## 📌 PriorityQueue(우선순위 큐)

---

- 우선순위가 가장 높은 데이터를 가장 먼저 삭제하는 자료구조
- 데이터를 **우선순위에 따라 처리하고 싶을 때 사용**한다.
- 그리디 알고리즘, 다익스트라 알고리즘 에서 이용됨

✅ 우선순위 큐를 구현하는 방법

- 리스트 : 삽입시간 O(1), 삭제시간 : O(N)
- 힙(Heap) : 삽입시간 O(logN), 삭제시간 : O(logN)

✅ 단순히 N개의 데이터를 힙에 넣었다가 모두 꺼내는 작업은 정렬과 동일하다. (힙 정렬)

- 이 경우 시간복잡도는 O(NlogN)

선언문 : `PriorityQueue pq = new PriorityQueue<>();`

❗정렬을 반대로 하고싶을 땐 ? 

- `PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());`
- 위와 같이 `Collections.reverseOrder()` 를 인자로 넣어주면 됨.

- ✏️ 예제문제
    
    [[백준] N번째 큰 수](https://www.acmicpc.net/status?user_id=ggoma003&problem_id=2075&from_mine=1)
    

<br>

## 📌 Map

---

- key, value로 구성된 자료구조
- 순서가 보장되지 않아도 될 땐 **HashMap**, 순서가 보장되어야 한다면 **LinkedHashMap** 사용

- Map 관련 메소드
    - `put(key, value)` : 맵에 key와 value 값 추가
    - `putAll(map)` : map의 모든 원소를 추가
    - `get(key)` : key와 매핑된 value 반환
        - 만약 key 값이 없을 땐, null을 반환
    - `getOrDefault(key, defaultValue)` :** key가 없다면 defaultValue로 초기화 하여 반환하고, 있다면 해당 key의 value를 반환
    - `remove(key)` : 특정 key에 해당하는 값을 삭제
    - `replace(key, value)` : 특정 key에 해당하는 값을 value로 대체
    - `clear()` : 맵에 저장된 모든 객체 제거
    - `containsKey(key)` : 특정 key가 맵에 있는지 판별
    - `containsValue(value)` : 특정 value가 맵에 있는지 판별
    - `keySet()` : 맵의 모든 key가 저장된 Set을 반환
    - `entrySet()` : 맵의 모든 entry(=key와 value의 결합) 저장된 Set을 반환
    - `values()` : 맵의 모든 value 값을 컬랙션 형태로 반환
- ✏️ 예제문제
    - 첫 줄에 사람 수 N (1 ≤ N ≤ 100)이 주어지고 둘 째 줄에 각 사람의 몸무게가 공백을 기준으로 주어진다.
        
        이 때 몸무게를 오름차순 하여 한 줄에 몸무게와 해당 몸무게를 가진 사람의 수를 공백을 기준으로 출력하여라.
        
        **입력 예시**
        
        5
        
        90 80 70 80 90
        
        **출력 예시**
        
        70 1
        
        80 2
        
        90 2
        
        - 정답 코드
            
            ```java
            import java.util.*;
            
            public class Main {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    for(int i=0; i<n; i++) {
                        arr[i] = sc.nextInt();
                    }
            
                    Map<Integer, Integer> answer = solution(n, arr);
                    for(int key : answer.keySet()) {
                        System.out.print(key + " " + answer.get(key));
                        System.out.println();
                    }
                }
            
                public static Map<Integer, Integer> solution(int n, int[] arr) {
                    Arrays.sort(arr);
            
                    // 몸무게, 사람 수
                    Map<Integer, Integer> map = new LinkedHashMap<>();
                    for(int x : arr) {
                        map.put(x, map.getOrDefault(x, 0) + 1);
                    }
            
                    return map;
                }
            }
            ```
            
    
    [[백준] 수 찾기](https://www.acmicpc.net/problem/1920)
    

<br>

## 📌 Set

---

- 집합, 중복제거 자료구조
- 주로 HashSet 사용

- Set 관련 메소드
    - `clear()` : Set에 저장된 모든 객체 제거
    - `getOrDefault(key, defaultValue)` : key가 없다면 defualtValue로 초기화하여 반환하고, 있다면 해당 key의 value를 반환
    
    > 아래 함수들은 확인/성공 여부를 boolean 값으로 반환
    > 
    - `add(obj)` : Set에 특정 요소 추가
    - `addAll(c)` : 주어진 컬렉션의 모든 객체를 집합에 추가 (=**합집합**)
    - `remove(obj)` : Set에 특정 요소 삭제
    - `removeAll(c)` : 주어진 컬렉션의 객체와 같은 원소를 제거(=**차집합**)
    - `contains(obj)` : 특정 객체를 포함하는지 확인
    - `containsAll(c)` : 주어진 컬렉션의 모든 객체를 포함하는지 확인(=**부분집합**)
    - `retainAll(c)` : 주어진 컬렉션의 객체와 동일한 것만 남기고 삭제(=**교집합)**
- ✏️ 예제문제
    
    [[백준] 숫자 카드](https://www.acmicpc.net/problem/10815)
    

<br>

## 📌 List

---

주로 ArrayList 사용

- List 관련 메소드
    - `add` : 특정 값 추가
        - `add(obj)` : 리스트 끝에 원소 추가
        - `add(index, obj)` : 특정 인덱스에 원소 추가
    - `addAll` : 주어진 컬렉션의 모든 객체를 추가
        - `addAll(c)` : 주어진 컬렉션의 모든 객체를 끝에 추가
        - `addAll(index, c)` : 주어진 컬렉션의 모든 객체를 index 위치에 추가
    - `get(index)` : 특정 인덱스 값 조회
    - `set(index, obj)` : 특정 위치에 객체 저장
    - `remove` : 특정 값 삭제
        - `remove(index)` : 인덱스에 위치하는 값 삭제
        - `remove(obj)` : 특정 객체 삭제
    - `indexOf(obj)` : 리스트에서 특정 객체의 인덱스를 반환
    - `subList(fromIndex, toIndex)` : fromIndex와 toIndex-1까지의 부분 리스트 반환
    - `contains(obj)` : 특정 원소가 리스트 내에 있는 지 확인
    - `sort()` : 리스트를 오름차순으로 정렬
        - `sort(comparator)` : 리스트를 특정 정렬 기준으로 정렬
    - `toArray()` : 리스트를 고정 크기의 배열로 전환

<br>

## 📌 2주차 과제

---

[[프로그래머스] 시소 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/152996)

[[프로그래머스] 올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

[[프로그래머스] 기능개발](https://school.programmers.co.kr/learn/courses/30/lessons/42586)

## 📌 Reference

---

[https://velog.io/@ann0905/알고리즘을-위한-자바-함수-정리](https://velog.io/@ann0905/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%84-%EC%9C%84%ED%95%9C-%EC%9E%90%EB%B0%94-%ED%95%A8%EC%88%98-%EC%A0%95%EB%A6%AC)