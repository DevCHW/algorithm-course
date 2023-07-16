import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        solution(arr, 0, 0, S);

        if(S == 0) count--;

        System.out.println(count);

    }


    public static void solution(int[] arr, int index, int sum, int target){
        if (index == arr.length){
            if (sum == target) count++; // 합이 target과 같으면 카운팅
            return; // 재귀 종료
        }

        // 합해온 값과 현재 arr의 값을 더하는 경우의 재귀함수
        solution(arr, index + 1, sum + arr[index], target);

        // 현재 arr을 제외하는 경우의 재귀함수
        solution(arr, index + 1, sum, target);
    }

}
