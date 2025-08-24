# Exercise ex09

How to run:

```bash
cd src
javac Demo09.java.java
java Demo09
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**DIP Violation Fixed**: Introduced `OrderRepository` interface with dependency injection in `OrderController`.  
**Flexible storage**: Can switch between SQL and NoSQL implementations without changing controller code.
