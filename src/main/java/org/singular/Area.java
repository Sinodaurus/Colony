package org.singular;

import org.singular.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private List<Module> modules;

    public Area() {
        modules = new ArrayList<Module>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}
