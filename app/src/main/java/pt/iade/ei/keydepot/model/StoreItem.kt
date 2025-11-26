package pt.iade.ei.keydepot.model


data class StoreItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val iconRes: Int = android.R.drawable.ic_menu_info_details
)
