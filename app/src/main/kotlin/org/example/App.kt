package org.example

enum class Operation(val opSymbol: Char) {
    Add('+'), Sub('-'), Mul('*'), Div('/'),
}

fun evalOperation(operation: Operation, operand1: Int, operand2: Int) = when (operation) {
    Operation.Add -> operand1 + operand2
    Operation.Sub -> operand1 - operand2
    Operation.Mul -> operand1 * operand2
    Operation.Div -> operand1 / operand2
}

fun getException() {
    val a = 5
    val b = 0
    println("a + b = ${evalOperation(Operation.Add, a, b)}")
    println("a - b = ${evalOperation(Operation.Sub, a, b)}")
    println("a * b = ${evalOperation(Operation.Mul, a, b)}")
    println("a / b = ${evalOperation(Operation.Div, a, b)}")
}

private fun evalAndLog(sb: StringBuilder, a: Int, b: Int) {
    sb.append("a + b = ${evalOperation(Operation.Add, a, b)}${System.lineSeparator()}")
    sb.append("a - b = ${evalOperation(Operation.Sub, a, b)}${System.lineSeparator()}")
    sb.append("a * b = ${evalOperation(Operation.Mul, a, b)}${System.lineSeparator()}")
    sb.append("a / b = ${evalOperation(Operation.Div, a, b)}${System.lineSeparator()}")
}

fun getAndCatchException() {
    val a = 5
    val b = 0
    val sb = StringBuilder()
    try {
        evalAndLog(sb, a, b)
        println(sb.toString())
    } catch (e: ArithmeticException) {
        println("Cannot eval operations with a = $a and b = $b")
        e.printStackTrace()
    } catch (e: Exception) {
        println("Unknown error")
    }
}

class DivisionException(message: String, cause: Throwable) : Exception(message, cause)

fun getAndCatchAndThrowException() {
    val a = 5
    val b = 0
    val sb = StringBuilder()
    try {
        evalAndLog(sb, a, b)
        println(sb.toString())
    } catch (e: ArithmeticException) {
        throw DivisionException("Cannot eval operations with a = $a and b = $b", e)
    } catch (e: Exception) {
        println("Unknown error")
        throw e
    }
}

fun getAndCatchAndThrowAndFinallyException() {
    val a = 5
    val b = 0
    val sb = StringBuilder()
    try {
        evalAndLog(sb, a, b)
    } catch (e: ArithmeticException) {
        throw DivisionException("Cannot eval operations with a = $a and b = $b", e)
    } catch (e: Exception) {
        println("Unknown error")
        throw e
    } finally {
        println(sb.toString())
    }
}

fun main() {
    getException()
//    getAndCatchException()
//    getAndCatchAndThrowException()
//    getAndCatchAndThrowAndFinallyException()
}
