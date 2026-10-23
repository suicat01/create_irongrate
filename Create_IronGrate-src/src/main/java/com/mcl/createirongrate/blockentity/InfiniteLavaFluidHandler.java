package com.mcl.createirongrate.blockentity;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraft.world.level.material.Fluids;

/**
 * 无限熔岩流体源：任何时刻都可抽出熔岩，永不耗尽；不接受任何注入。
 */
public class InfiniteLavaFluidHandler implements IFluidHandler {

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public FluidStack getFluidInTank(int tank) {
        return new FluidStack(Fluids.LAVA, Integer.MAX_VALUE);
    }

    @Override
    public int getTankCapacity(int tank) {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isFluidValid(int tank, FluidStack stack) {
        return stack.getFluid() == Fluids.LAVA;
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        return 0;
    }

    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
        if (resource.isEmpty() || resource.getFluid() != Fluids.LAVA) {
            return FluidStack.EMPTY;
        }
        return drain(resource.getAmount(), action);
    }

    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
        if (maxDrain <= 0) {
            return FluidStack.EMPTY;
        }
        return new FluidStack(Fluids.LAVA, maxDrain);
    }
}
