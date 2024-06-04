package screen.selection

import archive.Archive
import archive.ArchiveStorage
import input.inputName
import input.inputNumber
import screen.navigation.menus
import screen.navigation.printMenu

fun archiveSelection(storage: ArchiveStorage) {
    while (true) {
        printArchives(storage)
        println("Выбери нужный пункт:")
        printMenu(menus[0])

        val command = inputNumber(2)
        when (command) {
            0 -> createArchive(storage)
            1 -> changeArchive(storage)
            2 -> return
        }
    }
}

fun createArchive(storage: ArchiveStorage) {
    println("Введите название архива:")
    val archiveName = inputName()

    val archive = Archive(archiveName)
    storage.addArchive(archive)
    println("Архив «$archiveName» создан!")
}

fun changeArchive(storage: ArchiveStorage) {
    if (storage.archives.isEmpty()) {
        return
    }

    val archiveSize = storage.archives.size
    printArchives(storage)

    val command = inputNumber(archiveSize - 1)
    val archive = storage.archives[command]!!
    noteSelection(archive)
}

private fun printArchives(storage: ArchiveStorage) {
    if (storage.archives.isEmpty()) {
       println("Список архивов пуст :(")
       return
    }

    println("Список архивов:")
    storage.archives.forEach { (index, archive) -> println("$index. ${archive.name}") }
}