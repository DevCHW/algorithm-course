# 3주차 내용정리


## 📌 완전탐색(**Brute Force**)
___

### ✅ 완전 탐색이란?

- 모든 경우의 수를 다 체크해서 정답을 찾는 방법 (무식하게 가능한 거 다 해보겠다는 방법을 의미함)
- 예를 들어, 숫자 4자리의 암호로 구성된 자물쇠를 완전탐색으로 풀어보려고 한다면?
    - 무식하게 0000 ~ 9999 까지 모두 시도해보면 된다.

### ✅ 1차원 배열 입/출력 연습

- **1차원 배열 입/출력 연습문제**
    
    ```
    첫번째 수열의 길이 N이 주어지고, 두번 째 줄 부터 N개의 수열의 주어진다고 할 때 
    수열을 모두 출력하는 프로그램을 작성하세요
    
    **입력 예시**
    4
    100
    200
    300
    400
    
    **출력 예시**
    100 200 300 400    
    ```
    
    - 코드
        
        ```java
        import java.util.*;
        
        class Main {
        	public static void main(String[] args) {
        		Scanner sc = new Scanner(System.in);
        		int n = sc.nextInt();
        		int m = sc.nextInt();
        		int[][] arr = new int[n][m];
        		for(int i=0; i<n; i++) {
        			for(int j=0; j<m; j ++){
        				arr[i][j] = sc.nextInt();
        			}
        		}
        		
        		for(int i=0; i<n; i++) {
        			for(int j=0; j<m; j ++){
        				System.out.print(arr[i][j] + " ");
        			}
        			System.out.println();
        		}
        		
        	}
        }
        ```
    

### ✅ 2차원 배열 탐색 연습

- **2차원 배열 입/출력 연습문제**
    
    ```
    다음 예시를 입력받고, 출력하세요.
    세로의 길이 N과 가로의 길이 M이 첫 줄에 주어지고 다음 N개의 줄만큼 데이터가 주어진다.
    **입력 예시**
    4 5
    1 2 3 4 5
    6 7 8 9 10
    11 12 13 14 15
    16 17 18 19 20
    
    **출력 예시**
    1 2 3 4 5
    6 7 8 9 10
    11 12 13 14 15
    16 17 18 19 20
    ```
    
    - 코드
        
        ```java
        import java.util.*;
        
        class Main {
        	public static void main(String[] args) {
        		Scanner sc = new Scanner(System.in);
        		int n = sc.nextInt();
        		int m = sc.nextInt();
        		int[][] arr = new int[n][m];
        
        		for(int i=0; i<n; i++) {
        				for(int j=0; j<m; j++) {
        						arr[i][j] = sc.nextInt();				
        				}
        		}
        
        		for(int i=0; i<n; i++) {
        				for(int j=0; j<m; j++) {
        					System.out.print(arr[i][j] + " ");
        				}
        				System.out.println();
        		}
        	}
        }
        ```

### ✅ 예제문제

- [백준] - 한수
    - 정답코드
        
        ```java
        import java.util.*;
        
        public class Main {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                System.out.println(solution(n));
            }
        
            private static int solution(int n) {
                int answer = 0;
                for(int i=1; i<=n; i++) {
                    if (check(String.valueOf(i))) answer++;
                }
        
                return answer;
            }
        
            private static boolean check(String str) {
                if (str.length() >= 2) {
                    int num1 = str.charAt(0)-'0';
                    int num2 = str.charAt(1)-'0';
                    int gap = num2 - num1;
        
                    for(int i=2; i<str.length(); i++) {
                        int tmp = (str.charAt(i)-'0') - (str.charAt(i-1)-'0');
                        if (gap != tmp) return false;
                    }
                }
                return true;
            }
        }
        ```
        
- [백준] - 체스판 다시 칠하기
    - 정답코드
        
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
        
    

## 📌 재귀함수 개념(Recursive Function)
___

### ✅ 재귀함수란?

- 자기가 자기자신을 호출하는 함수라고 생각하면 된다.
- 기본적으로 스택프레임을 이용한다 !!!!

### ✅ 재귀함수 연습

- 숫자 n을 입력받고 1부터 n까지 출력
- n부터 1까지 출력
- 숫자 n을 입력받고 n! 계산해서 출력
- 알고리즘에서 재귀함수를 쓰는 이유?

## 📌 피보나치

---

**문제** 

<aside>
💡 피보나치 수는 0과 1로 시작한다.

0번째 피보나치 수는 0,

1번째 피보나치 수는 1

2번째 피보나치 수는 1

라고 할 때

숫자 n을 입력받으면, 0번째 피보나치 수 부터 n번째 피보나치 수 까지를 출력하는 프로그램을 작성하여라. 

**입력 예시**

17

**출력 예시**

0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597

</aside>

### ✅ 반복문을 이용하여 풀기

- 정답코드
    
    ```java
    import java.util.*;
    
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
    
            int count = 0;
            for(int x : solution(n)) {
                if(count != n) {
                    System.out.print(x + ",");
                } else {
                    System.out.print(x);
                }
                count++;
            }
        }
    
        private static int[] solution(int n) {
            int[] answer = new int[n+1];
    
            if (n >= 0) answer[0] = 0;
            if (n >= 1) answer[1] = 1;
            if (n >= 2) answer[2] = 1;
    
            for(int i=3; i<=n; i++) answer[i] = answer[i-2] + answer[i-1];
    
            return answer;
        }
    }
    ```
    

### ✅ 재귀함수를 써서 풀기

- 정답코드
    
    ```java
    import java.util.*;
    
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            solution(n);
        }
    
        private static void solution(int n) {
            for(int i=0; i<=n; i++) {
                if(i != n) {
                    System.out.print(recursive(i)+",");
                } else {
                    System.out.print(recursive(i));
                }
            }
        }
    
        private static int recursive(int n) {
            if(n == 0) return 0;
            else if(n == 1) return 1;
            else if(n == 2) return 1;
            else {
                return recursive(n-1) + recursive(n-2);
            }
        }
    }
    ```
    

### ✅ 메모이제이션을 적용해서 시간 줄이기

**메모이제이션이란 ?**

- **메모이제이션**(memoization)은 컴퓨터 프로그램이 동일한 계산을 반복해야 할 때, 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술이다. 동적 계획법의 핵심이 되는 기술이다.
- 정답코드
    
    ```java
    import java.util.*;
    
    public class Main {
    
        static int[] fibo;
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            solution(n);
            for(int i=0; i<=n; i++) {
                if(i == n) {
                    System.out.println(fibo[i]);
                } else {
                    System.out.print(fibo[i] + ",");
                }
            }
        }
    
        private static void solution(int n) {
            fibo = new int[n+1];
            recursive(n);
        }
    
        private static int recursive(int n) {
            //if(fibo[n] != 0) return fibo[n];
            if(n == 0) return fibo[n] = 0;
            else if(n == 1) return fibo[n] = 1;
            else if(n == 2) return fibo[n] = 1;
            else {
                return fibo[n] = recursive(n-1) + recursive(n-2);
            }
        }
    }
    ```
    

### ✅ 예제 문제

- [백준] - 피보나치 수
    - 정답코드
        
        ```java
        import java.util.*;
        
        public class Main {
        
            static int[] fibo;
        
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                solution(n);
                System.out.println(fibo[n]);
            }
        
            private static void solution(int n) {
                fibo = new int[n+1];
                recursive(n);
            }
        
            private static int recursive(int n) {
                if(fibo[n] != 0) return fibo[n];
                if(n == 0) return fibo[n] = 0;
                else if(n == 1) return fibo[n] = 1;
                else if(n == 2) return fibo[n] = 1;
                else {
                    return fibo[n] = recursive(n-1) + recursive(n-2);
                }
            }
        }
        ```
**예제문제**


## 📌 3주차 과제
___

**완전탐색**

[[백준] - 덩치](https://www.acmicpc.net/problem/7568)

[[백준] - 사탕 게임](https://www.acmicpc.net/problem/3085)

[[백준] - 숫자 야구](https://www.acmicpc.net/problem/2503)

[[백준] - 한수](https://www.acmicpc.net/problem/1065)

[[백준] - 체스판 다시 칠하기](https://www.acmicpc.net/problem/1018)

**재귀**

[[백준] - 피보나치 수](https://www.acmicpc.net/problem/2747)

[[백준] - 부분 수열의 합](https://www.acmicpc.net/problem/1182)