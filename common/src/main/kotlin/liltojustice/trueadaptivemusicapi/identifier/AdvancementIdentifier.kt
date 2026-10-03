package liltojustice.trueadaptivemusicapi.identifier

import net.minecraft.advancements.AdvancementHolder
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation

@Suppress("UNUSED")
class AdvancementIdentifier(id: ResourceLocation): TypedIdentifier(id) {
    override fun toPrefixedLanguageKey(): String {
        return id.toLanguageKey("advancement")
    }

    fun matches(advancement: AdvancementHolder): Boolean {
        return advancement.id == id
    }

    companion object: TypedIdentifierCompanion() {
        override fun getRegistryIds(): List<ResourceLocation> {
            return Minecraft.getInstance().singleplayerServer?.advancements?.allAdvancements?.map { it.id }
                ?: emptyList()
        }
    }
}