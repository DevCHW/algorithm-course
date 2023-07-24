import java.util.*;

public class Main {
    static int w;
    static int h;
    static int dx[] = {-1,1,0,0,-1,-1,1,1}; //방향 좌표
    static int dy[] = {0,0,-1,1,-1,1,-1,1};
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
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

        while(true){
            w = sc.nextInt();
            h = sc.nextInt();

            arr = new int[h][w];

            if(w == 0 && h ==0){
                break;
            }

            for(int i =0; i<h; i++){
                for(int j=0; j<w; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            solution();

        }

        System.out.print(sb);

    }

    private static void solution(){
        int answer=0;
        visited = new boolean[h][w];

        //지도 탐색
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(arr[i][j] == 1 && !visited[i][j]){ // 위치가 섬이고 방문 하지 않았을 경우
                    answer++; // 1이 섬이기때문에 count 올려주고
                    bfs(i,j); // 그 근처에 연결된 섬이있는지 다찾아보기
                }
            }
        }
        sb.append(answer+"\n");
    }

    private static void bfs(int i, int j){
        Queue<Node> queue= new LinkedList<>();

        queue.add(new Node(i,j)); //처음 섬을 큐에 담기
        visited[i][j] = true; // 처음 방문한 섬 방문처리

        while(!queue.isEmpty()){
            Node node = queue.poll(); //섬 꺼내기
            for(int k=0; k<8; k++){ // 주어진 섬에서 상,하,좌,우,대각선으로 탐색
                int nX = node.x + dx[k]; //사방팔방 탐색위해 방향벡터 더해주기
                int nY = node.y + dy[k];

                if(nX < 0 || nX >= h || nY < 0 || nY >= w) continue; //배열의 범위를 벗어나면 그만두기
                if(arr[nX][nY] ==1 && !visited[nX][nY]){ // 탐색중인 곳이 섬이고 방문한 적이 없다면
                    visited[nX][nY] = true; //방문처리(여기서 방문처리 해주어야 하나의 섬으로 인식)
                    queue.add(new Node(nX,nY)); //queue에 넣기
                }
            }
        }


    }
}
