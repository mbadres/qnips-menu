package domain

import com.fasterxml.jackson.annotation.JsonProperty

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
