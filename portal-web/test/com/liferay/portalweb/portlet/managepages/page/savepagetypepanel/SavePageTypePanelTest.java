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

package com.liferay.portalweb.portlet.managepages.page.savepagetypepanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SavePageTypePanelTest extends BaseTestCase {
	public void testSavePageTypePanel() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//li[contains(@class,'manage-page')]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("//li[contains(@class,'manage-page')]/a",
					RuntimeVariables.replace("Manage Pages"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Public Pages")
												.equals(selenium.getText(
										"//a[@class='layout-tree']"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Public Pages"),
					selenium.getText("//a[@class='layout-tree']"));

				boolean welcomePresent = selenium.isElementPresent(
						"//li/ul/li[1]/div/div[3]/a");

				if (welcomePresent) {
					label = 2;

					continue;
				}

				selenium.clickAt("//div[3]/ul/li/div/div[1]",
					RuntimeVariables.replace("Drop Down Arrow"));

			case 2:

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//li/ul/li[1]/div/div[3]/a")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Welcome"),
					selenium.getText("//li/ul/li[1]/div/div[3]/a"));
				assertEquals(RuntimeVariables.replace("Manage Pages Test Page"),
					selenium.getText("//li/ul/li[2]/div/div[3]/a"));
				selenium.clickAt("//li/ul/li[2]/div/div[3]/a",
					RuntimeVariables.replace("Manage Pages Test Page"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Manage Pages Test Page")
												.equals(selenium.getValue(
										"//div[1]/fieldset/div/span[1]/span/span/span/input"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals("Manage Pages Test Page",
					selenium.getValue(
						"//div[1]/fieldset/div/span[1]/span/span/span/input"));
				Thread.sleep(5000);

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace(
									"Portlet Panel Embedded Web Content URL Link to Page")
												.equals(selenium.getText(
										"//select[@id='_88_type']"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.select("//select[@id='_88_type']",
					RuntimeVariables.replace("Panel"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace("Save"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request completed successfully."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				selenium.open("/web/guest/home/");

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("link=Manage Pages Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("link=Manage Pages Test Page",
					RuntimeVariables.replace("Manage Pages Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Manage Pages Test Page"),
					selenium.getText("//nav/ul/li[2]/span/a"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Manage Pages Test Page")
												.equals(selenium.getText(
										"//td[2]/h2"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Manage Pages Test Page"),
					selenium.getText("//td[2]/h2"));
				assertEquals(RuntimeVariables.replace(
						"Please select a tool from the left menu."),
					selenium.getText("//td[2]/div"));
				assertEquals(RuntimeVariables.replace("Liferay"),
					selenium.getText("//p/a"));

			case 100:
				label = -1;
			}
		}
	}
}