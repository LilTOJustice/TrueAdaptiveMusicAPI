package liltojustice.trueadaptivemusicapi.trigger

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor

internal abstract class TriggerRegistry<T: TriggerTypeBase> {
    private val registry = mutableMapOf<String, RegistryEntry<T>>()

    fun register(triggerType: T) {
        registry[triggerType.typeName] = RegistryEntry(
            triggerType,
            triggerType.argumentType.classifier as KClass<*>
        )
    }

    fun getArguments(typeName: String): List<KParameter> {
        return registry[typeName]?.argumentClass?.primaryConstructor?.parameters
            ?: throw TriggerTypeException("Failed to get argument list for trigger type '$typeName'")
    }

    operator fun get(typeName: String): T? {
        return registry[typeName]?.triggerType
    }

    fun getAll(): List<Pair<String, T>> {
        return registry.entries.sortedBy { entry -> entry.key }.map { entry -> entry.key to entry.value.triggerType }
    }

    fun createState(triggerType: T, arguments: TriggerArguments): TriggerState {
        return triggerType.createState(arguments)
    }

    fun createArguments(triggerType: T, vararg arguments: Any?): TriggerArguments {
        return registry[triggerType.typeName]?.argumentClass?.primaryConstructor?.call(arguments)
                as? TriggerArguments
            ?: throw TriggerTypeException("Failed to create arguments for trigger type '${triggerType.typeName}")
    }

    data class RegistryEntry<T: TriggerTypeBase>(val triggerType: T, val argumentClass: KClass<*>)
}