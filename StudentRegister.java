import java.util.ArrayList;
import java.util.Scanner;

class StudentRegister {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // ---------- ADMIN LOGIN ----------
        System.out.println("---- Admin Login ----");
        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!Admin.login(user, pass)) {
            System.out.println("Invalid Login! Access Denied.");
            return;
        }

        System.out.println("Login Successful!");

        int choice;

        // ---------- MENU ----------
        do {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ---------- REGISTER ----------
                case 1:
                    Student s = new Student();

                    System.out.print("Enter ID: ");
                    s.id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    s.name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    s.email = sc.nextLine();

                    System.out.print("Enter Mobile: ");
                    s.mobile = sc.nextLine();

                    System.out.print("Enter Course: ");
                    s.course = sc.nextLine();

                    students.add(s);
                    System.out.println("Student Registered Successfully!");

                    EmailService.sendEmail(s);
                    break;

                // ---------- VIEW ----------
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students registered yet!");
                    } else {
                        System.out.println("\n---- Student List ----");
                        for (Student st : students) {
                            st.showStudent();
                            System.out.println("------------------");
                        }
                    }
                    break;

                // ---------- SEARCH ----------
                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Student st : students) {
                        if (st.id == searchId) {
                            System.out.println("Student Found:");
                            st.showStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                // ---------- DELETE ----------
                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;

                    for (Student st : students) {
                        if (st.id == deleteId) {
                            students.remove(st);
                            System.out.println("Student Deleted Successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                // ---------- EXIT ----------
                case 5:
                    System.out.println("Thank you! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
