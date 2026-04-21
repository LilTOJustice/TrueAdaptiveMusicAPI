package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.state.EmptyTriggerState
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments

@Suppress("UNUSED")
abstract class StaticPredicateType<TArg: TriggerArguments>(typeName: String)
    : PredicateType<TArg, EmptyTriggerState>(typeName) {
    abstract fun validatePredicate(arguments: TArg): Boolean

    final override fun createPredicateState(arguments: TArg): EmptyTriggerState {
        return EmptyTriggerState()
    }

    final override fun validatePredicate(arguments: TArg, state: EmptyTriggerState): Boolean {
        return validatePredicate(arguments)
    }
}