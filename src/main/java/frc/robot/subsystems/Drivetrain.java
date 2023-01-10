// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants.DrivetrainConstants;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Drivetrain extends SubsystemBase {
  
private final CANSparkMax m_frontLeft = new CANSparkMax(DrivetrainConstants.kMotorPorts[0],
    CANSparkMaxLowLevel.MotorType.kBrushless);
    
private final CANSparkMax m_rearLeft = new CANSparkMax(DrivetrainConstants.kMotorPorts[1],
    CANSparkMaxLowLevel.MotorType.kBrushless);

private final CANSparkMax m_frontRight = new CANSparkMax(DrivetrainConstants.kMotorPorts[2],
    CANSparkMaxLowLevel.MotorType.kBrushless);
    
private final CANSparkMax m_rearRight = new CANSparkMax(DrivetrainConstants.kMotorPorts[3],
    CANSparkMaxLowLevel.MotorType.kBrushless);

    private final CommandXboxController m_driverController =
    new CommandXboxController(OperatorConstants.kDriverControllerPort);

    private void configureBindings() {
      // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
      new Trigger(m_exampleSubsystem::exampleCondition)
          .onTrue(new ExampleCommand(m_exampleSubsystem));
  
      // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
      // cancelling on release.
      m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    }

    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
