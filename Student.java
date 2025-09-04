public class Student {
    private String roll;
    private String name;
    private String grade;

    public Student(String roll, String name, String grade) {
        this.roll = roll;
        this.name = name;
        this.grade = grade;
    }

    public String getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + grade;
    }

    // Parse student from line in file
    public static Student fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Student(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}
