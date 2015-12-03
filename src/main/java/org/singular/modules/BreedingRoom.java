package org.singular.modules;

import org.singular.HiveMind;

public class BreedingRoom extends Module {

    public BreedingRoom() {
        super();
    }

    @Override
    public void checkStatus() {
    }

    @Override
    public void yield() {
        HiveMind.get().queens().stream().forEach(s -> s.action());
        notifyAllObservers();
    }
}
