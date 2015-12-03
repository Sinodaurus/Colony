package org.singular.observers;

import org.singular.modules.Module;

public abstract class Observer {
    protected Module module;
    public abstract void update();
}
