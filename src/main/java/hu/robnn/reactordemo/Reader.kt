package hu.robnn.reactordemo

import java.io.IOException
import java.util.function.Consumer
import kotlin.jvm.Throws

interface Reader {

    /**
     * Beolvassa egy fájl tartalmát, majd meghívja kapott consumer-t a beolvasott sorok tartalmával
     */
    @Throws(IOException::class)
    fun read(fileName: String, consumer: Consumer<String>)
}