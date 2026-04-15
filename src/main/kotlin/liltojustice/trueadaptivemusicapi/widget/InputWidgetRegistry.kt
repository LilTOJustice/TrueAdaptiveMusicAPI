package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.components.AbstractWidget
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import kotlin.reflect.KType

internal class InputWidgetRegistry {
    private val registry = ArrayDeque<WidgetRegistryEntry>()

    fun register(predicate: (parameterType: KType) -> Boolean, widgetMaker: WidgetMaker) {
        registry.addFirst(WidgetRegistryEntry(predicate, widgetMaker))
    }

    @Suppress("UNUSED")
    fun makeWidget(
        screen: Screen,
        outArgs: MutableList<Any?>,
        arg: WidgetArg,
        displayName: Component?,
        tooltipText: Component?,
        onChange: () -> Unit
    ): AbstractWidget {
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