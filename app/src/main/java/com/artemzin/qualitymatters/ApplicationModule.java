package com.artemzin.qualitymatters;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// It's a Dagger module that provides application level dependencies.
@Module
public class ApplicationModule {

    public static final String MAIN_THREAD_HANDLER = "main_thread_handler";

    @NonNull
    private final QualityMattersApp qualityMattersApp;

    public ApplicationModule(@NonNull QualityMattersApp qualityMattersApp) {
        this.qualityMattersApp = qualityMattersApp;
    }

    @Provides @NonNull @Singleton
    public QualityMattersApp provideQualityMattersApp() {
        return qualityMattersApp;
    }

    @Provides @NonNull @Singleton
    public ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }

    @Provides @NonNull @Named(MAIN_THREAD_HANDLER) @Singleton
    public Handler provideMainThreadHandler() {
        return new Handler(Looper.getMainLooper());
    }
}
