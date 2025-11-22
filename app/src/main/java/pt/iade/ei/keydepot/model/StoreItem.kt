package pt.iade.ei.keydepot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val iconRes: Int = android.R.drawable.ic_menu_info_details
) : Parcelable
