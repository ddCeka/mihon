package tachiyomi.domain.storage.service

import tachiyomi.core.common.preference.Preference
import tachiyomi.core.common.preference.PreferenceStore
import tachiyomi.core.common.storage.FolderProvider

class StoragePreferences(
    folderProvider: FolderProvider,
    preferenceStore: PreferenceStore,
) {

    val baseStorageDirectory: Preference<String> = preferenceStore.getString(
        Preference.appStateKey("storage_dir"),
        folderProvider.path(),
    )

    // Direct filesystem access via MANAGE_EXTERNAL_STORAGE instead of the SAF picker.
    val useDirectStorageAccess: Preference<Boolean> = preferenceStore.getBoolean(
        Preference.appStateKey("use_direct_storage_access"),
        false,
    )
}
