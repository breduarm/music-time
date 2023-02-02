package com.example.musictime.components

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musictime.theme.colorSecondary
import kotlin.math.*

@ExperimentalComposeUiApi
@Composable
fun CircularSlider(
    modifier: Modifier = Modifier,
    padding: Float = 16f,
    stroke: Float = 15f,
    cap: StrokeCap = StrokeCap.Round,
    touchStroke: Float = 30f,
    thumbColor: Color = colorSecondary,
    progressColor: Color = colorSecondary,
    backgroundColor: Color = Color.LightGray,
    onChange: ((Float)->Unit)? = null
){
    var width by remember { mutableStateOf(0) }
    var height by remember { mutableStateOf(0) }
    var angle by remember { mutableStateOf(60f) }
    var last by remember { mutableStateOf(0f) }
    var down  by remember { mutableStateOf(false) }
    var radius by remember { mutableStateOf(0f) }
    var center by remember { mutableStateOf(Offset.Zero) }
    var appliedAngle by remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = angle){
        var a = angle
        if (!(60f<a && a<120f)) {
            a *= (-1)
            a += 60
            if(a<=-60f){
                a += 360
            }
            a = a.coerceIn(0f,300f)
            if(last<150f && a==300f){
                a = 0f
            }
            last = a
            appliedAngle = a
        }
    }
    LaunchedEffect(key1 = appliedAngle){
        onChange?.invoke(appliedAngle/300f)
    }
    Canvas(
        modifier = modifier
            .onGloballyPositioned {
                width = it.size.width
                height = it.size.height
                center = Offset(width / 2f, height / 2f)
                radius = min(width.toFloat(), height.toFloat()) / 2f - padding - stroke / 2f
            }
            .pointerInteropFilter {
                val x = it.x
                val y = it.y
                val offset = Offset(x, y)
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val d = distance(offset, center)
                        val a = angle(center, offset)
                        if (d >= radius - touchStroke / 2f && d <= radius + touchStroke / 2f && a !in 60f..120f) {
                            Log.d("down TRUE", "CircularSlider: $a")
                            down = true
                            angle = a
                        } else {
                            Log.d("down FALSE", "CircularSlider: $a")
                            down = false
                        }
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if (down) {
                            angle = angle(center, offset)
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        down = false
                    }
                    else -> return@pointerInteropFilter false
                }
                return@pointerInteropFilter true
            }
    ){
        drawArc(
            color = backgroundColor,
            startAngle = 240f,
            sweepAngle = -300f,
            topLeft = center - Offset(radius,radius),
            size = Size(radius*2,radius*2),
            useCenter = false,
            style = Stroke(
                width = stroke,
                cap = cap
            )
        )
        drawArc(
            color = progressColor,
            startAngle = -120f,
            sweepAngle = -appliedAngle,
            topLeft = center - Offset(radius,radius),
            size = Size(radius*2,radius*2),
            useCenter = false,
            style = Stroke(
                width = stroke,
                cap = cap
            )
        )
        drawCircle(
            color = thumbColor,
            radius = stroke + 8f,
            center = center + Offset(
                radius*cos((-120-appliedAngle)*PI/180f).toFloat(),
                radius*sin((-120-appliedAngle)*PI/180f).toFloat()
            )
        )
    }
}

fun angle(center: Offset, offset: Offset): Float {
    val centerY = center.y
    val centerX = center.x
    val offsetY = offset.y
    val offsetX = offset.x
    val rad = atan2(centerY - offsetY, centerX - offsetX)
    val deg = Math.toDegrees(rad.toDouble())
    return deg.toFloat()
}
fun distance(first: Offset, second: Offset) : Float{
    return sqrt((first.x-second.x).square()+(first.y-second.y).square())
}
fun Float.square(): Float{
    return this*this
}

@ExperimentalComposeUiApi
@Composable
@Preview
fun CircularSliderPreview() {
    CircularSlider(
        modifier = Modifier.size(300.dp)
    )
}