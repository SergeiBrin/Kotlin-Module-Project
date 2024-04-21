import archive.ArchiveStorage
import screen.navigation.showWelcomeMessage
import screen.selection.archiveSelection

fun main() {
    val storage = ArchiveStorage()
    showWelcomeMessage()
    archiveSelection(storage)
}




