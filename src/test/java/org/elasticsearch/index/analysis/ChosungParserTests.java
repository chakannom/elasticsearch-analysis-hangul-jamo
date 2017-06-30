package org.elasticsearch.index.analysis;

import static org.junit.Assert.*;

import org.elasticsearch.index.analysis.parser.AbstractJamoParser;
import org.elasticsearch.index.analysis.parser.ChosungParser;
import org.junit.Test;

public class ChosungParserTests {

	private AbstractJamoParser chosungParser = new ChosungParser();
	
	@Test
	public void test() {
		CharSequence parserdData = chosungParser.parse("안녕^^%test3");
		System.out.println(parserdData);
	}

}
