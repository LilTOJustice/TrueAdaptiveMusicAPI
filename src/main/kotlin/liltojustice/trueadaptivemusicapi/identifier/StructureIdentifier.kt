package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.MinecraftClient
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

@Suppress("UNUSED")
class StructureIdentifier(id: Identifier): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toTranslationKey("structure")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<Identifier> {
            return MinecraftClient.getInstance().server?.worlds
                ?.flatMap { world -> world.structureAccessor.registryManager
                    .getOptional(RegistryKeys.STRUCTURE).get().ids
                }
                ?.toSet()
                ?.toList()
                ?: emptyList()
        }
    }
}