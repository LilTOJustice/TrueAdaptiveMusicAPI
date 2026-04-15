package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.gui.components.AbstractWidget
import net.minecraft.client.gui.narration.NarrationElementOutput
import net.minecraft.network.chat.Component

internal class EmptyClickableWidget
    : AbstractWidget(0, 0, 0, 0, Component.literal("")) {
    override fun extractWidgetRenderState(graphics: GuiGraphicsExtractor, mouseX: Int, mouseY: Int, a: Float) {
    }

    override fun updateWidgetNarration(output: NarrationElementOutput) {
    }
}