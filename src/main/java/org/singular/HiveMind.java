package org.singular;

import org.singular.insects.Ant;
import org.singular.insects.impl.Nurturer;
import org.singular.insects.impl.Queen;
import org.singular.modules.BreedingRoom;
import org.singular.modules.Module;
import org.singular.modules.NurtureRoom;
import org.singular.observers.NurtureObserver;

import java.util.LinkedList;
import java.util.List;

import static org.singular.util.Logger.*;

public class HiveMind {
    private static HiveMind self = new HiveMind();
    private Area area;
    private int typeLogging;
    private int food = 50;
    private int eggs = 0;
    private int infantAnts = 0;
    private List<Ant> queens = new LinkedList<>();
    private List<Ant> nurtureAnts = new LinkedList<>();
    private List<Ant> workerAnts = new LinkedList<>();
    private List<Ant> soldierAnts = new LinkedList<>();

    public static HiveMind get() {
        return self;
    }

    public void init() {
        typeLogging = 1;
        Queen queen = new Queen();
        queen.setName("Alix");
        addQueen(queen);
//        info("A queen has been born!  Her name is %s.", queen.getName());
        addNurtureAnt(new Nurturer());
        addNurtureAnt(new Nurturer());
        area = new Area();
        Module breedingRoom = new BreedingRoom();
        new NurtureObserver(breedingRoom);
        area.addModule(breedingRoom);
        area.addModule(new NurtureRoom());
    }

    public Area area() {
        return area;
    }

    public int typeLogging() {
        return typeLogging;
    }

    public void changeTypeLogging(int typeLogging) {
        this.typeLogging = typeLogging;
    }

    public boolean logInfo() {
        if(typeLogging == 1) {
            return true;
        }
        return false;
    }

    public boolean logDebug() {
        if(typeLogging == 2) {
            return true;
        }
        return false;
    }

    //food -----------------

    public void addFood(int amount) {
        food += amount;
    }

    public void removeFood(int amount) {
        food -= amount;
    }

    public int food() {
        return food;
    }

    //eggs -----------------

    public void removeEggs(int amount) {
        eggs -= amount;
    }

    public void addEggs(int amount) {
        eggs += amount;
    }

    public int eggs() {
        return eggs;
    }

    //infantAnts ----------

    public void addInfantAnts(int amount) {
        infantAnts += amount;
    }

    public void removeInfantAnts(int amount) {
        infantAnts -= amount;
    }

    public int infantAnts() {
        return infantAnts;
    }

    //queens -----------

    public void addQueen(Ant ant) {
        queens.add(ant);
    }

    public void removeQueen(Ant ant) {
        queens.remove(ant);
    }

    public List<Ant> queens() {
        return queens;
    }

    //nurtureAnts -----------

    public void addNurtureAnt(Ant ant) {
        nurtureAnts.add(ant);
    }

    public void removeNurtureAnt(Ant ant) {
        nurtureAnts.remove(ant);
    }

    public List<Ant> nurtureAnts() {
        return nurtureAnts;
    }

    //workerAnts -----------

    public void addWorkerAnt(Ant ant) {
        workerAnts.add(ant);
    }

    public void removeWorkerAnt(Ant ant) {
        workerAnts.remove(ant);
    }

    public List<Ant> workerAnts() {
        return workerAnts;
    }

    //soldierAnts -----------

    public void addSoldierAnt(Ant ant) {
        soldierAnts.add(ant);
    }

    public void removeSoldierAnts(Ant ant) {
        soldierAnts.remove(ant);
    }

    public List<Ant> soldierAnts() {
        return soldierAnts;
    }
}
