package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.dimension.BuiltinDimensionTypes

@Suppress("UNUSED")
class DimensionIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("dimension")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft
                .getInstance().level?.registryAccess()?.registry(Registries.DIMENSION_TYPE)?.get()?.keySet()
                ?.filter { it != BuiltinDimensionTypes.OVERWORLD_CAVES.location() }
                ?.toList() ?: listOf()
        }
    }
}