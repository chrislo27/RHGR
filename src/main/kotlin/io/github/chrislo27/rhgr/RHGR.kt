package io.github.chrislo27.rhgr

import com.eclipsesource.json.Json
import io.github.chrislo27.rhgr.util.Logger
import io.github.chrislo27.rhgr.util.Version
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import jodd.http.HttpRequest
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class RHGR : Application() {

    companion object {

        val LOGGER: Logger = Logger()
        val VERSION: Version = Version(1, 0, 0, "DEVELOPMENT")
        const val TITLE = "Rhythm Heaven Game Randomizer"
        const val RELEASE_API_URL = "https://api.github.com/repos/chrislo27/RHGR/releases/latest"
        const val GITHUB = "https://github.com/chrislo27/RHGR"
        const val LATEST_RELEASE = "https://github.com/chrislo27/RHGR/releases/latest"
        var githubVersion: Version = Version.RETRIEVING
            private set

        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(RHGR::class.java, *args)
        }
    }

    private lateinit var primaryStage: Stage

    override fun start(primaryStage: Stage) {
        LOGGER.info("Starting $TITLE $VERSION")

        this.primaryStage = primaryStage
        primaryStage.title = "$TITLE $VERSION"
        // TODO set icon

        // Finally, show the stage
        primaryStage.scene = Scene(MainPane(this), 1280.0, 720.0)
        primaryStage.show()

        // Get GitHub version
        launch(CommonPool) {
            try {
                val nano = System.nanoTime()

                val req = HttpRequest.get(RELEASE_API_URL).charset("UTF-8")
                val response = req.send()

                githubVersion = Version.fromStringOrNull(Json.parse(response.bodyText()).asObject().getString("tag_name", "")) ?: Version.UNKNOWN
                LOGGER.info(
                        "Fetched version from GitHub in ${(System.nanoTime() - nano) / 1_000_000f} ms, is $githubVersion")
            } catch (e: Exception) {
                e.printStackTrace()
                githubVersion = Version.UNKNOWN
            }
        }
    }

    override fun stop() {
        super.stop()
        LOGGER.info("Exiting program")
        System.exit(0)
    }
}
