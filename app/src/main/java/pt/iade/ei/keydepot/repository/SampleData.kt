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
            coverRes = R.drawable.civilization_vi_banner,
            items = listOf(
                StoreItem(
                    id = "g1i1",
                    name = "Sid Meier's Civilization® VI: New Frontier Pass",
                    description = "Continue sua missão para construir o seu maior império com o Civilization VI - Passe Nova Fronteira, que incluí oito civilizações inéditas e nove líderes novos, além de uma variedade de novos conteúdos de jogo, incluindo seis modos novos. " +
                            "O Passe Nova Fronteira inclui: \nPacote 1: Pacote Maia e Grande Colômbia.\nPacote 2: Pacote Etiópia.\nPacote 3: Pacote Bizâncio e Gália.\nPacote 4: Pacote Babilônia.\nPacote 5: O Pacote Vietnã e Kublai Khan\nPacote 6: O Pacote Portugal",
                    price = 39.99,
                    iconRes = R.drawable.civilizationvi_newfrontierpass_banner
                ),
                StoreItem(
                    id = "g1i2",
                    name = "Sid Meier's Civilization® VI: Gathering Storm",
                    description = "Em Gathering Storm, a segunda expansão de Civilization VI, o mundo ao seu redor está mais vivo do que nunca.\n" +
                            "\n" +
                            "Você deve traçar um caminho para a vitória desenvolvendo novas tecnologias avançadas e projetos de engenharia, além de negociar assuntos críticos com a comunidade global no Congresso Mundial.\n" +
                            "\n" +
                            "As escolhas que você faz no jogo influenciarão o ecossistema do mundo e podem impactar o futuro de todo o planeta. Desastres naturais como inundações, tempestades e vulcões podem consumir recursos ou destruir suas melhorias e seus distritos — mas também podem renovar e enriquecer as terras depois que passarem.\n" +
                            "\n" +
                            "Além desses novos sistemas, Civilization VI: Gathering Storm apresenta oito civilizações e nove líderes novos. Há sete novas maravilhas do mundo para serem construídas, além de uma variedade de novas unidades, distritos, edificações e melhorias.",
                    price = 39.99,
                    iconRes = R.drawable.civilization_vi_gatheringstorm_banner
                ),
                StoreItem(
                    id = "g1i3",
                    name = "Sid Meier’s Civilization® VI: Rise and Fall",
                    description = "Expansão Rise and Fall traz novas escolhas, estratégias e desafios para jogadores enquanto conduzem uma civilização pelas eras. Você é capaz de inspirar a lealdade do povo ao redor do mundo ou perderá cidades aos seus rivais? Você estabelecerá uma Era de Ouro para a sua civilização ou a atolará em uma Idade das Trevas? Em Civilization VI: Rise and Fall, você realmente se torna um líder para as eras.\n" +
                            "\n" +
                            "A liderança bem-sucedida de uma civilização pode mandá-la para uma Era de Ouro próspera, mas ficar para trás pode conduzi-la a uma Idade das Trevas. Reaja bem aos desafios de uma Idade das Trevas e a sua civilização pode se erguer revitalizada com uma Era Heroica.\n" +
                            "\n" +
                            "Encoraje a lealdade dos seus cidadãos para manter suas fronteiras intactas, ou inspire lealdade entre outras civilizações para expandir o seu império. As fronteiras do mundo mudam constantemente à medida que cidades livres emergem de impérios, e vizinhos disputam a lealdade de cidades espalhadas pelo mapa.\n" +
                            "\n" +
                            "Como o novo sistema de governador, jogadores podem personalizar e especializar suas cidades ainda mais, além de reagir aos novos desafios de Idades das Trevas e lealdade. Cada um dos sete governadores exclusivos tem sua própria árvore de promoção, que se dedica a diferentes estilos de jogo e estratégias.\n" +
                            "\n" +
                            "Além desses novos sistemas, Civilization VI: Rise and Fall introduz oito civilizações novas e nove líderes novos. Oito maravilhas do mundo novas podem ser construídas, além de uma variedade de novas unidades, distritos, edificações e melhorias. Há mais jeitos do que nunca de se construir, conquistar e inspirar.",
                    price = 29.99,
                    iconRes = R.drawable.civilization_vi_riseandfall_banner
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
                    name = "Vampire Survivors: Ode to Castlevania",
                    description = "Os sobreviventes percorreram um longo caminho em sua honrosa caçada e, após unirem forças com a Família Belmont, estão mais próximos do que nunca. Finalmente, ao seu alcance... Um vampiro. É o que parece, pelo menos.\n" +
                            "\n" +
                            "O sol se pôs no Castelo do Drácula mais uma vez e, quando a lua surge, uma horda infernal de homens de lama sombrios, fantasmas horripilantes e homens pulguentos pavorosos entra em cena para travar a batalha entre o bem e o mal outra vez. Use um arsenal de novas armas destruidoras de vampiros contra essas feras e deixe um rastro de destruição antes de tentar livrar o mundo do terror indescritível. Não se deixe cegar pela sombra que paira sobre vocês, Sobreviventes, pois a missão está apenas começando! Tudo é muito sério, então aumente o volume e vamos lá! Castlevania em Vampire Survivors, baby!",
                    price = 3.99,
                    iconRes = R.drawable.vampire_survivors_castelvania_banner
                ),
                StoreItem(
                    id = "g2i2",
                    name = "Vampire Survivors: Operation Guns",
                    description = "Você sobrevive bem o suficiente para conseguir salvar o cachorro da irmã da prima do presidente das mãos do esquadrão de traidores Red Falcon? Junte-se à força Contra e não fique de fora de mais uma aventura apocalíptica em Vampire Survivors: Operation Guns.\n" +
                            "\n" +
                            "Reúna um esquadrão de personagens clássicos e arme-se com um arsenal explosivo de armas de fliperama nesta nova expansão cheia de ação do Vampire Survivors. Enfrente milhares de inimigos assustadores e chefes absurdos dos renomados jogos Contra. Resista com garra às fases incríveis inspiradas na icônica série da Konami, mas prepare-se para a chuva de balas: se você não tiver força no gatilho, a Terra pode não ter um futuro.\n" +
                            "\n" +
                            "Operação Armas reúne a simplicidade visceral do clássico Contra com personagens que permitem uma composição otimizada, diveeersas armas (22, incluindo evoluções!) e uma curva de aprendizado que junta a dificuldade dos fliperamas com a fórmula do Vampire Survivors.",
                    price = 2.49,
                    iconRes = R.drawable.vampire_survivors_guns_banner
                ),
                StoreItem(
                    id = "g2i3",
                    name = "Vampire Survivors: Emergency Meeting",
                    description = "Os sobreviventes estão loucos para caçar vampiros, mas estão ficando sem ter onde procurar. Só resta uma opção: ser uma chuva de balas... no espaço!\n" +
                            "\n" +
                            "Reúna seus tripulantes mais confiáveis, prepare-se para ejetar impostores e tente sobreviver enquanto acaba com milhares de inimigos extraterrestres na mais nova expansão do Vampire Survivors. Transforme as tarefas clássicas de Among Us em armas mortíferas, melhorando suas habilidades após cada partida para vencer obstáculos impossíveis com facilidade. Cuide para não cair em armadilhas ao explorar a vasta estranheza da Réplica de Polus e fique alerta, pois olhos suspeitos estão sempre observando \uD83D\uDC40.",
                    price = 2.49,
                    iconRes = R.drawable.vampire_survivors_emergency_banner
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
                    name = "Resident Evil Village - Expansão de Winters",
                    description = "Vivencie novos conteúdos adicionais da premiada obra-prima do terror moderno, Resident Evil Village:\n" +
                            "\n" +
                            "- Modo em terceira pessoa: jogue a história principal de uma perspectiva inteiramente nova.\n" +
                            "- Os Mercenários: Ordens Adicionais: três novos personagens se juntam ao combate, incluindo a gigantesca Lady Dimitrescu, que agora é jogável pela primeira vez.\n" +
                            "- Sombras de Rose: um novo cenário estrelando uma já crescida Rose, a amada filha de Ethan, cujo rapto quando bebê começou a história original de Village.",
                    price = 19.99,
                    iconRes = R.drawable.residentevil_village_winters_banner
                ),
                StoreItem(
                    id = "g3i2",
                    name = "Resident Evil Village - Pacote Trauma",
                    description = "Anos após os eventos trágicos na Louisiana, Ethan tenta seguir em frente. Reavive as lembranças traumáticas de seu passado com estes itens.\n" +
                            "\n" +
                            "Inclui artigos como a arma \"Samurai Edge\", o acessório \"Sr. Onipresente\", um filtro de tela, música de fundo especial do abrigo e muitos outros itens que ajudam a desvendar o passado de Ethan.",
                    price = 12.99,
                    iconRes = R.drawable.residentevil_village_trauma_bunner
                ),
                StoreItem(
                    id = "g3i3",
                    name = "Resident Evil Village Original Soundtrack",
                    description = "Reviva os horrores da vila em uma experiência sonora arrepiante com a trilha sonora original de Resident Evil Village!\n" +
                            "\n" +
                            "25 faixas sinistras aguardam você, incluindo a música que alivia a tensão ao salvar o jogo e um tema final que certamente deixará uma impressão duradoura.",
                    price = 14.99,
                    iconRes = R.drawable.residentevil_village_soundtrack_banner
                )
            )
        )
    )
}
