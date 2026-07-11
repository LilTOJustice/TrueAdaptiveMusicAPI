package liltojustice.trueadaptivemusicapi.trigger

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState

interface DowncastTriggerType<TArg: TriggerArguments, TState: TriggerState> {
    @Suppress("UNCHECKED_CAST")
    fun getCastedArguments(arguments: TriggerArguments): TArg {
        return arguments as? TArg
            ?: throw TriggerTypeException("Expected argument type '${this::class.typeParameters[0].name}' but got " +
                    "'${arguments::class.simpleName}")
    }

    @Suppress("UNCHECKED_CAST")
    fun getCastedState(state: TriggerState): TState {
        return state as? TState
            ?: throw TriggerTypeException("Expected state type '${this::class.typeParameters[1].name}' but got " +
                    "'${state::class.simpleName}")
    }
}