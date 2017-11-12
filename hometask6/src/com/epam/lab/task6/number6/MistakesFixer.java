package com.epam.lab.task6.number6;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.epam.lab.task6.number6.constants.MistakesPatterns;

public class MistakesFixer {
	private static final Logger LOG = Logger.getLogger(MistakesFixer.class);

	public String fixAll(String allText) {
		return beginSentenceUpperCase(fixSpaces(allText));
	}

	private String fixSpaces(String allText) {
		// Tab in the begin
		String step01 = replace(allText, "\r(\\x09)+", "");
		// Extra tabs
		String step02 = replace(step01, "^(\\x09)+|(\\x09)+$|(\\x09)+", " ");
		// Spaces in the begin
		String step1 = replace(step02, "\r( )+", "\n");
		// Spaces in the middle
		String step2 = replace(step1, "^ +| +$|( )+", " ");
		// Extra enters
		String step21 = replace(step2, "(\n)+", "\n");
		// Spaces before punctuation marks
		String step3 = replace(step21, "( )+,", ",");
		String step4 = replace(step3, "( )+\\.", "\\.");
		String step5 = replace(step4, "( )+:", ":");
		String step6 = replace(step5, " +;", ";");
		String step7 = replace(step6, " +\\?", "\\?");
		String step8 = replace(step7, " +!", "!");
		return beginSentenceUpperCase(step8);
	}

	private String beginSentenceUpperCase(String allText) {
		char[] chArray = allText.toCharArray();
		StringBuilder rez = new StringBuilder();
		Character currentChar = chArray[0];
		chArray[0] = Character.toUpperCase(currentChar);
		rez.append(chArray[0]);
		rez.append(chArray[1]);
		for (int i = 2; i < chArray.length; i++) {
			if ((isSentenceEnd(chArray[i - 2]) && (chArray[i - 1] == ' ')) || (isLineEnd(chArray[i - 1]))) {
				currentChar = chArray[i];
				currentChar = Character.toUpperCase(currentChar);
				chArray[i] = currentChar;
			}
			rez.append(chArray[i]);
		}
		return rez.toString();
	}

	private boolean isSentenceEnd(char symbol) {
		return (symbol == '.') | (symbol == '!') | (symbol == '?') | (symbol == '\n') | (symbol == '\r');
	}

	private boolean isLineEnd(char symbol) {
		return (symbol == '\n') | (symbol == '\r');
	}

	private String replace(String allText, String forPattern, String forReplace) {
		Pattern pattern = Pattern.compile(forPattern);
		Matcher matcher = pattern.matcher(allText);
		String replaceAll = matcher.replaceAll(forReplace);
		return replaceAll;
	}
}
