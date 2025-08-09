package DesignPatterns.Prototype;

import java.util.HashMap;
import java.util.Map;

interface Email {
    Email clone();
    public void setContent(String content);
    public void send(String to);
}

class EmailServer implements Email, Cloneable {
    private String content, subject;

    public EmailServer(String content, String subject) {
        this.content = content;
        this.subject = subject;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public Email clone() {
        try {
            return (Email) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void send(String to) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + this.subject);
        System.out.println("Content: " + this.content);
    }
}

class EmailRegistry {
    private static final Map<String, Email> emailMap = new HashMap<>();

    static {
        Email welcomeEmail = new EmailServer("Welcome to our service!",
                "Welcome to Mailer Service. Share your feedback!");
        emailMap.put("WELCOME_EMAIL", welcomeEmail);
        Email featureUpdateEmail = new EmailServer("New features available!",
                "Check out the latest updates to our service!");
        emailMap.put("FEATURE_UPDATE_EMAIL", featureUpdateEmail);
    }

    public static Email getEmail(String key) {
        return emailMap.get(key).clone();
    }
}

public class EmailService {
    public static void main(String[] args) {
        EmailServer welcomeEmail = (EmailServer) EmailRegistry.getEmail("WELCOME_EMAIL");
        welcomeEmail.setContent("New content for welcome email");
        welcomeEmail.setSubject("New subject for welcome email");
        welcomeEmail.send("sam@max.com");
        EmailServer anotherWelcomeEmail = (EmailServer) EmailRegistry.getEmail("FEATURE_UPDATE_EMAIL");
        anotherWelcomeEmail.setContent("New content for feature update email");
        anotherWelcomeEmail.setSubject("New subject for feature update email");
        anotherWelcomeEmail.send("lara@ajio.com");
    }
}
