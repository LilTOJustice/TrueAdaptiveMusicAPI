package liltojustice.trueadaptivemusicapi.trigger.event.type

import liltojustice.trueadaptivemusicapi.trigger.DowncastTriggerType
import liltojustice.trueadaptivemusicapi.trigger.TriggerTypeException
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.trigger.event.input.EventInput
import kotlin.reflect.KType

@Suppress("UNUSED")
abstract class EventType<TArg: TriggerArguments, TState: TriggerState, TInput: EventInput>(
    final override val typeName: String, final override val argumentType: KType
): EventTypeBase, DowncastTriggerType<TArg, TState> {

    protected open fun validate(arguments: TArg, state: TState, input: TInput): Boolean {
        return true
    }

    protected abstract fun createState(arguments: TArg): TState

    final override fun validateBase(arguments: TriggerArguments, state: TriggerState, input: EventInput): Boolean {
        return validate(
            getCastedArguments(arguments), getCastedState(state), getCastedInput(input))
    }

    final override fun createStateBase(arguments: TriggerArguments): TriggerState {
        return createState(getCastedArguments(arguments))
    }

    @Suppress("UNCHECKED_CAST")
    fun getCastedInput(input: EventInput): TInput {
        return input as? TInput
            ?: throw TriggerTypeException("Expected event input type '${this::class.typeParameters[1].name}' but got " +
                    "'${input::class.simpleName}")
    }

    @Suppress("UNUSED")
    private class Helper<TArg: TriggerArguments>
}