package com.example.flash.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.data.DataSource
import com.example.flash.ui.theme.FlashTheme


@Composable
fun ItemsScreen(flashViewModel: FlashViewModel){
    val flashUiState by flashViewModel.uiState.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
       items(DataSource.loadItem(
           flashUiState.selectedCategory
       )){
           ItemCard(
               stringResourceID = it.stringResourceID,
               imageResourceID = it.imageResource,
               itemQuantity = it.itemQuantityID,
               itemPrice = it.itemPrice)
       }
    }
}

@Composable
fun ItemCard(
    stringResourceID: Int,
    imageResourceID:Int,
    itemQuantity: String,
    itemPrice:Int
){
    val context = LocalContext.current
    Column {
        Card() {
            Box {
                Image(
                    painter = painterResource(id = imageResourceID),
                    contentDescription = "Item Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End
                ) {
                    Card(
                        modifier = Modifier.padding(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(244, 67, 54, 255)
                        )
                    ) {
                        Text(
                            text = "25% off",
                            color = Color.White,

                            fontSize = 12.sp,
                            modifier = Modifier.padding(
                                horizontal = 5.dp,
                                vertical = 2.dp
                            )
                        )
                    }
                }
            }
            }

                Text(
                    text = stringResource(id = stringResourceID),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp),
                    maxLines = 1,
                    textAlign = TextAlign.Left
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column {
                            Text(
                                text = "Rs $itemPrice",
                                fontSize = 12.sp,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                color = Color(109,109,109,255),
                                textDecoration = TextDecoration.LineThrough
                            )
                        Text(
                            text = "Rs. ${itemPrice*75/100}",
                            fontSize = 15.sp,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            color = Color(255,116,105,255),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = itemQuantity,
                        fontSize = 14.sp,
                        maxLines = 1,
                        color = Color(114,114,114,255)
                    )
                }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        Toast
                            .makeText(context, "Added To Cart", Toast.LENGTH_SHORT)
                            .show()
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color(108,194,111,255)
                )
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Add to cart",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FlashTheme {
        ItemsScreen(flashViewModel = FlashViewModel())
    }
}


