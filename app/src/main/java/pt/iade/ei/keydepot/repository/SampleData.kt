package pt.iade.ei.keydepot.repository

import pt.iade.ei.keydepot.R
import pt.iade.ei.keydepot.model.Game
import pt.iade.ei.keydepot.model.StoreItem

object SampleData {

    val games = listOf(
        Game(
            id = "g1",
            title = "Sid Meier’s Civilization® VI",
            subtitle = "Expanda seu império, avance sua cultura e vá de encontro aos maiores líderes da história. Será que sua civilização sobreviverá ao teste do tempo?",
            coverRes = R.drawable.civilization_iv_banner,
            items = listOf(
                StoreItem(
                    id = "g1i1",
                    name = "Dragon Sword",
                    description = "Espada lendária que aumenta +50 ATK.",
                    price = 4.99,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g1i2",
                    name = "XP Boost (7 dias)",
                    description = "Aumenta XP ganho por 7 dias.",
                    price = 2.99,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g1i3",
                    name = "Skin Phantom",
                    description = "Skin exclusiva com efeito brilhante.",
                    price = 1.99,
                    iconRes = android.R.drawable.ic_menu_info_details
                )
            )
        ),
        Game(
            id = "g2",
            title = "Vampire Survivors",
            subtitle = "Acabe com milhares de criaturas noturnas e sobreviva até o amanhecer!",
            coverRes = R.drawable.vampire_survivors_banner,
            items = listOf(
                StoreItem(
                    id = "g2i1",
                    name = "Fleet Pack",
                    description = "5 naves de elite para dominar o espaço.",
                    price = 6.99,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g2i2",
                    name = "Resource Pack",
                    description = "10.000 créditos de recursos.",
                    price = 3.49,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g2i3",
                    name = "Commander Skin",
                    description = "Skin especial do comandante.",
                    price = 2.49,
                    iconRes = android.R.drawable.ic_menu_info_details
                )
            )
        ),
        Game(
            id = "g3",
            title = "Resident Evil Village",
            subtitle = "Vivencie o horror de sobrevivência como nunca na 8ª sequência parte da franquia Resident Evil - Resident Evil Village.",
            coverRes = R.drawable.residentevil_village_banner,
            items = listOf(
                StoreItem(
                    id = "g3i1",
                    name = "Fleet Pack",
                    description = "5 naves de elite para dominar o espaço.",
                    price = 6.99,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g3i2",
                    name = "Resource Pack",
                    description = "10.000 créditos de recursos.",
                    price = 3.49,
                    iconRes = android.R.drawable.ic_menu_info_details
                ),
                StoreItem(
                    id = "g3i3",
                    name = "Commander Skin",
                    description = "Skin especial do comandante.",
                    price = 2.49,
                    iconRes = android.R.drawable.ic_menu_info_details
                )
            )
        )
    )
}
