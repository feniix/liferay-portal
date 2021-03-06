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

package com.liferay.portal.parsers.bbcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
  * @author Iliyan Peychev
 */
public class BBCodeLexer {

	public BBCodeLexer(String data) {
		_matcher = _pattern.matcher(data);
	}

	public int getLastIndex() {
		return _matcher.end();
	}

	public BBCodeToken getNextBBCodeToken() {
		if (!_matcher.find()) {
			return null;
		}

		return new BBCodeToken(
			_matcher.group(1), _matcher.group(2), _matcher.group(3),
			_matcher.start(), _matcher.end());
	}

	private static Pattern _pattern = Pattern.compile(
		"(?:\\[((?:[a-z]|\\*){1,16})(?:=([^\\x00-\\x1F\"'()<>\\[\\]]{1,256}))" +
			"?\\])|(?:\\[/([a-z]{1,16})\\])",
		Pattern.CASE_INSENSITIVE);

	private Matcher _matcher;

}