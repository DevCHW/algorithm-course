import java.util.*;
public class Main {
    static char[][] arr;
    static int n;
    static int count;
    static int max =1;
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new char[n][n];

        for(int i=0; i<n; i++){
            String a = sc.next();
            for(int j=0; j<n; j++){
                arr[i][j] = a.charAt(j);
            }
        }

        System.out.println(solution());
    }

    public static int solution(){
        //행 탐색 오른쪽 사탕과 바꿀 경우
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                swap(i,j,i,j+1); //행바꾸기 예시[1][1] [1][2] 바꾸기
                searchRow();//행 탐색
                searchCol();//열 탐색
                swap(i,j+1,i,j); //행 원상복구 예시[1][2] [1][1] 바꾸기
            }
        }

        //열 탐색 아래쪽 사탕과 바꿀 경우
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                swap(i,j,i+1,j); //열 바꾸기 예시 [1][1] [2][1] 바꾸기
                searchRow(); //행 탐색
                searchCol(); //열 탐색
                swap(i+1,j,i,j); //열 원상복구 예시[2][1] [1][1] 바꾸기
            }
        }
        return max;
    }

    //열,행 바꾸기
    public static void swap(int x1, int y1, int x2, int y2){
          char temp = arr[x1][y1];
          arr[x1][y1] = arr[x2][y2];
          arr[x2][y2] = temp;
    }

    //행 탐색
    public static void searchRow(){
        for(int i =0; i<n; i++){
            count =1; //시작하면 1개는 먹고 시작

            for(int j=0; j<n-1; j++){
                if(arr[i][j] == arr[i][j+1]){ //바로 옆 사탕과 같으면 먹을 수 있기때문에
                    count++; //count 더해주기
                    max = Math.max(max,count); //같지않을 경우 count 1로 초기화 되기때문에 max 기록해놓기
                }
                else{
                    count = 1; // 먹을 수 있는 사탕 초기화
                }
            }
        }
    }

    //열 탐색
    public static void searchCol(){
        for(int i=0; i<n; i++){
            count=1;

            for(int j=0; j<n-1; j++){
                if(arr[j][i] == arr[j+1][i]){ //바로 아래쪽 사탕과 같으면 먹을 수 있는 경우
                    count++;
                    max = Math.max(max,count);
                }
                else{
                    count = 1;
                }
            }
        }
    }


}
