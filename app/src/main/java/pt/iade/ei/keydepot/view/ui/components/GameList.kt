package pt.iade.ei.keydepot.view.ui.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pt.iade.ei.keydepot.controller.GameDetailActivity
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.repository.SampleData
import androidx.compose.ui.tooling.preview.Preview

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

            Spacer(Modifier.height(12.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameList() {
    GameList(games = pt.iade.ei.keydepot.repository.SampleData.games)
}