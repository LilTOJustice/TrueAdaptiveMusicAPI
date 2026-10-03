package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.advancements.Advancement
import net.minecraft.advancements.AdvancementHolder
import net.minecraft.client.Minecraft
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class AdvancementIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("advancement")
    }

    fun matches(advancement: AdvancementHolder): Boolean {
        return getAdvancementRegistry()?.get(id)?.getOrNull()?.`is`(advancement.id) ?: false
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            val registry = getAdvancementRegistry() ?: return emptyList()

            return registry.keySet().toList()
        }

        private fun getAdvancementRegistry(): Registry<Advancement>? {
            return Minecraft.getInstance().level
                ?.registryAccess()
                ?.lookup(Registries.ADVANCEMENT)
                ?.getOrNull()
        }
    }
}