# Exercise ex04

How to run:

```bash
cd src
javac Demo04.java.java
java Demo04
```

Tasks:

- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

## Refactoring Changes

**OCP Violation Fixed**: Implemented Strategy pattern with `PaymentProcessor` interface.  
**New payment methods**: Can be added without modifying existing `PaymentService` code.
