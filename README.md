Functional Programming Practice in Kotlin

------------------------------------------------------------
👥 Authors
------------------------------------------------------------
- David Mantilla Aviles – Code: 240220212015  
- Mariana Osorio Hernandez – Code: 24020211026  
- Juan Caicedo – Code: 240220232033  

------------------------------------------------------------
📌 Technical Requirements
------------------------------------------------------------
- Java Development Kit (JDK) 17 → Required to run or compile the project  
- Kotlin Compiler (kotlinc) or Gradle (optional for building from source)  
- The project includes a precompiled JAR (app.jar) that can be executed directly.  

To run the JAR from the project root:
    java -jar app.jar

------------------------------------------------------------
📂 Project Structure
------------------------------------------------------------
.
├── app/                       
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           └── kotlin/
│               └── org/example/
│                   ├── App.kt              # Entry point with interactive menu
│                   └── exercises/          # Exercise 1 — FP pillars
│                       ├── ImmutabilityExamples.kt
│                       ├── PureFunctions.kt
│                       ├── LambdaExamples.kt
│                       ├── HigherOrderExamples.kt
│                       └── LazyExamples.kt
│       └── test/
│ 
├── settings.gradle.kts
├── app.jar                  # Runnable JAR (compiled app)
└── README.md                # Project documentation

------------------------------------------------------------
🧩 Exercise 1 — Functional Programming Pillars
------------------------------------------------------------
1. Immutability
   - Example A → Immutable vs. mutable collections  
   - Example B → Using data class and .copy() instead of mutation  

2. Pure Functions
   - Demo shows difference between pure (no side effects) and impure functions  

3. Lambda Expressions
   - Example A → Squaring numbers with map  
   - Example B → Greeting function as a lambda  
   - Example C → More sophisticated pipeline using lambdas  

4. Higher-Order Functions
   - Passing functions as arguments (operate)  
   - Returning functions (powerOf)  

5. Lazy Evaluation
   - by lazy to load a configuration only once  
   - generateSequence to create infinite even numbers  

------------------------------------------------------------
▶️ Running the Application
------------------------------------------------------------
When you run the JAR, you’ll see an interactive menu:

=== Functional Programming in Kotlin — Demo ===
Choose a demo to run:
1. Immutability
2. Pure Functions
3. Lambda Expressions
4. Higher-Order Functions
5. Lazy Evaluation
6. Scope Functions (Exercise 2)
0. Exit
Enter option: _

Each option executes the corresponding demo until you decide to exit.


