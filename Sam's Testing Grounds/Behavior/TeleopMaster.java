abstract public class TeleopMaster extends Master {

    private InputManager input_manager;

    TeleopMaster(SubsystemManager subsystem_manager, InputManager input_manager) {
        super(subsystem_manager);
        this.input_manager = input_manager;
    }
}
