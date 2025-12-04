package pt.iade.ei.keydepot.view.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Title() {
    Text(
        text = "KeyDepot",
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 18.dp, bottom = 16.dp),
        color = Color(0xFFC6D4DF)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTitle() {
    Title()
}