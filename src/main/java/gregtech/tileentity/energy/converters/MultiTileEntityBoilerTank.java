/**
 * Copyright (c) 2021 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregtech.tileentity.energy.converters;

import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetCollisionBoundingBoxFromPool;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_OnEntityCollidedWithBlock;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_RemovedByPlayer;
import gregapi.code.TagData;
import gregapi.data.BI;
import gregapi.network.INetworkHandler;
import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.ITileEntityFunnelAccessible;
import gregapi.tileentity.base.TileEntityBase09FacingSingle;
import gregapi.tileentity.data.ITileEntityGibbl;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.energy.ITileEntityEnergyDataCapacitor;
import gregtechCH.tileentity.cores.boilers.IMTEC_BoilerTank;
import gregtechCH.tileentity.cores.IMTEC_ToolTips;
import gregtechCH.tileentity.cores.boilers.IMTEC_HasBoilerTank;
import gregtechCH.tileentity.cores.boilers.MTEC_BoilerTank_Greg;
import gregtechCH.tileentity.cores.boilers.MTEC_BoilerTank;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static gregapi.data.CS.*;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntityBoilerTank extends TileEntityBase09FacingSingle implements IMTEC_HasBoilerTank, ITileEntityEnergy, ITileEntityFunnelAccessible, ITileEntityGibbl, ITileEntityEnergyDataCapacitor, IFluidHandler, IMTE_RemovedByPlayer, IMTE_GetCollisionBoundingBoxFromPool, IMTE_OnEntityCollidedWithBlock {
	protected MTEC_BoilerTank mCore;
	@Override public MTEC_BoilerTank core() {return mCore;}
	@Override public byte facing() {return mFacing;}
	
	@Override
	public void readFromNBT2(NBTTagCompound aNBT) {
		// GTCH, core init
		if (mCore == null) mCore = new MTEC_BoilerTank(this);
		super.readFromNBT2(aNBT);
		mCore.readFromNBT(aNBT);
	}
	
	@Override
	public void writeToNBT2(NBTTagCompound aNBT) {
		super.writeToNBT2(aNBT);
		// GTCH, core save
		mCore.writeToNBT(aNBT);
	}
	
	@Override
	public NBTTagCompound writeItemNBT2(NBTTagCompound aNBT) {
		mCore.writeItemNBT(aNBT);
		return super.writeItemNBT2(aNBT);
	}
	
	// tooltips
	@Override public final void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {IMTEC_ToolTips.Util.addToolTips(mCore, aList, aStack, aF3_H); super.addToolTips(aList, aStack, aF3_H);}
	// ticking
	@Override public void onTick2(long aTimer, boolean aIsServerSide) {if (aIsServerSide) IMTEC_BoilerTank.Util.onTick(mCore, aTimer);}
	
	@Override public boolean breakBlock() {mCore.onBreakBlock(); return super.breakBlock();}
	
	@Override
	public long onToolClick2(String aTool, long aRemainingDurability, long aQuality, Entity aPlayer, List<String> aChatReturn, IInventory aPlayerInventory, boolean aSneaking, ItemStack aStack, byte aSide, float aHitX, float aHitY, float aHitZ) {
		long rReturn = super.onToolClick2(aTool, aRemainingDurability, aQuality, aPlayer, aChatReturn, aPlayerInventory, aSneaking, aStack, aSide, aHitX, aHitY, aHitZ);
		if (rReturn > 0) return rReturn;
		
		if (isClientSide()) return 0;
		
		return mCore.onToolClick(aTool, aRemainingDurability, aQuality, aPlayer, aChatReturn, aPlayerInventory, aSneaking, aStack, aSide, aHitX, aHitY, aHitZ);
	}
	
	@Override
	public boolean removedByPlayer(World aWorld, EntityPlayer aPlayer, boolean aWillHarvest) {
		mCore.onRemovedByPlayer(aWorld, aPlayer, aWillHarvest);
		return worldObj.setBlockToAir(xCoord, yCoord, zCoord);
	}
	
	@Override
	public void onExploded(Explosion aExplosion) {
		super.onExploded(aExplosion);
		mCore.onExploded(aExplosion);
	}
	
	@Override
	public void explode(boolean aInstant) {
		mCore.explode(aInstant, 100.0);
	}
	
	@Override
	public boolean onTickCheck(long aTimer) {
		return mCore.onTickCheck(aTimer) || super.onTickCheck(aTimer);
	}
	
	@Override
	public void onTickResetChecks(long aTimer, boolean aIsServerSide) {
		super.onTickResetChecks(aTimer, aIsServerSide);
		mCore.onTickResetChecks(aTimer, aIsServerSide);
	}
	
	@Override
	public void setVisualData(byte aData) {
		mCore.setVisualData(aData);
	}
	
	// 重写这个方法来扩展客户端数据，必须要把 efficiency 发送到客户端才存入物品
	@Override public void writeToClientDataPacketByteList(@NotNull List<Byte> rList) {super.writeToClientDataPacketByteList(rList); mCore.writeToClientDataPacketByteList(rList);}
	@Override public boolean receiveDataByteArray(byte[] aData, INetworkHandler aNetworkHandler) {super.receiveDataByteArray(aData, aNetworkHandler); return mCore.receiveDataByteArray(aData, aNetworkHandler);}
	
	@Override
	public int funnelFill(byte aSide, FluidStack aFluid, boolean aDoFill) {
		return mCore.funnelFill(aSide, aFluid, aDoFill);
	}
	
	@Override public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {return aShouldSideBeRendered[aSide] ? BlockTextureMulti.get(BlockTextureDefault.get(sColoreds[FACES_TBS[aSide]], mRGBa), BlockTextureDefault.get(sOverlays[FACES_TBS[aSide]]), aSide!=mFacing?null:BlockTextureDefault.get(BI.BAROMETER), aSide!=mFacing?null:BlockTextureDefault.get(BI.BAROMETER_SCALE[mCore.getBarometer()], CA_RED_64)) : null;}
	
	@Override public void onEntityCollidedWithBlock(Entity aEntity) {mCore.onEntityCollidedWithBlock(aEntity);}
	@Override public AxisAlignedBB getCollisionBoundingBoxFromPool() {return box(PX_P[2], PX_P[2], PX_P[2], PX_N[2], PX_N[2], PX_N[2]);}
	
	@Override public byte getVisualData() {return mCore.getVisualData();}
	@Override public byte getDefaultSide() {return SIDE_FRONT;}
	@Override public boolean[] getValidSides() {return SIDES_HORIZONTAL;}
	
	@Override public boolean isEnergyType(TagData aEnergyType, byte aSide, boolean aEmitting) {return mCore.isEnergyType(aEnergyType, aSide, aEmitting);}
	@Override public boolean isEnergyAcceptingFrom(TagData aEnergyType, byte aSide, boolean aTheoretical) {return mCore.isEnergyAcceptingFrom(aEnergyType, aSide, aTheoretical);}
	@Override public boolean isEnergyCapacitorType(TagData aEnergyType, byte aSide) {return mCore.isEnergyCapacitorType(aEnergyType, aSide);}
	@Override public long doInject(TagData aEnergyType, byte aSide, long aSize, long aAmount, boolean aDoInject) {return mCore.doInject(aEnergyType, aSide, aSize, aAmount, aDoInject);}
	@Override public long getEnergyDemanded(TagData aEnergyType, byte aSide, long aSize) {return mCore.getEnergyDemanded(aEnergyType, aSide, aSize);}
	@Override public long getEnergySizeInputRecommended(TagData aEnergyType, byte aSide) {return mCore.getEnergySizeInputRecommended(aEnergyType, aSide);}
	@Override public long getEnergySizeInputMin(TagData aEnergyType, byte aSide) {return mCore.getEnergySizeInputMin(aEnergyType, aSide);}
	@Override public long getEnergySizeInputMax(TagData aEnergyType, byte aSide) {return mCore.getEnergySizeInputMax(aEnergyType, aSide);}
	@Override public long getEnergyStored(TagData aEnergyType, byte aSide) {return mCore.getEnergyStored(aEnergyType, aSide);}
	@Override public long getEnergyCapacity(TagData aEnergyType, byte aSide) {return mCore.getEnergyCapacity(aEnergyType, aSide);}
	@Override public Collection<TagData> getEnergyTypes(byte aSide) {return mCore.getEnergyTypes(aSide);}
	@Override public Collection<TagData> getEnergyCapacitorTypes(byte aSide) {return mCore.getEnergyCapacitorTypes(aSide);}
	
	@Override protected IFluidTank getFluidTankFillable2(byte aSide, FluidStack aFluidToFill) {return mCore.getFluidTankFillable(aSide, aFluidToFill);}
	@Override protected IFluidTank getFluidTankDrainable2(byte aSide, FluidStack aFluidToDrain) {return mCore.getFluidTankDrainable(aSide, aFluidToDrain);}
	@Override protected IFluidTank[] getFluidTanks2(byte aSide) {return mCore.getFluidTanks(aSide);}
	
	@Override public long getGibblValue(byte aSide) {return mCore.getGibblValue(aSide);}
	@Override public long getGibblMax(byte aSide) {return mCore.getGibblMax(aSide);}
	
	@Override public boolean canDrop(int aInventorySlot) {return F;}
	
	// Icons
	public static IIconContainer sColoreds[] = new IIconContainer[] {
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/bottom"),
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/top"),
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/colored/side")
	}, sOverlays[] = new IIconContainer[] {
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/bottom"),
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/top"),
			new Textures.BlockIcons.CustomIcon("machines/tanks/boiler_steam/overlay/side")
	};
	
	@Override public String getTileEntityName() {return "gt.multitileentity.tank.boiler_steam";}
}