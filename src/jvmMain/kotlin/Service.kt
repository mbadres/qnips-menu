import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request


data class Menu(
    @JsonProperty("Allergens") val allergens: Map<String, Allergen>,
    @JsonProperty("Products") val products: Map<String, Product>,
    @JsonProperty("Rows") val rows: Array<Row>
)

data class Allergen(
    @JsonProperty("Id") val id: String,
    @JsonProperty("Label") val label: String
)

data class Product(
    @JsonProperty("AllergenIds") val AllergenIds: Array<String>,
    @JsonProperty("ProductId") val id: Int,
    @JsonProperty("Name") val name: String,
    @JsonProperty("Price") val price: Price
)

data class Price(
    @JsonProperty("Betrag") val amount: Double
)

data class Row(
    @JsonProperty("Name") val name: String,
    @JsonProperty("Days") val days: Array<Day>
)

data class Day(
    @JsonProperty("Weekday") val weekday: Int,
    @JsonProperty("ProductIds") val productIds: Array<ProductId>
)

data class ProductId(
    @JsonProperty("ProductId") val productId: Int
)

fun getMenu(): Menu {

    val baseUrl = "https://my.qnips.io/dbapi/ha/"

    val request = Request
        .Builder()
        .url(baseUrl)
        .get()
        .build()

    val result = OkHttpClient()
        .newCall(request)
        .execute()
        .body!!
        .string()

    return jacksonObjectMapper().readValue(result)
}
