package hu.robnn.reactordemo

import reactor.core.publisher.Flux
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Consumer

/**
 * Reactor Reader implementáció, ami a fő szálon iratkozik fel, ezért azon fut.
 */
class ReactorReaderMainThread : Reader {
    override fun read(fileName: String, consumer: Consumer<String>) {
        Flux.fromStream(Files.lines(Paths.get(javaClass.classLoader.getResource(fileName).toURI()),
                StandardCharsets.UTF_8))
//                .log()
                .subscribe(consumer)
    }
}