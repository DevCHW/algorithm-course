import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] arr = new char[N][M];

        for(int i=0; i<N; i++){
            String row = sc.next();
            for(int j=0; j<M; j++){
                arr[i][j] = row.charAt(j)   ;
            }
        }

        int min = Integer.MAX_VALUE;

        // 시작 위치를 기준으로 체스판 만들기
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int count = count(arr, i, j);
                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }

    public static int count(char[][] arr, int x, int y){
        char startColor = arr[x][y];
        int count = 0;

        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                // 현재 위치의 색깔과 다르면 칠하기
                if(arr[i][j] != startColor){
                    count++;
                }

                // 다음칸의 색깔로 변경
                startColor = startColor == 'B' ? 'W' : 'B';
            }
            // 행이 바뀌면 시작 색깔도 변경
            startColor = startColor == 'B' ? 'W' : 'B';
        }

        // 첫 번째 칸을 기준으로 칠하는 경우와 칠하지 않는 경우 중 더 작은 값
        return Math.min(count, 64 - count);
    }

}
