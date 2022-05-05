package hu.robnn.reactordemo

import hu.robnn.reactordemo.consumer.PrintingConsumer

fun main() {
    println("--- Blocking call ---")
    val blockingReader = BlockingReader()
    blockingReader.read("test1.txt", PrintingConsumer())
    println("--- Blocking call finished ---")

    println("--- Reactor call ---")
    val reactorReaderMainThread = ReactorReaderMainThread()
    reactorReaderMainThread.read("test1.txt", PrintingConsumer())
    println("--- Reactor call finished ---")

    println("--- Another reactor call ---")
    val reactorReaderParallelThread = ReactorReaderParallelThread()
    reactorReaderParallelThread.read("test1.txt", PrintingConsumer())
    println("--- Another reactor call finished ---")

//    Thread.sleep(1000L)
}