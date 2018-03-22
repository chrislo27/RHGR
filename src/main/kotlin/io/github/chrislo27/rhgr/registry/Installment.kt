package io.github.chrislo27.rhgr.registry


/**
 * An enum describing a physical game.
 */
enum class Installment(val gameName: String) {

    TENGOKU("Rhythm Tengoku"),
    DS("Rhythm Heaven"),
    FEVER("Rhythm Heaven Fever"),
    MEGAMIX("Rhythm Heaven Megamix");

    companion object {
        val VALUES: List<Installment> = Installment.values().toList()
    }

}