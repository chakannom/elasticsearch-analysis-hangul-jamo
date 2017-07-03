package org.elasticsearch.indices.analysis;

import org.elasticsearch.common.inject.AbstractModule;

public class HangulJamoiIndicesAnalysisModule extends AbstractModule {
	@Override
    protected void configure() {
        bind(HangulJamoiIndicesAnalysis.class).asEagerSingleton();
    }
}
