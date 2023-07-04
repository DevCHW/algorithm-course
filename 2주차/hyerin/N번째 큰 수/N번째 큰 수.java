import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        int nthBigger = findNthBiggerNumber(table, n);
        System.out.println(nthBigger);
    }

    public static int findNthBiggerNumber(int[][] table, int n) {
        // 순서를 거꾸로
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 1차원 배열로 변환
        for(int i=0; i < table.length; i++){
            for (int j=0; j < table[i].length; j++){
                pq.add(table[i][j]);
            }
        }

        // n 번째 큰 수 찾기
        int nthBigger = 0;
        for (int i=0; i< n; i++) {
            nthBigger = pq.poll();
        }

        return nthBigger;
    }


}
