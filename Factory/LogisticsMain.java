package DesignPatterns.Factory;

interface Logistics {
    void send();
}

class RoadLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road.");
    }
}

class SeaLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by sea.");
    }
}

class AirLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air.");
    }
}

class LogisticsFactory {
    public static Logistics getLogistics(String mode) {
        if (mode == "road") {
            return new RoadLogistics();
        }
        if (mode == "sea") {
            return new SeaLogistics();
        }
        if (mode == "air") {
            return new AirLogistics();
        }
        throw new IllegalArgumentException("Unknown logistics mode: " + mode);
    }
}

class LogisticsService {
    public void sendPackage(String mode) {
        Logistics log = LogisticsFactory.getLogistics(mode);
        log.send();
    }
}

public class LogisticsMain {

    public static void main(String[] args) {
        LogisticsService service = new LogisticsService();
        service.sendPackage("road");
        service.sendPackage("sea");
        service.sendPackage("air");
    }
}