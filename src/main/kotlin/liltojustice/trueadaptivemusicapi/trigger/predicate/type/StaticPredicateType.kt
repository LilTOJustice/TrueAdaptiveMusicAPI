package liltojustice.trueadaptivemusicapi.trigger.predicate.type

import liltojustice.trueadaptivemusicapi.trigger.state.EmptyTriggerState
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import kotlin.reflect.KType

@Suppress("UNUSED")
abstract class StaticPredicateType<TArg: TriggerArguments>(typeName: String, argumentType: KType)
    : PredicateType<TArg, EmptyTriggerState>(typeName, argumentType) {
    abstract fun test(arguments: TArg): Boolean

    final override fun createState(arguments: TArg): EmptyTriggerState {
        return EmptyTriggerState()
    }

    final override fun test(arguments: TArg, state: EmptyTriggerState): Boolean {
        return test(arguments)
    }
}