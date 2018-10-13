/*
Essentially the 'model' class -- keeps track of the state of the robot, contains all of the advanced/composite functions used to control it, as well as containing references to all the subsystems that handle, eg, the lift, the wheels, etc. Basically, if you want to control the robot, you go through this class. There will only be one instance of SubsystemManager at a time, since it handles all the physical robot stuff.
*/
public class SubsystemManager implements Updateable{

    private Master current_master;  //the thing that's currently giving this thing instructions.
    private ArrayList<Updateable> listOfUpdatingObjects = new ArrayList<Updateable>();  //this will have duplicate references from the various things below, plus others -- positionTracker, etc.
    public RobotMap robot_map;

    public Drivetrain drivetrain;   //this will get the RobotMap passed in when it's created
    //etc. ...
    //incidentally, do we want these to be private? Commands should go from masters through SubsystemManager, and SubsystemManager can deal with converting that into individual commands.

    SubsystemManager() {
        /*
        -setup all the Subsystems: Drivetrain, Grabbers, etc.
        -put them in default position -- a lot of this happened in robot.py , drive.py, and operatorFunctions in the past
        -HOWEVER: let the subsystems themselves set themselves up as much as possible. eg, tell liftMotor.setup() and let it handle itself
        -DON'T set up input -- that's InputManager's job
        */
    }

    public void update(double dt) {
        for(int i = 0; i < listOfUpdatingObjects.length(); ++i){
            listOfUpdatingObjects[i].update(dt);
        }
        current_master.update(dt);    //current_master, which has a reference to this object, will call the variosu commands below to tell the robot to do things
    }

        /*
        -have lots of commands for controlling said components. Things like last year's autonAngledTurn, autonMove, or even just tankDrive.
        -NOT commands that directly interpret driver input. Let the relevant TeleopMaster deal with input directly.
        */
}