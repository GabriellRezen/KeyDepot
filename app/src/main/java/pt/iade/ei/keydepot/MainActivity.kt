package pt.iade.ei.keydepot

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.repository.SampleData
import pt.iade.ei.keydepot.ui.theme.KeyDepotTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val games = SampleData.games

        setContent {
            MainScreen(games)
        }
    }
}

@Composable
fun MainScreen(games: List<Game>) {
    Scaffold (
        bottomBar = {BottomBar() },
        containerColor = Color(0xFF1B2838)
    ) { padding ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF1B2838)))
        {
            TopBar()
            Tittle()
            GameList(games)
        }
    }
}

@Composable
fun TopBar() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1B2838))
            .padding(16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(26.dp)
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Settings,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(26.dp)
        )
    }
}

@Composable
fun Tittle() {
    Text(
        text = "KeyDepot",
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .padding(start = 18.dp, bottom = 16.dp),
        color = Color(0xFFC6D4DF)
    )
}

@Composable
fun GameList(games: List<Game>) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1B2838))
            .padding(horizontal = 12.dp)
    ) {
        items(games) { game ->
            GameCard(game) {
                val intent = Intent(context, GameDetailActivity::class.java)
                intent.putExtra("gameIndex", SampleData.games.indexOf(game))
                context.startActivity(intent)
            }
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
        }
    }
}

@Composable
fun GameCard(game: Game, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(Color(0xFF1B2838))
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = game.coverRes),
                contentDescription = game.title,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(alpha = 0.35f)
                    )
            )
            Text(
                text = game.title,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}

@Composable
fun BottomBar() {
    NavigationBar (containerColor = Color(0xFF171A21)) {

        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(Icons.Outlined.Star,
                    contentDescription = null ) },
            label = { Text("Destaques") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF66C0F4)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(painter = painterResource(R.drawable.outline_archive_24),
                    contentDescription = null ) },
            label = { Text("Histórico") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF66C0F4)
            )
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(Icons.Outlined.Person,
                    contentDescription = null ) },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White,
                indicatorColor = Color(0xFF66C0F4)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MainScreen(games = SampleData.games)
}

@Preview(showBackground = true)
@Composable
fun PreviewGameCard() {
    val game = SampleData.games.first()
    GameCard(game = game, onClick = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewGameListScreen(){
    val games = SampleData.games
    GameList(games = games)
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopBar()
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomBar() {
    BottomBar()
}

@Preview(showBackground = true)
@Composable
fun PreviewTitle() {
    Tittle()
}