package com.mcl.createirongrate.blockentity;

import com.mcl.createirongrate.CreateIronGrate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InfiniteLavaTankBlockEntity extends BlockEntity {

    private final InfiniteLavaFluidHandler tank = new InfiniteLavaFluidHandler();
    private final LazyOptional<IFluidHandler> fluidCap = LazyOptional.of(() -> tank);

    public InfiniteLavaTankBlockEntity(BlockPos pos, BlockState state) {
        super(CreateIronGrate.INFINITE_LAVA_TANK_BE.get(), pos, state);
    }

    // 六面均对外提供无限熔岩
    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return fluidCap.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        fluidCap.invalidate();
    }
}
