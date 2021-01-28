package class_and_method.Array;

import java.util.Scanner;

public class ArrayDemo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生人数：");
        int num = input.nextInt();

        int score[] = new int[num];
        System.out.println("输入" + num + "个成绩：");
        for (int i = 0; i < score.length; i++)
        {
            score[i] = input.nextInt();
        }

        int maxScore = 0;
        for (int i = 0; i <score.length; i++)
        {
            if (score[i] > maxScore){
                maxScore = score[i];
            }
        }

        char level;
        for (int i = 0; i < score.length; i++)
        {
            if (maxScore - score[i] <= 10)
            {
                level = 'A';
            }
            else if (maxScore - score[i] <= 20)
            {
                level = 'B';
            }
            else if (maxScore - score[i] <= 30)
            {
                level = 'C';
            }
            else
            {
                level = 'D';
            }
            System.out.println("student " + i + " score is " + score[i] + ", grade is " + level);
        }

    }

}
