# Exercise ex05

How to run:

```bash
cd src
javac Demo05.java.java
java Demo05
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**LSP Violation Fixed**: Created separate `Shape` hierarchy where `Rectangle` and `Square` inherit independently.  
**Behavioral consistency**: Square no longer violates Rectangle's width/height setting expectations.
