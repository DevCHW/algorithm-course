import java.util.*;

public class Main {
    static int t;
    static int n;
    static int m;
    static int k;
    static int dx[] = {-1,1,0,0}; //방향 좌표
    static int dy[] = {0,0,1,-1};
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();


        while(t > 0){
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            arr = new int[n][m];

            for(int i=0; i<k; i++ ){
                int a = sc.nextInt(); //가로
                int b = sc.nextInt(); //세로
                arr[b][a] =1;
            }
            sb.append(solution()+"\n");
            t--;
        }
        System.out.print(sb);

    }

    private static int solution(){
        visited = new boolean[n][m];
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && !visited[i][j]){ //배추가 있는 땅이고 방문한적이 없을 경우
                    answer++;
                    bfs(i,j);
                }
            }
        }
        return answer;
    }

    private static void bfs(int i, int j){
        queue.add(new Node(i,j)); //시작점 큐에 넣기

        while(!queue.isEmpty()){
            Node node = queue.poll(); //익은 토마토 꺼내기

            for(int k=0; k<4; k++){
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                //상,하,좌,우 탐색
                if(nx < 0 || nx >=n || ny <0 || ny >= m) continue; //배열 범위를 벗어나면 그만두기
                if(arr[nx][ny] == 1 && !visited[nx][ny]) { //배추가 있고 방문한 적이 없다면
                    arr[nx][ny] = 0; //다시 방문 하지않게 0으로 바꾸기(visited 쓰면 안해도되긴 한다)
                    queue.add(new Node(nx, ny)); //큐에 넣기
                    visited[nx][ny] = true; //방문 처리, 섬의개수와마찬가지로 방문처리를 해주어야 하나의 섬으로 인식하고 다시 방문하지 않는다
                }
            }
        }
    }
}
