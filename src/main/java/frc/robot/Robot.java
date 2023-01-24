package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.photonvision.PhotonCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Robot extends TimedRobot {

  PhotonCamera camera = new PhotonCamera("photonvision");
  CANSparkMax frontRight = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax frontLeft = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax backRight = new CANSparkMax(4, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(2, MotorType.kBrushless);

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //spin();
    see();
  }

  public void spin() {
    frontRight.set(0.1);
    frontLeft.set(0.1);
    backRight.set(0.1);
    backLeft.set(0.1);
  }

  public void see() {
    var result = camera.getLatestResult();
    var target = result.getBestTarget();
    double yaw = 0.0;
    //System.out.println(target);

    if(target != null) {
      yaw = target.getYaw();
      SmartDashboard.putNumber("Yaw", yaw);
    }

    if (yaw < -5.0) {
      //turn left
      frontRight.set(0.1);
      frontLeft.set(0.1);
      backRight.set(0.1);
      backLeft.set(0.1);
    }
    else {
      frontRight.set(0);
      frontLeft.set(0);
      backRight.set(0);
      backLeft.set(0);
    }

    if (yaw > 5.0) {
      //turn right
      frontRight.set(-0.1);
      frontLeft.set(-0.1);
      backRight.set(-0.1);
      backLeft.set(-0.1);
    }
    else {
      frontRight.set(0);
      frontLeft.set(0);
      backRight.set(0);
      backLeft.set(0);
    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {

  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {

  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {

  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {

  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {

  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {

  }
}
