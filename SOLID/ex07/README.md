# Exercise ex07

How to run:

```bash
cd src
javac Demo07.java.java
java Demo07
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**ISP Violation Fixed**: Segregated `Machine` into specific interfaces: `Printer`, `Scanner`, and `FaxMachine`.  
**No forced implementations**: `BasicPrinter` only implements `Printer` interface, avoiding unused methods.
