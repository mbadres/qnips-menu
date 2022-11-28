package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.getMenu

private val paddingModifier = Modifier
    .background(Transparent)
    .padding(5.dp)

private val headModifier = Modifier
    .background(White)
    .width(200.dp)
    .height(50.dp)
    .padding(5.dp)

private val tileModifier = Modifier
    .background(White)
    .width(200.dp)
    .height(150.dp)
    .padding(5.dp)

@Composable
fun Main() {

    val menu = getMenu()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = paddingModifier) { Text("", modifier = Modifier.width(200.dp).height(50.dp).padding(5.dp)) }
            Box(modifier = paddingModifier) { Text("Montag", modifier = headModifier) }
            Box(modifier = paddingModifier) { Text("Dienstag", modifier = headModifier) }
            Box(modifier = paddingModifier) { Text("Mittwoch", modifier = headModifier) }
            Box(modifier = paddingModifier) { Text("Donnerstag", modifier = headModifier) }
            Box(modifier = paddingModifier) { Text("Freitag", modifier = headModifier) }
        }

        for (row in menu.rows) {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(modifier = paddingModifier) {
                    Text(row.name, modifier = tileModifier)
                }

                for (day in row.days) {
                        for (productId in day.productIds) {

                            val product = menu.products[productId.productId.toString()]

                            if (product == null) {
                                Box(modifier = paddingModifier) {
                                    Text("", modifier = tileModifier)
                                }
                            } else {
                                Box(modifier = paddingModifier) {
                                    Row(modifier = tileModifier) {
                                        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                                            Column {
                                                Text(product.name, style = TextStyle(fontWeight = FontWeight.Bold))
                                            }
                                            Column {
                                                Text(
                                                    product.price.amount
                                                        .toString()
                                                        .replace(".", ",")
                                                        .padEnd(4, '0') + " €"
                                                )
                                                Text("")
                                                Text("Allergene", style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic))
                                                Row {
                                                    for (allergenId in product.AllergenIds) {
                                                        val allergen = menu.allergens[allergenId]
                                                        if (allergen != null) {
                                                            Text(allergen.label, style = TextStyle(fontSize = 14.sp, fontStyle = FontStyle.Italic))
                                                            Text(" ")
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
}
