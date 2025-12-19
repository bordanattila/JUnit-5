## Portfolio Artifact: Software Testing, Automation, and Quality Assurance

### Overview
This portfolio submission highlights my work in unit testing, test automation concepts, and quality assurance practices. It includes a completed service layer implementation and automated unit tests from Project One, along with a written summary and reflections report from Project Two.

### Included Artifacts
**Project One (Contact Service)**
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

**Project Two**
- Summary and Reflections Report

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?
I ensure functionality by building directly to requirements and validating behavior with automated unit tests. In this artifact, I used JUnit tests to verify expected outcomes, cover edge cases, and confirm that invalid inputs are handled correctly (such as enforcing field constraints and preventing bad data from being stored). I treat tests as executable requirements—when requirements change, both the code and tests must be updated together to stay aligned.

To improve security, I apply secure coding practices throughout development: validating inputs, handling errors safely, minimizing exposure of sensitive information, and avoiding unsafe assumptions about external data. When available, I also rely on tooling such as static analysis and automated checks to catch issues earlier in the SDLC.

### How do I interpret user needs and incorporate them into a program?
I interpret user needs by translating them into clear, testable requirements and acceptance criteria. I identify what the user must be able to do, what constraints apply (required fields, formatting rules, length limits), and how the system should behave with invalid input. From there, I implement the required behaviors and write tests that map directly to the requirements.

In these projects, the requirements guided both my service logic and my test cases. Writing tests helped me clarify edge cases and confirm that the program behaves consistently as changes are made.

### How do I approach designing software?
I design software with a focus on clarity, maintainability, and testability. I break the problem into smaller components with single responsibilities (for example, keeping data models separate from service logic), define clear interfaces, and enforce constraints close to where data is created or modified.

I also use an iterative approach: implement one requirement at a time, validate it with tests, and refactor when needed to keep the code clean and easy to extend. This mindset helps produce software that is more reliable, easier to maintain, and less likely to fail unexpectedly.