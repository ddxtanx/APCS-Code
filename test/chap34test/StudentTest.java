package chap34test;

import chap34.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void getName() {
        Student stu = new Student("Gerome");
        assertEquals(stu.getName(), "Gerome");
        Student stu2 = new Student(123);
        assertEquals(stu2.getName(), "No Name");
    }

    @Test
    void setName() {
        Student stu = new Student("Alpha");
        assertEquals(stu.getName(), "Alpha");
        stu.setName("Beta");
        assertEquals(stu.getName(), "Beta");
    }

    @Test
    void addQuiz() {
        Student stu = new Student("Aemon");
        ArrayList<Integer> scores = new ArrayList<Integer>();
        stu.addQuiz(50);
        scores.add(50);
        assertEquals(stu.getQuizScores(), scores);
    }

    @Test
    void getTotalScore() {
        Student stu = new Student("a");
        assertEquals(stu.getTotalScore(), 0);
        stu.addQuiz(50);
        assertEquals(stu.getTotalScore(), 50);
        stu.addQuiz(60);
        assertEquals(stu.getTotalScore(), 110);
    }

    @Test
    void getAverageScore() {
        Student stu = new Student("a");
        stu.addQuiz(50);
        assertEquals(stu.getAverageScore(), 50);
        stu.addQuiz(50);
        assertEquals(stu.getAverageScore(), 50);
        stu.addQuiz(60);
        assertEquals(stu.getAverageScore(), (160.0/3));
    }

    @Test
    void droppedAverage() {
        Student stu = new Student("a");
        stu.addQuiz(1);
        stu.addQuiz(50);
        stu.addQuiz(50);
        assertEquals(stu.droppedAverage(), 50);
    }

    void testCustomStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the student's name?");
        String name = scan.nextLine();
        System.out.println("How many scores are you adding?");
        int num = scan.nextInt();
        Student stu = new Student(name);
        for(int x = 0; x<num; x++){
            System.out.println("What is score #"+(x+1)+"?");
            stu.addQuiz(scan.nextInt());
        }
    }
}