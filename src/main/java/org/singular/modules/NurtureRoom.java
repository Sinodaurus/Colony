package org.singular.modules;

public class NurtureRoom extends Module {
    public NurtureRoom() {
        super();
    }

    @Override
    public void checkStatus() {
    }

    @Override
    public void yield() {
        hiveMind.nurtureAnts().stream().forEach(s -> s.action());
        notifyAllObservers();
    }
}
