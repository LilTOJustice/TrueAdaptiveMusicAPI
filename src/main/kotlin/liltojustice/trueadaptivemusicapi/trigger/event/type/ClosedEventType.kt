package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.input.EmptyEventInput
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import kotlin.reflect.KType

@Suppress("UNUSED")
abstract class ClosedEventType<TArg: TriggerArguments, TState: TriggerState>(typeName: String, argumentType: KType)
    : EventType<TArg, TState, EmptyEventInput>(typeName, argumentType) {
    abstract fun validate(arguments: TArg, state: TState): Boolean

    final override fun validate(arguments: TArg, state: TState, input: EmptyEventInput): Boolean {
        return validate(arguments, state)
    }
}