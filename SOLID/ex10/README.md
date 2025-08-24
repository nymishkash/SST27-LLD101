# Exercise ex10

How to run:

```bash
cd src
javac Demo10.java.java
java Demo10
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**DIP Violation Fixed**: Introduced `Logger` interface with dependency injection in `ReportService`.  
**Flexible logging**: Can switch between console and file logging without changing service code.
