package org.elasticsearch.index.analysis;

import static org.junit.Assert.*;

import org.elasticsearch.index.analysis.parser.AbstractJamoParser;
import org.elasticsearch.index.analysis.parser.JamoParser;
import org.junit.Test;

public class JamoParserTests {

	private AbstractJamoParser jamoParser = new JamoParser();
	
	@Test
	public void test() {
		CharSequence parserdData = jamoParser.parse("안녕^^%test3");
		System.out.println(parserdData);
	}

}
