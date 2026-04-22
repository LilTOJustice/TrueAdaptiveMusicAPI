package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.DowncastTriggerType
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import kotlin.reflect.KType

abstract class PredicateType<TArg: TriggerArguments, TState: TriggerState>(
    final override val typeName: String, final override val argumentType: KType
): PredicateTypeBase, DowncastTriggerType<TArg, TState> {
    override val tickRate: Int = 1

    @Suppress("UNUSED")
    protected abstract fun test(arguments: TArg, state: TState): Boolean
    protected abstract fun createState(arguments: TArg): TState

    final override fun testBase(arguments: TriggerArguments, state: TriggerState): Boolean {
        return test(getCastedArguments(arguments), getCastedState(state))
    }

    final override fun createStateBase(arguments: TriggerArguments): TriggerState {
        return createState(getCastedArguments(arguments))
    }

    @Suppress("UNUSED")
    private class Helper<TArg: TriggerArguments>
}