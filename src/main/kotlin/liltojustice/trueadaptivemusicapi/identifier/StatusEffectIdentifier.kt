package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

@Suppress("UNUSED")
class StatusEffectIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toTranslationKey("effect")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return Registries.STATUS_EFFECT.ids.toList()
        }
    }
}