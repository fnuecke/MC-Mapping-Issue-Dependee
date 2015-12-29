package li.cil.test;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Mod(modid = ModDependee.MODID, version = ModDependee.VERSION)
public class ModDependee {
    public static final String MODID = "test-mapping-dependee";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        final TileEntity tileEntity = new TileEntityChest();
        final List<TileEntity> tileEntities = new ArrayList<>();

        // This is mapped fine, and does not error.
        final BlockPos pos = tileEntity.getPos();

        // This is not mapped, and errors when called.
        tileEntities.sort(Comparator.comparing(TileEntity::getPos));
    }
}
