public class PrimaryTeleopMaster extends TeleopMaster {
    public void update(double dt) {  //PSEUDOCODE ALERT
        if(input_manager.buttons_pressed['x']) {
            subsystem_manager.teleopMove(1,0.5,0.75)    //These are made-up numbers, but should illustrate the point: Master's don't implement, they tell the SubsystemManager what to do
        }
    }
}
