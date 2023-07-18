import java.util.*;
public class Main {
    private static int node;
    private static int line;
    private static int startNode;
    private static int[][] arr;
    private static StringBuilder dfsSb;
    private static boolean[] visitedDfs;
    private static boolean[] visitedBfs;
    private static StringBuilder bfsSb;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        node = sc.nextInt(); //노드 개수
        line = sc.nextInt(); //간선 개수
        startNode = sc.nextInt(); // 시작 노드

        arr = new int[node+1][node+1]; //배열 생성 index 0은 사용하지 않기 때문에 +1
        // 노드와 간선 연결정보 입력하기(간선의 개수만큼)
        for(int i=1; i<=line; i++){
            //입력 정보 받기
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();

            //노드끼리 연결 정보 넣어주기(1은 연결 되었다는 것)
            arr[vertex1][vertex2] = 1;
            arr[vertex2][vertex1] = 1; // 양방향으로 정보 넣어 주기

        }

        solution();
        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    private static void solution(){

        dfsSb = new StringBuilder();

        visitedDfs = new boolean[node+1]; // index 0은 사용안함

        visitedDfs[startNode] = true; //시작노드 방문기록
        dfsSb.append(startNode).append(" "); // print용

        dfs(startNode);
        bfs();
    }

    private static void dfs(int vertex){
        for(int i=1; i<=node; i++){
            if(arr[vertex][i] == 1) //입력 vertex와 i가 연결된 상태인지 확인
                if(!visitedDfs[i]){ //연결되었다면 방문 기록있는 지 확인
                    visitedDfs[i] = true; //방문한적 없다면 방뭉 기록
                    dfsSb.append(i).append(" ");
                    dfs(i); //재귀 시작 관련 노드과 연결된노드부터 또 탐색시작(깊게)
                }
        }
    }

    private static void bfs(){

        Queue<Integer> queue = new LinkedList<>();

        visitedBfs = new boolean[node+1];
        bfsSb = new StringBuilder();

        visitedBfs[startNode] = true; //시작 노드 방문기록
        queue.add(startNode); //시작노드 큐에 넣기
        bfsSb.append(startNode).append(" "); //프린트용

        while(!queue.isEmpty()){ //큐가 빌때 까지 반복
            int currentNode = queue.poll();

            for(int i=1; i<=node; i++){
                if(arr[currentNode][i] == 1) { //현재노드가 i번 노드랑 연결되어 있는지 체크
                    if(!visitedBfs[i]) { //i노드 방문기록 확인
                        queue.add(i); // 큐에 i노드 넣어주기
                        visitedBfs[i] = true; // 방문 처리, 실제 방문하고 해주어도 된다
                        bfsSb.append(i).append(" "); //print용
                        // dfs와 다르게 재귀함수가없어 일단 현재 노드와 연결된 노드는 모두 큐에 넣어진다(넓게 탐색)
                    }
                }
            }
        }
    }
}


