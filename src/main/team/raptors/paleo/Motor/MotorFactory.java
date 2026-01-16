package team.raptors.paleo.motor;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import team.raptors.paleo.runtime.RuntimeMode;

/**
 * MotorFactory creates PaleoMotor instances for real or simulated runtimes.
 * This is the only location where runtime checks should occur.
 */
public final class MotorFactory {

    private MotorFactory() {
        // Utility class
    }

    /**
     * Creates a PaleoMotor from a real MotorController.
     * In simulation, the MotorController is ignored.
     *
     * @param realMotor real WPILib motor controller
     * @return PaleoMotor implementation
     */
    public static PaleoMotor create(MotorController realMotor) {
        if (RuntimeMode.current() == RuntimeMode.REAL) {
            return new RealMotor(realMotor);
        } else {
            return new SimMotor();
        }
    }
}
