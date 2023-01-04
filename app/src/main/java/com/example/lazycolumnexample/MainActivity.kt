package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.lazycolumnexample.ui.theme.LazyColumnExampleTheme

class MainActivity : ComponentActivity() { // 앱에서 실행시키는 부분
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnExampleTheme {
                Surface(
                    modifier = Modifier, // 속성 정하는거(패딩, 크기 등)
                    color = MaterialTheme.colors.background // app.build.gradle에서 색 지정 가능
                ) {
                    Posts()
                }
            }
        }
    }
}

// 게시글들을 띄우는 함수
@Composable
private fun Posts(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) { // RecyclerView이 compose에서는 LazyColumn, LazyRow로 대체됨
        item{
            for (i in 1..10){ // UI에 for문도 가능
                Post() // 대충 만들어 놓은 게시글 포맷
            }
        }
    }
}

@Composable
fun Post() {
    Surface(
        color = MaterialTheme.colors.primary, //primary color 내가 따로 저 연노랑으로 설정해놓음 대충
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "게시글 제목",
                textAlign = TextAlign.Center,
                fontWeight = Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            AsyncImage(
                model = "", // 여기에 이미지 주소 넣으면 나옴
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(
                text = "5분전",
                fontSize = 10.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true) //미리보기 용
@Composable
fun DefaultPreview() {
    LazyColumnExampleTheme {
        Post()
    }
}

@Preview //미리보기 용
@Composable
fun PostsPreview() {
    LazyColumnExampleTheme {
        Posts()
    }
}