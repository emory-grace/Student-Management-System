import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;

public class StudentManager {
    private ArrayList<Student> students;
    private static final String FILE_NAME = "students.txt";

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean removeStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    // search by name (case-insensitive, partial match allowed)
    public ArrayList<Student> searchByName(String query) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    // sort by grade, highest first
    public void sortByGradeDescending() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return b.getGrade() - a.getGrade();
            }
        });
    }

    // sort alphabetically by name
    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public double classAverage() {
        if (students.isEmpty()) return 0.0;
        int total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        return (double) total / students.size();
    }

    // save all students to a text file (simple CSV-style format)
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.getName() + "," + s.getGrade() + "," + s.getIsGraduate());
            }
            System.out.println("Saved " + students.size() + " student(s) to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // load students from the text file, replacing the current list
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved file found (" + FILE_NAME + ").");
            return;
        }
        students.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                String name = parts[0];
                int grade = Integer.parseInt(parts[1]);
                boolean isGraduate = Boolean.parseBoolean(parts[2]);
                students.add(new Student(name, grade, isGraduate));
            }
            System.out.println("Loaded " + students.size() + " student(s) from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
