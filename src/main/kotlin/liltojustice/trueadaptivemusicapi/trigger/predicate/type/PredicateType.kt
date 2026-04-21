package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.DowncastTriggerType
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import kotlin.reflect.KType
import kotlin.reflect.full.starProjectedType

abstract class PredicateType<TArg: TriggerArguments, TState: TriggerState>(final override val typeName: String)
    : PredicateTypeBase, DowncastTriggerType<TArg, TState> {
    final override val argumentType: KType
        get() = this::class.typeParameters.first().starProjectedType
    @Suppress("UNUSED")
    open val tickRate = 1

    protected abstract fun validatePredicate(arguments: TArg, state: TState): Boolean
    protected abstract fun createPredicateState(arguments: TArg): TState

    final override fun validate(arguments: TriggerArguments, state: TriggerState): Boolean {
        return validatePredicate(getCastedArguments(arguments), getCastedState(state))
    }

    final override fun createState(arguments: TriggerArguments): TriggerState {
        return createPredicateState(getCastedArguments(arguments))
    }
}