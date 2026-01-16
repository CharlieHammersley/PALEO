package team.raptors.paleo.motor;

/**
 * PaleoMotor is the core motor abstraction used by PALEO.
 * Robot code should depend only on this interface and never
 * directly on vendor-specific motor controller classes.
 */
public interface PaleoMotor {

    /**
     * Sets the motor output as a percentage of full output.
     *
     * @param output value from -1.0 to 1.0
     */
    void set(double output);

    /**
     * Stops the motor.
     */
    default void stop() {
        set(0.0);
    }

    /**
     * Sets whether the motor output should be inverted.
     *
     * @param inverted true to invert motor direction
     */
    void setInverted(boolean inverted);

    /**
     * @return true if the motor output is inverted
     */
    boolean isInverted();

    /**
     * Sets the motor idle mode.
     *
     * @param brake true for brake mode, false for coast
     */
    void setBrakeMode(boolean brake);
}
