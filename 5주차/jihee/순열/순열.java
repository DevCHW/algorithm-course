import java.util.*;
public class Main {
    private static String str;
    private static int n;
    private static boolean[] visited;
    private static char[] arr;
    private static char[] answer;
    private static int count;
    private static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            str = sc.next();
            n = sc.nextInt();

            count = 0;

            sb = new StringBuilder();
            sb.append(str +" " + n +" = ");
            solution(sb);
            sb.append("\n");
            System.out.print(sb);
        }
    }

    private static void solution(StringBuilder sb){
        int m = str.length();
//        System.out.println("m : " + m);
        visited = new boolean[m];

        arr = new char[m];
        for(int i=0; i<m; i++){
            arr[i] = str.charAt(i);
        }
        answer = new char[m];
        dfs(0,m,sb);

        if(count < n){
            sb.append("No permutation");
        }
    }

    private static void dfs(int depth, int m, StringBuilder sb){
        if(depth == m) { //depth가 만들어야 할 자리수와 같다면
            count++; //조합 하나완성 할 때마다 count
//           System.out.print("count : " + count);
            if(count == n){ // 목표번째(n) 조합일 경우
                for(int i=0; i<m; i++){
//                  System.out.println("이건 : " +n);
                    sb.append(answer[i]);
                }
            }
        }
        else{
            for(int i=0; i<m; i++){
                if(visited[i]) continue;
                visited[i] = true; //방문처리
                answer[depth] = arr[i]; //정답 = 주어진 배열에서 하나씩 조합
//                System.out.println("answer :" + answer[depth]);
//                System.out.println("depth : " +depth);
                dfs(depth+1, m, sb);
                visited[i] = false; //재귀에서 나오면 visited 원상복구
            }
        }
    }
}
