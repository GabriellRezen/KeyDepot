package pt.iade.ei.keydepot.model


data class Game(
    val id: String,
    val title: String,
    val subtitle: String,
    val coverRes: Int,
    val items: List<StoreItem>
)


