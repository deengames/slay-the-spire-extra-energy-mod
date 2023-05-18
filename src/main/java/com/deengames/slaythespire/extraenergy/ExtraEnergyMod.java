package com.deengames.slaythespire.extraenergy;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.OnPlayerTurnStartSubscriber;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class ExtraEnergyMod implements ISubscriber, OnPlayerTurnStartSubscriber
{
	private static final int STARTING_ENERGY = 4;

	public static void initialize() {
        new ExtraEnergyMod();
    }
	
	public ExtraEnergyMod() {
		BaseMod.subscribe(this);
	}

	@Override
	public void receiveOnPlayerTurnStart()
	{
		AbstractPlayer player = AbstractDungeon.player;
		player.energy.energy = STARTING_ENERGY;
		// Start the first round with 4/4, not 3/4 energy!
		player.gainEnergy(1);
	}
}
