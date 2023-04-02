// Home.java

import java.util.Scanner;

// BasicHome.java
class BasicHome extends Home {
    public BasicHome() {
        // No additional cost for a basic home.
        System.out.println(" The basic home with some standard facilities are ready.");
                System.out.println(" You need to pay $" +
                        this.getPrice() + " for this.");
    }
    @Override
    public double getPrice() {
        return basePrice;
    }
}

// AdvancedHome.java
class AdvancedHome extends Home {
    public AdvancedHome() {
        additionalCost = 25000;
        System.out.println(" It becomes an advanced home with more facilities.");
                System.out.println(" You need to pay $" +
                        this.getPrice() + " for this.");
    }
    @Override
    public double getPrice() {
        return basePrice + additionalCost;
    }
}
// Luxury.java
abstract class Luxury extends Home {
    protected Home home;
    public double luxuryCost;
    public Luxury(Home home) {
        this.home = home;
    }
    @Override
    public double getPrice() {
        return home.getPrice();
    }
}
// PlayGround.java
class PlayGround extends Luxury {
    public PlayGround(Home home) {
        super(home);
        this.luxuryCost = 20000;
        System.out.println(" For a playground, you pay an extra $" + this.luxuryCost);
    }
    @Override
    public double getPrice() {
        return home.getPrice() + luxuryCost;
    }
}
// SwimmingPool.java
class SwimmingPool extends Luxury {
    public SwimmingPool(Home home) {
        super(home);
        this.luxuryCost = 55000;
        System.out.println(" For a swimming pool, you pay an extra $" + this.luxuryCost);
    }
    @Override
    public double getPrice() {
        return home.getPrice() + luxuryCost;
    }
}
// Client.java
class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println( "Scenario-1: Making a basic home with standard facilities." +
                            "\nScenario-2: Making a basic home. Then adding a playground."+
                            "\nScenario-3: Making a basic home. Then adding two playgrounds one-by-one."+
                            "\nScenario-4: Making a basic home. Then adding one additional playground and swimming pool."+
                            "\nScenario-5: Adding a swimming pool and then a playground to a basic home."+
                            "\nScenario-6: Making an advanced home now."+
                            "\nScenario-7: Making an advanced home. Then adding one additional playground to it."+
                            "\nScenario-8: Making an advanced home. Then adding one additional playground and one swimming pool to it.");


        System.out.print("Choose number of scenario (1-8): ");
        int r = 0;
        try {
            var t = sc.nextLine();
            r = Integer.valueOf(t);
        }
        catch (ClassCastException ce){
            ce.getMessage();
        }
        catch (NullPointerException npe){
            npe.getMessage();
        }

        switch(r){
            case(1):
                System.out.println("Scenario-1: Making a basic home with standard facilities.");
                Home home = new BasicHome();
                System.out.println("Total cost: $" + home.getPrice());
                break;
            case(2):
                System.out.println("\nScenario-2: Making a basic home. Then adding a playground.");
                home = new BasicHome();
                home = new PlayGround(home);
                System.out.println("Total cost: $" + home.getPrice());
                break;
            case(3):
                System.out.println("\nScenario-3: Making a basic home. Then adding two playgrounds one-by-one.");
                home = new BasicHome();
                home = new PlayGround(home);
                home = new PlayGround(home);
                System.out.println("Total cost: $" +
                        home.getPrice());
                break;
            case(4):
                System.out.println("\nScenario-4: Making a basic home. Then adding one additional playground and swimming pool.");
                home = new BasicHome();
                home = new PlayGround(home);
                home = new SwimmingPool(home);
                System.out.println("Total cost: $" +
                        home.getPrice());
                break;
            case(5):
                System.out.println("\nScenario-5: Adding a swimming pool and then a playground to a basic home.");
                home = new BasicHome();
                home = new SwimmingPool(home);
                home = new PlayGround(home);
                System.out.println("Total cost: $" + home.getPrice());
                break;
            case(6):
                System.out.println("\nScenario-6: Making an advanced home now.");
                home = new AdvancedHome();
                System.out.println("Total cost: $" + home.getPrice());
                break;
            case(7):
                System.out.println("\nScenario-7: Making an advanced home. Then adding one additional playground to it.");
                home = new AdvancedHome();
                home = new PlayGround(home);
                System.out.println("Total cost: $" +
                        home.getPrice());
                break;
            case(8):
                System.out.println("\nScenario-8: Making an advanced home. Then adding one additional playground and one swimming pool to it.");
                home = new AdvancedHome();
                home = new PlayGround(home);
                home = new SwimmingPool(home);
                System.out.println("Total cost: $" +
                        home.getPrice());
                break;
            default:
                System.out.println("I don't know this scenario");

        }


    }
}
