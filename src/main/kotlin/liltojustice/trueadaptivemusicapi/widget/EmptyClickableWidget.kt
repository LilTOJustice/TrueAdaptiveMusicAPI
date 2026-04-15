package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.text.Text

internal class EmptyClickableWidget: ClickableWidget(0, 0, 0, 0, Text.of("")) {
    override fun renderWidget(context: DrawContext?, mouseX: Int, mouseY: Int, deltaTicks: Float) {
    }

    override fun appendClickableNarrations(builder: NarrationMessageBuilder?) {
    }
}