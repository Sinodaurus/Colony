package org.singular.observers;

import org.singular.HiveMind;
import org.singular.modules.Module;

import static org.singular.util.Logger.*;

public class NurtureObserver extends Observer {
    private HiveMind hiveMind;

    public NurtureObserver(Module module) {
        this.hiveMind = HiveMind.get();
        this.module = module;
        module.attach(this);
    }

    @Override
    public void update() {
        if (hiveMind.eggs() >= 20) {
            int eggs = hiveMind.eggs();
            debug("All " + hiveMind.eggs() + " eggs have hatched!");
            debug(hiveMind.nurtureAnts().size() + " nurture ants available.  Taking " + hiveMind.eggs() + " new larva to the nurture room.");
            hiveMind.removeEggs(eggs);
            hiveMind.addInfantAnts(eggs);
        }
    }
}
