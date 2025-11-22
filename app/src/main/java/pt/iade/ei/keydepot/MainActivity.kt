package pt.iade.ei.keydepot

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.repository.SampleData
import pt.iade.ei.keydepot.ui.theme.KeyDepotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val games = SampleData.games

        setContent {
            GameListScreen(games = games)
        }
    }
}

@Composable
fun GameListScreen(games: List<Game>) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(games) { game ->
            GameCard(game = game, onClick = {
                val intent = Intent(context, GameDetailActivity::class.java)
                intent.putExtra("game",game)
                context.startActivity(intent)
            })
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
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
        ) {
           Row(
               modifier = Modifier.padding(12.dp)
           ) {
               Image(
                   painter = painterResource(id = game.coverRes),
                   contentDescription = game.title,
                   modifier = Modifier
                       .size(90.dp),
                   contentScale = ContentScale.Crop
               )

               Spacer(
                   modifier = Modifier
                       .width(12.dp)
               )

               Column {
                   Text(
                       text = game.title,
                       style = MaterialTheme.typography.titleLarge
                   )
                   Text(
                       text = game.subtitle,
                       style = MaterialTheme.typography.bodyMedium
                   )
               }
           }
        }
    }
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
    GameListScreen(games = games)
}