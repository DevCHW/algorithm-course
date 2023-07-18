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

        //맨 처음은 아무것도 더해주지않아도 0이므로 처음꺼 빼주기위해 false
        recursive(0,0 , false);
        System.out.print(count);
    }


    public static void recursive(int sum, int idx, boolean check){
        if(idx == n){ //n개의 배열까지 다돌았을경우
            if(sum == k && check){ // 더한값이 목표값 k과 같고 숫자가 1개이상 더해졌을 경우
                count++;
            }return;
        }
        recursive(sum+arr[idx], idx+1, true); //숫자가 1개이상 더해졌기때문에 true
        recursive(sum, idx+1, check);
    }
}
