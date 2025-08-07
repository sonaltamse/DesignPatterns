package DesignPatterns;

class Analytics {
    private volatile static Analytics instance;

    private Analytics() {
    }

    public static Analytics getInstance() {
        if (instance == null) {
            synchronized (Analytics.class) {
                if (instance == null) {
                    instance = new Analytics();
                }
            }
        }
        return instance;
    }
}

public class DoubleCheck {
    public static void main(String[] args) {
        Analytics analytics = Analytics.getInstance();
        System.out.println("Analytics instance created: " + analytics);
        // Additional operations can be performed using the analytics instance
        Analytics anotherAnalytics = Analytics.getInstance();
        System.out.println("Another reference to Analytics instance: " + anotherAnalytics);
        System.out.println("Are both references the same? " + (analytics == anotherAnalytics));
    }
}
