import java.util.*;
public class Main {
    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        arr[0] = 0;

        if(n>=1){
            arr[1] = 1;
        }
        if(n>=2){
            arr[2] = 1;
        }

        System.out.println(solution(n, arr));
    }

    static int[] memo;
    public static int solution(int n, int[] arr){

        memo = new int[n+1];

        for(int i=3; i <=n; i++){
            arr[i]=recursive(i);
        }

        int answer = arr[n];

        return answer;
    }

    public static int recursive(int n){
       if(memo[n] !=0) return memo[n];
       if(n==0) return memo[0] = 0;
       else if(n==1) return memo[1] = 1;
       else if(n==2) return memo[2] = 1;
         return memo[n] = recursive(n-1)+recursive(n-2);
    }
}
