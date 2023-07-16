import java.util.*;

public class 한수_1065 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for(int i=1; i<=N; i++){
            if (isHansu(i)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isHansu(int x){
        // 두자리 수 -> 모두 한수 -> true
        if(x < 100){
            return true;
        }

        // 세자리 수 이상인 경우
        int first = x/100;
        int second = (x / 10) % 10;
        int third = x % 10;

        // 등차수열 확인
        return (second - first) == (third - second);
    }

}
