package pt.iade.ei.keydepot.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.repository.SampleData

@Composable
fun GameHeader(game: Game) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp)
    ) {
        Image(
            painter = painterResource(id = game.coverRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp).clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = game.subtitle,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 16.dp.value.sp
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameHeader() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        GameHeader(SampleData.games.first())
    }
}
