package com.Molecule;

public class MainMolecule {
	public static void main(String args[]){
		OrganicCompound compound = new OrganicCompound("CHOC(CH3(OC)2)2");
		System.out.println(compound.getMassOfCompound());
	}
}
