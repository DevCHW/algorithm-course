import java.util.*;
public class Main {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(solution(n));
    }
    public static int solution(int n){
        int count =0;

        String checkNum = String.valueOf(n);
        int numLength = checkNum.length();

        if(numLength <= 2 ){
            if(numLength == 2){
                for(int i=1; i<=n; i++){
                    count++;
                }
            }
            else if(numLength == 1){
                for(int i=1; i<=n; i++){
                    count++;
                }
            }
        }
        if(numLength > 2){
            count = 99; //2자리까지 모두 한수 인정

            for(int i=100; i<=n; i++) {

                int a = i % 10;
                int b = i % 100 / 10;
                int c = i % 1000 / 100;

                int check1 = c - b;
                int check2 = b - a;

                if (check1 == check2) {
                    count++;
                }
            }

            if (numLength == 4) { // 1000 일때 위에서 000 카운트 해주었기 때문에 1개빼주기
                count--;
            }
        }
        return count;
    }

}
