# PALEO
## What is PALEO?
Parallel Abstraction Library for Emulated Objects (PALEO) is a library extension to WPILib that abstracts robot hardware, allowing for robot simulation without altering robot code. PALEO allows programmers to begin working on robot code before the robot is built and wired, reducing the development bottleneck put on programming. Additionally, PALEO provides real time game physics and simulations to streamline the programming process as well as tools for scoring and autonomous motion.
### Design Goals
The goal of PALEO is to allow programmers to transition from a simulated to real runtime without having to drastically change any robot code. PALEO is intended to work in tandem with the simulation tools provided by WPILib and vendors rather than working against them.
### Design Philosophy
PALEO abstracts hardware access through device wrapper factories, effectively implementing a Dependency Injection pattern. This keeps robot logic decoupled from the physical Hardware Abstraction Layer, improving testability and portability without needing to change any robot code between runtime environments.
## Using PALEO
When creating a robot project intended for use with PALEO, ensure desktop support is enabled, if it isn't, you can find it in your build.gradle file. When implementing PALEO's simulated device wrappers,care should be taken in modeling the physical constraints of the robot, such as friction. An overly idealized simulation will result in PID values and constants that may not transfer well to a real runtime environment.

