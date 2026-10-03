package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.advancements.Advancement
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class AdvancementIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("advancement")
    }

    fun matches(advancement: Advancement): Boolean {
        return advancement.id == id
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft.getInstance().connection?.advancements?.advancements?.allAdvancements?.map { it.id }
                ?: emptyList()
        }
    }
}