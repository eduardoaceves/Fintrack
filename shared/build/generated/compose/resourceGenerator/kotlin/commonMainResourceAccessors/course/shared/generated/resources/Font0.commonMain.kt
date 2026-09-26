@file:OptIn(InternalResourceApi::class)

package course.shared.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceContentHash
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String = "composeResources/course.shared.generated.resources/"

@delegate:ResourceContentHash(1_992_583_201)
internal val Res.font.open_sans: FontResource by lazy {
      FontResource("font:open_sans", setOf(
        ResourceItem(setOf(), "${MD}font/open_sans.ttf", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainFont0Resources(map: MutableMap<String, FontResource>) {
  map.put("open_sans", Res.font.open_sans)
}
