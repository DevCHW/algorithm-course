import java.util.*;

public class Main {

    static int answer;

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            int len = arr.length;
            boolean flag = true;
            if(len >= 2) {
                int gap = arr[1] - arr[0];
                for(int j=2; j<len; j++) {
                    if (arr[j] - arr[j-1] != gap) flag = false;
                }
            }

            if (flag) answer++;
        }
        return answer;
    }


    /**
     * print() 구현
     */
    private static void print(String str) {
        System.out.println(str);
    }

    /**
     * print() 구현
     */
    private static void print(int number) {
        System.out.println(number);
    }
}
