package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class MusicSoundEventIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("sound")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.SOUND_EVENT.registryKeySet().map { it.location() }.filter { it.path.contains("music.") }.toList()
        }
    }
}