package com.habbashmahmood.compose_splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.habbashmahmood.compose_splash_screen.ui.theme.DarkRed

@Composable
fun MovieBookingScreen() {
    Surface(color = Color.White) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
        ) {
            val (
                menuButton, coverImage, titleText, genreText, ratingText,
                castText, castContainer, castImage1, castImage2, castImage3, castImage4,
                showMore, plotHeading, plot, bookButton,
            ) = createRefs()

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .constrainAs(menuButton) {
                        start.linkTo(parent.start, 16.dp)
                        top.linkTo(parent.top, 16.dp)
                    }
            )

            val rightGuideline = createGuidelineFromStart(0.4f)

            Image(
                painter = painterResource(id = R.drawable.top_gun_poster), contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .constrainAs(coverImage) {
                        start.linkTo(parent.start, 24.dp)
                        top.linkTo(menuButton.bottom, 16.dp)
                        end.linkTo(rightGuideline, 16.dp)
                        width = Dimension.fillToConstraints
                    }
                    .aspectRatio(2f / 3f),
            )

            Text(
                text = "Top Gun: Maverick",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(titleText) {
                    top.linkTo(menuButton.bottom, 8.dp)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            Text(
                text = "Action | 2h 10m",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.constrainAs(genreText) {
                    top.linkTo(titleText.bottom)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            Text(
                text = "IMDb 8.5/10",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.constrainAs(ratingText) {
                    top.linkTo(genreText.bottom, 16.dp)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            Text(
                text = "CAST",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.constrainAs(castText) {
                    bottom.linkTo(castContainer.top, 10.dp)
                    start.linkTo(coverImage.end, 16.dp)
                }
            )

            ConstraintLayout(modifier = Modifier.constrainAs(castContainer) {
                bottom.linkTo(coverImage.bottom)
                start.linkTo(coverImage.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            })
            {
                Image(
                    painter = painterResource(id = R.drawable.tom_cruise),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage1) {
                            bottom.linkTo(coverImage.bottom)
                            start.linkTo(coverImage.end, 16.dp)
                        }
                        .aspectRatio(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.jennifer_connelly),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage2) {
                            top.linkTo(castImage1.top)
                            bottom.linkTo(castImage1.bottom)
                            start.linkTo(castImage1.end)
                        }
                        .aspectRatio(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.miles_teller),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(castImage3) {
                            top.linkTo(castImage1.top)
                            bottom.linkTo(castImage1.bottom)
                            start.linkTo(castImage2.end)
                        }
                        .aspectRatio(1f)
                )

                Box(modifier = Modifier
                    .height(50.dp)
                    .background(color = Color.LightGray)
                    .constrainAs(castImage4) {
                        top.linkTo(castImage1.top)
                        bottom.linkTo(castImage1.bottom)
                        start.linkTo(castImage3.end)
                        end.linkTo(parent.end, 16.dp)
                    }
                    .aspectRatio(1f)) {
                    Text(
                        text = "+20",
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .align(Alignment.Center),
                        color = Color.Black
                    )
                }

                createHorizontalChain(
                    castImage1, castImage2, castImage3, castImage4,
                    chainStyle = ChainStyle.SpreadInside
                )
            }

            val barrier = createBottomBarrier(coverImage, castContainer)
            val barrierPlot = createBottomBarrier(plotHeading)
            val barrierShowMore = createBottomBarrier(plot)

            Text(
                text = "PLOT",
                color = Color(0xFF000000),
                fontSize = 17.sp,
                modifier = Modifier.constrainAs(plotHeading) {
                    top.linkTo(barrier, 35.dp)
                    start.linkTo(parent.start, 24.dp)
                    width = Dimension.preferredWrapContent
                }
            )

            Text(
                text = "Over 30 years after graduating from TOPGUN, United States Navy Captain Pete \"Maverick\" Mitchell is a test pilot. While he has won many honors, repeated insubordination has kept him from flag rank. His friend and former TOPGUN rival Admiral Tom \"Iceman\" Kazansky, commander of the U.S. Pacific Fleet, often protects Maverick from being grounded. Rear Admiral Chester \"Hammer\" Cain cancels Maverick\'s \"Darkstar\" scramjet program in favor of funding drones. Before Cain can officially do so, Maverick sets a new flight plan to push into high-hypersonic speed, accomplishing the program's goal. The prototype is destroyed, however, when Maverick pushes beyond Mach 10. Iceman again saves Maverick's career by ordering him to NAS North Island for his next assignment, but Hammer warns Maverick that the era of crewed fighter aircraft will soon end.",
                color = Color(0x8A000000),
                fontSize = 15.sp,
                modifier = Modifier.constrainAs(plot) {
                    top.linkTo(barrierPlot, 15.dp)
                    start.linkTo(parent.start, 24.dp)
                    end.linkTo(parent.end, 24.dp)
                    width = Dimension.preferredWrapContent
                }
            )

            Text(
                text = "SHOW MORE",
                color = Color(0x8A3C3C3C),
                fontSize = 15.sp,
                modifier = Modifier.constrainAs(showMore) {
                    top.linkTo(barrierShowMore, 60.dp)
                    start.linkTo(parent.start, 24.dp)
                    end.linkTo(parent.end, 24.dp)
                    width = Dimension.preferredWrapContent
                }
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = DarkRed),
                modifier = Modifier
                    .height(60.dp)
                    .background(color = DarkRed)
                    .constrainAs(bookButton) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(
                    text = "BOOK TICKETS",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}