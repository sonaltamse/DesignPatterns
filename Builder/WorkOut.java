package DesignPatterns.Builder;

class Gym {
    private final String threadMill, cyclingBike;

    private String yogaClass, weightTraining;
    private boolean hasPersonalTrainer, hasNutritionist, hasDietPlan;

    Gym(GymBuilder builder) {
        this.threadMill = builder.threadMill;
        this.cyclingBike = builder.cyclingBike;
        this.yogaClass = builder.yogaClass;
        this.weightTraining = builder.weightTraining;
        this.hasPersonalTrainer = builder.hasPersonalTrainer;
        this.hasNutritionist = builder.hasNutritionist;
        this.hasDietPlan = builder.hasDietPlan;
    }

    static class GymBuilder {
        private String threadMill, cyclingBike;
        private String yogaClass, weightTraining;
        private boolean hasPersonalTrainer, hasNutritionist, hasDietPlan;

        public GymBuilder setThreadMill(String threadMill) {
            this.threadMill = threadMill;
            return this;
        }

        public GymBuilder setCyclingBike(String cyclingBike) {
            this.cyclingBike = cyclingBike;
            return this;
        }

        public GymBuilder setYogaClass(String yogaClass) {
            this.yogaClass = yogaClass;
            return this;
        }

        public GymBuilder setWeightTraining(String weightTraining) {
            this.weightTraining = weightTraining;
            return this;
        }

        public GymBuilder setPersonalTrainer(boolean hasPersonalTrainer) {
            this.hasPersonalTrainer = hasPersonalTrainer;
            return this;
        }

        public GymBuilder setNutritionist(boolean hasNutritionist) {
            this.hasNutritionist = hasNutritionist;
            return this;
        }

        public GymBuilder setDietPlan(boolean hasDietPlan) {
            this.hasDietPlan = hasDietPlan;
            return this;
        }

        public Gym build() {
            return new Gym(this);
        }
    }

    @Override
    public String toString() {
        return "Gym{" +
                "threadMill='" + threadMill + '\'' +
                ", cyclingBike='" + cyclingBike + '\'' +
                ", yogaClass='" + yogaClass + '\'' +
                ", weightTraining='" + weightTraining + '\'' +
                ", hasPersonalTrainer=" + hasPersonalTrainer +
                ", hasNutritionist=" + hasNutritionist +
                ", hasDietPlan=" + hasDietPlan +
                '}';
    }
}

public class WorkOut {
    public static void main(String[] args) {
        Gym gymFirstMonth = new Gym.GymBuilder()
                .setThreadMill("NordicTrack")
                .setCyclingBike("Peloton")
                .setYogaClass("Hatha Yoga")
                .setWeightTraining("Bodybuilding")
                .setPersonalTrainer(true)
                .setNutritionist(true)
                .setDietPlan(true)
                .build();

        System.out.println(gymFirstMonth);

        Gym gymSecondMonth = new Gym.GymBuilder()
                .setThreadMill("LifeFitness")
                .setCyclingBike("Schwinn")
                .setYogaClass("Vinyasa Yoga")
                .setWeightTraining("Powerlifting")
                .setPersonalTrainer(false)
                .setNutritionist(true)
                .setDietPlan(false)
                .build();

        System.out.println(gymSecondMonth);
    }
}
