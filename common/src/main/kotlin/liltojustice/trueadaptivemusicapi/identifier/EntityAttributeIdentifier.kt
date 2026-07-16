package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import kotlin.jvm.optionals.getOrNull

@Suppress("UNUSED")
class EntityAttributeIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("attribute")
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft
                .getInstance().level?.registryAccess()
                ?.lookup(Registries.ATTRIBUTE)
                ?.getOrNull()
                ?.keySet()
                ?.toList()
                ?: listOf()
        }
    }
}