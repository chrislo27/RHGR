package io.github.chrislo27.rhgr

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory
import io.github.chrislo27.rhgr.registry.GameRegistry
import io.github.chrislo27.rhgr.registry.InputType
import io.github.chrislo27.rhgr.registry.Installment
import io.github.chrislo27.rhgr.registry.Minigame
import javafx.application.Application
import javafx.beans.property.SimpleBooleanProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.util.Callback
import javafx.util.StringConverter


class MainPane(val application: Application) : BorderPane() {

    companion object {
        const val SPACING = 4.0
    }

    val menuBar: MenuBar = MenuBar()
    val bottomBox: HBox = HBox(SPACING)
    val centreBox: HBox = HBox(0.0)

    val mainList: ObservableList<Minigame> = FXCollections.observableArrayList()
    val selectedList: ObservableList<Minigame> = FXCollections.observableArrayList()
    val resultList: ObservableList<Minigame> = FXCollections.observableArrayList()
    val mainListView: ListView<Minigame> = ListView(mainList.sorted())
    val selectedListView: ListView<Minigame> = ListView(selectedList.sorted())
    val resultListView: ListView<Minigame> = ListView(resultList.sorted())
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
    val randomizeSpinner = Spinner<Int>(1, GameRegistry.backingMap.size, 4)
    val installmentListView: ListView<Installment> = ListView()
    val selectedInstallments: MutableSet<Installment> = mutableSetOf(*Installment.VALUES.toTypedArray())
    val inputTypeListView: ListView<InputType> = ListView()
    val selectedInputTypes: MutableSet<InputType> = mutableSetOf(*InputType.values())
    val sideGamesCheckbox: CheckBox = CheckBox("Include side games")

    init {
        top = menuBar
        bottom = bottomBox
        center = centreBox

        HBox.setHgrow(mainListView, Priority.ALWAYS)
        HBox.setHgrow(selectedListView, Priority.ALWAYS)
        HBox.setHgrow(resultListView, Priority.ALWAYS)

        bottomBox.prefHeight = 150.0

        menuBar.menus += Menu("About").apply {
            this.items += MenuItem("About this program").apply {
                this.onAction = EventHandler {
                    val alert = Alert(Alert.AlertType.INFORMATION)

                    alert.title = "About ${RHGR.TITLE}"
                    alert.headerText = alert.title

                    alert.dialogPane.content = TextFlow(
                            Text("${RHGR.TITLE}\n${RHGR.VERSION}${if (RHGR.githubVersion < RHGR.VERSION) " (latest public version is ${RHGR.githubVersion})" else ""}\n"),
                            Text("\nMade by chrislo27 under the"),
                            Hyperlink("GNU GPL-3.0 license").apply {
                                setOnAction {
                                    HostServicesFactory.getInstance(application).showDocument("https://github.com/chrislo27/RHGR/blob/master/LICENSE.txt")
                                }
                            },
                            Text("\nIcons used from the"),
                            Hyperlink("Rhythm Heaven Remix Editor").apply {
                                setOnAction {
                                    HostServicesFactory.getInstance(application).showDocument("https://github.com/chrislo27/RhythmHeavenRemixEditor")
                                }
                            },
                            Text("\n"),
                            Hyperlink(RHGR.GITHUB).apply {
                                setOnAction {
                                    HostServicesFactory.getInstance(application).showDocument(RHGR.GITHUB)
                                }
                            }
                    )

                    alert.showAndWait()
                }
            }
        }

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
        randomizeBox.children += Separator(Orientation.HORIZONTAL)
        randomizeBox.children += Label("Number to Output").apply {
            maxWidth = Double.MAX_VALUE
            alignment = Pos.CENTER
        }
        randomizeBox.children += randomizeSpinner.apply {
            maxWidth = Double.MAX_VALUE
        }

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

        HBox.setHgrow(mainListBox, Priority.ALWAYS)
        HBox.setHgrow(selectedListBox, Priority.ALWAYS)
        HBox.setHgrow(resultListBox, Priority.ALWAYS)

        mainListBox.children.addAll(makeLabel("Filtered Minigames"), mainListView.settings())
        selectedListBox.children.addAll(makeLabel("Selected Minigames"), selectedListView.settings())
        resultListBox.children.addAll(makeLabel("Result"), resultListView.settings())

        centreBox.children.addAll(mainListBox, addRemoveBox, selectedListBox, randomizeBox, resultListBox)

        bottomBox.children += BorderPane().apply {
            top = Label("Game Installments")
            center = installmentListView.apply {
                Installment.VALUES.forEach {
                    this.items.add(it)
                }
                cellFactory = CheckBoxListCell.forListView({ installment ->
                    SimpleBooleanProperty(true).apply {
                        addListener { _, _, new ->
                            if (new) {
                                selectedInstallments.add(installment)
                            } else {
                                selectedInstallments.remove(installment)
                            }
                            updateMainList()
                        }
                    }
                }, object : StringConverter<Installment>() {
                    override fun toString(obj: Installment): String {
                        return obj.gameName
                    }

                    override fun fromString(string: String): Installment {
                        return Installment.valueOf(string)
                    }
                })
            }
        }
        bottomBox.children += Separator(Orientation.VERTICAL)
        bottomBox.children += VBox().apply {
            children += sideGamesCheckbox.apply {
                onAction = EventHandler { _ ->
                    updateMainList()
                }
            }
            alignment = Pos.CENTER
        }
        bottomBox.children += Separator(Orientation.VERTICAL)
        bottomBox.children += BorderPane().apply {
            top = Label("Input Types")
            center = inputTypeListView.apply {
                InputType.values().forEach {
                    this.items.add(it)
                }
                cellFactory = CheckBoxListCell.forListView({ inputType ->
                    SimpleBooleanProperty(true).apply {
                        addListener { _, _, new ->
                            if (new) {
                                selectedInputTypes.add(inputType)
                            } else {
                                selectedInputTypes.remove(inputType)
                            }
                            updateMainList()
                        }
                    }
                }, object : StringConverter<InputType>() {
                    override fun toString(obj: InputType): String {
                        return obj.title
                    }

                    override fun fromString(string: String): InputType {
                        return InputType.valueOf(string)
                    }
                })
            }
        }

        addButton.onAction = EventHandler { _ ->
            val item = mainListView.selectionModel.selectedItem ?: return@EventHandler

            mainList -= item
            selectedList += item
            updateMainList()
        }
        removeButton.onAction = EventHandler { _ ->
            val item = selectedListView.selectionModel.selectedItem ?: return@EventHandler

            selectedList -= item
            mainList += item
            updateMainList()
        }
        addAllButton.onAction = EventHandler { _ ->
            if (mainList.isNotEmpty()) {
                selectedList.addAll(mainList)
                mainList.clear()
                updateMainList()
            }
        }
        removeAllButton.onAction = EventHandler { _ ->
            if (selectedList.isNotEmpty()) {
                mainList.addAll(selectedList)
                selectedList.clear()
                updateMainList()
            }
        }
        randomizeButton.onAction = EventHandler { _ ->
            resultList.clear()

            if (selectedList.isNotEmpty()) {
                val num = randomizeSpinner.value
                resultList.addAll(selectedList.shuffled().take(num))
            }
            updateMainList()
        }

        updateMainList()
    }

    fun updateMainList() {
        mainList.clear()
        mainList.addAll(GameRegistry.backingMap.values
                .filter { it !in selectedList }
                .filter { minigame ->
                    minigame.installments.any { it in selectedInstallments }
                }
                .filter { minigame ->
                    !minigame.sideGame || (minigame.sideGame && sideGamesCheckbox.isSelected)
                }
                .filter { minigame ->
                    minigame.inputTypes.any { it in selectedInputTypes }
                })
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