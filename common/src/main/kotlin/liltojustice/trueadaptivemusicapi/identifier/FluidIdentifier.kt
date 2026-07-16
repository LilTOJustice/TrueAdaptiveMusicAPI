package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class FluidIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("fluid")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return BuiltInRegistries.FLUID.registryKeySet()
                .map { it.location() }.filter { it != BuiltInRegistries.FLUID.defaultKey }
        }
    }
}