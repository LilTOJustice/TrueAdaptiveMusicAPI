package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.DowncastTriggerType
import liltojustice.trueadaptivemusicapi.trigger.TriggerTypeException
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.trigger.event.input.EventInput
import kotlin.reflect.KType
import kotlin.reflect.full.starProjectedType

@Suppress("UNUSED")
abstract class EventType<TArg: TriggerArguments, TState: TriggerState, TInput: EventInput>(
    final override val typeName: String): EventTypeBase, DowncastTriggerType<TArg, TState> {
    final override val argumentType: KType
        get() = this::class.typeParameters.first().starProjectedType

    protected open fun validateEvent(arguments: TArg, state: TState, input: TInput): Boolean {
        return true
    }

    protected abstract fun createEventState(arguments: TArg): TState

    final override fun validate(arguments: TriggerArguments, state: TriggerState, input: EventInput): Boolean {
        return validateEvent(
            getCastedArguments(arguments), getCastedState(state), getCastedInput(input))
    }

    final override fun createState(arguments: TriggerArguments): TriggerState {
        return createEventState(getCastedArguments(arguments))
    }

    @Suppress("UNCHECKED_CAST")
    fun getCastedInput(input: EventInput): TInput {
        return input as? TInput
            ?: throw TriggerTypeException("Expected event input type '${this::class.typeParameters[1].name}' but got " +
                    "'${input::class.simpleName}")
    }
}