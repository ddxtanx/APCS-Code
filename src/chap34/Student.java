package chap34;

import java.util.ArrayList;
import java.util.Collections;

public class Student {

    private String name;
    private ArrayList<Integer> quizScores = new ArrayList<Integer>();

    public Student(String n){
        name =  n;
    }

    public Student(int quizScore) {
        quizScores.add(quizScore);
        name = "No Name";
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public void addQuiz(int quizScore){
        quizScores.add(quizScore);
    }

    public ArrayList<Integer> getQuizScores(){
        return quizScores;
    }
    public int getTotalScore(){
        int sum = 0;
        for(int score: quizScores){
            sum += score;
        }
        return sum;
    }

    public double getAverageScore(){
        double sum = (double)getTotalScore();
        return sum/quizScores.size();
    }

    public double droppedAverage(){
        Collections.sort(quizScores);
        ArrayList<Integer> quizCopy = (ArrayList<Integer>)quizScores.clone();
        quizCopy.remove(0);
        double sum = 0;
        for(int score: quizCopy){
            sum += score;
        }
        return sum/quizCopy.size();
    }
}
