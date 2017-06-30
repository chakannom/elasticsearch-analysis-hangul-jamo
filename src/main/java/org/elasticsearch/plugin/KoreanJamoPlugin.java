package org.elasticsearch.plugin;

import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.KoreanChosungFilterFactory;
import org.elasticsearch.index.analysis.KoreanJamoTokenFilterFactory;
import org.elasticsearch.plugins.Plugin;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class KoreanJamoPlugin extends Plugin {

	@Override
	public String name() {
		return "elasticsearch-analysis-korean-jamo";
	}

	@Override
	public String description() {
		return "Elasticsearch Analysis Korean Jamo";
	}
	
	public void onModule(AnalysisModule module) {
		module.addTokenFilter("korean_jamo", KoreanJamoTokenFilterFactory.class);
		module.addTokenFilter("korean_chosung", KoreanChosungFilterFactory.class);
	}

}
