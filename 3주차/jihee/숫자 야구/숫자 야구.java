import java.util.*;
public class Basic {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArr = new int[n];
        int[] strike = new int[n];
        int[] ball = new int[n];

        for(int i=0; i<n; i++){
            inputArr[i] = sc.nextInt();
            strike[i] = sc.nextInt();
            ball[i] = sc.nextInt();
        }

        System.out.println(solution(inputArr, strike, ball, n));

    }

    public static int solution(int[] inputArr, int[] strike, int[] ball, int n){
        int answer = 0;
        boolean[] arr = new boolean [999];

        //가능한 수 뽑기(0안되고 중복된 숫자 안됨)
        for(int i=123; i<999; i++ ){
            int a = i%10;
            int b = i%100/10;
            int c = i%1000/100;

            int s = 0;
            int ba = 0;
            int trueCount =0;

            if( a !=b && a !=c && b!=c && a!=0 && b!=0 && c!=0 ){
                for(int j=0; j<n; j++){
                    s = strike[j];
                    ba = ball[j];

                    String inputArr2 = Integer.toString(inputArr[j]);
                    String arr2 = Integer.toString(i);

                    //strike 판단(같은 자리 같은 수)
                    int strikeCount = 0;
                    for(int k=0; k<3; k++){
                        if(inputArr2.charAt(k) == arr2.charAt(k)){
                            strikeCount++;
                        }
                    }
                    //ball 판단(다른 자리 같은 수)
                    int ballCount = 0;
                    for(int k=0; k<3; k++){
                        for(int l=0; l<3; l++){
                            //같은 수인지
                            if(arr2.charAt(l) == inputArr2.charAt(k)){
                                if(k !=l ) ballCount++;
                            }
                        }
                    }
                    //주어진 숫자와 랜덤숫자의 ball,strike 가 주어진 n만큼 일치해야 통과 
                    if(s == strikeCount && ba== ballCount) trueCount++;
                }
            }
            if(trueCount == n ) answer++;
        }
        return answer;
    }
}
