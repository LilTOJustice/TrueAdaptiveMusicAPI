package liltojustice.trueadaptivemusicapi.trigger

import com.google.gson.Gson
import com.google.gson.JsonObject
import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.state.TriggerState
import kotlin.reflect.KType
import kotlin.reflect.jvm.javaType

@Suppress("UNUSED")
interface TriggerTypeBase {
    val typeName: String
    val argumentType: KType
    val displayName: String?
        get() = null
    val argDisplayNames: Map<String, String>
        get() = mapOf()
    val argDescriptions: Map<String, String>
        get() = mapOf()

    fun createState(arguments: TriggerArguments): TriggerState

    fun createArguments(json: JsonObject): TriggerArguments {
        return gson.fromJson(json, argumentType.javaType)
    }

    companion object {
        val gson = Gson()
    }
}
