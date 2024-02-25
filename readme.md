# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)

<span style="color:blue">Provide your answer here! </span>
> Note: you can also use code snippets to illustrate your answer. 

Nullable types are variables that can hold null, 
while non-nullable types are variables which can't hold null.

```kotlin 
// Example of non-null types
var a: String = "value" 
var b: Int = 10
var c: Char = "a"
var d: Any = 10
```
To declare nullable variables, we need a ? operator to the ennd of the type
```kotlin 
// Example of null types
var aa: String? = "value" 
var bb: Int? = 10
var cc: Char? = "a"
var dd: Any? = 10
```
To access methods or properties of nullable variables, we need to use ?. safe call operators or !!. not-null assertion operators.
```kotlin 
var aa: String? = "value"
aa = null
val l = aa?.length

var bb: Int? = 10
var cc: Int = 8
val m = bb!!.minus(cc)

```
We can use if/else statements with null checks to access nullable variables in non-nullable contexts

```kotlin 
//Basic Null Check
val name: String? = "Janella"

if (name != null) {
    println(name)  
} else {
    println("Name is null")
}

//
```

You can convert a nullable variable to a non-nullable type with if/else expressios.

```kotlin 
val nullableName: String? = getNullableName() // This function might return null

// Convert nullableName into a non-nullable type
val name: String = if (nullableName != null) nullableName else "Unknown"

println(name) // 'name' is guaranteed to be non-null here

//Another Exampls
val userInput: String? = readLine()

// Ensuring a non-nullable assignment with a default value
val validInput: String = if (!userInput.isNullOrBlank()) userInput!! else "Default Input"

println(validInput) // 'validInput' is now a non-nullable String
```

You can provide a default value for when a nullable variable is null with the if7else expression or the ?: Elvis operator.

```kotlin 
val nullableName: String? = getNullableName() // This function might return null

// Using the Elvis operator to provide a default value
val name: String = nullableName ?: "Unknown"

```

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)

<span style="color:blue">Provide your answer here!</span>
Lambda Expression
Lambda expression is an anonymous function; a function without a nname. They are passed immediately as an expression without declaration, ig
Here, a lambda expression is assigned to variable hello. The expression doesn't accept any parameters and doesn't return any value in this program.
```kotlin
val hello = { println("Hello!")}
// invoking function
hello()
```
The code snippet below has a lambda expression that accepts two integers as parameters, and returns the product of those two integers.
Here, the lambda expression is enclosed in the curly braces.
```kotlin
val product = { a: Int, b: Int -> a * b }
val result = product(9, 3)
println(result)
```

Higher-Order Function
In Kotlin you can pass functions as arguments to other functions. Also, you can return a function from other functions. These functions are called higher-order functions.

Passing a Lambda exoression to a higher-order function
Here, greetMe() is a higher-order function (because it takes function as a parameter). The hello parameter accepts the lambda passed to the greetMe() function as: hello: () -> Unit
The empty parenthesis suggest that, the passed anonymous function doesn't accept any parameters. And, the Unit keyword suggest that the anonymous function doesn't return any value.
```kotlin
fun greetMe(hello: () -> Unit) {
    hello()
}

fun main(args: Array<String>) {
    greetMe({ println("Hello!") })
}
```

Why Store a Function in a Variable?
1. Higher-Order Functions
2. Reusability
3. Simplification
4. Functional Programming Patterns

### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly regardless of their position, 
and "m" is the number of digits guessed correctly at their correct position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

