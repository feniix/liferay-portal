/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.dbupgrade.transfersampledatalatest.blogs.pagescopelarcommunity;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ImportExportCommunityLARBlogsPageScopeTest extends BaseTestCase {
	public void testImportExportCommunityLARBlogsPageScope()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Sites", RuntimeVariables.replace("Sites"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.type("//input[@id='_134_name']",
			RuntimeVariables.replace("Blogs Page Scope Community"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//td[6]/span/ul/li/strong/a/span"));
		selenium.clickAt("//td[6]/span/ul/li/strong/a/span",
			RuntimeVariables.replace("Actions"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Manage Pages"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[2]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace("Import"),
			selenium.getText("//button[3]"));
		selenium.clickAt("//button[3]", RuntimeVariables.replace("Import"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@id='_156_importFileName']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		selenium.uploadFile("//input[@id='_156_importFileName']",
			RuntimeVariables.replace("Blogs_Page_Scope.Community.lar"));
		assertFalse(selenium.isChecked(
				"//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']",
			RuntimeVariables.replace("Delete Missing Pages"));
		assertTrue(selenium.isChecked(
				"//input[@id='_156_DELETE_MISSING_LAYOUTSCheckbox']"));
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isChecked(
				"//input[@id='_156_PERMISSIONSCheckbox']"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@id='_156_PERMISSIONSCheckbox']",
			RuntimeVariables.replace("Permissions"));
		assertTrue(selenium.isChecked("//input[@id='_156_PERMISSIONSCheckbox']"));
		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isChecked("//input[@id='_156_CATEGORIESCheckbox']"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@id='_156_CATEGORIESCheckbox']",
			RuntimeVariables.replace("Categories"));
		assertTrue(selenium.isChecked("//input[@id='_156_CATEGORIESCheckbox']"));
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isPartialText("//div[@id='_156_importMoreDiv']/a",
				"More Options"));
		selenium.clickAt("//div[@id='_156_importMoreDiv']/a",
			RuntimeVariables.replace("More Options"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//input[@id='_156_DELETE_PORTLET_DATACheckbox']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.saveScreenShotAndSource();
		assertFalse(selenium.isChecked(
				"//input[@id='_156_DELETE_PORTLET_DATACheckbox']"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@id='_156_DELETE_PORTLET_DATACheckbox']",
			RuntimeVariables.replace("Delete portlet data before importing"));
		assertTrue(selenium.isChecked(
				"//input[@id='_156_DELETE_PORTLET_DATACheckbox']"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("//input[@value='Import']",
			RuntimeVariables.replace("Import"));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}