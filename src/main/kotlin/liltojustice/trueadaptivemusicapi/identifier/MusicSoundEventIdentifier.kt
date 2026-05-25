package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

@Suppress("UNUSED")
class MusicSoundEventIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toTranslationKey("sound")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return Registries.SOUND_EVENT.keys.map { it.value }.filter { it.path.contains("music.") }.toList()
        }
    }
}