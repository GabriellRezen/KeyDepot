package pt.iade.ei.keydepot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: String,
    val title: String,
    val subtitle: String,
    val coverRes: Int,
    val items: List<StoreItem>
) : Parcelable


