package pt.iade.ei.keydepot

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        "Comprou ${selectedItem!!.name} por $${selectedItem!!.price}",
                        Toast.LENGTH_LONG
                    ).show()
                    selectedItem = null
                }
            )
        }
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_media_previous),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { }
                )

                Spacer(modifier = Modifier
                    .width(12.dp))

                Text(
                    text = game.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier
                    .weight(1f))

                Icon(
                    painter = painterResource(id = android.R.drawable.btn_star_big_off),
                    contentDescription = "Favorito",
                    modifier = Modifier
                        .size(26.dp)
                )
            }

            Spacer(modifier = Modifier
                .height(12.dp))
        }

        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color(0xFFE2E2E2))
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .background(Color(0xFFCCCCCC)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Game\nimage", fontSize = 14.sp)
                }

                Spacer(modifier = Modifier
                    .width(16.dp))

                Text(
                    text = game.subtitle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier
                .height(22.dp))
        }

        item {
            Text(
                text = "Itens Compráveis",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier
                .height(12.dp))
        }

        items(game.items) { item ->
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedItem = item }
                    .padding(vertical = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color(0xFFCCCCCC)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Item\nImage", fontSize = 14.sp)
                }

                Spacer(modifier = Modifier
                    .width(12.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(item.name, style = MaterialTheme.typography.titleMedium)
                    Text(
                        item.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2
                    )
                }

                Text(
                    "$${item.price}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            HorizontalDivider()
        }
    }
}

@Composable
fun BottomSheetContent(item: StoreItem, onBuy: () -> Unit) {
    Column (
        modifier = Modifier
            .padding(22.dp)
    ) {
       Row {
           Box(
               modifier = Modifier
                   .size(110.dp)
                   .clip(MaterialTheme.shapes.medium)
                   .background(Color(0xFFCCCCCC)),
               contentAlignment = Alignment.Center
           ) {
               Text("Item\nImage", fontSize = 14.sp)
           }

           Spacer(modifier = Modifier
               .width(16.dp))

           Column {
               Text(
                   text = item.name,
                   style = MaterialTheme.typography.titleLarge
               )
               Text(
                   text = item.description,
                   style = MaterialTheme.typography.bodyMedium
               )
           }
       }

        Spacer(modifier = Modifier
            .height(24.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "$${item.price}",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .weight(1f)
            )
            Button(
                onClick = onBuy,
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Compre com 1-click")
            }
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