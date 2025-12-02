package pt.iade.ei.keydepot.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.ExperimentalMaterial3Api


class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val index = intent.getIntExtra("gameIndex", -1)

        val game = SampleData.games[index]

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
            ItemBottomSheet(
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
    Scaffold(
        topBar = {
            GameTopBar(game.title) },
        containerColor = Color(0xFF1B2838)
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item { GameHeader(game) }
            item { SectionTitle("Itens Compraveis") }

            items(game.items) { item ->
                ItemRow(item) { selectedItem = item }
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameTopBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1B2838),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        title = {
            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            val context = LocalContext.current
            IconButton(onClick = { (context as? ComponentActivity)?.finish() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Voltar"
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Favorito")
            }
        }
    )
}


@Composable
fun GameHeader(game: Game) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
    ) {
        Image(
            painter = painterResource(id = game.coverRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = game.subtitle,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 16.sp
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 26.sp),
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun ItemRow(item: StoreItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = item.iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(140.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontSize = 17.sp
                )
            )

            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFFD4D4D4),
                    fontSize = 15.sp
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "€${item.price}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align (Alignment.End)
            )
        }
    }
}


@Composable
fun ItemBottomSheet(item: StoreItem, onBuy: () -> Unit) {
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
                   .size(115.dp)
                   .clip(RoundedCornerShape(12.dp)),
               contentScale = ContentScale.Crop
           )

           Spacer(modifier = Modifier.width(16.dp))

           Column {
               Text(
                   text = item.name,
                   color = Color.White,
                   style = MaterialTheme.typography.headlineSmall,
                   fontWeight = FontWeight.Bold
               )
               Text(
                   text = item.description,
                   color = Color.White,
                   style = MaterialTheme.typography.bodyMedium,
                   modifier = Modifier
                       .heightIn(max = 120.dp)
                       .verticalScroll(rememberScrollState())
               )
           }
       }
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "€${item.price}",
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
    GameDetailScreen(SampleData.games.first())
}

@Preview(showBackground = true)
@Composable
fun PreviewGameTopBar() {
    GameTopBar("Sid Meier’s Civilization® VI")
}

@Preview(showBackground = true)
@Composable
fun PreviewHeader() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        GameHeader(SampleData.games.first())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemRow() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        ItemRow(SampleData.games.first().items.first()) {}
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionTitle() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        SectionTitle("Itens Compráveis")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomSheet() {
    Box(modifier = Modifier.background(Color(0xFF171A21))) {
       ItemBottomSheet(SampleData.games.first().items.first()) {}    
    }
}
