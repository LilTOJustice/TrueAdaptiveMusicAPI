package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.text.Text
import kotlin.reflect.KType

internal class InputWidgetRegistry {
    private val registry = ArrayDeque<WidgetRegistryEntry>()

    fun register(predicate: (parameterType: KType) -> Boolean, widgetMaker: WidgetMaker) {
        registry.addFirst(WidgetRegistryEntry(predicate, widgetMaker))
    }

    fun makeWidget(
        screen: Screen,
        outArgs: MutableList<Any?>,
        arg: WidgetArg,
        displayName: Text?,
        tooltipText: Text?,
        onChange: () -> Unit
    ): ClickableWidget {
        val displayName = displayName?.string ?: arg.name ?: "Unknown"
        return registry.firstOrNull { entry -> entry.predicate(arg.type) }
            ?.widgetMaker(displayName, screen, outArgs, arg, tooltipText, onChange)
            ?: run {
                EmptyClickableWidget()
            }
    }

    private data class WidgetRegistryEntry(
        val predicate: (parameterType: KType) -> Boolean, val widgetMaker: WidgetMaker)
}