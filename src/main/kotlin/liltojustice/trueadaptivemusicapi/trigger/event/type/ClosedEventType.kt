package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.input.EmptyEventInput
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState

@Suppress("UNUSED")
abstract class ClosedEventType<TArg: TriggerArguments, TState: TriggerState>(typeName: String)
    : EventType<TArg, TState, EmptyEventInput>(typeName) {
    abstract fun validateEvent(arguments: TArg, state: TState): Boolean

    final override fun validateEvent(arguments: TArg, state: TState, input: EmptyEventInput): Boolean {
        return validateEvent(arguments, state)
    }
}