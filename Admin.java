class Admin {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin@123456789";

    static boolean login(String user, String pass) {
        return USERNAME.equals(user) && PASSWORD.equals(pass);
    }
}
