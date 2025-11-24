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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
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
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder


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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B2838))
    ) {

    if (selectedItem != null) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { selectedItem = null }
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
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        item {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Voltar",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable{ (context as? ComponentActivity)?.finish() },
                    tint = Color.White
                )

                Spacer(modifier = Modifier
                    .width(12.dp))

                Text(
                    text = game.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 22.sp)
                )

                Spacer(modifier = Modifier
                    .weight(1f))

                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorito",
                    modifier = Modifier
                        .size( 28.dp),
                    tint = Color.White
                )
            }
        }

        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFF1B2838))
                    .padding(18.dp)
            ) {
                Image(
                    painter = painterResource(id = game.coverRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(110.dp)
                        .clip(RoundedCornerShape(14.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier
                    .width(16.dp))

                Text(
                    text = game.subtitle,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp),
                    modifier = Modifier
                        .weight(1f)

                )
            }

            Spacer(modifier = Modifier
                .height(22.dp))
        }

        item {
            Text(
                text = "Itens Compráveis",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }

        items(game.items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedItem = item }
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier
                        .width(12.dp)
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        item.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Text(
                        item.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        color = Color.White
                    )
                }

                Text(
                    "$${item.price}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    color = Color.White
                )
            }

            HorizontalDivider(thickness = 1.dp)
        }
        }
    }
}

@Composable
fun BottomSheetContent(item: StoreItem, onBuy: () -> Unit) {
    Column (
        modifier = Modifier
            .padding(22.dp)
            .background(Color(0xFF171A21))
    ) {
       Row {
           Box(
               modifier = Modifier
                   .size(110.dp)
                   .clip(MaterialTheme.shapes.medium)
                   .background(Color(0xFF171A21)),
               contentAlignment = Alignment.Center
           ) {
               Text("Item\nImage", fontSize = 14.sp)
           }

           Spacer(modifier = Modifier
               .width(16.dp))

           Column {
               Text(
                   text = item.name,
                   style = MaterialTheme.typography.titleLarge,
                   color = Color.White,
               )
               Text(
                   text = item.description,
                   style = MaterialTheme.typography.bodyMedium,
                   color = Color.White,
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
                color = Color.White,
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