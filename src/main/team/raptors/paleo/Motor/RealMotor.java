package team.raptors.paleo.motor;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

/**
 * RealMotor is a thin wrapper around a real WPILib MotorController.
 * It adapts vendor hardware to the PaleoMotor abstraction.
 */
public class RealMotor implements PaleoMotor {

    private final MotorController motor;
    private boolean inverted = false;
    private boolean brakeMode = false;

    public RealMotor(MotorController motor) {
        this.motor = motor;
    }

    @Override
    public void set(double output) {
        motor.set(inverted ? -output : output);
    }

    @Override
    public void setInverted(boolean inverted) {
        this.inverted = inverted;
        motor.setInverted(inverted);
    }

    @Override
    public boolean isInverted() {
        return inverted;
    }

    @Override
    public void setBrakeMode(boolean brake) {
        this.brakeMode = brake;

        // Not all MotorControllers support brake/coast.
        // This is intentionally left as a no-op for generic controllers.
    }

    /**
     * @return true if brake mode is requested
     */
    public boolean isBrakeMode() {
        return brakeMode;
    }
}
