package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;

public class Load_and_Shoot extends SequentialCommandGroup{
    
public Load_and_Shoot (Shooter shooter, Loader loader, double FrontshooterSpeed, double BackshooterSpeed, double SpindexerSpeed){
addCommands(
    new ParallelCommandGroup(
        new Shoot_Ball(shooter, FrontshooterSpeed, BackshooterSpeed),
        new SequentialCommandGroup(
        new WaitCommand(1.15),
        new Load_Ball(loader, SpindexerSpeed))
     ));
    }

}
