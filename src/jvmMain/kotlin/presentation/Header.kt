package presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Row(modifier = Modifier.height(150.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource("logo_short.svg"), contentDescription = null, modifier = Modifier.height(60.dp).padding(end = 10.dp))
        Text("Speiseplan", style = TextStyle(fontSize = 30.sp), fontWeight = FontWeight.Bold, color = White)
    }
}
