## Info
<a href="https://www.acmicpc.net/problem/1920">수 찾기</a>

## ❗ 풀이 방법
___
1. main 함수에서 int n, int[] arr1, int m, int[] arr2를 입력받고 solution 메소드로 입력받은 값들을 solution 메소드에 넘겨준다.
``` java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] arr1 = new int[n];
for(int i=0; i<n; i++) {
    arr1[i] = sc.nextInt();
}

int m = sc.nextInt();
int[] arr2 = new int[m];
for(int i=0; i<m; i++) {
    arr2[i] = sc.nextInt();
}
``` 

2. solution 메소드에서는 HashSet<Integer> 자료구조를 선언하고, arr1의 원소들을 다음과 같이 옮겨담아준다.  
``` java
Set<Integer> set = new HashSet<>();
for(int x : arr1) set.add(x);
```

<br>

3. arr2를 탐색하면서, set에 arr2의 원소가 포함되어 있는지를 검사하여 answer 배열에 1 또는 0을 담아주고, 탐색이 끝난 뒤 answer 배열을 리턴하여 출력한다.  
``` java
for(int i=0; i<m; i++) {
    int tmp = arr2[i];
    if (set.contains(tmp)) answer[i] = 1;
    else answer[i] = 0;
}
return answer;
```

## 🙂 새로 알게된 점
___

* 해당 문제를 나는 Set 자료구조를 이용하여 풀었는데, 이분탐색으로도 풀 수 있다고 한다. 다음은 이분탐색으로 해결한 코드이다.

``` java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }

        for(int x : solution(n, m, arr1, arr2)) {
            System.out.println(x);
        }
    }

    private static int[] solution(int n, int m, int[] arr1, int[] arr2) {
        int[] answer = new int[m];

        Arrays.sort(arr1); //이분탐색을 하기위한 정렬

        for(int i=0; i<m; i++) {
            int tmp = arr2[i]; //존재여부 검사 값 추출
            answer[i] = binarySearch(arr1, tmp);
        }

        return answer;
    }

    private static int binarySearch(int[] arr, int tmp) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(tmp < arr[mid]) right = mid - 1;
            else if(tmp > arr[mid]) left = mid + 1;
            else {
                return 1;
            }
        }
        return 0;
    }
}
```

풀이방법은, 이분탐색을 하기위하여 arr2를 오름차순 정렬시켜놓고, arr1을 탐색하면서 존재여부를 확인할 값을 추출하여 binarySearch하여 값을 찾게되면 1, 찾지 못할경우 0을 리턴하여 answer 배열에 담는식으로 하였다.

solution 메소드로 따졌을 때 Set을 이용한 풀이는 O(N), 이분탐색을 이용한 풀이는 O(NlogN) 이므로 효율성은 시간은 Set을 이용한 풀이가 조금 더 좋은 것 같고, 메모리는 자료구조를 따로 사용하지 않는 이분탐색을 이용한 풀이가 더 효율적이라고 볼 수 있다.

<br>

## Reference
___
https://st-lab.tistory.com/261

