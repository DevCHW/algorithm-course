import java.util.*;
public class Basic {

    public static void main(String arg[]){
        Scanner sc= new Scanner(System.in);
        Integer n = sc.nextInt();

        int[] weight = new int[n];
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        for(int x : solution(weight , height)){
            System.out.print(x + " ");
        }


    }

    public static int[] solution(int[] weight, int[] height){
        int[] answer =new int[weight.length];
        int n = weight.length;
        //배열 값 1로 초기화
        for(int i=0; i<n; i++){
            answer[i] =1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && weight[i] < weight[j] && height[i] <height[j]){
                        answer[i] +=1;
                }
            }
        }
        return answer;
    }

}