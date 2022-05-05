package hu.robnn.reactordemo

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Consumer

/**
 * Egyszerű blokkoló Reader implementáció java.nio.file.Files használatával
 */
class BlockingReader: Reader {
    override fun read(fileName: String, consumer: Consumer<String>) {
        val lines = Files.readAllLines(Paths.get(javaClass.classLoader.getResource(fileName).toURI()),
                StandardCharsets.UTF_8)
        lines.forEach { consumer.accept(it) }
    }
}