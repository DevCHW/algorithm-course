import java.util.*;
public class Main {
    private static int n;
    private static boolean[] visited;
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        dfs(0);
        System.out.print(count);
    }

    private static void dfs(int depth) {
        if(depth == n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){
                arr[depth] = i; //배열의 인덱스가 행, 값이 열이 된다.(퀸의 위치) , arr[0]=1 이면 0행 1열에 퀸이 위치 (즉 i가 열의 값이 된다)
                if(visited(depth)){ // 퀸이 방문할 수 있는지
                    dfs(depth+1); // 가능하다면 다음행으로 이동(depth가 행)
                }
        }
    }

    private static boolean visited(int col){

        for(int i=0; i<col; i++){
            if(arr[i]== arr[col]){ // 열에 일치하는게 있는지 판별
                return false; // col이 0이면 실행X, col이 1이면 arr[0] == arr[0] false;
            }
            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])){ //두 위치의 열의 차이와 행의 차이의 절대값이 같으면 대각선에 놓인 경우다
                return false; //depth가 0일때(col이 0일때)는 false
            }
        }

        return true;
    }
}
