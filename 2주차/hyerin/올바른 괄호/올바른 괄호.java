import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        System.out.println(solution(s));
    }

    public static boolean solution(String s) { //괄호문제
        boolean answer = true;

        char[] cArray = s.toCharArray();
        Stack charStack = new Stack<Character>();

        for(char c : cArray){
            if(c == '('){
                charStack.push(c);
            } else {
                if(!charStack.isEmpty())
                    charStack.pop();
                else
                    answer = false;
            }
        }

        if(!charStack.isEmpty())
            answer = false;

        return answer;
    }

}