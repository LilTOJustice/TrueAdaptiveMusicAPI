package liltojustice.trueadaptivemusicapi

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.type.EventTypeBase
import liltojustice.trueadaptivemusicapi.trigger.event.EventRegistry
import liltojustice.trueadaptivemusicapi.trigger.predicate.PredicateRegistry
import liltojustice.trueadaptivemusicapi.trigger.predicate.type.PredicateTypeBase
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.widget.InputWidgetRegistry
import liltojustice.trueadaptivemusicapi.widget.WidgetArg
import liltojustice.trueadaptivemusicapi.widget.WidgetMaker
import net.minecraft.client.gui.components.AbstractWidget
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import kotlin.reflect.KParameter
import kotlin.reflect.KType

@Suppress("UNUSED")
object TAMAPI {
    private val predicateRegistry = PredicateRegistry()
    private val eventRegistry = EventRegistry()
    private val inputWidgetRegistry = InputWidgetRegistry()

    fun getPredicateTypeNames(): List<String> {
        return predicateRegistry.getAll().map { it.first }
    }

    fun getEventTypeNames(): List<String> {
        return eventRegistry.getAll().map { it.first }
    }

    fun getPredicateType(typeName: String): PredicateTypeBase? {
        return predicateRegistry[typeName]
    }

    fun getEventType(typeName: String): EventTypeBase? {
        return eventRegistry[typeName]
    }

    fun getPredicateTypeArguments(typeName: String): List<KParameter> {
        return predicateRegistry.getArguments(typeName)
    }

    fun getEventTypeArguments(typeName: String): List<KParameter> {
        return eventRegistry.getArguments(typeName)
    }

    fun registerPredicateType(predicateType: PredicateTypeBase) {
        predicateRegistry.register(predicateType)
    }

    fun registerEventType(eventType: EventTypeBase) {
        eventRegistry.register(eventType)
    }

    fun registerInputWidget(predicate: (parameterType: KType) -> Boolean, widgetMaker: WidgetMaker) {
        inputWidgetRegistry.register(predicate, widgetMaker)
    }

    fun registerInputWidget(parameterType: KType, widgetMaker: WidgetMaker) {
        registerInputWidget({ type -> type == parameterType}, widgetMaker)
    }

    fun makePredicateState(predicateType: PredicateTypeBase, arguments: TriggerArguments): TriggerState {
        return predicateRegistry.createState(predicateType, arguments)
    }

    fun makeEventState(eventType: EventTypeBase, arguments: TriggerArguments): TriggerState {
        return eventRegistry.createState(eventType, arguments)
    }

    fun makePredicateArguments(triggerType: PredicateTypeBase, vararg args: Any?): TriggerArguments {
        return predicateRegistry.createArguments(triggerType, args)
    }

    fun makeEventArguments(triggerType: EventTypeBase, vararg args: Any?): TriggerArguments {
        return eventRegistry.createArguments(triggerType, args)
    }

    fun makeInputWidget(
        screen: Screen,
        outArgs: MutableList<Any?>,
        arg: WidgetArg,
        displayName: Component?,
        tooltipText: Component?,
        onChange: () -> Unit
    ): AbstractWidget {
        return inputWidgetRegistry.makeWidget(screen, outArgs, arg, displayName, tooltipText, onChange)
    }
}