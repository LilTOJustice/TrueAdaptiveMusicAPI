package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.state.EmptyTriggerState
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.input.EventInput

@Suppress("UNUSED")
abstract class StaticEventType<TArg: TriggerArguments, TInput: EventInput>(typeName: String)
    : EventType<TArg, EmptyTriggerState, TInput>(typeName) {
    abstract fun validateEvent(arguments: TArg, input: TInput): Boolean

    final override fun createEventState(arguments: TArg): EmptyTriggerState {
        return EmptyTriggerState()
    }

    final override fun validateEvent(arguments: TArg, state: EmptyTriggerState, input: TInput): Boolean {
        return validateEvent(arguments, input)
    }
}