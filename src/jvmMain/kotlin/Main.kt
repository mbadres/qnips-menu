import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import presentation.App
import java.awt.Dimension

fun main() {
    application {
        Window(icon = painterResource("icon.svg"), title = "Speiseplan", onCloseRequest = ::exitApplication) {
            window.minimumSize = Dimension(1600, 900)
            App()
        }
    }
}
