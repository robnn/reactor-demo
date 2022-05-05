package hu.robnn.reactordemo

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.function.Consumer

/**
 * Reactor Reader implementáció ami egy párhuzamos szálon iratkozik fel, ezért azon fut
 */
class ReactorReaderParallelThread : Reader {
    override fun read(fileName: String, consumer: Consumer<String>) {
        Flux.fromStream(Files.lines(Paths.get(javaClass.classLoader.getResource(fileName).toURI()),
                StandardCharsets.UTF_8))
//                .log()
                .subscribeOn(Schedulers.parallel())
                .subscribe(consumer)
    }
}