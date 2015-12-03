package org.singular.modules;

import org.singular.HiveMind;
import org.singular.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    protected HiveMind hiveMind;
    protected List<Observer> observers = new ArrayList<>();

    public Module() {
        hiveMind = HiveMind.get();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers() {
        observers.stream().forEach(s -> s.update());
    }

    public abstract void checkStatus();
    public abstract void yield();
}
