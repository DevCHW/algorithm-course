import java.util.*;

public class Main {
    static int n;
    static int m;
    static int dx[] = {-1,1,0,0}; //방향 좌표
    static int dy[] = {0,0,1,-1};
    static int[][] arr;
    static int[][] visited;
    static Queue<Node> queue = new LinkedList<>();
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

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for(int i=0; i<n; i++ ){
            for(int j=0; j<m; j++){
               arr[i][j] = sc.nextInt();
               if(arr[i][j] == 1){
                   queue.add(new Node(i,j)); // 익은 토마토가 어디있는지 알아야 하기 때문에 익은 토마토 큐에 넣어주기
               }
            }
        }
        System.out.print(solution());
    }

    private static int solution(){
        visited = new int[n][m];

        if(queue.size() == (n*m)) return 0; //처음부터 토마토가 다익은 상태면 바로 리턴

        bfs();

        int answer = 0;

        //탐색 마치고 토마토판에서 가장 큰 일 자 구하기
        for(int i = 0; i< n; i++){
            for(int j=0; j<m; j++){
             if(arr[i][j] == 0) { //탐색 마쳤는데 안익은 토마토가 있다면
                 return -1;
             }
             answer = Math.max(answer, visited[i][j]);
            }
        }
        return answer;
    }

    private static void bfs(){

        while(!queue.isEmpty()){
            Node node = queue.poll(); //익은 토마토 꺼내기

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                //상,하,좌,우 토마토 익히기
                if(nx < 0 || nx >=n || ny <0 || ny >= m) continue; //배열 범위를 벗어나면 그만두기
                if(arr[nx][ny] == 0 && visited[nx][ny] == 0) { //익지 않은 토마토이고 방문한 적이 없다면
                    arr[nx][ny] = 1; //토마토 익었다고 처리
                    queue.add(new Node(nx, ny)); //큐에 넣기
                    visited[nx][ny] = visited[node.x][node.y] +1; //익은 토마토 걸린 시간(이전 토마토 익는기간 +1, 미로와 같은 개념)
                }
            }
        }
    }
}
