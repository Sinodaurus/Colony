package org.singular.insects.impl;

import org.singular.insects.Ant;
import org.singular.insects.Rank;
import static org.singular.util.Logger.*;

public class Queen extends Ant {
    public Queen() {
        super();
        setRank(Rank.QUEEN);
        setActionTime(1);
    }

    @Override
    public void action() {
        try {
            Thread.sleep(getActionTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int eggs = layEggs();
        hiveMind.addEggs(eggs);
        debug("Alix lays " + eggs + " eggs.");
    }

    private int layEggs() {
        return 1;
    }
}
