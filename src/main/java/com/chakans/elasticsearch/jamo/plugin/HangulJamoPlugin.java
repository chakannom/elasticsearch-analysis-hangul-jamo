package com.chakans.elasticsearch.jamo.plugin;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import com.chakans.elasticsearch.jamo.index.analysis.HangulChosungFilterFactory;
import com.chakans.elasticsearch.jamo.index.analysis.HangulJamoTokenFilterFactory;

/**
 * Created by chakannom on 17. 6. 30.
 * Modified by chakannom on 18. 8. 14.
 */
public class HangulJamoPlugin extends Plugin implements AnalysisPlugin {

	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        extra.put("hangul_jamo", HangulJamoTokenFilterFactory::new);
        extra.put("hangul_chosung", HangulChosungFilterFactory::new);
        return extra;
	}
	
}
