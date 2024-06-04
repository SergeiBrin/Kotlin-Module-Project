package archive

import note.Note

class Archive(var name: String) {
    val notes: MutableList<Note> = mutableListOf()
}