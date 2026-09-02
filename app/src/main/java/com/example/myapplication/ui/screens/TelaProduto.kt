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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Preview
@Composable
fun TelaProduto() {
    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = Color(0xFFECECEC)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BotaoVoltar()
                    BotaoFavorito()
                }

                Spacer(modifier = Modifier.height(16.dp))

                ImagemProduto()

                Spacer(modifier = Modifier.height(20.dp))

                InformacoesProduto()

                Spacer(modifier = Modifier.height(20.dp))

                SeletorQuantidade()

                Spacer(modifier = Modifier.weight(1f))

                RodapeCompra()
            }
        }
    }
}

@Composable
fun BotaoVoltar() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .size(48.dp)
            .background(Color(255,255,255), shape = CircleShape)
            .border(1.dp, Color.LightGray, shape = CircleShape),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Botão de voltar",
            tint = Color.Black,
        )
    }
}

@Composable
fun BotaoFavorito() {

    var favoritado by remember { mutableStateOf(false) }

    IconButton(
        onClick = {favoritado = !favoritado},
        modifier = Modifier
            .size(48.dp)
            .background(Color.White, shape = CircleShape)
            .border(1.dp, Color.LightGray, shape = CircleShape),
    ) {
        Icon(
            painter = if (favoritado) painterResource(id = R.drawable.favorite_fill24) else painterResource(id = R.drawable.favorite_24),
            contentDescription = "Favoritar produto",
            tint = Color(0xFFE53935),
        )
    }
}

@Composable
fun ImagemProduto() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.puro_malte),
            contentDescription = "Cerveja Puro Malte 350ml",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun InformacoesProduto() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "CERVEJARIA NOTURNA",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5B8DEF)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Cerveja Puro Malte",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TagProduto(texto = "350ml",  color = Color.Gray)
            TagProduto(texto = "4,7% álcool",  color = Color.Gray)
            TagProduto(texto = "sempre gelada", color = Color.Green)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Lager leve e refrescante, com final seco e pouco amargor. Ideal pra abrir a noite.",
            fontSize = 14.sp,
            color = Color(0xFF3D3D3D)
        )
    }
}

@Composable
fun TagProduto(texto: String, color: Color) {
    Box(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(50))
            .border(1.dp, color, shape = RoundedCornerShape(50))
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            text = texto,
            fontSize = 12.sp,
            color = color
        )
    }
}

@Composable
fun SeletorQuantidade() {
    var quantidade by remember { mutableIntStateOf(1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Quantidade",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(50))
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            BotaoQuantidade(
                icone = R.drawable.remove_24,
                descricao = "Diminuir quantidade",
                onClick = { if (quantidade > 1) quantidade-- }
            )

            Text(
                text = "$quantidade",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(32.dp),
                textAlign = TextAlign.Center
            )

            BotaoQuantidade(
                icone = R.drawable.add_24,
                descricao = "Aumentar quantidade",
                onClick = { quantidade++ }
            )
        }
    }
}

@Composable
fun BotaoQuantidade(icone: Int, descricao: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Color(0xFFD6EFFB))
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = icone),
            contentDescription = descricao,
            tint = Color.Black,
            modifier = Modifier.size(14.dp)
        )
    }
}

@Composable
fun RodapeCompra() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "R$ 5,90",
                fontSize = 13.sp,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                text = "R$ 4,90",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7043)),
            modifier = Modifier.width(160.dp)
        ) {
            Text(
                text = "Adicionar ao carrinho",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}