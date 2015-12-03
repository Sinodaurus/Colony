package org.singular.insects;

import org.singular.HiveMind;

public abstract class Ant {
    protected HiveMind hiveMind;
    private String name;
    private int health;
    private Rank rank;
    private int actionTime;

    public Ant() {
        this.hiveMind = HiveMind.get();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void heal() {
        health += 2;
    }
    
    public void takeDmg(int amount) {
        health -= amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public int getActionTime() {
        return (int)  actionTime * 1000;
    }

    public void setActionTime(int actionTime) {
        this.actionTime = actionTime;
    }

    public abstract void action();
}
