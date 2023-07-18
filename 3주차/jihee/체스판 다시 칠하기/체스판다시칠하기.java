import java.util.*;
public class Main {
    static boolean[][] whiteBoard;
    static boolean[][] blackBoard;
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        whiteBoard = new boolean[n][m];
        blackBoard = new boolean[n][m];

        boolean[][] arr = new boolean[n][m];
        for(int i=0; i<n; i++){
            String a = sc.next();
            for(int j=0; j<m; j++){
                if(a.charAt(j) == 'W'){
                    arr[i][j] = true;
                }
                else{
                    arr[i][j] = false;
                }
            }
        }

        System.out.print(solution(n,m,arr));

    }

    public static int solution(int n, int m, boolean [][] arr){
        //체스판 만들기
        makeBoard();
        int count=64; //체스판 모두 칠할 경우(최악의 경우의 수)
        //체스판 다시 칠할 경우의 수 구하기
        for(int i =0; i<=n-8; i++ ){
            for(int j=0; j<=m-8; j++){
                //다시 칠할 경우의 수 안에서 체스판 다시 칠해보기
                count = Math.min(searchBoard(i,j,arr),count); //마지막 count가 리턴되기때문에 기록해놓고 작은거로 return
            }
        }

        return count;
    }

    public static void makeBoard(){
        //whiteBoard,blackBoard 만들기
        boolean white = true;
        for( int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                whiteBoard[i][j] = white; //첫번째 w로시작
                white = !white; // 한줄에서는 WBWBWBWBWB
            }
            white = !white;//그다음줄은 B부터 시작
        }

        //blackBoard 만들기
        boolean black = false;
        for( int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                blackBoard[i][j] = black; //첫번째 w로시작
                black = !black; // 한줄에서는 WBWBWBWBWB
            }
            black = !black;//그다음줄은 B부터 시작
        }
    }

    //체스판 탐색(다시 칠하기)
    public static int searchBoard(int x, int y, boolean arr[][] ) {
        int whiteBoardCount =0;
        int blackBoardCount = 0;

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                //만들어둔 체스판과 입력받은 체스판 비교하기(흰색,검정 두가지 버전모두)
                if(whiteBoard[i][j] != arr[x+i][y+j]){ //만들어둔 체스판과 경우의수 안에서 입력받은 체스판 비교
                    whiteBoardCount++;
                }
                if(blackBoard[i][j] != arr[x+i][y+j]){
                    blackBoardCount++;
                }
            }
        }
        return Math.min(whiteBoardCount, blackBoardCount);
    }

}
