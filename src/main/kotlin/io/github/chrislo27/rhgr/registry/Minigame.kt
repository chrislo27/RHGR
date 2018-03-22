package io.github.chrislo27.rhgr.registry

import java.util.*


/**
 * The minigame. Contains info such as its name, the installments it is in, and other metadata.
 */
data class Minigame(val name: String, val installments: EnumSet<Installment>) {
}