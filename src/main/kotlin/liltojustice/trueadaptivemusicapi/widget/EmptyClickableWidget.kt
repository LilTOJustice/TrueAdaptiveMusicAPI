package liltojustice.trueadaptivemusicapi.widget

import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder
import net.minecraft.client.gui.widget.ClickableWidget
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.text.Text

internal class EmptyClickableWidget: ClickableWidget(0, 0, 0, 0, Text.of("")) {
    override fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(matrices, mouseX, mouseY, delta)
    }

    override fun appendNarrations(builder: NarrationMessageBuilder?) {
    }
}