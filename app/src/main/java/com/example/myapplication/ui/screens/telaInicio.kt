package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.Categoria
import com.example.myapplication.model.Produto
import org.intellij.lang.annotations.JdkConstants

@Preview
@Composable
fun telaInicio() {

    val categorias = listOf<Categoria>(
        Categoria("Cerveja", R.drawable.sports_bar_24dp_e3e3e3_fill0_wght400_grad0_opsz24, Color(0xFF29B6F6)),
        Categoria("Vinho", R.drawable.wine_bar_24, Color(0xFF7E57C2)),
        Categoria("Destilada", R.drawable.liquor_24, Color(0xFFFF7043)),
        Categoria("Gelo", R.drawable.ice_24, Color(0xFF66BB6A)),
        Categoria("Refrigerante", R.drawable.water_full_24dp_e3e3e3_fill0_wght400_grad0_opsz24, Color(0xFF8D6E63))
    )

    val produtos = listOf<Produto>(
        Produto("Puro Malte", "350ml", "4,90", R.drawable.puro_malte),
        Produto("Vinho Tinto", "750ml", "32,90", R.drawable.vinho),
        Produto("Energético", "2L", "22,90", R.drawable.energetico)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFECECEC),
        bottomBar = {
            BarraDeNavegacaoInferior()
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                EnderecoComponente()
                IconeNotificacoes()
            }

            Spacer(Modifier.height(16.dp)) // era 40.dp

            BarraPesquisa()

            Spacer(Modifier.height(16.dp)) // era 20.dp

            ListaCategorias(categorias)

            Spacer(Modifier.height(20.dp)) // era 30.dp

            cardDeDesconto()

            Spacer(modifier = Modifier.height(16.dp)) // era 30.dp

            ListaMaisPedidos(produtos)
        }
    }
}

@Composable
fun EnderecoComponente() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_location_on_24),
            contentDescription = "Ícone de endereço de entrega",
            tint = Color(16, 129, 225)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(modifier = Modifier.clickable{}) {

            Text(
                text = "ENTREGAR EM",
                fontSize = 12.sp,
                color = Color(164, 158, 160),
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "R. Fiar Longo, 123",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun IconeNotificacoes() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .padding(end = 4.dp)
            .size(48.dp)
            .background(Color(255,255,255), shape = CircleShape)
            .border(1.dp,Color.LightGray, shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.notifications_24dp),
            contentDescription = "Ícone de notificações",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun BarraPesquisa() {
    var texto by remember { mutableStateOf("") }

    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = "Buscar cerveja, vinho, gelo, cachaça...",
                color = Color(164, 158, 160)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_24),
                contentDescription = "Ícone de pesquisa",
                tint = Color.Black
            )
        },
        shape = RoundedCornerShape(28.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        singleLine = true
    )
}

@Composable
fun ListaCategorias(categorias: List<Categoria>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(categorias) {categoria ->
            ItemCategoria(categoria)
        }
    }
}

@Composable
fun ItemCategoria(categoria: Categoria) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(70.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(48.dp)
                .background(Color(255,255,255), shape = CircleShape)
                .border(2.dp,categoria.cor, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = categoria.icone),
                contentDescription = "Icone categoria",
                tint = categoria.cor,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = categoria.nome,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            color = Color(164, 158, 160)
        )
    }
}

@Composable
fun cardDeDesconto() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFF7043),
                        Color(0xFFFFAB91)
                    )
                )
            )
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(
                text = "Frete Grátis",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "em pedidos acima de R$60",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Text(
            text = "%",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun ListaMaisPedidos(produtos: List<Produto>) {
    Column {
        Text(
            text = "Mais pedidos por aqui",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(produtos) { produto ->
                CardProduto(produto)
            }
        }
    }
}

@Composable
fun CardProduto(produto: Produto) {
    Box(
        modifier = Modifier
            .width(140.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(bottom = 8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = produto.imagem),
                contentDescription = produto.nome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(12.dp),
                contentScale = ContentScale.Fit
            )

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(
                    text = produto.nome,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = produto.volume,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = produto.preco,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp, bottom = 4.dp)
                .size(24.dp)
                .background(Color(0xFFFF7043), shape = CircleShape)
                .clickable {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_24),
                contentDescription = "Adicionar",
                tint = Color.Black,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}

@Composable
fun BarraDeNavegacaoInferior() {
    var itemSelecionado by remember { mutableStateOf(0) }

    val itens = listOf<Triple<String, Int, Int>>(
        Triple("Início", R.drawable.home_24, 0),
        Triple("Buscar", R.drawable.search_24, 1),
        Triple("Pedidos", R.drawable.list_24, 2),
        Triple("Perfil", R.drawable.person_24dp_e3e3e3_fill0_wght400_grad0_opsz24, 3)
    )

    NavigationBar (
        containerColor = Color.White
    ) {
        itens.forEach { (nome, icone, index) ->
            NavigationBarItem(
                selected = itemSelecionado == index,
                onClick = { itemSelecionado = index },
                icon = {
                    Icon(painter = painterResource(id = icone), contentDescription = nome)
                },
                label = {
                    Text(text = nome)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}