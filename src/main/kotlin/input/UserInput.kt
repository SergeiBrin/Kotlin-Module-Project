package input

fun inputNumber(check: Int): Int {
    while (true) {
        val input = readLine()?.toIntOrNull()

        when (input) {
            null -> println("Ошибка! Вы ввели не число. Попробуйте, пожалуйста, ввести число.")
            !in 0..check -> println("Пункта с таким числом нет. Попробуйте, пожалуйста, ввести правильное число.")
            else -> return input
        }
    }
}

fun inputName(): String {
    while (true) {
        val name = readLine()

        if (!name.isNullOrBlank()) {
            return name
        }

        println("Вы ничего не ввели. Пожалуйста, введите что-нибудь, так как поле не может быть пустым")
    }
}


