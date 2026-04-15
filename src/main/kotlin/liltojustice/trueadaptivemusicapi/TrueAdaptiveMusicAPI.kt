package liltojustice.trueadaptivemusicapi

import liltojustice.trueadaptivemusicapi.trigger.MusicEvent
import liltojustice.trueadaptivemusicapi.trigger.MusicPredicate
import liltojustice.trueadaptivemusicapi.trigger.MusicTriggerRegistry
import liltojustice.trueadaptivemusicapi.widget.InputWidgetRegistry
import liltojustice.trueadaptivemusicapi.widget.WidgetMaker
import kotlin.reflect.KClass
import kotlin.reflect.KType

@Suppress("UNUSED")
object TrueAdaptiveMusicAPI {
    private object MusicPredicateRegistry: MusicTriggerRegistry<MusicPredicate>()
    private object MusicEventRegistry: MusicTriggerRegistry<MusicEvent>()
    private val inputWidgetRegistry = InputWidgetRegistry()

    fun getPredicateType(typeName: String): KClass<out MusicPredicate>? {
        return MusicPredicateRegistry[typeName]
    }

    fun getEventType(typeName: String): KClass<out MusicEvent>? {
        return MusicEventRegistry[typeName]
    }

    fun registerPredicateType(typeName: String, predicateType: KClass<out MusicPredicate>) {
        MusicPredicateRegistry[typeName] = predicateType
    }

    fun registerEventType(typeName: String, eventType: KClass<out MusicEvent>) {
        MusicEventRegistry[typeName] = eventType
    }

    fun registerPredicateType(name: String, predicateType: Class<out MusicPredicate>) {
        registerPredicateType(name, predicateType.kotlin)
    }

    fun registerEventType(name: String, eventType: Class<out MusicEvent>) {
        registerEventType(name, eventType.kotlin)
    }

    fun registerInputWidget(predicate: (parameterType: KType) -> Boolean, widgetMaker: WidgetMaker) {
        inputWidgetRegistry.register(predicate, widgetMaker)
    }

    fun registerInputWidget(parameterType: KType, widgetMaker: WidgetMaker) {
        registerInputWidget({ type -> type == parameterType}, widgetMaker)
    }
}