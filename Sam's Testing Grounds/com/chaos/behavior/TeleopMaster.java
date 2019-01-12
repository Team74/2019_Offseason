package com.chaos.behavior;

import com.chaos.behavior.Master;
import com.chaos.SubsystemManager;
import com.chaos.InputManager;

abstract public class TeleopMaster extends Master {

    protected InputManager input_manager;

    protected TeleopMaster(SubsystemManager subsystem_manager, InputManager _input_manager) {
        super(subsystem_manager);
        input_manager = _input_manager;
    }
}
