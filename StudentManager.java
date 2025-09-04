import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String FILE_NAME = "students.txt";

    // Read all students from file
    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Student s = Student.fromString(line);
                if (s != null) students.add(s);
            }
        } catch (IOException e) {
            // Ignore if file not found (first run)
        }
        return students;
    }

    // Save all students to file
    public void saveStudents(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Add student
    public void addStudent(Student student) {
        List<Student> students = loadStudents();
        for (Student s : students) {
            if (s.getRoll().equals(student.getRoll())) {
                System.out.println("❌ Roll number already exists.");
                return;
            }
        }
        students.add(student);
        saveStudents(students);
        System.out.println("✅ Student added successfully.");
    }

    // View students
    public void viewStudents() {
        List<Student> students = loadStudents();
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println("Roll: " + s.getRoll() + " | Name: " + s.getName() + " | Grade: " + s.getGrade());
        }
        System.out.println("-----------------------\n");
    }

    // Search student
    public void searchStudent(String roll) {
        List<Student> students = loadStudents();
        for (Student s : students) {
            if (s.getRoll().equals(roll)) {
                System.out.println("✅ Found: Roll=" + s.getRoll() + ", Name=" + s.getName() + ", Grade=" + s.getGrade());
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    // Update student
    public void updateStudent(String roll, String newName, String newGrade) {
        List<Student> students = loadStudents();
        for (Student s : students) {
            if (s.getRoll().equals(roll)) {
                if (!newName.isEmpty()) s.setName(newName);
                if (!newGrade.isEmpty()) s.setGrade(newGrade);
                saveStudents(students);
                System.out.println("✅ Student updated successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    // Delete student
    public void deleteStudent(String roll) {
        List<Student> students = loadStudents();
        boolean removed = students.removeIf(s -> s.getRoll().equals(roll));
        if (removed) {
            saveStudents(students);
            System.out.println("✅ Student deleted successfully.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }
}
