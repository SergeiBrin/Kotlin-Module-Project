package archive

class ArchiveStorage {
    var id = 0
    val archives: MutableMap<Int, Archive> = mutableMapOf()

    fun addArchive(archive: Archive) {
        archives[id] = archive
        id++
    }
}