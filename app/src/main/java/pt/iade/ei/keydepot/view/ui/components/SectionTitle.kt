package pt.iade.ei.keydepot.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 26.sp),
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSectionTitle() {
    Box(modifier = Modifier.background(Color(0xFF1B2838))) {
        SectionTitle("Itens Compráveis")
    }
}

