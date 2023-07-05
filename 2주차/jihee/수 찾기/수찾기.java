import java.util.*;
public class 수찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arrN = new Integer[n];
        for(int i=0; i< n; i++) arrN[i] = sc.nextInt();

        Arrays.sort(arrN);

        int m = sc.nextInt();

        int[] arrM = new int[m];
        for(int i=0; i<m; i++) arrM[i] =sc.nextInt();

        solution(n,arrN,m,arrM);
    }
    public static void solution(int n ,Integer[] arrN, int m, int[]arrM){
        Set<Integer> setN = new HashSet<Integer>(Arrays.asList(arrN));
        for(int i=0; i<m; i++){
            if(setN.contains(arrM[i])){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}

