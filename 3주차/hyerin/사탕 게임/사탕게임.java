package baekjoon.three;
import java.util.*;

public class 사탕게임_3085 {
    static int max = 1;
    static int N;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];

        for(int i=0; i<N; i++){
            String tmp = sc.next();
            for(int j=0; j<N; j++){
                arr[i][j] = tmp.charAt(j);
            }
        }
        
        // 현재 연속된 사탕의 개수 확인하기
        for(int i=0; i<N; i++){
            max = Math.max(max, chkRow(i)); // 행 체크
            max = Math.max(max, chkCol(i)); // 열 체크
        }

        // 행/열을 바꾸어 연속된 사탕 개수 갱신하기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j+1 < N){ // 열 범위가 벗어나지 않을 때
                    change(i, j, i, j+1); // 사탕 위치 바꾸기 (행)
                    max = Math.max(max, chkRow(i));
                    max = Math.max(max, chkCol(j));
                    max = Math.max(max, chkCol(j+1));
                    change(i, j, i, j+1); // 원래대로 되돌아오기
                }
                if(i+1 < N){ // 행 범위가 벗어나지 않을 때
                    change(i, j, i+1, j);
                    max = Math.max(max, chkRow(i)); // 사탕위치 바꾸기 (열)
                    max = Math.max(max, chkRow(i+1));
                    max = Math.max(max, chkCol(j));
                    change(i, j, i+1, j); // 되돌리기
                }
            }
        }

        System.out.println(max);

    }

    // 값 바꾸기
    public static void change(int x1, int y1, int x2, int y2){
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }


    public static int chkRow(int x){
        int tmp = 1; 
        int res = 1;
        char ch = arr[x][0]; 
        for(int i=1; i<N; i++){
            if(arr[x][i] != ch){
                ch = arr[x][i];
                res = Math.max(res, tmp);
                tmp = 1;
            } else {
                tmp ++;
            }
        }
        return Math.max(res, tmp);
    }

    public static int chkCol(int y){
        int tmp = 1;
        int res = 1;
        char ch = arr[0][y];
        for(int i=1; i<N; i++){
            if(arr[i][y] != ch){
                ch = arr[i][y];
                res = Math.max(res, tmp);
                tmp = 1;
            } else {
                tmp ++;
            }
        }
        return Math.max(res, tmp);
    }

}
