package accessfield.b;

import accessfield.a.TheOwner;

public class OtherPackageA {

	public OtherPackageA(){
		String s = new TheOwner().theString;
	}
	
}
