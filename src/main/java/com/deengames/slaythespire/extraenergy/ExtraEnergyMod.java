package com.deengames.slaythespire.extraenergy;

import basemod.BaseMod;
import basemod.interfaces.ISubscriber;
import basemod.interfaces.OnStartBattleSubscriber;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class ExtraEnergyMod implements ISubscriber, OnStartBattleSubscriber
{
	public static void initialize() {
        new ExtraEnergyMod();
    }
	
	public ExtraEnergyMod() {
		BaseMod.subscribe(this);
	}

	@Override
	public void receiveOnBattleStart(AbstractRoom currentRoom)
	{
		AbstractPlayer player = AbstractDungeon.player;
		player.energy.energy++;
		// Start the first round with 4/4, not 3/4 energy!
		player.gainEnergy(1);
	}
}
