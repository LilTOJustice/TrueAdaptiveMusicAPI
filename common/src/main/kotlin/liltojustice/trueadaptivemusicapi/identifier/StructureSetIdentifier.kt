package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class StructureSetIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("structure_set")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft.getInstance().singleplayerServer?.allLevels
                ?.flatMap { world -> world.structureManager().registryAccess()
                    .registry(Registries.STRUCTURE_SET).get().keySet()
                }
                ?.toSet()
                ?.toList()
                ?: emptyList()
        }
    }
}