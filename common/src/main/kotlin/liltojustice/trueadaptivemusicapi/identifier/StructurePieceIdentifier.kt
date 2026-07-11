package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class StructurePieceIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("structure_piece")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft.getInstance().singleplayerServer?.allLevels
                ?.flatMap { world -> world.structureManager().registryAccess()
                    .lookup(Registries.STRUCTURE_PIECE).get().keySet()
                }
                ?.toSet()
                ?.toList()
                ?: emptyList()
        }
    }
}