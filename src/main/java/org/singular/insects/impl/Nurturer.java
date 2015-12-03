package org.singular.insects.impl;

import org.singular.insects.Ant;
import org.singular.insects.Rank;

import static org.singular.util.Logger.*;

public class Nurturer extends Ant {
    public Nurturer() {
        super();
        setRank(Rank.NURTURER);
        setActionTime(10);
    }

    @Override
    public void action() {
        feedInfants();
    }

    private void feedInfants() {
        int foodEaten = 0;
        int infantsPerNurturer = (int) ((double) hiveMind.infantAnts() / (double) hiveMind.nurtureAnts().size());

        for (int i = 1; i <= infantsPerNurturer; i++) {
            hiveMind.removeFood(1);
            foodEaten += 1;
        }

        try {
            Thread.sleep(getActionTime());
            debug(hiveMind.nurtureAnts().size() + " nurture ants each fed " + infantsPerNurturer + " infant ants " + foodEaten + " food.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
