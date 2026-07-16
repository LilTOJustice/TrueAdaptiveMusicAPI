package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class StatusEffectIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("effect")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.MOB_EFFECT.keySet().toList()
        }
    }
}