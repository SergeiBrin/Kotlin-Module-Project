package note

class Note(var name: String, var description: String = "") {

    fun addText(text: String) {
        description = "$description. $text"
        println("Текст успешно добавлен в заметку $name")
    }

    override fun toString(): String {
        return "Имя заметки: ${this.name}\nТекст заметки: ${this.description}"
    }
}