package com.epam.lab.task6.number4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.epam.lab.task6.number4.constants.CommentPatterns;

public class CommentsHunter {
	private static final Logger LOG = Logger.getLogger(CommentsHunter.class);	
	public void find(String allText) {
		Pattern pattern = Pattern.compile(String.format("(%s)|(%s)|%s|%s|%s", CommentPatterns.SL, CommentPatterns.ML,
				CommentPatterns.STR_LIT, CommentPatterns.CH_LIT, CommentPatterns.ANY));

		Matcher patternMatcher = pattern.matcher(allText);

		while (patternMatcher.find()) {
			String targetString = patternMatcher.group();
			if (patternMatcher.group(1) != null) {
				LOG.info(String.format("Single Line :: %s", targetString));
			}
			if (patternMatcher.group(2) != null) {
				LOG.info(String.format("Multi Line :: %s", targetString));
			}
		}
	}

}
