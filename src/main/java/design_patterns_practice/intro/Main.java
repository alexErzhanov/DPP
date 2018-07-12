package design_patterns_practice.intro;

public class Main {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyReactive());
        modelDuck.performFly();
    }
}
