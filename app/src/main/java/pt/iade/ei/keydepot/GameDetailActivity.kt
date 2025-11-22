package pt.iade.ei.keydepot

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.model.StoreItem
import pt.iade.ei.keydepot.repository.SampleData

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = intent.getParcelableExtra<Game>("game")
            ?: return

        setContent {
            GameDetailScreen(game = game)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game : Game) {
    val context = LocalContext.current

    var selectedItem by remember { mutableStateOf<StoreItem?>(null) }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    if (selectedItem != null) {
        ModalBottomSheet(
            onDismissRequest = { selectedItem = null },
            sheetState = sheetState
        ) {
            BottomSheetContent(
                item = selectedItem!!,
                onBuy = {
                    Toast.makeText(
                        context,
                        "Acabou de comprar o item ${selectedItem!!.name} por $${selectedItem!!.price}",
                        Toast.LENGTH_LONG
                    ).show()
                    selectedItem = null
                }
            )
        }
    }

    Column {
        Image(
            painter = painterResource(id = game.coverRes),
            contentDescription = game.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = game.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(12.dp)
        )

        Text(
            text = game.subtitle,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        LazyColumn {
            items(game.items) { item ->
                ListItem(
                    headlineContent = { Text(item.name) },
                    supportingContent = { Text("$${item.price}") },
                    leadingContent = {
                        Image(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = item.name,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    },
                    modifier = Modifier
                        .clickable{ selectedItem = item}
                )
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            }
        }
    }
}

@Composable
fun BottomSheetContent(item: StoreItem, onBuy: () -> Unit) {
    Column (
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            text = item.name,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Button(
            onClick = onBuy,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Compra por $${item.price}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameDetail() {
    GameDetailScreen(game = SampleData.games.first())
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    BottomSheetContent(
        item = SampleData.games.first().items.first(),
        onBuy = {}
    )
}