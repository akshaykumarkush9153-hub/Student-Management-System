class Student {
    int id;
    String name;
    String email;
    String mobile;
    String course;

    // ✅ Getter methods (IMPORTANT for EmailService)
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getCourse() {
        return course;
    }

    // Existing method (unchanged)
    void showStudent() {
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Email  : " + email);
        System.out.println("Mobile : " + mobile);
        System.out.println("Course : " + course);
    }
}
