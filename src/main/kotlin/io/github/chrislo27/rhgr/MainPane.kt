package io.github.chrislo27.rhgr

import io.github.chrislo27.rhgr.registry.Minigame
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.util.Callback


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
    val mainListBox: VBox = VBox(SPACING)
    val selectedListBox: VBox = VBox(SPACING)
    val resultListBox: VBox = VBox(SPACING)
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

        fun ListView<Minigame>.settings(): ListView<Minigame> {
            maxHeight = Double.MAX_VALUE
            prefHeight = Region.USE_COMPUTED_SIZE
            VBox.setVgrow(this, Priority.ALWAYS)
            cellFactory = Callback<ListView<Minigame>, ListCell<Minigame>> {
                MinigameCell()
            }
            return this
        }

        fun makeLabel(text: String): Label {
            return Label(text).apply {
                maxWidth = Double.MAX_VALUE
                alignment = Pos.CENTER
            }
        }

        mainListBox.children.addAll(makeLabel("Filtered Minigames"), mainList.settings())
        selectedListBox.children.addAll(makeLabel("Selected Minigames"), selectedList.settings())
        resultListBox.children.addAll(makeLabel("Result"), resultList.settings())

        centreBox.children.addAll(mainListBox, addRemoveBox, selectedListBox, randomizeBox, resultListBox)
    }

    class MinigameCell : ListCell<Minigame>() {
        override fun updateItem(item: Minigame?, empty: Boolean) {
            super.updateItem(item, empty)
            if (empty || item == null) {
                graphic = null
                text = null
            } else {
                text = item.name
                graphic = ImageView(item.icon)
            }
        }
    }

}