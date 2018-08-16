package com.chakans.elasticsearch.jamo.index.analysis;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chakans.elasticsearch.jamo.index.analysis.parser.AbstractJamoParser;
import com.chakans.elasticsearch.jamo.index.analysis.parser.JamoParser;

public class JamoParserTests {

	private AbstractJamoParser jamoParser = new JamoParser();
	
	@Test
	public void test() {
		CharSequence parserdData = jamoParser.parse("안녕^^%test3");
		System.out.println(parserdData);
	}

}
