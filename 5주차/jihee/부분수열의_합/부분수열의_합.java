import java.util.*;
public class Main {
    private static int n;
    private static int s;
    private static int count;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        solution();

        if(s==0){
            count--;
        }

        System.out.println(count);

    }

    private static void solution(){

        dfs(0,0);
    }
    private static void dfs(int depth, int sum){
        if(depth == n){
            if(sum == s) count++;
        }
        else{
            dfs(depth+1, sum); // 원소값 사용 하지않을 경우
            dfs(depth+1, sum+arr[depth]); //원소값 사용 한 경우
        }
    }

}
