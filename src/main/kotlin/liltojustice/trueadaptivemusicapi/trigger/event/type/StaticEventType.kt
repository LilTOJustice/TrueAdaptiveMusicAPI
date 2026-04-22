package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.state.EmptyTriggerState
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.event.input.EventInput
import kotlin.reflect.KType

@Suppress("UNUSED")
abstract class StaticEventType<TArg: TriggerArguments, TInput: EventInput>(typeName: String, argumentType: KType)
    : EventType<TArg, EmptyTriggerState, TInput>(typeName, argumentType) {
    abstract fun validate(arguments: TArg, input: TInput): Boolean

    final override fun createState(arguments: TArg): EmptyTriggerState {
        return EmptyTriggerState()
    }

    final override fun validate(arguments: TArg, state: EmptyTriggerState, input: TInput): Boolean {
        return validate(arguments, input)
    }
}