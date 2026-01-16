# PALEO

## What is PALEO?

**Parallel Abstraction Library for Emulated Objects (PALEO)** is a library extension to WPILib that abstracts robot hardware, allowing robot code to run in simulation without requiring changes between simulated and real runtimes.

PALEO enables programmers to begin developing and testing robot code before the robot is built or wired, reducing the development bottleneck placed on programming during early build phases. In addition, PALEO provides real-time game physics and simulation utilities to streamline development, including tools to assist with scoring logic and autonomous motion.

## Design Goals

The primary goal of PALEO is to allow robot code to transition from a simulated runtime to a real robot runtime without requiring significant refactoring. PALEO is designed to work **in tandem** with WPILib’s built-in simulation tools and vendor-provided simulation support, rather than replacing or conflicting with them.

## Design Philosophy

PALEO abstracts hardware access through **device wrapper factories**, effectively implementing a Dependency Injection pattern. This approach decouples robot logic from the physical Hardware Abstraction Layer (HAL), improving testability and portability while ensuring the same robot code can execute in both simulated and real environments.

## Using PALEO

When creating a robot project intended for use with PALEO, ensure that **desktop support is enabled**. If it is not enabled, this setting can be found and modified in the project’s `build.gradle` file.

When implementing PALEO’s simulated device wrappers, care should be taken to accurately model physical constraints such as friction, inertia, and current limits. Overly idealized simulations may result in PID constants and control values that do not transfer well to a real robot.

To use PALEO, build the PALEO library and include it as a dependency in your robot project. Robot code should create hardware devices through PALEO’s factory interfaces, which will automatically instantiate either real or simulated implementations depending on the runtime environment.

## Scope (Planned)

* Device wrappers for common FRC hardware
  * Motors
  * Encoders
  * Batteries
  * Sensors and actuators
* Physics-based simulation where applicable
* Mechanism simulation (intakes, indexers, etc.)
* Game piece interaction and field-level simulation
* Visualization support for mechanisms and motion