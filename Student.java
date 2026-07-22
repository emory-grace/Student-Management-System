public class Student {
    private String name;
    private int grade;
    private char letterGrade;
    private boolean isGraduate; // default false

    // default constructor
    public Student() {
        name = "";
        grade = 0;
        isGraduate = false;
        setLetterGrade();
    }

    // constructor with 1 parameter
    public Student(String name) {
        this.name = name;
        grade = 0;
        isGraduate = false;
        setLetterGrade();
    }

    // constructor with 2 parameters
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        isGraduate = false;
        setLetterGrade();
    }

    // constructor with 3 parameters
    public Student(String name, int grade, boolean isGraduate) {
        this.name = name;
        this.grade = grade;
        this.isGraduate = isGraduate;
        setLetterGrade();
    }

    // getters
    public String getName() { return name; }
    public int getGrade() { return grade; }
    public char getLetterGrade() { return letterGrade; }
    public boolean getIsGraduate() { return isGraduate; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setGrade(int grade) {
        this.grade = grade;
        setLetterGrade();
    }
    public void setIsGraduate(boolean isGraduate) { this.isGraduate = isGraduate; }

    // sets the letter grade based on numeric grade
    private void setLetterGrade() {
        if (grade >= 90) letterGrade = 'A';
        else if (grade >= 80) letterGrade = 'B';
        else if (grade >= 70) letterGrade = 'C';
        else if (grade >= 60) letterGrade = 'D';
        else letterGrade = 'F';
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Grade: " + grade +
               ", Letter Grade: " + letterGrade +
               ", Graduate: " + isGraduate;
    }
}
