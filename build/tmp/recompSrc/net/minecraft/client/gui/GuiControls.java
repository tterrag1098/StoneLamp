package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

@SideOnly(Side.CLIENT)
public class GuiControls extends GuiScreen
{
    private static final GameSettings.Options[] field_146492_g = new GameSettings.Options[] {GameSettings.Options.INVERT_MOUSE, GameSettings.Options.SENSITIVITY, GameSettings.Options.TOUCHSCREEN};
    /**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    private GuiScreen parentScreen;
    protected String field_146495_a = "Controls";
    /**
     * Reference to the GameSettings object.
     */
    private GameSettings options;
    /**
     * The ID of the button that has been pressed.
     */
    public KeyBinding buttonId = null;
    private GuiKeyBindingList keyBindingList;
    private GuiButton field_146493_s;
    private static final String __OBFID = "CL_00000736";

    public GuiControls(GuiScreen par1GuiScreen, GameSettings par2GameSettings)
    {
        this.parentScreen = par1GuiScreen;
        this.options = par2GameSettings;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.keyBindingList = new GuiKeyBindingList(this, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 155, this.height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(this.field_146493_s = new GuiButton(201, this.width / 2 - 155 + 160, this.height - 29, 150, 20, I18n.format("controls.resetAll", new Object[0])));
        this.field_146495_a = I18n.format("controls.title", new Object[0]);
        int i = 0;
        GameSettings.Options[] aoptions = field_146492_g;
        int j = aoptions.length;

        for (int k = 0; k < j; ++k)
        {
            GameSettings.Options options = aoptions[k];

            if (options.getEnumFloat())
            {
                this.buttonList.add(new GuiOptionSlider(options.returnEnumOrdinal(), this.width / 2 - 155 + i % 2 * 160, 18 + 24 * (i >> 1), options));
            }
            else
            {
                this.buttonList.add(new GuiOptionButton(options.returnEnumOrdinal(), this.width / 2 - 155 + i % 2 * 160, 18 + 24 * (i >> 1), options, this.options.getKeyBinding(options)));
            }

            ++i;
        }
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
        if (p_146284_1_.id == 200)
        {
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (p_146284_1_.id == 201)
        {
            KeyBinding[] akeybinding = this.mc.gameSettings.keyBindings;
            int i = akeybinding.length;

            for (int j = 0; j < i; ++j)
            {
                KeyBinding keybinding = akeybinding[j];
                keybinding.setKeyCode(keybinding.getKeyCodeDefault());
            }

            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (p_146284_1_.id < 100 && p_146284_1_ instanceof GuiOptionButton)
        {
            this.options.setOptionValue(((GuiOptionButton)p_146284_1_).returnEnumOptions(), 1);
            p_146284_1_.displayString = this.options.getKeyBinding(GameSettings.Options.getEnumOptions(p_146284_1_.id));
        }
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        if (this.buttonId != null)
        {
            this.options.setOptionKeyBinding(this.buttonId, -100 + par3);
            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else if (par3 != 0 || !this.keyBindingList.func_148179_a(par1, par2, par3))
        {
            super.mouseClicked(par1, par2, par3);
        }
    }

    /**
     * Called when the mouse is moved or a mouse button is released.  Signature: (mouseX, mouseY, which) which==-1 is
     * mouseMove, which==0 or which==1 is mouseUp
     */
    protected void mouseMovedOrUp(int p_146286_1_, int p_146286_2_, int p_146286_3_)
    {
        if (p_146286_3_ != 0 || !this.keyBindingList.func_148181_b(p_146286_1_, p_146286_2_, p_146286_3_))
        {
            super.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
        }
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        if (this.buttonId != null)
        {
            if (par2 == 1)
            {
                this.options.setOptionKeyBinding(this.buttonId, 0);
            }
            else
            {
                this.options.setOptionKeyBinding(this.buttonId, par2);
            }

            this.buttonId = null;
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        else
        {
            super.keyTyped(par1, par2);
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.keyBindingList.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRendererObj, this.field_146495_a, this.width / 2, 8, 16777215);
        boolean flag = true;
        KeyBinding[] akeybinding = this.options.keyBindings;
        int k = akeybinding.length;

        for (int l = 0; l < k; ++l)
        {
            KeyBinding keybinding = akeybinding[l];

            if (keybinding.getKeyCode() != keybinding.getKeyCodeDefault())
            {
                flag = false;
                break;
            }
        }

        this.field_146493_s.enabled = !flag;
        super.drawScreen(par1, par2, par3);
    }
}