package com.example.ui.social

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.BorderColor
import com.example.CardBg
import com.example.LuxuryGold
import com.example.ScreenBg
import com.example.TextMutedColor
import com.example.TextSoftColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialMediaScreen(isArabic: Boolean) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    
    // States for account linking
    var tiktokLinked by remember { mutableStateOf(false) }
    var instagramLinked by remember { mutableStateOf(false) }
    var facebookLinked by remember { mutableStateOf(false) }
    var youtubeLinked by remember { mutableStateOf(false) }
    
    // Simulate linking process
    var isLinking by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        text = if (isArabic) "حسابات النشر" else "Social Accounts", 
                        fontWeight = FontWeight.Bold, 
                        color = LuxuryGold, 
                        fontSize = 20.sp
                    ) 
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = ScreenBg)
            )
        },
        containerColor = ScreenBg,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Header
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = null,
                tint = LuxuryGold,
                modifier = Modifier
                    .size(64.dp)
                    .background(CardBg, CircleShape)
                    .border(1.dp, LuxuryGold, CircleShape)
                    .padding(16.dp)
            )
            
            Text(
                text = if (isArabic) "اربط حساباتك لنشر المقاطع بشكل تلقائي" else "Link your accounts to publish automatically",
                color = TextSoftColor,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // TikTok Card
            SocialAccountCard(
                platformName = if (isArabic) "تيك توك (TikTok)" else "TikTok",
                isLinked = tiktokLinked,
                isLinking = isLinking == "tiktok",
                onLinkClick = {
                    isLinking = "tiktok"
                    scope.launch {
                        delay(1500)
                        tiktokLinked = !tiktokLinked
                        isLinking = null
                        Toast.makeText(context, if (tiktokLinked) (if (isArabic) "تم ربط تيك توك بنجاح" else "TikTok linked successfully") else (if (isArabic) "تم إلغاء ربط تيك توك" else "TikTok unlinked"), Toast.LENGTH_SHORT).show()
                    }
                },
                isArabic = isArabic
            )

            // Instagram Card
            SocialAccountCard(
                platformName = if (isArabic) "انستقرام (Instagram)" else "Instagram",
                isLinked = instagramLinked,
                isLinking = isLinking == "instagram",
                onLinkClick = {
                    isLinking = "instagram"
                    scope.launch {
                        delay(1500)
                        instagramLinked = !instagramLinked
                        isLinking = null
                        Toast.makeText(context, if (instagramLinked) (if (isArabic) "تم ربط انستقرام بنجاح" else "Instagram linked successfully") else (if (isArabic) "تم إلغاء ربط انستقرام" else "Instagram unlinked"), Toast.LENGTH_SHORT).show()
                    }
                },
                isArabic = isArabic
            )

            // Facebook Card
            SocialAccountCard(
                platformName = if (isArabic) "فيسبوك (Facebook)" else "Facebook",
                isLinked = facebookLinked,
                isLinking = isLinking == "facebook",
                onLinkClick = {
                    isLinking = "facebook"
                    scope.launch {
                        delay(1500)
                        facebookLinked = !facebookLinked
                        isLinking = null
                        Toast.makeText(context, if (facebookLinked) (if (isArabic) "تم ربط فيسبوك بنجاح" else "Facebook linked successfully") else (if (isArabic) "تم إلغاء ربط فيسبوك" else "Facebook unlinked"), Toast.LENGTH_SHORT).show()
                    }
                },
                isArabic = isArabic
            )

            // YouTube Card
            SocialAccountCard(
                platformName = if (isArabic) "يوتيوب (YouTube)" else "YouTube Shorts",
                isLinked = youtubeLinked,
                isLinking = isLinking == "youtube",
                onLinkClick = {
                    isLinking = "youtube"
                    scope.launch {
                        delay(1500)
                        youtubeLinked = !youtubeLinked
                        isLinking = null
                        Toast.makeText(context, if (youtubeLinked) (if (isArabic) "تم ربط يوتيوب بنجاح" else "YouTube linked successfully") else (if (isArabic) "تم إلغاء ربط يوتيوب" else "YouTube unlinked"), Toast.LENGTH_SHORT).show()
                    }
                },
                isArabic = isArabic
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = if (isArabic) "عند تفعيل النشر التلقائي، سيتم نشر المقاطع فور إنشائها على الحسابات المرتبطة." else "When auto-publish is enabled, reels will be published automatically to linked accounts.",
                color = TextMutedColor,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SocialAccountCard(
    platformName: String,
    isLinked: Boolean,
    isLinking: Boolean,
    onLinkClick: () -> Unit,
    isArabic: Boolean
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = CardBg),
        border = BorderStroke(1.dp, if (isLinked) LuxuryGold else BorderColor),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (isLinked) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = LuxuryGold,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .border(2.dp, BorderColor, CircleShape)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = platformName,
                    color = TextSoftColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
            }
            
            Button(
                onClick = onLinkClick,
                enabled = !isLinking,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isLinked) ScreenBg else LuxuryGold,
                    contentColor = if (isLinked) TextSoftColor else ScreenBg,
                    disabledContainerColor = BorderColor
                ),
                shape = RoundedCornerShape(8.dp),
                border = if (isLinked) BorderStroke(1.dp, BorderColor) else null
            ) {
                if (isLinking) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = LuxuryGold,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = if (isLinked) (if (isArabic) "إلغاء الربط" else "Unlink") else (if (isArabic) "ربط" else "Link"),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
