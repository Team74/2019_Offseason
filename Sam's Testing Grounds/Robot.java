public class Robot extends TimedRobot {

    SubsystemManager subsystem_manager;
    InputManager input_manager;


    public void robotInit() {
        subsystem_manager = new SubsystemManager(); //this will set up the whole robot and its subsystems
        input_manager = new InputManager(); //this is the significantly smaller bit of code that handles input from the xbox controllers and such
    }
    public void autonomousInit() {
        subsystem_manager.current_master = PathFollowing_AutonMaster(subsystem_manager);
         //or whatever other auton we want -- we'll probably need something for SmartDashboard eventually
    }
    public void autonomousPeriodic() {
        subsystem_manager.update();
    }
    public void teleopInit() {
        subsystem_manager.current_master = PrimaryTeleopMaster(subsystem_manager);
        //similarly, if we want to do, say, a different control scheme, a different teleopmaster could be subbed in that would interpret the inputs differently
    }
    public void teleopPeriodic() {
        input_manager.update();
        subsystem_manager.update();
    }

}
