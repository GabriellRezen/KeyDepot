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
import androidx.compose.ui.text.style.TextOverflow


class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = intent.getParcelableExtra<Game>("game") ?: return

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
            sheetState = sheetState,
            containerColor = Color(0xFF171A21),
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
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B2838),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = {
                    Text(text = game.title, fontSize = 20.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { (context as? ComponentActivity)?.finish() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorito"
                        )
                    }
                }
            )
        },
        containerColor = Color(0xFF1B2838)
    ) { innerPadding ->

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            item {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = game.coverRes),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(0.65f)
                        .aspectRatio(16f / 9f)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier
                    .width(16.dp))

                Text(
                    text = game.subtitle,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
        }

        item {
            Text(
                text = "Itens Compráveis",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }

        items(game.items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedItem = item }
                    .padding(vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        item.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                    Text(
                        item.description,
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp),
                        color = Color(0xFFD4D4d4),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    "$${item.price}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }
            }
        }
    }
}

@Composable
fun BottomSheetContent(item: StoreItem, onBuy: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
            .background(Color(0xFF171A21))
    ) {
       Row (verticalAlignment = Alignment.CenterVertically) {

           Image(
               painter = painterResource(item.iconRes),
               contentDescription = item.name,
               modifier = Modifier
                   .size(110.dp)
                   .clip(RoundedCornerShape(12.dp)),
               contentScale = ContentScale.Crop
           )

           Spacer(modifier = Modifier.width(16.dp))

           Column {
               Text(
                   text = item.name,
                   color = Color.White,
                   style = MaterialTheme.typography.titleLarge
               )
               Text(
                   text = item.description,
                   color = Color.White,
                   style = MaterialTheme.typography.bodyMedium
               )
           }
       }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$${item.price}",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = onBuy,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF66C0F4),
                    contentColor = Color.Black
                )
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