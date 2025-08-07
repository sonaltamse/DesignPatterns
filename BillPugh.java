package DesignPatterns;

class Analytics {
    private Analytics() {
    }

    private static class Holder {
        private static final Analytics INSTANCE = new Analytics();
    }

    public static Analytics getInstance() {
        return Holder.INSTANCE;
    }
}

public class BillPugh {
    public static void main(String[] args) {
        Analytics analytics = Analytics.getInstance();
        System.out.println("Analytics instance created: " + analytics);
        // Additional operations can be performed using the analytics instance
        Analytics anotherAnalytics = Analytics.getInstance();
        System.out.println("Another reference to Analytics instance: " + anotherAnalytics);
        System.out.println("Are both references the same? " + (analytics == anotherAnalytics));
    }
}
