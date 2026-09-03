# Delivery de Bebidas

Aplicativo mobile de **delivery de bebidas**, desenvolvido como trabalho acadêmico para a disciplina de **Desenvolvimento de Aplicativos Móveis**.

O projeto tem como objetivo aplicar, na prática, conceitos de desenvolvimento mobile, criação de interfaces, navegação entre telas, gerenciamento de dados e implementação de funcionalidades comuns em aplicativos de delivery.

---

### Objetivos

* Desenvolver uma aplicação mobile funcional;
* Aplicar conceitos apresentados na disciplina;

---

## Desenvolvimento no Figma

Em anexo estará o link para visualizar o board onde foi desenvolvido a UI das seguintes 5 telas:

* Tela de Inicio
* Tela do Produto
* Tela do Carrinho
* Tela do Pagamento
* Tela de Verificação do pedido

https://www.figma.com/design/FGavv6Oe5wV3DbMC6QftjL/atividade-android?node-id=0-1&t=4b5kjobzLUZ87pgu-1

---

## Canvas: por que esse aplicativo existe?

**Qual problema esse aplicativo resolve? Para quem ele é?**

O app resolve o problema de comprar bebida em cima da hora, quando o usuário já decidiu o que quer e precisa que chegue rápido, sem ter que sair de casa ou ir a um mercado físico.

**Por que alguém abriria esse aplicativo hoje? E por que abriria de novo amanhã?**

Hoje, abriria porque percebeu que está faltando bebida para um evento próximo e precisa resolver rápido. Abriria de novo amanhã se a experiência de pedir tiver sido simples e rápida da primeira vez.

**Qual é a única coisa que o aplicativo precisa fazer bem para "funcionar" na cabeça de quem usa?**

Dar confiança de que o pedido vai chegar rápido e no lugar certo.

**Se fosse um produto de verdade, como ele geraria valor ou dinheiro?**

De forma hipotética, por comissão sobre cada pedido repassada aos estabelecimentos parceiros, por taxa de entrega no checkout, e por destaque pago de produtos, um espaço que fornecedores poderiam pagar para aparecer, parecido com o modelo de outros apps de delivery.

**Quais decisões de tela vieram dessas respostas?**

Por isso a tela inicial mostra a categoria e os produtos mais pedidos, o usuário já sabe o que quer, então a prioridade é reduzir cliques até o carrinho, não apresentar o app. Pelo mesmo motivo, a tela de rastreio expõe o tempo estimado de chegada em destaque em vez de detalhes menos urgentes como o histórico completo do pedido.

---

## Tecnologias Utilizadas

* **Linguagem:** [Kotlin]
* **IDE:** Android Studio
* **Plataforma:** Android
* **Interface:** [Jetpack Compose]

---

## Estrutura do Projeto

```text
app/
├── build/
├── src/
│   ├── androidTest/
│   └── main/
│       ├── java/
│       │   └── com/example/myapplication/
│       │       ├── model/
│       │       │   ├── Categoria
│       │       │   ├── EstadoEtapa
│       │       │   └── Produto
│       │       ├── ui/
│       │       │   ├── screens/
│       │       │   │   ├── TelaInicio.kt
│       │       │   │   ├── TelaProduto.kt
│       │       │   │   └── TelaRastreio.kt
│       │       │   └── theme/
│       │       └── MainActivity.kt
│       ├── keepRules/
│       └── res/
│           ├── drawable/
│           ├── mipmap-anydpi-v26/
│           ├── mipmap-hdpi/
│           ├── mipmap-mdpi/
│           └── mipmap-xhdpi/
│
├── build.gradle
└── ...
```

---

## Como Executar

### Pré-requisitos

Para executar o projeto, é necessário ter instalado:

* [Android Studio](https://developer.android.com/studio)
* Android SDK compatível com o projeto;
* JDK compatível com a versão utilizada pelo projeto.

### Instalação

1. Clone este repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

2. Abra o projeto no **Android Studio**.

3. Aguarde o Gradle sincronizar e baixar as dependências necessárias.

4. Conecte um dispositivo Android ou inicialize um emulador.

5. Execute o projeto pelo botão **Run ▶** do Android Studio.

---

## Licença

Este projeto foi desenvolvido para fins acadêmicos e não possui finalidade comercial.
