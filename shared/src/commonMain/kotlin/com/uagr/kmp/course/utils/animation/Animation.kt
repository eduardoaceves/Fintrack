/*
 * Animation.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.uagr.kmp.course.utils.animation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.ContentTransform
import androidx.compose.ui.Alignment

object Animation {

    private const val DEFAULT_TRANSITION_DURATION = 300
    const val DEFAULT_ANIMATION_DURATION = 250

    fun scaleTransition(): ContentTransform =
        scaleIn(
            initialScale = 0.9f,
            animationSpec = tween(durationMillis = DEFAULT_TRANSITION_DURATION, easing = FastOutSlowInEasing),
        ) + fadeIn() togetherWith scaleOut(
            targetScale = 1.1f,
            animationSpec = tween(durationMillis = DEFAULT_TRANSITION_DURATION, easing = FastOutSlowInEasing),
        ) + fadeOut()

    fun fadeInTransition(duration: Int = DEFAULT_ANIMATION_DURATION) =
        fadeIn(animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing))

    fun fadeOutTransition(duration: Int = DEFAULT_ANIMATION_DURATION) =
        fadeOut(animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing))

    fun expandVerticallyTransition(duration: Int = DEFAULT_ANIMATION_DURATION): EnterTransition =
        expandVertically(
            animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing),
            expandFrom = Alignment.Top,
        )

    fun shrinkVerticallyTransition(duration: Int = DEFAULT_ANIMATION_DURATION): ExitTransition =
        shrinkVertically(
            animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing),
            shrinkTowards = Alignment.Top,
        )
}
