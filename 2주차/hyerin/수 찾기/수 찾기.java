import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nNum = new int[n];
        for (int i=0; i<n; i++){
            nNum[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mNum = new int[m];
        for (int i=0; i<m; i++){
            mNum[i] = sc.nextInt();
        }

        System.out.println(solution(n, nNum, m, mNum).toString());
    }

    public static int[] solution(int n, int[] nNum, int m, int[] mNum){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nNum[i], map.getOrDefault(nNum[i], 0) + 1);
        }

        int[] answer = new int[m];

        for(int i=0; i<m; i++){
            if(map.getOrDefault(mNum[i], 0) > 0)
                answer[i] = 1;
            else
                answer[i] = 0;
        }

        return answer;
    }

}
