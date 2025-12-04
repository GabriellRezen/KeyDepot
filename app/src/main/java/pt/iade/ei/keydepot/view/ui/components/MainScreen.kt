package pt.iade.ei.keydepot.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.keydepot.model.Game

@Composable
fun MainScreen(games: List<Game>) {

    Scaffold(
        bottomBar = { BottomBar() },
        containerColor = Color(0xFF1B2838)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF1B2838))
        ) {
            TopBar()
            Title()
            GameList(games)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        MainScreen(games = pt.iade.ei.keydepot.repository.SampleData.games)
    }
}
