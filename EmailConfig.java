class EmailConfig {

    // These are PLACEHOLDERS (do NOT put real password)
    static final String FROM_EMAIL = "yourgmail@gmail.com";
    static final String SMTP_SERVER = "smtp.gmail.com";
    static final int SMTP_PORT = 587;

    static void showConfig() {
        System.out.println("Gmail SMTP Configuration Loaded");
        System.out.println("Server : " + SMTP_SERVER);
        System.out.println("Port   : " + SMTP_PORT);
    }
}
