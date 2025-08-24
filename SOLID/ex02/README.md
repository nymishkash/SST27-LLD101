# Exercise ex02

How to run:

```bash
cd src
javac Demo02.java.java
java Demo02
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**SRP Violation Fixed**: Separated `Player` concerns into `Decoder`, `UIRenderer`, and `FrameCache` classes.  
**OCP Applied**: Each component can now be extended independently without modifying existing code.
