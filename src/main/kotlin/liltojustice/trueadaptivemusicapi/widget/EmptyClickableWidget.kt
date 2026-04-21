package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.text.Text

class EmptyClickableWidget
    : AbstractWidget(0, 0, 0, 0, Component.literal("")) {
    override fun extractWidgetRenderState(graphics: GuiGraphicsExtractor, mouseX: Int, mouseY: Int, a: Float) {
    }

    override fun appendClickableNarrations(builder: NarrationMessageBuilder?) {
    }
}