package pt.iade.ei.keydepot.view.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.model.StoreItem
import pt.iade.ei.keydepot.repository.SampleData
import pt.iade.ei.keydepot.ui.components.gamedetail.ItemBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game) {
    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf<StoreItem?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (selectedItem != null) {
        ModalBottomSheet(
            sheetState = sheetState,
            containerColor = Color(0xFF171A21),
            onDismissRequest = { selectedItem = null }
        ) {
            ItemBottomSheet(
                item = selectedItem!!,
                onBuy = {
                    Toast.makeText(
                        context,
                        "Comprou ${selectedItem!!.name} por €${selectedItem!!.price}",
                        Toast.LENGTH_LONG
                    ).show()
                    selectedItem = null
                }
            )
        }
    }

    Scaffold(
        topBar = { GameTopBar(game.title) },
        containerColor = Color(0xFF1B2838)
    ) { padding ->

        LazyColumn(
            modifier = Modifier.padding(padding).padding(16.dp)
        ) {
            item { GameHeader(game) }
            item { SectionTitle("Itens Compráveis") }

            items(game.items) { item ->
                ItemRow(item) { selectedItem = item }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewGameDetailScreen() {
    GameDetailScreen(SampleData.games.first())
}

