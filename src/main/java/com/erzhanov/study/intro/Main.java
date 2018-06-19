package com.erzhanov.study.intro;

public class Main {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyReactive());
        modelDuck.performFly();
    }
}
