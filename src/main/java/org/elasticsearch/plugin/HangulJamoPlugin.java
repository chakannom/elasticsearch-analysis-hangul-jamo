package org.elasticsearch.plugin;

import java.util.Collection;
import java.util.Collections;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.HangulChosungFilterFactory;
import org.elasticsearch.index.analysis.HangulJamoTokenFilterFactory;
import org.elasticsearch.indices.analysis.HangulJamoiIndicesAnalysisModule;
import org.elasticsearch.plugins.Plugin;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class HangulJamoPlugin extends Plugin {

	@Override
	public String name() {
		return "elasticsearch-analysis-hangul-jamo";
	}

	@Override
	public String description() {
		return "Elasticsearch Analysis Hangul Jamo";
	}
	
	@Override
    public Collection<Module> nodeModules() {
        return Collections.<Module>singletonList(new HangulJamoiIndicesAnalysisModule());
    }
	
	public void onModule(AnalysisModule module) {
		module.addTokenFilter("hangul_jamo", HangulJamoTokenFilterFactory.class);
		module.addTokenFilter("hangul_chosung", HangulChosungFilterFactory.class);
	}

}
