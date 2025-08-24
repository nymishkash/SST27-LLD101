# Exercise ex08

How to run:

```bash
cd src
javac Demo08.java.java
java Demo08
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**ISP Violation Fixed**: Created specific capability interfaces: `Pedalable`, `EngineVehicle`, and `ElectricVehicle`.  
**Focused implementations**: Each vehicle type implements only relevant interfaces (Bicycle implements Pedalable only).
