// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SimpleMotor extends SubsystemBase {

  private final String speedKey = " speed:";
  private final String stateKey = " state:";
  /** Creates a new SimpleMotorController. */
  private CANSparkMax controller;
  private boolean off;

  String name;


  public SimpleMotor(int sparkMaxID, String name) {
    controller = new CANSparkMax(sparkMaxID, MotorType.kBrushless);
    this.name = name;
    off = false;

    SmartDashboard.putNumber(name + speedKey, 0);
    SmartDashboard.putString(name + stateKey, "init");
  }

  public void on() {
    off = false;
    controller.set(SmartDashboard.getNumber(name + speedKey, 0));
    SmartDashboard.putString(name + stateKey, "on");
  }

  public void reverse() {
    off = false;
    controller.set(-SmartDashboard.getNumber(name + speedKey, 0));
    SmartDashboard.putString(name + stateKey, "reverse");
  }

  public void off() {
    off = true;
    controller.set(0);
    SmartDashboard.putString(name + stateKey, "off");
  }

  public void toggle(){
    if(off){
      on();
    } else{
      off();
    }
  }

  public String getName(){
    return name;
  }

  @Override
  public void periodic() {}
}