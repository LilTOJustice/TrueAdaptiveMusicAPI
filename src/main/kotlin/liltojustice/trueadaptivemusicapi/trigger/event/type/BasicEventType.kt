package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.EmptyTriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.input.EmptyEventInput
import kotlin.reflect.typeOf

@Suppress("UNUSED")
abstract class BasicEventType(typeName: String): StaticEventType<EmptyTriggerArguments, EmptyEventInput>(
    typeName, typeOf<EmptyTriggerArguments>()
) {
    final override val argDescriptions: Map<String, String>
        get() = super.argDescriptions
    final override val argDisplayNames: Map<String, String>
        get() = super.argDisplayNames

    final override fun validate(arguments: EmptyTriggerArguments, input: EmptyEventInput): Boolean {
        return true
    }
}