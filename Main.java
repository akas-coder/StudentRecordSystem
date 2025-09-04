import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Record System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    manager.addStudent(new Student(roll, name, grade));
                    break;
                case "2":
                    manager.viewStudents();
                    break;
                case "3":
                    System.out.print("Enter Roll Number to search: ");
                    manager.searchStudent(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Enter Roll Number to update: ");
                    String uroll = sc.nextLine();
                    System.out.print("Enter New Name (leave blank to keep same): ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Grade (leave blank to keep same): ");
                    String ugrade = sc.nextLine();
                    manager.updateStudent(uroll, uname, ugrade);
                    break;
                case "5":
                    System.out.print("Enter Roll Number to delete: ");
                    manager.deleteStudent(sc.nextLine());
                    break;
                case "6":
                    System.out.println("👋 Exiting... Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
