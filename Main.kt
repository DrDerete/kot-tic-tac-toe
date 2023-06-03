package tictactoe

fun main() {

    var str = "_________"
    var game = true

    show(str)

    while (game) {
        str = input1(str)
        show(str)
        game = check(str)
        if (!game) return
        str = input2(str)
        show(str)
        game = check(str)
    }

}

fun show(str: String) {

    println("---------")
    for (i in str.indices) {
        when (i % 3) {
            0 -> print("| " + str[i])
            1 -> print(" " + str[i])
            2 -> print(" " + str[i] + " |\n")
        }
    }
    println("---------")

}

fun input1(str: String): String {

    val strg: String
    try {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a !in 1..3 || b !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            return input1(str)
        } else if (str[(a - 1) * 3 + b - 1] != '_') {
            println("This cell is occupied! Choose another one!")
            return input1(str)
        } else strg = str.replaceRange((a - 1) * 3 + b - 1, (a - 1) * 3 + b - 1 + 1, "X")
    } catch (e: NumberFormatException) {
        println("You should enter numbers!")
        return input1(str)
    }
    return strg

}

fun input2(str: String): String {

    val strg: String
    try {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a !in 1..3 || b !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            return input2(str)
        } else if (str[(a - 1) * 3 + b - 1] != '_') {
            println("This cell is occupied! Choose another one!")
            return input2(str)
        } else strg = str.replaceRange((a - 1) * 3 + b - 1, (a - 1) * 3 + b - 1 + 1, "O")
    } catch (e: NumberFormatException) {
        println("You should enter numbers!")
        return input2(str)
    }
    return strg

}

fun check(str: String): Boolean {

    val game: Boolean
    var wins = 0
    if (str[0] == str[1] && str[1] == str[2] && str[0] != '_') wins++
    if (str[3] == str[4] && str[4] == str[5] && str[3] != '_') wins++
    if (str[6] == str[7] && str[7] == str[8] && str[6] != '_') wins++
    if (str[0] == str[3] && str[3] == str[6] && str[0] != '_') wins++
    if (str[1] == str[4] && str[4] == str[7] && str[1] != '_') wins++
    if (str[2] == str[5] && str[5] == str[8] && str[2] != '_') wins++
    if (str[0] == str[4] && str[4] == str[8] && str[0] != '_') wins++
    if (str[2] == str[4] && str[4] == str[6] && str[2] != '_') wins++
    if (wins == 1 || "_" !in str) println(
        when {
            str[0] == str[1] && str[1] == str[2] -> "${str[0]} wins"
            str[3] == str[4] && str[4] == str[5] -> "${str[3]} wins"
            str[6] == str[7] && str[7] == str[8] -> "${str[6]} wins"
            str[0] == str[3] && str[3] == str[6] -> "${str[0]} wins"
            str[1] == str[4] && str[4] == str[7] -> "${str[1]} wins"
            str[2] == str[5] && str[5] == str[8] -> "${str[2]} wins"
            str[0] == str[4] && str[4] == str[8] -> "${str[0]} wins"
            str[2] == str[4] && str[4] == str[6] -> "${str[2]} wins"
            else ->  "Draw."
        }
    )
    game = !(wins == 1 || "_" !in str)
    return game
}
