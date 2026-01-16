package team.raptors.paleo.runtime;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * RuntimeMode centralizes detection of the current robot runtime.
 * 
 * This allows PALEO factories and abstractions to decide whether to
 * instantiate real or simulated devices, without leaking HAL checks
 * throughout robot code.
 */
public enum RuntimeMode {
    REAL,
    SIM;

    // Cache the current runtime mode for efficiency and determinism
    private static final RuntimeMode CURRENT = RobotBase.isReal() ? REAL : SIM;

    /**
     * @return the current runtime mode.
     *         REAL for a real robot, SIM for desktop simulation.
     */
    public static RuntimeMode current() {
        return CURRENT;
    }

    /**
     * @return true if running in a real robot environment
     */
    public static boolean isReal() {
        return CURRENT == REAL;
    }

    /**
     * @return true if running in a simulation
     */
    public static boolean isSim() {
        return CURRENT == SIM;
    }
}
