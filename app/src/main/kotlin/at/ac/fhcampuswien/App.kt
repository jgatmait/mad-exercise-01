/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package at.ac.fhcampuswien
import kotlin.random.Random

class App {
    // Game logic for a number guessing game
    fun playNumberGame(digitsToGuess: Int = 4) {
        //TODO: build a menu which calls the functions and works with the return values
        val generatedNumber = generateRandomNonRepeatingNumber(digitsToGuess)
        var guess: Int
        var attempts = 0

        println("Welcome to the Guess that Number Game!")
        println("So, I just dropped a random $digitsToGuess-digit number. It's as special as a snowflake, no digit dares to repeat itself!")
        println("Your mission is to guess it. Enter your guess, or if you lack the braincells to guess smash 0 to exit.")

        do {
            println("\nEnter your guess:")
            guess = readLine()?.toIntOrNull() ?: -1
            if (guess == 0) {
                println("Give up already? The secret number was $generatedNumber.")
                break
            }

            if (guess.toString().length != digitsToGuess) {
                println("Oops! Make sure it's a $digitsToGuess-digit number, please.")
                continue
            }

            val result = checkUserInputAgainstGeneratedNumber(guess, generatedNumber)
            if (result.n == digitsToGuess) {
                println("Woohoo! Nailed it in $attempts tries!")
                break
            } else {
                println("Output: ${result.m}:${result.n} (Correct digits: ${result.m}, Correct positions: ${result.n})")
                attempts++
            }
        } while (true)
    }

    /**
     * Generates a non-repeating number of a specified length between 1-9.
     *
     * Note: The function is designed to generate a number where each digit is unique and does not repeat.
     * It is important to ensure that the length parameter does not exceed the maximum possible length
     * for non-repeating digits (which is 9 excluding 0 for base-10 numbers).
     *
     * @param length The length of the non-repeating number to be generated.
     *               This dictates how many digits the generated number will have.
     * @return An integer of generated non-repeating number.
     *         The generated number will have a number of digits equal to the specified length and will
     *         contain unique, non-repeating digits.
     * @throws IllegalArgumentException if the length is more than 9 or less than 1.
     */
    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        //TODO implement the function
        if (length !in 1..9) throw IllegalArgumentException("Length must be between 1 and 9")

        val digits = (1..9).shuffled().take(length)
        digits.joinToString("").toInt()

          // return value is a placeholder

    }

    /**
     * Compares the user's input integer against a generated number for a guessing game.
     * This function evaluates how many digits the user guessed correctly and how many of those
     * are in the correct position. The game generates number with non-repeating digits.
     *
     * Note: The input and the generated number must both be numbers.
     * If the inputs do not meet these criteria, an IllegalArgumentException is thrown.
     *
     * @param input The user's input integer. It should be a number with non-repeating digits.
     * @param generatedNumber The generated number with non-repeating digits to compare against.
     * @return [CompareResult] with two properties:
     *         1. `m`: The number of digits guessed correctly (regardless of their position).
     *         2. `n`: The number of digits guessed correctly and in the correct position.
     *         The result is formatted as "Output: m:n", where "m" and "n" represent the above values, respectively.
     * @throws IllegalArgumentException if the inputs do not have the same number of digits.
     */
    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        //TODO implement the function

        val inputString = input.toString()
        val generatedString = generatedNumber.toString()
        val countedDigits = mutableSetOf<Char>() // Tracks digits from generatedNumber that have been counted

        if (inputString.length != generatedString.length) {
            throw IllegalArgumentException("Input and generated number must have the same number of digits.")
        }
        // Check for non-repeating digits within each number
        /** Error in AppTest
          if (inputString.toSet().size != inputString.length || generatedString.toSet().size != generatedString.length) {
            throw IllegalArgumentException("Both numbers must have non-repeating digits.")
        }**/

        var correctDigits = 0
        var correctPositions = 0




        inputString.forEachIndexed { index, char ->
            // Check if the digit has not been counted yet and if it exists in the generatedNumber
            if (char !in countedDigits && generatedString.contains(char)) {
                correctDigits++
                countedDigits.add(char) // Mark the digit as counted
            }
            // Check for correct positions
            if (generatedString[index] == char) {
                correctPositions++
            }
        }

        CompareResult(correctDigits, correctPositions)

        //CompareResult(0, 0)   // return value is a placeholder
    }
}

fun main() {
    println("Hello World!")
    // TODO: call the App.playNumberGame function with and without default arguments

    App().playNumberGame(4)
    App().playNumberGame()

}
