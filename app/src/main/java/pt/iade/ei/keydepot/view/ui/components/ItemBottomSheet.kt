package pt.iade.ei.keydepot.ui.components.gamedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.keydepot.model.StoreItem
import pt.iade.ei.keydepot.repository.SampleData

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
fun PreviewBottomSheet() {
    ItemBottomSheet(SampleData.games.first().items.first()) {}
}
