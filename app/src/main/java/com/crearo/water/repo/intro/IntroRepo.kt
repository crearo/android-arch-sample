package com.crearo.water.repo.intro

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntroRepo @Inject constructor(@ApplicationContext context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "intro_prefs")
    private val dataStore = context.dataStore

    object PreferencesKeys {
        val INTRO_STAGE = intPreferencesKey("stage")
    }

    fun getStage(): Flow<Int> {
        return dataStore.data.map { prefs -> prefs[PreferencesKeys.INTRO_STAGE] ?: 1 }
    }

    suspend fun reset() {
        setStage(1)
    }

    suspend fun setStage(stage: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.INTRO_STAGE] = stage
        }
    }
}