package presentation
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {

    MaterialTheme(typography = Typography()) {

        val modifier = Modifier
            .background(brush = Brush.verticalGradient(colors = listOf(Blue, Green)))
            .padding(50.dp)
            .fillMaxSize()

        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround)
        {
            Column {
                Header()
                Main()
            }
        }
    }
}
