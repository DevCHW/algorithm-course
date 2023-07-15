import java.util.*;
public class Main {
    static int n;
    static int k;
    static int count=0;
    static int[] arr;
    public static void main(String arg[]){

        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for(int i=0; i <n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            recursive(0,i);
        }
        System.out.print(count);
    }


    public static void recursive(int sum, int idx){
        sum += arr[idx];
        if(sum == k){
            count++;
        }
        if(idx == n-1){
            return;
        }
        for(int i=idx+1; i <n; i++){
            recursive(sum, i);
        }
    }
}
