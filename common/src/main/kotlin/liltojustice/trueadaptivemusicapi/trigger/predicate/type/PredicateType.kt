package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.DowncastTriggerType
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import liltojustice.trueadaptivemusicapi.util.StringExtensions.prettify
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.jvm.jvmErasure

abstract class PredicateType<TArg: TriggerArguments, TState: TriggerState>(
    final override val typeName: String, final override val argumentType: KType
): PredicateTypeBase, DowncastTriggerType<TArg, TState> {
    override val tickRate: Int = 1
    override val argDisplayNames: Map<String, String>
        get() = super.argDisplayNames +
            argumentType.jvmErasure.declaredMembers.map { it.name }.associateWith { it.prettify() }

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