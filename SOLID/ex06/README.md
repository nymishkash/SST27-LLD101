# Exercise ex06

How to run:

```bash
cd src
javac Demo06.java.java
java Demo06
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**LSP Violation Fixed**: Introduced `Flyable` interface and separated flying birds (`FlyingBird`) from non-flying birds.  
**No more exceptions**: Penguin can swim instead of throwing exceptions when asked to fly.
