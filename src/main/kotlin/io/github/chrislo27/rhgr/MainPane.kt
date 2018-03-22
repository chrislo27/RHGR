package io.github.chrislo27.rhgr

import io.github.chrislo27.rhgr.registry.Minigame
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox


class MainPane : BorderPane() {

    companion object {
        const val SPACING = 4.0
    }

    val menuBar: MenuBar = MenuBar(Menu("File"), Menu("About"))
    val bottomBox: HBox = HBox(SPACING)
    val centreBox: HBox = HBox(0.0)

    val mainList: ListView<Minigame> = ListView()
    val selectedList: ListView<Minigame> = ListView()
    val resultList: ListView<Minigame> = ListView()
    val addRemoveBox: VBox = VBox(SPACING)
    val randomizeBox: VBox = VBox(SPACING)

    val addButton = Button("Add >")
    val removeButton = Button("< Remove")
    val addAllButton = Button("Add All >>")
    val removeAllButton = Button("<< Remove All")
    val randomizeButton = Button("Randomize!")

    init {
        top = menuBar
        bottom = bottomBox
        center = centreBox

        HBox.setHgrow(mainList, Priority.ALWAYS)
        HBox.setHgrow(selectedList, Priority.ALWAYS)
        HBox.setHgrow(resultList, Priority.ALWAYS)

        bottomBox.children += Button("filler")

        fun VBox.settings() {
            prefWidth = 200.0
            isFillWidth = true
            alignment = Pos.CENTER
        }
        addRemoveBox.settings()
        randomizeBox.settings()

        fun Button.settings(): Button {
            maxWidth = Double.MAX_VALUE
            return this
        }

        addRemoveBox.children.addAll(addButton.settings(), removeButton.settings(),
                Separator(Orientation.HORIZONTAL), addAllButton.settings(), removeAllButton.settings())
        randomizeBox.children += randomizeButton.settings()

        centreBox.children.addAll(mainList, addRemoveBox, selectedList, randomizeBox, resultList)
    }

}