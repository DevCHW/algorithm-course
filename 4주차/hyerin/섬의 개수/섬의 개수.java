import java.util.*;

public class 섬의개수_4963 {

    static int w; // 지도 너비
    static int h; // 지도 높이
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    arr[i][j] = sc.nextInt();
                }

            }
            System.out.println(solution());
        }

    }

    public static int solution(){
        int count = 0; // 섬의 개수
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j] == 1 ){
                    count++;
                    DFS(i, j);
                }

            }
        }
        return count;
    }


    public static void DFS(int x, int y){
        if(x < 0 || y < 0 || x >= h || y >= w || arr[x][y] != 1){
            return;
        }

        arr[x][y] = 0; // 방문처리

        // 상하좌우 탐색
        DFS(x + 1, y);
        DFS(x - 1, y);
        DFS(x, y + 1);
        DFS(x, y - 1);

        // 대각선 탐색
        DFS(x + 1, y + 1);
        DFS(x - 1, y + 1);
        DFS(x + 1, y - 1);
        DFS(x - 1, y - 1);

    }


}
