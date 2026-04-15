package liltojustice.trueadaptivemusicapi.trigger

@Suppress("UNUSED")
abstract class MusicTrigger {
    @Serialize
    private val type = getTypeName()

    abstract fun getTypeName(): String

    interface MusicTriggerCompanion {
        val displayName: String?
            get() = null

        val argDisplayNames: Map<String, String>
            get() = mapOf()

        val argDescriptions: Map<String, String>
            get() = mapOf()
    }

    abstract class Parameters {
        interface ParametersCompanion<TSelf: Parameters> {
            val displayNames: Map<String, String>
                get() = mapOf()

            val descriptions: Map<String, String>
                get() = mapOf()

            fun default(): TSelf
        }
    }
}
