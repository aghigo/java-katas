package dev.andreghigo.katas.java.util.localization;

import java.util.ListResourceBundle;

public class ListResourceBundleClass_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][]{
			{"prop", "test from ListResourceBundleClass_en_US extends ListResourceBundle"}
		};
	}

}
