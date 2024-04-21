package screen.selection

import archive.Archive
import input.inputName
import input.inputNumber
import note.Note
import screen.navigation.menus
import screen.navigation.printMenu

fun noteSelection(archive: Archive) {
    while (true) {
        printNotes(archive)
        println("Выбери нужный пункт:")
        printMenu(menus[1])
        val innerCommand = inputNumber(2)

        when (innerCommand) {
            0 -> createNote(archive)
            1 -> changeNote(archive)
            2 -> return
        }
    }
}

private fun createNote(archive: Archive) {
    println("Введите название заметки")
    val noteName = inputName()

    println("Введите текст заметки")
    val noteDescription = inputName()

    val note = Note(noteName, noteDescription)
    archive.notes.add(note)
    println("Заметка «$noteName» создана и добавлена в архив «${archive.name}»")
}

private fun changeNote(archive: Archive) {
    if (archive.notes.isEmpty()) {
        return
    }

    printNotes(archive)
    val command = inputNumber(archive.notes.size - 1)
    openNote(archive.notes[command])
}

private fun openNote(note: Note) {
    println("Заметка с именем «${note.name}» открыта")
    println("Что вы хотите c ней сделать?")

    while (true) {
        printMenu(menus[2])
        val command = inputNumber(2)

        when (command) {
            0 -> note.addText(inputText())
            1 -> viewNoteContent(note)
            2 -> return
        }
    }
}

private fun viewNoteContent(note: Note) {
    println(note.toString())

    while (true) {
        println("Выбери пункт:")
        printMenu(menus[3])
        val command = inputNumber(0)
        if (command == 0) return else "Здесь можно только назад :("
    }
}

private fun inputText(): String {
    println("Введите текст:")
    val text = inputName()
    return text
}

private fun printNotes(archive: Archive) {
    if (archive.notes.isEmpty()) {
        println("У вас пока нет заметок в этом архиве :(")
        return
    }

    println("Ваш список заметок:")
    archive.notes.forEachIndexed { index, note -> println("$index ${note.name}") }
}

