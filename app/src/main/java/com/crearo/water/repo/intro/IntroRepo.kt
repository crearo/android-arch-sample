package com.crearo.water.repo.intro

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class IntroRepo @Inject constructor(@ApplicationContext context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "intro_prefs")
    private val dataStore = context.dataStore

    object PreferencesKeys {
        val INTRO_STAGE = intPreferencesKey("stage")
    }

    suspend fun getStage(): Int {
        val preferences = dataStore.data.first()
        val stage = preferences[PreferencesKeys.INTRO_STAGE]
        return stage ?: 0
    }

    suspend fun setStage(stage: Int) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.INTRO_STAGE] = stage
        }
    }
}