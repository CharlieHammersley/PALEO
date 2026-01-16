package team.raptors.paleo.motor;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotController;

/**
 * SimMotor is a simple physics-based motor simulation.
 * It models percent output, inversion, and basic velocity behavior.
 */
public class SimMotor implements PaleoMotor {

    private boolean inverted = false;
    private boolean brakeMode = false;

    private double output = 0.0;
    private double velocity = 0.0;

    // Simple constants (tunable later)
    private static final double MAX_RPM = 5700.0;
    private static final double RESPONSE_RATE = 0.1;

    @Override
    public void set(double output) {
        this.output = MathUtil.clamp(output, -1.0, 1.0);
    }

    @Override
    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    @Override
    public boolean isInverted() {
        return inverted;
    }

    @Override
    public void setBrakeMode(boolean brake) {
        this.brakeMode = brake;
    }

    /**
     * Called periodically to update simulated state.
     * Intended to be run at ~20ms.
     */
    public void update() {
        double targetRpm = output * MAX_RPM;
        velocity += (targetRpm - velocity) * RESPONSE_RATE;

        if (brakeMode && Math.abs(output) < 0.01) {
            velocity *= 0.9;
        }
    }

    /**
     * @return simulated motor velocity in RPM
     */
    public double getVelocityRpm() {
        return inverted ? -velocity : velocity;
    }

    /**
     * @return estimated applied voltage
     */
    public double getVoltage() {
        return RobotController.getBatteryVoltage() * output;
    }
}
