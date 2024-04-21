package screen.navigation

val menus: Map<Int, List<String>> =
    mapOf(
        0 to listOf(
            "Создать архив",
            "Выбрать архив",
            "Выход"
        ),
        1 to listOf(
            "Создать заметку",
            "Выбрать заметку",
            "Назад"
        ),
        2 to listOf(
            "Добавить текст в заметку",
            "Посмотреть заметку",
            "Назад"
        ),
        3 to listOf(
            "Назад"
        )
    )

fun showWelcomeMessage() {
    println(
        "Привет! Программа заметок запущена. Начинай записывать.\n"
    )
}

fun printMenu(value: List<String>?) {
    value?.forEachIndexed { index, menu -> println("$index. $menu") }
}


