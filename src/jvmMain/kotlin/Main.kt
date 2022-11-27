import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {

    val menu = getMenu()

    application {
        Window(onCloseRequest = ::exitApplication) {
            app()
        }
    }
}
