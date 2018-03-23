package io.github.chrislo27.rhgr.registry

import javafx.scene.image.Image
import java.util.*


/**
 * The minigame. Contains info such as its name, the installments it is in, and other metadata.
 */
data class Minigame(val id: String, val name: String,
                    val installments: EnumSet<Installment>, val inputTypes: EnumSet<InputType>,
                    val sideGame: Boolean = false) : Comparable<Minigame> {

    val icon: Image by lazy {
        Image("/games/$id.png")
    }

    override fun compareTo(other: Minigame): Int {
        return name.compareTo(other.name)
    }
}