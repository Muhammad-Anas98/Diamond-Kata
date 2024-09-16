# Diamond Kata

This project implements the logic specified in the take-home assignment.

## Implementation

- Implemented the **end-to-end logic** as specified in the assignment.
- Followed best practices of **Object-Oriented Programming (OOP)** and **Separation of Concerns**.
- The project is implemented in **Java** for quicker completion, given the existing setup.
- Comprehensive **test cases** were added to cover all use cases of the implemented functionality.
- Since the output is mainly **console-based** (Diamond Shape), a solution was devised to accurately test the console output to validate the correct shape in various scenarios.
- Tests simulate **Byte Array Output Stream**. These are passed via Print Stream which works as pointer to in-memory printed output.

## Assumptions

- Input is always a single character from A to Z.
- The accepted input is always an uppercase character.

## Efficiency:

- Time complexity is O(k+k) -> O(k) where k is the number of characters to process.
- Space complexity is O(1)

## How to Run the Application

### Running with an Input argument

To run the application with a provided input, navigate to the project directory and execute the following command:

```bash
    ./gradlew run --args="your-argument-here" --warning-mode none (This runs the app with your provided argument)
    ./gradlew run --warning-mode none (Runs the project without argument but you need to provide the chracter in the main file)
```
If you have an intelliJ just open the project and run it from the top right corner or go to the main class and run it from there by clicking green arrow. You need to pass the character in the main file.

## How to run tests:
There are multiple ways to run/trigger tests
```bash
    ./gradlew clean build (It will be build the whole project and automatically triggers the tests)
    ./gradlew clean test (Runs the tests)
```
If you have intelliJ just open the project, go to the tests and run it from there by clicking green arrow