import java.util.*;


class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, 0, target, numbers);
    
        return answer;
    }
    
    private static void dfs(int depth, int sum, int target, int[] numbers){
        if(depth == numbers.length){ //마지막 depth일 때
            if(sum == target)
                answer++;
        }
        else{
            dfs(depth+1, sum+numbers[depth], target, numbers);
            dfs(depth+1, sum-numbers[depth], target, numbers);
            
        }
    }
}