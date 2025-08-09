package DesignPatterns.Builder;

import java.util.List;

class BurgerMeal {
    private final String burgerType, patty;

    // optional
    private String drink, side;
    private List<String> toppings;
    private boolean isSpicy, hasCheese;

    public BurgerMeal(BurgerBuilder builder) {
        this.burgerType = builder.burgerType;
        this.patty = builder.patty;
        this.drink = builder.drink;
        this.side = builder.side;
        this.toppings = builder.toppings;
        this.isSpicy = builder.isSpicy;
        this.hasCheese = builder.hasCheese;
    }

    static class BurgerBuilder {
        private final String burgerType, patty;
        private String drink, side;
        private List<String> toppings;
        private boolean isSpicy, hasCheese;

        public BurgerBuilder(String burgerType, String patty) {
            this.burgerType = burgerType;
            this.patty = patty;
        }

        public BurgerBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public BurgerBuilder setSide(String side) {
            this.side = side;
            return this;
        }

        public BurgerBuilder setToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerBuilder setSpicy(boolean isSpicy) {
            this.isSpicy = isSpicy;
            return this;
        }

        public BurgerBuilder setCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }

    @Override
    public String toString() {
        return "BurgerMeal{" +
                "burgerType='" + burgerType + '\'' +
                ", patty='" + patty + '\'' +
                ", drink='" + drink + '\'' +
                ", side='" + side + '\'' +
                ", toppings=" + toppings +
                ", isSpicy=" + isSpicy +
                ", hasCheese=" + hasCheese +
                '}';
    }
}

public class Food {
    public static void main(String[] args) {
        BurgerMeal mealOne = new BurgerMeal.BurgerBuilder("Cheese Burger", "chicken")
                .setDrink("Coke")
                .setSide("Fries")
                .setToppings(List.of("Lettuce", "Tomato", "Onion"))
                .setSpicy(true)
                .setCheese(true)
                .build();
        BurgerMeal mealTwo = new BurgerMeal.BurgerBuilder("Veggie Burger", "vegetable").build();
        System.out.println(mealOne + "\n" + mealTwo);
    }
}
