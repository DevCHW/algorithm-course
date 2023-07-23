import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Person[] people = new Person[N];
        for (int i=0; i<N; i++){
            int weight = sc.nextInt();
            int height = sc.nextInt();
            people[i] = new Person(weight, height);
        }

        solution(people);

        for(int i=0; i<N; i++){
            System.out.print(people[i].rank + " ");
        }

    }

    public static void solution(Person[] people){

        for(int i=0; i<people.length; i++){
            for (int j=0; j<people.length; j++){
                if(i==j) continue; // 같은 사람이면 비교하지 않고 다음 반복으로 넘어감
                if(people[i].weight < people[j].weight && people[i].height < people[j].height){
                    // j번째 사람이 덩치가 더 크면 i번째 사람의 등수가 1 밀림
                    people[i].rank ++;
                }
            }
        }
    }


    static class Person{
        int weight;
        int height;
        int rank;

        Person(int weight, int height){
            this.weight = weight;
            this.height = height;
            this.rank = 1; // 초기 등수는 1
        }

    }

}
