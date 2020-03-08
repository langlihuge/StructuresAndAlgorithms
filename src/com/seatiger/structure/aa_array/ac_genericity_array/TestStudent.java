package com.seatiger.structure.aa_array.ac_genericity_array;

public class TestStudent {

    private String name;
    private int score;

    public TestStudent(String studentName, int studentScore){
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<TestStudent> arr = new Array<>();
        arr.addLast(new TestStudent("Alice", 100));
        arr.addLast(new TestStudent("Bob", 66));
        arr.addLast(new TestStudent("Charlie", 88));
        System.out.println(arr);
    }
}
