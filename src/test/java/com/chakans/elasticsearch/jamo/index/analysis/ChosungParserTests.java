package com.chakans.elasticsearch.jamo.index.analysis;

import org.junit.Test;

import com.chakans.elasticsearch.jamo.index.analysis.parser.AbstractJamoParser;
import com.chakans.elasticsearch.jamo.index.analysis.parser.ChosungParser;

public class ChosungParserTests{

	private AbstractJamoParser chosungParser = new ChosungParser();
	
	@Test
	public void test() {
		CharSequence parserdData = chosungParser.parse("안녕^^%test3");
		System.out.println(parserdData);
	}

}
