package pt.iade.ei.keydepot.controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pt.iade.ei.keydepot.repository.SampleData
import pt.iade.ei.keydepot.view.ui.components.GameDetailScreen

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val index = intent.getIntExtra("gameIndex", -1)
        val game = SampleData.games[index]

        setContent {
            GameDetailScreen(game)
        }
    }
}
