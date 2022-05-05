package hu.robnn.reactordemo.consumer

import java.util.function.Consumer

/**
 * Printel egy stringet a standart outputra
 */
class PrintingConsumer: Consumer<String> {
    override fun accept(input: String) {
        println(input)
    }
}